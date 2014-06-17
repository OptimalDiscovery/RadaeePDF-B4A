package com.rootsoft.rspdfviewer.pdf;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;

import com.radaee.pdf.Page;

@ShortName("PDF")
@Hide
public class RSPDFTemplate extends AbsObjectWrapper<Page> {
	
	//Attributes

	//Constructors - Initialization
	
	/**
	 * Initializes the PDFDocument.
	 */
	public void Initialize() {
		setObject(new Page());
	}
	
	
}
