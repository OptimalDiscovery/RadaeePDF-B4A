package com.rootsoft.rspdfviewer.pdf;

import android.graphics.Canvas;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;

import com.radaee.pdf.Ink;

@ShortName("PDFInk")
public class RSPDFInk extends AbsObjectWrapper<Ink> {
	
	//Attributes

	//Constructors - Initialization
	
	/**
	 * Initializes the PDF Ink.
	 * class for ink
	 */
	public void Initialize(float line_w) {
		setObject(new Ink(line_w));
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
		
	}
	
	/**
	 * draw to locked bitmap handle.
	 * @param bmp, obtained by Global.lockBitmap()
	 */
	public void OnDraw( Canvas canvas )
	{
		getObject().OnDraw(canvas);
	}
	
	/**
	 * draw to locked bitmap handle.
	 * @param bmp, obtained by Global.lockBitmap()
	 */
	public void OnDraw(Canvas canvas, float scrollx, float scrolly) 
	{
		getObject().OnDraw(canvas, scrollx, scrolly);
	}
	
}
