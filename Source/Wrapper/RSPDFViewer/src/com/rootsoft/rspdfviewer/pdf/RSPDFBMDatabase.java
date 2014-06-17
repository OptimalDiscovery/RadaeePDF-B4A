package com.rootsoft.rspdfviewer.pdf;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;

import com.radaee.pdf.BMDatabase;

@ShortName("PDFBMDatabase")
public class RSPDFBMDatabase extends AbsObjectWrapper<BMDatabase> {

	// Attributes

	// Constructors - Initialization

	/**
	 * Initializes the BookMark database.
	 */
	public void Initialize() {
		setObject(new BMDatabase());
	}

	/**
	 * Open exist database file or create it if not exist. (Database for
	 * BookMark)
	 * 
	 * @param db_path
	 * @return
	 */
	public boolean OpenOrCreate(String db_path) {
		return getObject().OpenOrCreate(db_path);
	}

	/**
	 * close database
	 */
	public void Close() {
		getObject().Close();
	}

	/**
	 * Get a RecordSet handle, by input PDF file path
	 * 
	 * @param look_path
	 *            PDF path to lookup.
	 * @return handle value of RecordSet.
	 */
	public int RecOpen(String look_path) {
		return getObject().RecOpen(look_path);
	}

	/**
	 * Close a RecordSet handle
	 * 
	 * @param rec
	 *            handle value of RecordSet. obtained by RecOpen
	 */
	public void RecClose(int rec) {
		getObject().RecClose(rec);
	}

	/**
	 * Get items count of RecordSet.
	 * 
	 * @param rec
	 *            RecordSet Handle, obtained by RecOpen
	 * @return records count
	 */
	public int RecGetCount(int rec) {
		return getObject().RecGetCount(rec);
	}

	/**
	 * Get item name by index.
	 * 
	 * @param rec
	 *            RecordSet Handle that returned by RecOpen
	 * @param index
	 *            0 based index value, range:[0, RecGetCount()-1]
	 * @return name of item.
	 */
	public String RecItemGetName(int rec, int index) {
		return getObject().RecItemGetName(rec, index);
	}

	/**
	 * Get page no by index.
	 * 
	 * @param rec
	 *            RecordSet Handle that returned by RecOpen
	 * @param index
	 *            0 based index value, range:[0, RecGetCount()-1]
	 * @return 0 based page NO.
	 */
	public int RecItemGetPage(int rec, int index) {
		return getObject().RecItemGetPage(rec, index);
	}

	/**
	 * remove item by index.
	 * 
	 * @param rec
	 *            RecordSet Handle that returned by RecOpen
	 * @param index
	 *            0 based index value, range:[0, RecGetCount()-1]
	 * @return true or false.
	 */
	public boolean RecItemRemove(int rec, int index) {
		return getObject().RecItemRemove(rec, index);
	}

	/**
	 * insert item.
	 * 
	 * @param rec
	 *            RecordSet Handle that returned by RecOpen
	 * @param name
	 *            label of BookMark.
	 * @param pageno
	 *            0 based page no recorded.
	 * @return true or false
	 */
	public boolean RecItemInsert(int rec, String name, int pageno) {
		return getObject().RecItemInsert(rec, name, pageno);
	}
}
