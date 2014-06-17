package com.rootsoft.rspdfviewer.pdf;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;

import com.radaee.pdf.HWriting;

@ShortName("PDFHWriting")
public class RSPDFHWriting extends AbsObjectWrapper<HWriting> {
	
	//Attributes

	//Constructors - Initialization
	
	/**
	 * Initializes the PDF HWriting.
	 * class for hand-writing ink.
	 * not same to Ink class, this class has max line width and min line width.
	 * so the line in HWriting will not in same width.
	 */
	public void Initialize(int w, int h, float min_w, float max_w, int clr_r, int clr_g, int clr_b) {
		setObject(new HWriting(w, h, min_w, max_w, clr_r, clr_g, clr_b));
	}
	
	/**
	 * destroy and free memory.
	 */
	public void Destroy()
	{
		getObject().Destroy();
	}
	
	/**
	 * call when click down
	 * @param x x value of point in this object.
	 * @param y y value of point in this object.
	 */
	public void OnDown( float x, float y )
	{
		getObject().OnDown(x, y);
	}
	
	/**
	 * call when moving
	 * @param x x value of point in this object.
	 * @param y y value of point in this object.
	 */
	public void OnMove( float x, float y )
	{
		getObject().OnMove(x, y);	
	}
	
	/**
	 * call when click up
	 * @param x x value of point in this object.
	 * @param y y value of point in this object.
	 */
	public void OnUp( float x, float y )
	{
		getObject().OnUp(x, y);
	}
	/**
	 * draw to locked bitmap handle.
	 * @param bmp, obtained by Global.lockBitmap()
	 */
	public void OnDraw( int bmp )
	{
		getObject().OnDraw(bmp);
	}
	
}
