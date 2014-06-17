package com.radaee.reader;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;

import com.radaee.pdf.Document;
import com.radaee.view.PDFView;
import com.radaee.view.PDFView.PDFViewListener;
import com.radaee.view.PDFViewDual;


@Hide
public class ReaderController extends View
{
    private PDFView m_pdv;
    private BA ba;
    private String eventName;
    
    public ReaderController(Context context, BA ba, String EventName)
    {
        super(context);
        this.ba = ba;
        this.eventName = EventName;
    }

    public ReaderController(Context context, PDFView pdfView, BA ba, String EventName)
    {
        super(context);
        m_pdv = pdfView;
        this.ba = ba;
        this.eventName = EventName;
    }

    public ReaderController(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    protected void onDraw(Canvas canvas)
    {
        //m_pdv.vDraw(canvas);
        BA.Log("--------In on draw. eventName: " + eventName);
        
        if (ba.subExists(eventName + "_draw")==true) {
        	BA.Log("--------Calling draw method in B4A");
			ba.raiseEvent(this, eventName + "_draw", new Object[] { canvas } );
		}
        // Paint paint = new Paint();
        // paint.setARGB(255, 255, 0, 0);
        // canvas.drawText("myText", 20, 20, paint);
    }

    public void open(Document doc, PDFViewListener listener)
    {
        m_pdv = new PDFViewDual(getContext());
        m_pdv.vOpen(doc, 4, 0xFFCCCCCC, listener);
        //boolean paras[] = new boolean[doc.GetPageCount()];
        //((PDFViewDual)m_pdv).vSetLayoutPara(null, paras, false);
        invalidate();
    }
    
    public PDFView getPDFView() {
    	return this.m_pdv;
    }
    
    /**
     * Invalidates the view.
     */
    public void invalidate4() {
    	invalidate();
    }
    
    @Override
    protected void onSizeChanged (int w, int h, int oldw, int oldh)
    {
//        m_save_w = w;
//        m_save_h = h;
//        if( m_pdv != null && !m_lock_resize )
//            m_pdv.vResize(w, h);
        
        BA.Log("--------In on size changed.");
        
        if (ba.subExists(eventName + "_sizechanged")==true) {
			ba.raiseEvent(this, eventName + "_sizechanged", new Object[] { w, h, oldw, oldh } );
		}
    }

    @Override
	public boolean onTouchEvent(MotionEvent event)
    {
//    	if( m_pdv != null )
//    		return m_pdv.vTouchEvent(event);
//    	else
//    		return true;
    	
    	BA.Log("--------In touch event.");
        boolean yesno=true;
        if (ba.subExists(eventName + "_touchevent")==true) {
			yesno = (Boolean) ba.raiseEvent(this, eventName + "_touchevent", new Object[] { event } );
		}
        return yesno;
    }
    
    @Override
	public void computeScroll()
	{
//		if( m_pdv == null ) return;
//		m_pdv.vComputeScroll();
    	
    	BA.Log("--------In compute scroll");
        
        if (ba.subExists(eventName + "_computescroll")==true) {
			ba.raiseEvent(this, eventName + "_computescroll" );
		}
	}
   


}
