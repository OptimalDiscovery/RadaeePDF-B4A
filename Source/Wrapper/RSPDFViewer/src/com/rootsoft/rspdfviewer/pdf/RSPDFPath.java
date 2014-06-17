package com.rootsoft.rspdfviewer.pdf;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;

import com.radaee.pdf.Path;

@ShortName("PDFPath")
public class RSPDFPath extends AbsObjectWrapper<Path> {

	// Attributes

	// Constructors - Initialization

	/**
	 * Initializes the PDFDocument.
	 */
	public void Initialize() {
		setObject(new Path());
	}

	/**
	 * move to operation
	 * 
	 * @param x
	 * @param y
	 */
	public void MoveTo(float x, float y) {
		getObject().MoveTo(x, y);
	}

	/**
	 * line to operation
	 * 
	 * @param x
	 * @param y
	 */
	public void LineTo(float x, float y) {
		getObject().LineTo(x, y);
	}

	public void CurveTo(float x1, float y1, float x2, float y2, float x3, float y3) {
		getObject().CurveTo(x1, y1, x2, y2, x3, y3);

	}

	/**
	 * close a contour.
	 */
	public void ClosePath() {
		getObject().ClosePath();
	}

	/**
	 * free memory
	 */
	public void Destroy() {
		getObject().Destroy();
	}

	public int GetNodeCount() {
		return getObject().GetNodeCount();
	}

	/**
	 * get each node
	 * 
	 * @param index
	 *            range [0, GetNodeCount() - 1]
	 * @param pt
	 *            output value: 2 elements coordinate point
	 * @return node type:<br/>
	 *         0: move to<br/>
	 *         1: line to<br/>
	 *         3: curve to, index, index + 1, index + 2 are all data<br/>
	 *         4: close operation<br/>
	 */
	public int GetNode(int index, float pt[]) {
		return getObject().GetNode(index, pt);
	}

}
