package com.rootsoft.rspdfviewer.pdf;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;

import com.radaee.pdf.Matrix;
import com.radaee.pdf.PageContent;
import com.radaee.pdf.Path;
import com.radaee.pdf.Page.ResFont;
import com.radaee.pdf.Page.ResGState;
import com.radaee.pdf.Page.ResImage;

@ShortName("PDFPageContent")
public class RSPDFPageContent extends AbsObjectWrapper<PageContent> {

	// Attributes

	// Constructors - Initialization

	/**
	 * Initializes the PDF Page Content.
	 */
	public void Initialize() {
		setObject(new PageContent());
	}

	/**
	 * create it.
	 */
	public void Create() {
		getObject().Create();
	}

	/**
	 * destroy and free memory.
	 */
	public void Destroy() {
		getObject().Destroy();
	}

	/**
	 * PDF operator: gs_save, save current GraphicState
	 */
	public void GSSave() {
		 getObject().GSSave();
	}

	/**
	 * PDF operator: gs_restore, restore GraphicState
	 */
	public void GSRestore() {
		 getObject().GSRestore();
	}

	/**
	 * PDF operator: set matrix.
	 * 
	 * @param mat
	 *            Matrix object
	 */
	public void GSSetMatrix(Matrix mat) {
		 getObject().GSSetMatrix(mat);
	}

	/**
	 * PDF operator: set ExtGraphicState
	 * 
	 * @param gs
	 *            ResGState object created by Page.AddResGState()
	 */
	public void GSSet(ResGState gs) {
		 getObject().GSSet(gs);
	}

	/**
	 * PDF operator: show image.
	 * 
	 * @param image
	 *            image object created by Page.AddResImage()
	 */
	public void DrawImage(ResImage image) {
		 getObject().DrawImage(image);
	}

	/**
	 * fill path.
	 * 
	 * @param path
	 *            Path object
	 * @param winding
	 *            winding fill rule?
	 */
	public void FillPath(Path path, boolean winding) {
		 getObject().FillPath(path, winding);
	}

	/**
	 * set the path as clip path.
	 * 
	 * @param path
	 *            Path object
	 * @param winding
	 *            winding fill rule?
	 */
	public void ClipPath(Path path, boolean winding) {
		 getObject().ClipPath(path, winding);
	}

	/**
	 * stroke path.
	 * 
	 * @param path
	 *            Path object
	 */
	public void StrokePath(Path path) {
		 getObject().StrokePath(path);
	}

	/**
	 * PDF operator: set fill and other operations color.
	 * 
	 * @param color
	 *            formatted as 0xRRGGBB, no alpha channel. alpha value shall set
	 *            by ExtGraphicState(ResGState).
	 */
	public void SetFillColor(int color) {
		 getObject().SetFillColor(color);
	}

	/**
	 * PDF operator: set stroke color.
	 * 
	 * @param color
	 *            formatted as 0xRRGGBB, no alpha channel. alpha value shall set
	 *            by ExtGraphicState(ResGState).
	 */
	public void SetStrokeColor(int color) {
		 getObject().SetStrokeColor(color);
	}

	/**
	 * PDF operator: set line cap
	 * 
	 * @param cap
	 *            0:butt, 1:round: 2:square
	 */
	public void SetStrokeCap(int cap) {
		 getObject().SetStrokeCap(cap);
	}

	/**
	 * PDF operator: set line join
	 * 
	 * @param join
	 *            0:miter, 1:round, 2:bevel
	 */
	public void SetStrokeJoin(int join) {
		 getObject().SetStrokeJoin(join);
	}

	/**
	 * PDF operator: set line width
	 * 
	 * @param w
	 *            line width in PDF coordinate
	 */
	public void SetStrokeWidth(float w) {
		 getObject().SetStrokeWidth(w);
	}

	/**
	 * PDF operator: set miter limit.
	 * 
	 * @param miter
	 *            miter limit.
	 */
	public void SetStrokeMiter(float miter) {
		 getObject().SetStrokeMiter(miter);
	}

	/**
	 * show text
	 * 
	 * @param text
	 *            text to show, '\r' or '\n' in string start a new line.
	 */
	public void DrawText(String text) {
		 getObject().DrawText(text);
	}

	/**
	 * PDF operator: begin text and set text position to (0,0).
	 */
	public void TextBegin() {
		 getObject().TextBegin();
	}

	/**
	 * PDF operator: text end.
	 */
	public void TextEnd() {
		getObject().TextEnd();
	}

	/**
	 * PDF operator: set char space(extra space between chars).
	 * 
	 * @param space
	 *            char space
	 */
	public void TextSetCharSpace(float space) {
		getObject().TextSetCharSpace(space);
	}

	/**
	 * PDF operator: set word space(extra space between words spit by blank char
	 * ' ' ).
	 * 
	 * @param space
	 *            word space.
	 */
	public void TextSetWordSpace(float space) {
		getObject().TextSetWordSpace(space);
	}

	/**
	 * PDF operator: set text leading, height between 2 text lines.
	 * 
	 * @param leading
	 *            leading in PDF coordinate
	 */
	public void TextSetLeading(float leading) {
		getObject().TextSetLeading(leading);
	}

	/**
	 * PDF operator: set text rise
	 * 
	 * @param rise
	 */
	public void TextSetRise(float rise) {
		getObject().TextSetRise(rise);
	}

	/**
	 * PDF operator: set horizon scale for chars.
	 * 
	 * @param scale
	 *            100 means scale value 1.0f
	 */
	public void TextSetHScale(int scale) {
		getObject().TextSetHScale(scale);
	}

	/**
	 * PDF operator: new a text line
	 */
	public void TextNextLine() {
		getObject().TextNextLine();
	}

	/**
	 * PDF operator: move text position relative to previous line
	 * 
	 * @param x
	 *            in PDF coordinate add to previous line position
	 * @param y
	 *            in PDF coordinate add to previous line position
	 */
	public void TextMove(float x, float y) {
		getObject().TextMove(x, y);
	}

	/**
	 * PDF operator: set text render mode.
	 * 
	 * @param mode
	 * <br/>
	 *            0: filling<br/>
	 *            1: stroke<br/>
	 *            2: fill and stroke<br/>
	 *            3: do nothing<br/>
	 *            4: fill and set clip path<br/>
	 *            5: stroke and set clip path<br/>
	 *            6: fill/stroke/clip<br/>
	 *            7: set clip path.
	 */
	public void TextSetRenderMode(int mode) {
		getObject().TextSetRenderMode(mode);
	}

	/**
	 * set text font
	 * 
	 * @param font
	 *            ResFont object created by Page.AddResFont()
	 * @param size
	 *            text size in PDF coordinate.
	 */
	public void TextSetFont(ResFont font, float size) {
		getObject().TextSetFont(font, size);
	}

	/**
	 * reserved.
	 * 
	 * @param font
	 * @param text
	 *            test to display, may container '\r' or '\n'
	 * @param width
	 *            font width
	 * @param height
	 *            font height
	 * @param char_space
	 * @param word_space
	 * @return
	 */
	public float[] TextGetSize(ResFont font, String text, float width, float height, float char_space, float word_space) {
		return getObject().TextGetSize(font, text, width, height, char_space, word_space);
		
	}

}
