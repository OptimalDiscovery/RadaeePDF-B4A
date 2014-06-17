package com.radaee.util;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.radaee.pdf.Document.PDFStream;

/**
 * a class for HttpURLConnection.<br/>
 * the class read PDF file in remote way, this class not support write back to server.<br/>
 * the server must support Http header "Range" for request, and "content-length" for response.<br/>
 * and this class need Internet access right to run.
 * @author radaee
 */
public class PDFHttpStream implements PDFStream
{
	private static final int BLOCK_SIZE = 8192;
	private String m_url = null;
	private File m_tmp = null;
	private int m_total = 0;
	private RandomAccessFile m_cache = null;
	private HttpThread m_thread = null;
	private int m_block_pos = 0;
	private byte[] m_block = null;
	private int m_pos = 0;
	private int[] m_blocks_flag = null;

	/**
	Inner class.<br/>
	developer should not use this.
	*/
	public class HttpThread extends Thread
	{
		private Handler m_hand = null;
		private boolean is_notified = false;
		private boolean is_waitting = false;
		private class OP
		{
			PDFHttpStream stream;
			int para1;
			int para2;
			byte[] data;
		}
		private synchronized void wait_op()
		{
			try
			{
				if( is_notified )
					is_notified = false;
				else
				{
					is_waitting = true;
					wait();
					is_waitting = false;
				}
			}
			catch(Exception e)
			{
			}
		}
		private synchronized void notify_op()
		{
			if( is_waitting )
				notify();
			else
				is_notified = true;
		}
		
		@Override
	    public void start()
		{
			super.start();
			wait_op();
		}
		@Override
	    public void run()
		{
			Looper.prepare();
			m_hand = new Handler(Looper.myLooper())
			{
				public void handleMessage(Message msg)
				{
					if( msg != null )
					{
						if( msg.what == 0 )//render function
						{
							OP op = (OP)msg.obj;
							op.para1 = op.stream.read_total_size();
							notify_op();
							super.handleMessage(msg);
						}
						else if( msg.what == 1 )
						{
							OP op = (OP)msg.obj;
							op.data = op.stream.read_range(op.para1, op.para2);
							notify_op();
							super.handleMessage(msg);
						}
						else if( msg.what == 100 )//quit
						{
							super.handleMessage(msg);
							getLooper().quit();
						}
						else
						{
							super.handleMessage(msg);
						}
					}
					else
						getLooper().quit();
				}
			};
			notify_op();
			Looper.loop();
		}
		public int get_size(PDFHttpStream stream)
		{
			OP op = new OP();
			op.stream = stream;
			m_hand.sendMessage(m_hand.obtainMessage(0, op));
			wait_op();
			return op.para1;
		}
		public byte[] read_range(PDFHttpStream stream, int start, int len)
		{
			OP op = new OP();
			op.stream = stream;
			op.para1 = start;
			op.para2 = len;
			m_hand.sendMessage(m_hand.obtainMessage(1, op));
			wait_op();
			return op.data;
		}
		public synchronized void destroy()
		{
			try
			{
				m_hand.sendEmptyMessage(100);
				join();
				m_hand = null;
			}
			catch(InterruptedException e)
			{
			}
		}
	}
	/**
	 * this method need http_header "content-length" for server.
	 * @return total size of PDF
	 */
	private int read_total_size()
	{
		try
		{
			URL url = new URL(m_url);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.connect();
			int len = 0;
			try
			{
				len = conn.getContentLength();
			}
			catch(Exception e)
			{
				len = 0;
			}
			if( len <= 0 )
			{
				try
				{
					String slen = conn.getHeaderField("Content-Length");
					len = Integer.parseInt(slen);
				}
				catch(Exception e)
				{
					len = 0;
				}
			}
			//it's better to comment this line in release version.
			Log.d("Total Size:", String.valueOf(len) );
			conn.disconnect();
			return len;
		}
		catch(Exception e)
		{
			Log.d("Error", e.getMessage());
			return (int) 0;
		}
	}
	private byte[] read_range( int start, int len )
	{
		try
		{
			long time1 = System.currentTimeMillis();
			URL url = new URL(m_url);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Range", String.format("bytes=%d-%d", start, start + len));
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.connect();
			InputStream stream = conn.getInputStream();
			byte[] data = new byte[len];
			int read = 0;
			int read_total = 0;
			while( read_total < len )
			{
				read = stream.read(data, read_total, len - read_total);
				if( read > 0 ) read_total += read;
			}
			stream.close();
			conn.disconnect();
			long time2 = System.currentTimeMillis();
			//it's better to comment this line in release version.
			Log.d(String.format("Time:%06d %d", start/BLOCK_SIZE, len), String.valueOf(time2 - time1));
			return data;
		}
		catch(Exception e)
		{
			Log.d("Error", e.getMessage());
			return null;
		}
	}
	private byte[] read_block(int index)
	{
		try
		{
			m_cache.seek(index * BLOCK_SIZE);
			int size = BLOCK_SIZE;
			if( index == m_blocks_flag.length - 1 )
				size = m_total%BLOCK_SIZE;
			byte[] data;
			if( m_blocks_flag[index] != 0 )
			{
				data = new byte[size];
				m_cache.read(data);
				return data;
			}
			else
			{
				data = m_thread.read_range(this, index * BLOCK_SIZE, size);
				if( data != null )
				{
					m_cache.write(data);
					m_blocks_flag[index] = 1;
				}
				return data;
			}
		}
		catch(Exception e)
		{
			Log.d("Error", e.getMessage());
			return null;
		}
	}
	/**
	 * open an url as stream
	 * @param url url address.
	 * @return true or false.
	 */
	public boolean open(String url)
	{
		m_url = url;
		m_thread = new HttpThread();
		m_thread.start();
		try
		{
			m_total = m_thread.get_size(this);
			if( m_total <= 0 ) return false;
			m_tmp = File.createTempFile("RDTMP", ".dat");
			m_cache = new RandomAccessFile(m_tmp.getAbsolutePath(), "rw");
			m_cache.setLength(m_total);
			m_blocks_flag = new int[(m_total + BLOCK_SIZE - 1)/BLOCK_SIZE];
			m_block = read_block(0);
			return true;
		}
		catch(Exception e)
		{
			Log.d("Error", e.getMessage());
			return false;
		}
	}
	/**
	 * free resources.<br/>
	 * this method is needed when APP close the PDF.
	 */
	public void close()
	{
		try
		{
			m_thread.destroy();
			m_cache.close();
			m_tmp.delete();
		}
		catch(Exception e)
		{
		}
	}
	public boolean writeable()
	{
		return false;
	}
	public int get_size()
	{
		return m_total;
	}
	public int read(byte[] data)
	{
		int dst_cur = 0;
		int old_pos = m_pos;
		while( dst_cur < data.length && m_pos < m_total )
		{
			if( dst_cur > 0 )
			{
				seek( old_pos + dst_cur );
			}
			int src_cur = m_pos%BLOCK_SIZE;
			while( dst_cur < data.length && src_cur < m_block.length )
			{
				data[dst_cur] = m_block[src_cur];
				dst_cur++;
				src_cur++;
			}
			seek( old_pos + dst_cur );
		}
		return dst_cur;
	}
	public int write(byte[] data)
	{
		return 0;
	}
	public void seek(int pos)
	{
		if( pos < 0 ) pos = 0;
		if( pos > m_total ) pos = m_total;
		if( pos == m_pos ) return;
		m_pos = pos;
		int new_block_pos = pos/BLOCK_SIZE;
		if( new_block_pos == m_block_pos ) return;
		m_block_pos = new_block_pos;
		m_block = read_block(m_block_pos);
	}
	public int tell()
	{
		return m_pos;
	}
}
