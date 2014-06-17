package com.rootsoft.rspdfviewer.pdf;

import android.graphics.Bitmap;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Permissions;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;

import com.radaee.pdf.Global;
import com.radaee.pdf.Matrix;

@ShortName("PDFGlobal")
@Author("RootSoft")
@Version(1.0f)
@DependsOn(values = { "pdfviewer_native" })
@ActivityObject
@Permissions(values = { "android.permission.INTERNET" })
public class RSPDFGlobal {

	// Attributes

	/**
	 * color for ink annotation
	 */
	public int inkColor = 0x80404040;

	/**
	 * width for ink lines.
	 */
	public float inkWidth = 4;

	/**
	 * color for rect annotation.
	 */
	public int rectColor = 0x80C00000;

	/**
	 * selection color.
	 */
	public int selColor = 0x400000C0;// selection color

	/**
	 * is text selection start from right to left in one line?
	 */
	public boolean selRTOL = false;

	/**
	 * max zoom level; valid values: [2, 5]
	 */
	public float zoomLevel = 3;

	public float zoomStep = 1;
	/**
	 * fling distance: 0.5-2
	 */
	public float fling_dis = 1.0f;// 0.5-2

	/**
	 * fling speed: 0.1-0.4
	 */
	public float fling_speed = 0.2f;// 0.1 - 0.4

	/**
	 * default view:<br/>
	 * 0:vertical<br/>
	 * 2:scroll<br/>
	 * 3:single<br/>
	 * 4:SingleEx<br/>
	 * 5:ReFlow<br/>
	 * 6:2 page in landscape
	 */
	public int def_view = 0;

	/**
	 * render mode: 0:draft 1:normal 2:best
	 */
	public int render_mode = 2;

	/**
	 * render as dark mode?
	 */
	public boolean dark_mode = false;

	// Constructors - Initialization

	/**
	 * Initializes the Global pdf variable.
	 */
	public void Initialize(final BA ba, String EventName) {
		System.loadLibrary("rdpdf");
		Global.Init(ba.activity);
	}

	/**
	 * Remove all tmp files that "pdfex" library generated.
	 */
	public void RemoveTmp() {
		Global.RemoveTmp();
	}

	/**
	 * reset to default configure.
	 */
	public void default_config() {
		Global.default_config();
	}

	/**
	 * map PDF point to DIB point.
	 * 
	 * @param mat
	 *            Matrix object defined scale, rotate, tranlate operations.
	 * @param ppoint
	 *            input point in PDF coordinate system. [x, y]
	 * @param dpoint
	 *            output point in DIB coordinate system. [x, y]
	 */
	public void ToDIBPoint(Matrix mat, float[] ppoint, float[] dpoint) {
		Global.ToDIBPoint(mat, ppoint, dpoint);
	}

	/**
	 * map DIB point to PDF point.
	 * 
	 * @param mat
	 *            Matrix object defined scale, rotate, tranlate operations.
	 * @param dpoint
	 *            input point in DIB coordinate system. [x, y]
	 * @param ppoint
	 *            output point in PDF coordinate system. [x, y]
	 */
	public void ToPDFPoint(Matrix mat, float[] dpoint, float[] ppoint) {
		Global.ToPDFPoint(mat, dpoint, ppoint);
	}

	/**
	 * map PDF rectangle to DIB rectangle.
	 * 
	 * @param mat
	 *            Matrix object defined scale, rotate, tranlate operations.
	 * @param prect
	 *            input rect in PDF coordinate system. [left, top, right,
	 *            bottom]
	 * @param drect
	 *            output rect in DIB coordinate system. [left, top, right,
	 *            bottom]
	 */
	public void ToDIBRect(Matrix mat, float[] prect, float[] drect) {
		Global.ToDIBRect(mat, prect, drect);
	}

	/**
	 * map DIB rectangle to PDF rectangle.
	 * 
	 * @param mat
	 *            Matrix object defined scale, rotate, tranlate operations.
	 * @param drect
	 *            input rect in DIB coordinate system. [left, top, right,
	 *            bottom]
	 * @param prect
	 *            output rect in PDF coordinate system. [left, top, right,
	 *            bottom]
	 */
	public void ToPDFRect(Matrix mat, float[] drect, float[] prect) {
		Global.ToPDFRect(mat, drect, prect);
	}

	/**
	 * map PDF point to DIB point.
	 * 
	 * @param ratio
	 *            scale value apply to page rendering.
	 * @param dib_h
	 *            height of render bitmap.
	 * @param ppoint
	 *            input point in PDF coordinate system. [x, y]
	 * @param dpoint
	 *            output point in DIB coordinate system. [x, y]
	 */
	public void ToDIBPoint(float ratio, int dib_h, float[] ppoint,
			float[] dpoint) {
		Global.ToDIBPoint(ratio, dib_h, ppoint, dpoint);
	}

	/**
	 * map DIB point to PDF point.
	 * 
	 * @param ratio
	 *            scale value apply to page rendering.
	 * @param dib_h
	 *            height of render bitmap.
	 * @param dpoint
	 *            input point in DIB coordinate system. [x, y]
	 * @param ppoint
	 *            output point in PDF coordinate system. [x, y]
	 */
	public void ToPDFPoint(float ratio, int dib_h, float[] dpoint,
			float[] ppoint) {
		Global.ToPDFPoint(ratio, dib_h, dpoint, ppoint);
	}

	/**
	 * map PDF rectangle to DIB rectangle.
	 * 
	 * @param ratio
	 *            scale value apply to page rendering.
	 * @param dib_h
	 *            height of render bitmap.
	 * @param prect
	 *            input rect in PDF coordinate system. [left, top, right,
	 *            bottom]
	 * @param drect
	 *            output rect in DIB coordinate system. [left, top, right,
	 *            bottom]
	 */
	public void ToDIBRect(float ratio, int dib_h, float[] prect, float[] drect) {
		Global.ToDIBRect(ratio, dib_h, prect, drect);
	}

	/**
	 * map DIB rectangle to PDF rectangle.
	 * 
	 * @param ratio
	 *            scale value apply to page rendering.
	 * @param dib_h
	 *            height of render bitmap.
	 * @param drect
	 *            input rect in DIB coordinate system. [left, top, right,
	 *            bottom]
	 * @param prect
	 *            output rect in PDF coordinate system. [left, top, right,
	 *            bottom]
	 */
	public void ToPDFRect(float ratio, int dib_h, float[] drect, float[] prect) {
		Global.ToPDFRect(ratio, dib_h, drect, prect);
	}

	/**
	 * lock Bitmap object, and get a handle.
	 * 
	 * @param bitmap
	 *            Bitmap object.
	 * @return hand handle value.
	 */
	public int LockBitmap(Bitmap bitmap) {
		return Global.lockBitmap(bitmap);
	}

	/**
	 * unlock Bitmap object, and free the handle.
	 * 
	 * @param bitmap
	 *            Bitmap object that passed to lockBitmap.
	 * @param bmp
	 *            handle value, that returned by lockBitmap.
	 */
	public void UnlockBitmap(Bitmap bitmap, int bmp) {
		Global.unlockBitmap(bitmap, bmp);
	}

	/**
	 * draw Bitmap object to a dib
	 * 
	 * @param dib
	 * @param bmp
	 *            handle value, that returned by lockBitmap.
	 * @param x
	 * @param y
	 */
	public void DrawBmpToDIB(int dib, int bmp, int x, int y) {
		Global.drawBmpToDIB(dib, bmp, x, y);
	}

	/**
	 * draw a dib to another dib
	 * 
	 * @param dst_dib
	 * @param src_dib
	 * @param x
	 * @param y
	 */
	public void DrawToDIB(int dst_dib, int src_dib, int x, int y) {
		Global.drawToDIB(dst_dib, src_dib, x, y);
	}

	/**
	 * draw dib to bmp.
	 * 
	 * @param bmp
	 *            handle value, that returned by lockBitmap.
	 * @param dib
	 * @param x
	 *            origin position in bmp.
	 * @param y
	 *            origin position in bmp.
	 */
	public void DrawToBmp(int bmp, int dib, int x, int y) {
		Global.drawToBmp(bmp, dib, x, y);
	}

	/**
	 * draw dib to bmp, with scale
	 * 
	 * @param bmp
	 * @param dib
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public void DrawToBmp2(int bmp, int dib, int x, int y, int w, int h) {
		Global.drawToBmp2(bmp, dib, x, y, w, h);
	}

	/**
	 * fill solid rectangle to bmp.
	 * 
	 * @param bmp
	 *            handle value, that returned by lockBitmap.
	 * @param color
	 *            the color to fill, formatted: 0xAARRGGBB, AA: alpha value.
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param mode
	 * <br/>
	 *            0: mix color by source pixels with alpha channel. <br/>
	 *            1: replace pixels.
	 */
	public void DrawRect(int bmp, int color, int x, int y, int width,
			int height, int mode) {
		Global.drawRect(bmp, color, x, y, width, height, mode);
	}

	public void DrawRectToDIB(int dib, int color, int x, int y, int width,
			int height, int mode) {
		Global.drawRectToDIB(dib, color, x, y, width, height, mode);
	}

	/**
	 * invert all colors for locked bmp.
	 * 
	 * @param bmp
	 *            handle value, that returned by lockBitmap.
	 */
	public void InvertBmp(int bmp) {
		Global.invertBmp(bmp);
	}

	/**
	 * create or resize dib, and reset all pixels in dib.<br/>
	 * if dib is 0, function create a new dib object.<br/>
	 * otherwise function resize the dib object.
	 */
	public int DibGet(int dib, int width, int height) {
		return Global.dibGet(dib, width, height);
	}

	/**
	 * free dib object.
	 */
	public int DibFree(int dib) {
		return Global.dibFree(dib);
	}

}
