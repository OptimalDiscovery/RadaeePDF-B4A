package com.rootsoft.rspdfviewer.pdf;

import android.graphics.Bitmap;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;

import com.radaee.pdf.Document.DocFont;
import com.radaee.pdf.Document.DocGState;
import com.radaee.pdf.Document.DocImage;
import com.radaee.pdf.HWriting;
import com.radaee.pdf.Ink;
import com.radaee.pdf.Matrix;
import com.radaee.pdf.Page;
import com.radaee.pdf.Page.Annotation;
import com.radaee.pdf.Page.Finder;
import com.radaee.pdf.Page.ResFont;
import com.radaee.pdf.Page.ResGState;
import com.radaee.pdf.Page.ResImage;
import com.radaee.pdf.PageContent;
import com.radaee.pdf.Path;

@ShortName("PDFPage")
public class RSPDFPage extends AbsObjectWrapper<Page> {
	
	//Attributes

	//Constructors - Initialization
	
	/**
	 * Initializes the PDF Page.
	 */
	public void Initialize() {
		setObject(new Page());
	}
	
	/**
	 * Close page object and free memory.
	 */
	public void Close()
	{
		getObject().Close();
	}
	/**
	 * prepare to render. it reset dib pixels to white value, and reset page status.
	 * @param dib DIB object to render. obtained by Global.dibGet().
	 */
	public void RenderPrePare( int dib )
	{
		getObject().RenderPrePare(dib);
	}
	/**
	 * render page to dib object. this function returned for cancelled or finished.<br/>before render, you need invoke RenderPrePare.
	 * @param dib DIB object to render. obtained by Global.dibGet().
	 * @param mat Matrix object define scale, rotate, translate operations.
	 * @return true or false.
	 */
	public boolean Render( int dib, Matrix mat )
	{
		return getObject().Render(dib, mat);
	}
	/**
	 * render page to Bitmap object directly. this function returned for cancelled or finished.<br/>before render, you need erase Bitmap object. 
	 * @param bitmap Bitmap object to render.
	 * @param mat Matrix object define scale, rotate, translate operations.
	 * @return true or false.
	 */
	public boolean RenderToBmp( Bitmap bitmap, Matrix mat )
	{
		return getObject().RenderToBmp(bitmap, mat);
	}
	
	/**
	 * render to page in normal quality
	 * @param dib same as Render function
	 * @param mat same as Render function
	 */
	public void Render_Normal( int dib, Matrix mat )
	{
		getObject().Render_Normal(dib, mat);
	}
	/**
	 * set page status to cancelled and cancel render function.
	 */
	public void RenderCancel()
	{
		getObject().RenderCancel();
	}
	/**
	 * render thumb image to Bitmap object.<br/>
	 * the image always scale and displayed in center of Bitmap.<br/>
	 * @param bmp Bitmap to render
	 * @return true if the page has thumb image, or false.
	 */
	public boolean RenderThumb(Bitmap bmp)
	{
		return getObject().RenderThumb(bmp);
	}
	/**
	 * check if page rendering is finished.
	 * @return true or false
	 */
	public boolean RenderIsFinished()
	{
		return getObject().RenderIsFinished();
	}
	/**
	 * get text objects to memory.<br/>
	 * a standard license is needed for this method
	 */
	public void ObjsStart()
	{
		getObject().ObjsStart();
	}
	/**
	 * get string from range. this can be invoked after ObjsStart
	 * @param from 0 based unicode index.
	 * @param to 0 based unicode index.
	 * @return string or null.
	 */
	public String ObjsGetString( int from, int to )
	{
		return getObject().ObjsGetString(from, to);
	}
	/**
	 * get index aligned by word. this can be invoked after ObjsStart
	 * @param from 0 based unicode index.
	 * @param dir if dir < 0,  get start index of the word. otherwise get last index of the word.
	 * @return new index value.
	 */
	public int ObjsAlignWord( int from, int dir )
	{
		return getObject().ObjsAlignWord(from, dir);
	}
	/**
	 * get char's box in PDF coordinate system, this can be invoked after ObjsStart
	 * @param index 0 based unicode index.
	 * @param vals return 4 elements for PDF rectangle.
	 */
	public void ObjsGetCharRect( int index, float[]vals )
	{
		getObject().ObjsGetCharRect(index, vals);
	}
	/**
	 * get char's font name. this can be invoked after ObjsStart
	 * @param index 0 based unicode index.
	 * @return font name, may be null.
	 */
	public String ObjsGetCharFontName( int index )
	{
		return getObject().ObjsGetCharFontName(index);
	}
	/**
	 * get chars count in this page. this can be invoked after ObjsStart<br/>
	 * a standard license is needed for this method
	 * @return count or 0 if ObjsStart not invoked.
	 */
	public int ObjsGetCharCount()
	{
		return getObject().ObjsGetCharCount();
	}
	/**
	 * get char index nearest to point
	 * @param pt point as [x,y] in PDF coordinate.
	 * @return char index or -1 failed.
	 */
	public int ObjsGetCharIndex( float[] pt )
	{
		return getObject().ObjsGetCharIndex(pt);
	}
	/**
	 * create a find session. this can be invoked after ObjsStart
	 * @param str key string to find.
	 * @param match_case match case?
	 * @param whole_word match whole word?
	 * @return handle of find session, or 0 if no found.
	 */
	public Finder FindOpen( String str, boolean match_case, boolean whole_word )
	{
		return getObject().FindOpen(str, match_case, whole_word);
	}

	/**
	 * get rotate degree for page, example: 0 or 90
	 * @param page
	 * @return rotate degree for page
	 */
	public int getRotate()
	{
		return getObject().GetRotate();
	}
	/**
	 * get annotations count in this page.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @return count
	 */
	public int getAnnotCount()
	{
		return getObject().GetAnnotCount();
	}
	/**
	 * get annotations by index.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param index 0 based index value. range:[0, GetAnnotCount()-1]
	 * @return handle of annotation, valid until Close invoked.
	 */
	public Annotation GetAnnot( int index )
	{
		return getObject().GetAnnot(index);
	}
	/**
	 * get annotations by PDF point.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param x x value in PDF coordinate system.
	 * @param y y value in PDF coordinate system.
	 * @return handle of annotation, valid until Close invoked.
	 */
	public Annotation GetAnnotFromPoint( float x, float y )
	{
		return getObject().GetAnnotFromPoint(x, y);
	}
	/**
	 * add goto-page link to page.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param rect link area rect [left, top, right, bottom] in PDF coordinate.
	 * @param pageno 0 based pageno to goto.
	 * @param top y coordinate in PDF coordinate, page.height is top of page. and 0 is bottom of page.
	 * @return true or false.<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotGoto( float[] rect, int pageno, float top )
	{
		return getObject().AddAnnotGoto(rect, pageno, top);
	}
	
	/**
	 * add URL link to page.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param rect link area rect [left, top, right, bottom] in PDF coordinate.
	 * @param uri url address, example: "http://www.radaee.com/en"
	 * @return true or false.<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotURI( float[] rect, String uri )
	{
		return getObject().AddAnnotURI(rect, uri);
	}
	
	/**
	 * add an Rubber Stamp to page.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param rect icon area rect [left, top, right, bottom] in PDF coordinate.
	 * @param icon predefined value as below:<br/>
	 *  0: "Draft"(default icon)<br/>
	 *  1: "Approved"<br/>
	 *  2: "Experimental"<br/>
	 *  3: "NotApproved"<br/>
	 *  4: "AsIs"<br/>
	 *  5: "Expired"<br/>
	 *  6: "NotForPublicRelease"<br/>
	 *  7: "Confidential"<br/>
	 *  8: "Final"<br/>
	 *  9: "Sold"<br/>
	 * 10: "Departmental"<br/>
	 * 11: "ForComment"<br/>
	 * 12: "TopSecret"<br/>
	 * 13: "ForPublicRelease"<br/>
	 * 14: "Accepted"<br/>
	 * 15: "Rejected"<br/>
	 * 16: "Witness"<br/>
	 * 17: "InitialHere"<br/>
	 * 18: "SignHere"<br/>
	 * 19: "Void"<br/>
	 * 20: "Completed"<br/>
	 * 21: "PreliminaryResults"<br/>
	 * 22: "InformationOnly"<br/>
	 * 23: "End"<br/>
	 * @return true or false.<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotStamp( float[] rect, int icon )
	{
		return getObject().AddAnnotStamp(rect, icon);
	}
	
	/**
	 * add hand-writing to page.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param mat Matrix for Render function.
	 * @param ink Ink object
	 * @param orgx origin x coordinate in page. in DIB coordinate system
	 * @param orgy origin y coordinate in page. in DIB coordinate system
	 * @return true or false<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotInk( Matrix mat, Ink ink, float orgx, float orgy )
	{
		return getObject().AddAnnotInk(mat, ink, orgx, orgy);
	}
	/**
	 * add hand-writing to page.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param mat Matrix for Render function.
	 * @param hwriting hand writing object
	 * @param orgx origin x coordinate in page. in DIB coordinate system
	 * @param orgy origin y coordinate in page. in DIB coordinate system
	 * @return true or false<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotHWriting( Matrix mat, HWriting hwriting, float orgx, float orgy )
	{
		return getObject().AddAnnotHWriting(mat, hwriting, orgx, orgy);
	}
	/**
	 * add a user-defined glyph to page.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param mat Matrix for Render function.
	 * @param path Path object.
	 * @param color text color, formated as 0xAARRGGBB.
	 * @param winding if true, using winding fill rule, otherwise using odd-even fill rule.
	 * @return true or false.<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotGlyph( Matrix mat, Path path, int color, boolean winding )
	{
		return getObject().AddAnnotGlyph(mat, path, color, winding);
	}
	/**
	 * add rectangle to page.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param mat Matrix for Render function.
	 * @param rect 4 elements for left, top, right, bottom in DIB coordinate system
	 * @param width line width
	 * @param color rectangle color, formated as 0xAARRGGBB
	 * @param fill_color fill color in rectangle, formated as 0xAARRGGBB, if alpha channel is 0, means no fill operation, otherwise alpha channel are ignored.
	 * @return true or false.<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotRect( Matrix mat, float[] rect, float width, int color, int fill_color )
	{
		return getObject().AddAnnotRect(rect, width, color, fill_color);
	}
	/**
	 * add line to page.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param mat Matrix for Render function.
	 * @param pt1 start point, 2 elements for x,y
	 * @param pt2 end point, 2 elements for x,y
	 * @param style1 style for start point:<br/>
	 * 0: None<br/>
	 * 1: Arrow<br/>
	 * 2: Closed Arrow<br/>
	 * 3: Square<br/>
	 * 4: Circle<br/>
	 * 5: Butt<br/>
	 * 6: Diamond<br/>
	 * 7: Reverted Arrow<br/>
	 * 8: Reverted Closed Arrow<br/>
	 * 9: Slash
	 * @param style2 style for end point, values are same as style1.
	 * @param width line width in DIB coordinate
	 * @param color line color. same as addAnnotRect.
	 * @param fill_color fill color. same as addAnnotRect.
	 * @return true or false.<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotLine( Matrix mat, float[] pt1, float[] pt2, int style1, int style2, float width, int color, int fill_color )
	{
		return getObject().AddAnnotLine(mat, pt1, pt2, style1, style2, width, color, fill_color);
	}
	/**
	 * add ellipse to page.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param mat Matrix for Render function.
	 * @param rect 4 elements for left, top, right, bottom in DIB coordinate system
	 * @param width line width
	 * @param color ellipse color, formated as 0xAARRGGBB
	 * @param fill_color fill color in ellipse, formated as 0xAARRGGBB, if alpha channel is 0, means no fill operation, otherwise alpha channel are ignored.
	 * @return true or false<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotEllipse( Matrix mat, float[] rect, float width, int color, int fill_color )
	{
		return getObject().AddAnnotEllipse(mat, rect, width, color, fill_color);
	}
	/**
	 * add a text-markup annotation to page.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param mat Matrix for Render function.
	 * @param rects 4 * n rectangles, each 4 elements: left, top, right, bottom in DIB coordinate system. n is decided by length of array.
	 * @param type 0: Highlight, 1: Underline, 2: StrikeOut, 3: Highlight without round corner.
	 * @return true or false.<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotMarkup( Matrix mat, float[] rects, int type )
	{
		return getObject().AddAnnotMarkup(mat, rects, type);
	}
	/**
	 * add hand-writing to page.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param ink Ink object in PDF coordinate.
	 * @return true or false.<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotInk2( Ink ink )
	{
		return getObject().AddAnnotInk(ink);
	}
	/**
	 * add line to page.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param pt1 start point in PDF coordinate, 2 elements for x,y
	 * @param pt2 end point in PDF coordinate, 2 elements for x,y
	 * @param style1 style for start point:<br/>
	 * 0: None<br/>
	 * 1: Arrow<br/>
	 * 2: Closed Arrow<br/>
	 * 3: Square<br/>
	 * 4: Circle<br/>
	 * 5: Butt<br/>
	 * 6: Diamond<br/>
	 * 7: Reverted Arrow<br/>
	 * 8: Reverted Closed Arrow<br/>
	 * 9: Slash
	 * @param style2 style for end point, values are same as style1.
	 * @param width line width in DIB coordinate
	 * @param color line color. same as addAnnotRect.
	 * @param fill_color fill color, used to fill arrows of the line.
	 * @return true or false.<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotLine2( float[] pt1, float[] pt2, int style1, int style2, float width, int color, int icolor )
	{
		return getObject().AddAnnotLine(pt1, pt2, style1, style2, width, color, icolor);
	}
	/**
	 * add rectangle to page.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param rect 4 elements for left, top, right, bottom in PDF coordinate system
	 * @param width line width in PDF coordinate.
	 * @param color rectangle color, formated as 0xAARRGGBB
	 * @param fill_color fill color in rectangle, formated as 0xAARRGGBB, if alpha channel is 0, means no fill operation, otherwise alpha channel are ignored.
	 * @return true or false.<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotRect2( float[] rect, float width, int color, int fill_color )
	{
		return getObject().AddAnnotRect(rect, width, color, fill_color);
	}
	/**
	 * add ellipse to page.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param rect 4 elements for left, top, right, bottom in PDF coordinate system
	 * @param width line width in PDF coordinate
	 * @param color ellipse color, formated as 0xAARRGGBB
	 * @param fill_color fill color in ellipse, formated as 0xAARRGGBB, if alpha channel is 0, means no fill operation, otherwise alpha channel are ignored.
	 * @return true or false<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotEllipse2( float[] rect, float width, int color, int fill_color )
	{
		return getObject().AddAnnotEllipse(rect, width, color, fill_color);
	}
	/**
	 * add an edit-box on page. the edit-box has no border and background.
	 * the font of edit box is set by Global.setTextFont in Global.Init().
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in premium version.
	 * @param rect 4 elements: left, top, right, bottom in PDF coordinate system.
	 * @param tsize text size in DIB coordinate system.
	 * @param color text color, formated as 0xAARRGGBB.
	 * @return true or false.<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotEditbox2( float[] rect, float tsize, int color )
	{
		return getObject().AddAnnotEditbox(rect, tsize, color);
	}
	/**
	 * add polygon to page.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param path must be a closed contour.
	 * @param color stroke color formated as 0xAARRGGBB.
	 * @param fill_color fill color, formated as 0xAARRGGBB. if AA == 0, no fill operations, otherwise alpha value is same to stroke color. 
	 * @param width stroke width in PDF coordinate
	 * @return true or false.<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotPolygon( Path path, int color, int fill_color, float width )
	{
		return getObject().AddAnnotPolygon(path, color, fill_color, width);
	}
	/**
	 * add polyline to page.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param path must be a set of unclosed lines. do not container any move-to operation except the first point in the path.
	 * @param style1 style for start point:<br/>
	 * 0: None<br/>
	 * 1: Arrow<br/>
	 * 2: Closed Arrow<br/>
	 * 3: Square<br/>
	 * 4: Circle<br/>
	 * 5: Butt<br/>
	 * 6: Diamond<br/>
	 * 7: Reverted Arrow<br/>
	 * 8: Reverted Closed Arrow<br/>
	 * 9: Slash
	 * @param style2 style for end point, values are same as style1.
	 * @param color stroke color formated as 0xAARRGGBB.
	 * @param fill_color fill color, formated as 0xAARRGGBB. if AA == 0, no fill operations, otherwise alpha value is same to stroke color. 
	 * @param width stroke width in PDF coordinate
	 * @return true or false.<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotPolyline( Path path, int style1, int style2, int color, int fill_color, float width )
	{
		return getObject().AddAnnotPolyline(path, style1, style2, color, fill_color, width);
	}
	/**
	 * add a text-markup annotation to page.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this can be only invoked after ObjsStart.<br/>
	 * this method valid in professional or premium version
	 * @param cindex1 first char index
	 * @param cindex2 second char index
	 * @param type type as following:<br/>
	 * 0: Highlight<br/>
	 * 1: Underline<br/>
	 * 2: StrikeOut<br/>
	 * 3: Highlight without round corner<br/>
	 * 4: Squiggly underline.
	 * @return true or false.<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotMarkup2( int cindex1, int cindex2, int type )
	{
		return getObject().AddAnnotMarkup(cindex1, cindex2, type);
	}
	/**
	 * add a bitmap object as an annotation to page.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param bitmap Bitmap object to add, which should be formated in ARGB_8888
	 * @param has_alpha is need to save alpha channel information?
	 * @param rect 4 elements: left, top, right, bottom in PDF coordinate system.
	 * @return true or false.<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotBitmap( Bitmap bitmap, boolean has_alpha, float[] rect )
	{
		return getObject().AddAnnotBitmap(bitmap, has_alpha, rect);
	}
	/**
	 * add a file as an attachment to page.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param path absolute path name to the file.
	 * @param icon icon display to the page. values as:<br/>
	 * 0: PushPin<br/>
	 * 1: Graph<br/>
	 * 2: Paperclip<br/>
	 * 3: Tag<br/>
	 * @param rect 4 elements: left, top, right, bottom in PDF coordinate system.
	 * @return true or false.<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true. 
	 */
	public boolean AddAnnotAttachment(String path, int icon, float[] rect)
	{
		return getObject().AddAnnotAttachment(path, icon, rect);
	}
	/**
	 * add a sticky text annotation to page.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in professional or premium version
	 * @param pt 2 elements: x, y in PDF coordinate system.
	 * @return true or false.<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotText( float[] pt )
	{
		return getObject().AddAnnotText(pt);
	}
	/**
	 * add an edit-box on page. the edit-box has no border and background.
	 * the font of edit box is set by Global.setTextFont in Global.Init().
	 * this can be invoked after ObjsStart or Render or RenderToBmp.<br/>
	 * this method valid in premium version.
	 * @param matrix Matrix object that passed to Render or RenderToBmp function.
	 * @param rect 4 elements: left, top, right, bottom in DIB coordinate system.
	 * @param tsize text size in DIB coordinate system.
	 * @param color text color, formated as 0xAARRGGBB.
	 * @return true or false.<br/>
	 * the added annotation can be obtained by Page.GetAnnot(Page.GetAnnotCount() - 1), if this method return true.
	 */
	public boolean AddAnnotEditbox( Matrix mat, float[] rect, float tsize, int color )
	{
		return getObject().AddAnnotEditbox(mat, rect, tsize, color);
	}
	/**
	 * Start Reflow.<br/>
	 * this method valid in professional or premium version
	 * @param width input width, function calculate height.
	 * @param scale scale base to 72 DPI, 2.0 means 144 DPI. the reflowed text will displayed in scale
	 * @param enable_images enable reflow images.
	 * @return the height that reflow needed.
	 */
	public float ReflowStart( float width, float scale, boolean enable_images )
	{
		return getObject().ReflowStart(width, scale, enable_images);
	}
	/**
	 * Reflow to dib.<br/>
	 * this method valid in professional or premium version
	 * @param dib dib to render
	 * @param orgx origin x coordinate
	 * @param orgy origin y coordinate
	 * @return true or false
	 */
	public boolean Reflow( int dib, float orgx, float orgy )
	{
		return getObject().Reflow(dib, orgx, orgy);
	}
	/**
	 * Reflow to Bitmap object.<br/>
	 * this method valid in professional or premium version
	 * @param bitmap bitmap to reflow
	 * @param orgx origin x coordinate
	 * @param orgy origin y coordinate
	 * @return true or false
	 */
	public boolean ReflowToBmp( Bitmap bitmap, float orgx, float orgy )
	{
		return getObject().ReflowToBmp(bitmap, orgx, orgy);
	}
	/**
	 * get reflow paragraph count.<br/>
	 * this method valid in professional or premium version
	 * @return count
	 */
	public int ReflowGetParaCount()
	{
		return getObject().ReflowGetParaCount();
	}
	/**
	 * get one paragraph's char count.<br/>
	 * this method valid in professional or premium version
	 * @param iparagraph paragraph index range[0, ReflowGetParaCount()-1]
	 * @return char count
	 */
	public int ReflowGetCharCount( int iparagraph )
	{
		return getObject().ReflowGetCharCount(iparagraph);
	}
	/**
	 * get char's font width.<br/>
	 * this method valid in professional or premium version
	 * @param iparagraph paragraph index range[0, ReflowGetParaCount()-1]
	 * @param ichar char index range[0, ReflowGetCharCount()]
	 * @return font width for this char
	 */
	public float ReflowGetCharWidth( int iparagraph, int ichar )
	{
		return getObject().ReflowGetCharWidth(iparagraph, ichar);
	}
	/**
	 * get char's font height.<br/>
	 * this method valid in professional or premium version
	 * @param iparagraph paragraph index range[0, ReflowGetParaCount()-1]
	 * @param ichar char index range[0, ReflowGetCharCount()]
	 * @return font height for this char
	 */
	public float ReflowGetCharHeight( int iparagraph, int ichar )
	{
		return getObject().ReflowGetCharHeight(iparagraph, ichar);
	}
	/**
	 * get char's fill color for display.<br/>
	 * this method valid in professional or premium version
	 * @param iparagraph paragraph index range[0, ReflowGetParaCount()-1]
	 * @param ichar char index range[0, ReflowGetCharCount()]
	 * @return color value formatted 0xAARRGGBB, AA: alpha value, RR:red, GG:green, BB:blue
	 */
	public int ReflowGetCharColor( int iparagraph, int ichar )
	{
		return getObject().ReflowGetCharColor(iparagraph, ichar);
	}
	/**
	 * get char's unicode value.<br/>
	 * this method valid in professional or premium version
	 * @param iparagraph paragraph index range[0, ReflowGetParaCount()-1]
	 * @param ichar char index range[0, ReflowGetCharCount()]
	 * @return unicode
	 */
	public int ReflowGetCharUnicode( int iparagraph, int ichar )
	{
		return getObject().ReflowGetCharUnicode(iparagraph, ichar);
	}
	/**
	 * get char's font name.<br/>
	 * this method valid in professional or premium version
	 * @param iparagraph paragraph index range[0, ReflowGetParaCount()-1]
	 * @param ichar char index range[0, ReflowGetCharCount()]
	 * @return name string
	 */
	public String ReflowGetCharFont( int iparagraph, int ichar )
	{
		return getObject().ReflowGetCharFont(iparagraph, ichar);
	}
	/**
	 * get char's bound box.<br/>
	 * this method valid in professional or premium version
	 * @param iparagraph paragraph index range[0, ReflowGetParaCount()-1]
	 * @param ichar char index range[0, ReflowGetCharCount()]
	 * @param rect output: 4 element as [left, top, right, bottom].
	 */
	public void ReflowGetCharRect( int iparagraph, int ichar, float rect[] )
	{
		getObject().ReflowGetCharRect(iparagraph, ichar, rect);
	}
	/**
	 * get text from range.<br/>
	 * this method valid in professional or premium version
	 * @param iparagraph1 first position
	 * @param ichar1 first position
	 * @param iparagraph2 second position
	 * @param ichar2 second position
	 * @return string value or null
	 */
	public String ReflowGetText( int iparagraph1, int ichar1, int iparagraph2, int ichar2 )
	{
		return getObject().ReflowGetText(iparagraph1, ichar1, iparagraph2, ichar2);
	}
	/**
	 * add a font as resource of this page.<br/>
	 * a premium license is needed for this method.
	 * @param font font object created by Document.NewFontCID()
	 * @return ResFont or null.
	 */
	public ResFont AddResFont( DocFont font )
	{
		return getObject().AddResFont(font);
	}
	/**
	 * add an image as resource of this page.<br/>
	 * a premium license is needed for this method.
	 * @param image image object created by Document.NewImage() or Document.NewImageJPEG()
	 * @return null means failed.
	 */
	public ResImage AddResImage( DocImage image )
	{
		return getObject().AddResImage(image);
	}
	/**
	 * add GraphicState as resource of this page.<br/>
	 * a premium license is needed for this method.
	 * @param gstate ExtGraphicState created by Document.NewGState();
	 * @return null means failed.
	 */
	public ResGState AddResGState( DocGState gstate )
	{
		return getObject().AddResGState(gstate);
	}
	/**
	 * add content stream to this page.<br/>
	 * a premium license is needed for this method.
	 * @param content PageContent object called PageContent.create().
	 * @return true or false.
	 */
	public boolean AddContent( PageContent content )
	{
		return getObject().AddContent(content);
	}
	/**
	 * clone an annotation object to this page.<br/>
	 * this method need a professional or premium license.
	 * @param annot Annotation object must be in this document..
	 * @param rect [left, top, right, bottom] in PDF coordinate.
	 * @return true or false.
	 */
	public boolean CopyAnnot( Annotation annot, float[] rect )
	{
		return getObject().CopyAnnot(annot, rect);
	}
	
	@ShortName("PDFPageFinder")
	public class RSPPDFDocGState extends AbsObjectWrapper<Page.Finder> {
		
		/**
		 * Initializes the DocGState
		 */
		public void Initialize(Finder finder) {
			setObject(finder);
		}
		
		/**
		 * get find count in this page.
		 * @param hand_finder handle of find session, obtained by FindOpen.
		 * @return count or 0 if no found.
		 */
		public int GetCount()
		{
			return getObject().GetCount();
		}
		/**
		 * get find count in this page.
		 * @param hand_finder handle of find session, obtained by FindOpen.
		 * @param index 0 based index value. range:[0, FindGetCount()-1]
		 * @return the first char index of texts, see: ObjsGetString. range:[0, ObjsGetCharCount()-1]
		 */
		public int GetFirstChar( int index )
		{
			return getObject().GetFirstChar(index);
		}
		/**
		 * free memory of find session.
		 * @param hand_finder handle of find session, obtained by FindOpen.
		 */
		public void Close()
		{
			getObject().Close();
		}
	}
	
	
}
