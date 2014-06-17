package com.rootsoft.rspdfviewer.pdf;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;

import com.radaee.pdf.Matrix;
import com.radaee.pdf.Page;
import com.radaee.view.PDFVPage;

@ShortName("PDFVPage")
public class RSPDFVPage extends AbsObjectWrapper<PDFVPage> {

	// Attributes

	// Constructors - Initialization
	
	public boolean IsFinished() {
		return getObject().IsFinished();
	}

	public float ToPDFX(float x, float scrollx) {
		return getObject().ToPDFX(x, scrollx);
	}

	public float ToPDFY(float y, float scrolly) {
		return getObject().ToPDFY(y, scrolly);
	}

	public float ToDIBX(float x) {
		return getObject().ToDIBX(x);
	}

	public float ToDIBY(float y) {
		return getObject().ToDIBY(y);
	}

	public Page GetPage() {
		return getObject().GetPage();
	}

	public int GetPageNo() {
		return getObject().GetPageNo();
	}

	public int GetX() {
		return getObject().GetX();
	}

	public int GetY() {
		return getObject().GetY();
	}

	public float GetScale() {
		return getObject().GetScale();
	}

	public int GetVX(float scrollx) {
		return getObject().GetVX(scrollx);
	}

	public int GetVY(float scrolly) {
		return getObject().GetVY(scrolly);
	}

	public int GetWidth() {
		return getObject().GetWidth();
	}

	public int GetHeight() {
		return getObject().GetHeight();
	}

	public Matrix CreateMatrix() {
		return getObject().CreateMatrix();
	}

	public Matrix CreateInvertMatrix(float scrollx, float scrolly) {
		return getObject().CreateInvertMatrix(scrollx, scrolly);
	}

	public float ToPDFSize(float val) {
		return getObject().ToPDFSize(val);
	}

}
