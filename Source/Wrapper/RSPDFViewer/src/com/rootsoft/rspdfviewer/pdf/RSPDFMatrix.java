package com.rootsoft.rspdfviewer.pdf;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;

import com.radaee.pdf.Ink;
import com.radaee.pdf.Matrix;
import com.radaee.pdf.Path;

@ShortName("PDFMatrix")
public class RSPDFMatrix extends AbsObjectWrapper<Matrix> {

	// Attributes

	// Constructors - Initialization

	/**
	 * Initializes the PDF Matrix xx = sx yx = 0; xy = 0; yx = sy;
	 */
	public void Initialize(float sx, float sy, float x0, float y0) {
		setObject(new Matrix(sx, sy, x0, y0));
	}

	/**
	 * Initializes the PDF Matrix constructor for full values.
	 */
	public void Initialize2(float xx, float yx, float xy, float yy, float x0,
			float y0) {
		setObject(new Matrix(xx, yx, xy, yy, x0, y0));
	}

	public void Invert() {
		getObject().Invert();
	}

	public void TransformPath(Path path) {
		getObject().TransformPath(path);
	}

	public void TransformInk(Ink ink) {
		getObject().TransformInk(ink);
	}

	public void TransformRect(float[] rect) {
		getObject().TransformRect(rect);
	}

	public void TransformPoint(float[] point) {
		getObject().TransformPoint(point);
	}

	/**
	 * destroy and free memory.
	 */
	public void Destroy() {

	}

}
