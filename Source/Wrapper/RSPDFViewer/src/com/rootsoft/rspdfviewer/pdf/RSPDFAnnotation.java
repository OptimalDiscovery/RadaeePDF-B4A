package com.rootsoft.rspdfviewer.pdf;

import android.graphics.Bitmap;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;

import com.radaee.pdf.Page;
import com.radaee.pdf.Page.Annotation;
import com.radaee.pdf.PageContent;
import com.radaee.pdf.Path;

@ShortName("PDFAnnotation")
public class RSPDFAnnotation extends AbsObjectWrapper<Annotation> {

	// Attributes

	// Constructors - Initialization

	/**
	 * Initializes the PDF Annotation.
	 */
	public void Initialize(Annotation annotation) {
		setObject(annotation);
	}

	/**
	 * get this annotation index in page.
	 * 
	 * @return 0 based index value or -1;
	 */
	public int getIndexInPage() {
		return getObject().GetIndexInPage();
	}

	/**
	 * move annotation to another page.<be/> this method valid in professional
	 * or premium version.<br/>
	 * this method just like invoke Page.CopyAnnot() and
	 * Annotation.RemoveFromPage(), but, less data generated.<br/>
	 * Notice: ObjsStart or RenderXXX shall be invoked for dst_page.
	 * 
	 * @param dst_page
	 *            page to move.
	 * @param rect
	 *            [left, top, right, bottom] in PDF coordinate in dst_page.
	 * @return true or false.
	 */
	public boolean MoveToPage(Page dst_page, float[] rect) {
		return getObject().MoveToPage(dst_page, rect);
	}

	/**
	 * render an annotation to Bitmap. this method fully scale annotation to
	 * bitmap object.<br/>
	 * this method valid in professional or premium version.<br/>
	 * Notice 1: the render result may not correct for some annotation that not
	 * used Alpha Color blending.<br/>
	 * example: highlight annotation may not render correctly.<br/>
	 * Notice 2: you can invoke Global.hideAnnots() in Global.Init(), and invoke
	 * this method to handle Annotations by yourself.
	 * 
	 * @param bitmap
	 *            Bitmap object.
	 * @return true or false.
	 */
	public boolean RenderToBmp(Bitmap bitmap) {
		return getObject().RenderToBmp(bitmap);
	}

	/**
	 * get annotation field type in acroForm.<br/>
	 * this method valid in premium version
	 * 
	 * @return type as these values:<br/>
	 *         0: unknown<br/>
	 *         1: button field<br/>
	 *         2: text field<br/>
	 *         3: choice field<br/>
	 *         4: signature field<br/>
	 */
	public int GetFieldType() {
		return getObject().GetFieldType();
	}

	/**
	 * get name of the annotation.<br/>
	 * this method valid in premium version
	 * 
	 * @return null if it is not field, or name of the annotation, example:
	 *         "EditBox1[0]".
	 */
	public String GetFieldName() {
		return getObject().GetFieldName();
	}

	/**
	 * get name of the annotation.<br/>
	 * this method valid in premium version
	 * 
	 * @return null if it is not field, or full name of the annotation, example:
	 *         "Form1.EditBox1".
	 */
	public String GetFieldFullName() {
		return getObject().GetFieldFullName();
	}

	/**
	 * get full name of the annotation with more details.<br/>
	 * this method valid in premium version
	 * 
	 * @return null if it is not field, or full name of the annotation, example:
	 *         "Form1[0].EditBox1[0]".
	 */
	public String GetFieldFullName2() {
		return getObject().GetFieldFullName2();
	}

	/**
	 * get annotation type.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @return type as these values:<br/>
	 *         0: unknown<br/>
	 *         1: text<br/>
	 *         2: link<br/>
	 *         3: free text<br/>
	 *         4: line<br/>
	 *         5: square<br/>
	 *         6: circle<br/>
	 *         7: polygon<br/>
	 *         8: polyline<br/>
	 *         9: text hilight<br/>
	 *         10: text under line<br/>
	 *         11: text squiggly<br/>
	 *         12: text strikeout<br/>
	 *         13: stamp<br/>
	 *         14: caret<br/>
	 *         15: ink<br/>
	 *         16: popup<br/>
	 *         17: file attachment<br/>
	 *         18: sound<br/>
	 *         19: movie<br/>
	 *         20: widget<br/>
	 *         21: screen<br/>
	 *         22: print mark<br/>
	 *         23: trap net<br/>
	 *         24: water mark<br/>
	 *         25: 3d object<br/>
	 *         26: rich media
	 */
	public int GetType() {
		return getObject().GetType();
	}

	/**
	 * check if position and size of the annotation is locked?<br/>
	 * this method valid in professional or premium version
	 * 
	 * @return true if locked, or not locked.
	 */
	public boolean IsLocked() {
		return getObject().IsLocked();
	}

	/**
	 * set annotation lock status.<br/>
	 * 
	 * @param lock
	 *            true if lock, otherwise false.
	 */
	public void setLocked(boolean lock) {
		getObject().setLocked(lock);
	}

	/**
	 * check if texts of the annotation is locked?<br/>
	 * this method valid in professional or premium version
	 * 
	 * @return true if locked, or not locked.
	 */
	public boolean IsLockedContent() {
		return getObject().IsLockedContent();
	}

	/**
	 * check whether the annotation is hide.
	 * 
	 * @return true or false.
	 */
	public boolean IsHide() {
		return getObject().IsHide();
	}

	/**
	 * get annotation's box rectangle.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @return 4 elements: left, top, right, bottom in PDF coordinate system
	 */
	public float[] GetRect() {
		return getObject().GetRect();
	}

	/**
	 * set annotation's box rectangle.<br/>
	 * this method valid in professional or premium version.<br/>
	 * you shall render page after this invoked, to resize or move annotation.
	 */
	public void SetRect(float left, float top, float right, float bottom) {
		getObject().SetRect(left, top, right, bottom);
	}

	/**
	 * get markup annotation's boxes.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @return float array, container many boxes.<br/>
	 *         each 4 elements defined a box, as [left, top, right, bottom] in
	 *         PDF coordinate.<br/>
	 *         length of this array must be 4 times.
	 */
	public float[] GetMarkupRects() {
		return getObject().GetMarkupRects();
	}

	/**
	 * set hide status for annotation. this method valid in professional or
	 * premium version.<br/>
	 * you shall render page after this invoked, to hide annotation.
	 * 
	 * @param hide
	 *            true or false.
	 */
	public void SetHide(boolean hide) {
		getObject().SetHide(hide);
	}

	/**
	 * get annotation's popup text.<br/>
	 * this method valid in professional or premium version.
	 * 
	 * @return text string or null if failed.
	 */
	public String GetPopupText()
	{
		return getObject().GetPopupText();
	}

	/**
	 * set annotation's popup text.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @param val
	 *            text string
	 * @return true or false
	 */
	public boolean SetPopupText( String val )
	{
		return getObject().SetPopupText(val);
	}

	/**
	 * get annotation's popup subject.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @return subject string or null if failed.
	 */
	public String GetPopupSubject()
	{
		return getObject().GetPopupSubject();
	}

	/**
	 * set annotation's popup subject.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @param val
	 *            subject string
	 * @return true or false
	 */
	public boolean SetPopupSubject( String val )
	{
		return getObject().SetPopupSubject(val);
	}

	/**
	 * get annotation's destination.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @return 0 based page NO, or -1 if failed.
	 */
	public int GetDest()
	{
		return getObject().GetDest();
	}

	/**
	 * get annotation's URL link string.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @return string of URL, or null
	 */
	public String GetURI()
	{
		return getObject().GetURI();
	}

	/**
	 * get annotation's 3D object name.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @return name of the 3D object, or null
	 */
	public String Get3D()
	{
		return getObject().Get3D();
	}

	/**
	 * get annotation's movie name.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @return name of the movie, or null
	 */
	public String GetMovie()
	{
		return getObject().GetMovie();
	}

	/**
	 * get annotation's sound name.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @return name of the audio, or null
	 */
	public String GetSound()
	{
		return getObject().GetSound();
	}

	/**
	 * get annotation's attachment name.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @return name of the attachment, or null
	 */
	public String GetAttachment()
	{
		return getObject().GetAttachment();
	}

	/**
	 * get annotation's 3D data. must be *.u3d format.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @param save_file
	 *            full path name to save data.
	 * @return true if save_file created, or false.
	 */
	public boolean Get3DData( String save_file )
	{
		return getObject().Get3DData(save_file);
	}

	/**
	 * 
	 * get annotation's movie data.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @param save_file
	 *            full path name to save data.
	 * @return true if save_file created, or false.
	 */
	public boolean GetMovieData( String save_file )
	{
		return getObject().GetMovieData(save_file);
	}

	/**
	 * get annotation's sound data.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @param paras
	 *            paras[0] == 0, if formated audio file(*.mp3 ...).
	 * @param save_file
	 *            full path name to save data.
	 * @return true if save_file created, or false.
	 */
	public boolean GetSoundData( int paras[], String save_file )
	{
		return getObject().GetSoundData(paras, save_file);
	}

	/**
	 * get annotation's attachment data.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @param save_file
	 *            full path name to save data.
	 * @return true if save_file created, or false.
	 */
	public boolean GetAttachmentData( String save_file )
	{
		return getObject().GetAttachmentData(save_file);
	}

	/**
	 * get type of edit-box.<br/>
	 * this method valid in premium version
	 * 
	 * @return <br/>
	 *         -1: this annotation is not text-box.<br/>
	 *         1: normal single line.<br/>
	 *         2: password.<br/>
	 *         3: MultiLine edit area.
	 */
	public int GetEditType()
	{
		return getObject().GetEditType();
	}

	/**
	 * get max-len of edit-box.<br/>
	 * this method valid in premium version
	 * 
	 * @return 0 if no limit, great than 0 if has limit.
	 */
	public int GetEditMaxlen()
	{
		return getObject().GetEditMaxlen();
	}

	/**
	 * get position and size of edit-box.<br/>
	 * for FreeText annotation, position of edit-box is not the position of
	 * annotation.<br/>
	 * so this function is needed for edit-box. this method valid in premium
	 * version
	 * 
	 * @param rect
	 *            4 elements in order: left, top, right, bottom, in PDF
	 *            coordinate.
	 * @return true or false
	 */
	public boolean GetEditTextRect( float[] rect )
	{
		return getObject().GetEditTextRect(rect);
	}

	/**
	 * get text size of edit-box.<br/>
	 * this method valid in premium version
	 * 
	 * @return size of text, in PDF coordinate system.
	 */
	public float GetEditTextSize()
	{
		return getObject().GetEditTextSize();
	}

	/**
	 * get contents of edit-box.<br/>
	 * this method valid in premium version
	 * 
	 * @return content in edit-box
	 */
	public String GetEditText()
	{
		return getObject().GetEditText();
	}

	/**
	 * set contents of edit-box.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this method valid in premium version
	 * 
	 * @param text
	 *            contents to be set.<br/>
	 *            in MultiLine mode: '\r' or '\n' means change line.<br/>
	 *            in password mode the edit box always display "*".
	 * @return true or false.
	 */
	public boolean SetEditText( String text )
	{
		return getObject().SetEditText(text);
	}

	/**
	 * get item count of combo-box.<br/>
	 * this method valid in premium version
	 * 
	 * @return -1: this is not combo. otherwise: items count.
	 */
	public int GetComboItemCount()
	{
		return getObject().GetComboItemCount();
	}

	/**
	 * get an item of combo-box.<br/>
	 * this method valid in premium version
	 * 
	 * @param item
	 *            0 based item index. range:[0, GetAnnotComboItemCount()-1]
	 * @return null if this is not combo-box, "" if no item selected, otherwise
	 *         the item selected.
	 */
	public String GetComboItem(int item) {
		return getObject().GetComboItem(item);
	}

	/**
	 * get current selected item index of combo-box.<br/>
	 * this method valid in premium version
	 * 
	 * @return -1 if this is not combo-box or no item selected, otherwise the
	 *         item index that selected.
	 */
	public int GetComboItemSel() {
		return getObject().GetComboItemSel();
	}

	/**
	 * set current selected.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this method valid in premium version
	 * 
	 * @param item
	 *            0 based item index to set.
	 * @return true or false.
	 */
	public boolean SetComboItem(int item) {
		return getObject().SetComboItem(item);
	}

	/**
	 * get item count of list-box.<br/>
	 * this method valid in premium version
	 * 
	 * @return -1: this is not a list. otherwise: items count.
	 */
	public int GetListItemCount() {
		return getObject().GetListItemCount();
	}

	/**
	 * get an item of list-box.<br/>
	 * this method valid in premium version
	 * 
	 * @param item
	 *            0 based item index. range:[0, GetListItemCount()-1]
	 * @return null if this is not list-box, "" if no item selected, otherwise
	 *         the item selected.
	 */
	public String GetListItem( int item )
	{
		return getObject().GetListItem(item);
	}

	/**
	 * get selected indexes of list-box.<br/>
	 * this method valid in premium version
	 * 
	 * @return null if it is not a list-box, or no items selected.
	 */
	public int[] GetListSels()
	{
		return getObject().GetListSels();
	}

	/**
	 * set selects of list-box this method valid in premium version
	 * 
	 * @param items
	 *            0 based indexes of items.
	 * @return true or false
	 */
	public boolean SetListSels( int[] items )
	{
		return getObject().SetListSels(items);
	}

	/**
	 * get status of check-box and radio-box.<br/>
	 * this method valid in premium version
	 * 
	 * @return <br/>
	 *         -1 if annotation is not valid control.<br/>
	 *         0 if check-box is not checked.<br/>
	 *         1 if check-box checked.<br/>
	 *         2 if radio-box is not checked.<br/>
	 *         3 if radio-box checked.
	 */
	public int GetCheckStatus()
	{
		return getObject().GetCheckStatus();
	}

	/**
	 * set value to check-box.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this method valid in premium version
	 * 
	 * @param check
	 *            true or false.
	 * @return true or false.
	 */
	public boolean SetCheckValue( boolean check )
	{
		return getObject().SetCheckValue(check);
	}

	/**
	 * check the radio-box and deselect others in radio group.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this method valid in premium version
	 * 
	 * @return true or false.
	 */
	public boolean SetRadio()
	{
		return getObject().SetRadio();
	}

	/**
	 * get status of signature field.<br/>
	 * this method valid in premium version
	 * 
	 * @return -1 if this is not signature field<br/>
	 *         0 if not signed.<br/>
	 *         1 if signed.
	 */
	public int GetSignStatus()
	{
		return getObject().GetSignStatus();
	}

	/**
	 * check if the annotation is reset button?<br/>
	 * this method valid in premium version
	 * 
	 * @return true or false.
	 */
	public boolean GetReset()
	{
		return getObject().GetReset();
	}

	/**
	 * perform the button and reset the form.<br/>
	 * you should re-render page to display modified data.<br/>
	 * this method valid in premium version
	 * 
	 * @return true or false.
	 */
	public boolean SetReset()
	{
		return getObject().SetReset();
	}

	/**
	 * get annotation submit target.<br/>
	 * this method valid in premium version
	 * 
	 * @return null if this is not submit button.
	 */
	public String GetSubmitTarget()
	{
		return getObject().GetSubmitTarget();
	}

	/**
	 * get annotation submit parameters.<br/>
	 * mail mode: return whole XML string for form data.<br/>
	 * other mode: url data likes: "para1=xxx&para2=xxx".<br/>
	 * this method valid in premium version
	 * 
	 * @return null if this is not submit button.
	 */
	public String GetSubmitPara()
	{
		return getObject().GetSubmitPara();
	}

	/**
	 * get fill color of square/circle/highlight/line/ploygon/polyline/sticky
	 * text/free text annotation.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @return color value formatted as 0xAARRGGBB, if 0 returned, means false.
	 */
	public int GetFillColor()
	{
		return getObject().GetFillColor();
	}

	/**
	 * set fill color of square/circle/highlight/line/ploygon/polyline/sticky
	 * text/free text annotation.<br/>
	 * you need render page again to show modified annotation.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @param color
	 *            color value formatted as 0xAARRGGBB, if alpha channel is too
	 *            less or 0, return false.
	 * @return true or false
	 */
	public boolean SetFillColor( int color )
	{
		return getObject().SetFillColor(color);
	}

	/**
	 * get stroke color of
	 * square/circle/ink/line/underline/Squiggly/strikeout/ploygon/polyline/free
	 * text annotation.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @return color value formatted as 0xAARRGGBB, if 0 returned, means false.
	 */
	public int GetStrokeColor()
	{
		return getObject().GetStrokeColor();
	}

	/**
	 * set stroke color of
	 * square/circle/ink/line/underline/Squiggly/strikeout/ploygon/polyline/free
	 * text annotation.<br/>
	 * you need render page again to show modified annotation.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @param color
	 *            color value formatted as 0xAARRGGBB, if alpha channel is too
	 *            less or 0, return false.
	 * @return true or false
	 */
	public boolean SetStrokeColor( int color )
	{
		return getObject().SetStrokeColor(color);
	}

	/**
	 * get stroke width of square/circle/ink/line/ploygon/polyline/free text
	 * annotation.<br/>
	 * for free text annotation: width of edit-box border<br/>
	 * this method valid in professional or premium version
	 * 
	 * @return width value in PDF coordinate, or 0 if error.
	 */
	public float GetStrokeWidth()
	{
		return getObject().GetStrokeWidth();
	}

	/**
	 * set stroke width of square/circle/ink/line/ploygon/polyline/free text
	 * annotation.<br/>
	 * for free text annotation: width of edit-box border<br/>
	 * you need render page again to show modified annotation.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @param width
	 *            stroke width in PDF coordinate.
	 * @return true or false
	 */
	public boolean SetStrokeWidth( float width )
	{
		return getObject().SetStrokeWidth(width);
	}

	/**
	 * get Path object from Ink annotation.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @return a new Path object, you need invoke Path.Destroy() to free memory.
	 */
	public Path GetInkPath()
	{
		return getObject().GetInkPath();
	}

	/**
	 * set Path to Ink annotation.<br/>
	 * you need render page again to show modified annotation.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @param path
	 *            Path object.
	 * @return true or false.
	 */
	public boolean SetInkPath( Path path )
	{
		return getObject().SetInkPath(path);
	}

	/**
	 * get Path object from Polygon annotation.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @return a new Path object, you need invoke Path.Destroy() to free memory.
	 */
	public Path GetPolygonPath()
	{
		return getObject().GetPolygonPath();
	}

	/**
	 * set Path to Polygon annotation.<br/>
	 * you need render page again to show modified annotation.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @param path
	 *            Path object.
	 * @return true or false.
	 */
	public boolean SetPolygonPath( Path path )
	{
		return getObject().SetPolygonPath(path);
	}

	/**
	 * get Path object from Polyline annotation.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @return a new Path object, you need invoke Path.Destroy() to free memory.
	 */
	public Path GetPolylinePath()
	{
		return getObject().GetPolylinePath();
	}

	/**
	 * set Path to Polyline annotation.<br/>
	 * you need render page again to show modified annotation.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @param path
	 *            Path object.
	 * @return true or false.
	 */
	public boolean SetPolylinePath( Path path )
	{
		return getObject().SetPolylinePath(path);
	}

	/**
	 * set icon for sticky text note/file attachment/Rubber Stamp annotation.<br/>
	 * you need render page again to show modified annotation.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @param icon
	 *            icon value depends on annotation type.<br/>
	 *            <strong>For sticky text note:</strong><br/>
	 *            0: Note<br/>
	 *            1: Comment<br/>
	 *            2: Key<br/>
	 *            3: Help<br/>
	 *            4: NewParagraph<br/>
	 *            5: Paragraph<br/>
	 *            6: Insert<br/>
	 *            7: Check<br/>
	 *            8: Circle<br/>
	 *            9: Cross<br/>
	 *            <strong>For file attachment:</strong><br/>
	 *            0: PushPin<br/>
	 *            1: Graph<br/>
	 *            2: Paperclip<br/>
	 *            3: Tag<br/>
	 *            <strong>For Rubber Stamp:</strong><br/>
	 *            0: "Draft"(default icon)<br/>
	 *            1: "Approved"<br/>
	 *            2: "Experimental"<br/>
	 *            3: "NotApproved"<br/>
	 *            4: "AsIs"<br/>
	 *            5: "Expired"<br/>
	 *            6: "NotForPublicRelease"<br/>
	 *            7: "Confidential"<br/>
	 *            8: "Final"<br/>
	 *            9: "Sold"<br/>
	 *            10: "Departmental"<br/>
	 *            11: "ForComment"<br/>
	 *            12: "TopSecret"<br/>
	 *            13: "ForPublicRelease"<br/>
	 *            14: "Accepted"<br/>
	 *            15: "Rejected"<br/>
	 *            16: "Witness"<br/>
	 *            17: "InitialHere"<br/>
	 *            18: "SignHere"<br/>
	 *            19: "Void"<br/>
	 *            20: "Completed"<br/>
	 *            21: "PreliminaryResults"<br/>
	 *            22: "InformationOnly"<br/>
	 *            23: "End"<br/>
	 * @return true or false.
	 */
	public boolean SetIcon( int icon )
	{
		return getObject().SetIcon(icon);
	}

	/**
	 * set customized icon for sticky text note/file attachment annotation.<br/>
	 * 
	 * @param name
	 *            customized icon name.
	 * @param content
	 *            PageContent object to display icon, must be 20 * 20 size.
	 * @return true or false.
	 */
	public boolean SetIcon( String name, PageContent content )
	{
		return getObject().SetIcon(name, content);
	}

	/**
	 * get icon value for sticky text note/file attachment/Rubber Stamp
	 * annotation.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @return icon value depends on annotation type.<br/>
	 *         <strong>For sticky text note:</strong><br/>
	 *         0: Note<br/>
	 *         1: Comment<br/>
	 *         2: Key<br/>
	 *         3: Help<br/>
	 *         4: NewParagraph<br/>
	 *         5: Paragraph<br/>
	 *         6: Insert<br/>
	 *         7: Check<br/>
	 *         8: Circle<br/>
	 *         9: Cross<br/>
	 *         <strong>For file attachment:</strong><br/>
	 *         0: PushPin<br/>
	 *         1: Graph<br/>
	 *         2: Paperclip<br/>
	 *         3: Tag<br/>
	 *         <strong>For Rubber Stamp:</strong><br/>
	 *         0: "Draft"(default icon)<br/>
	 *         1: "Approved"<br/>
	 *         2: "Experimental"<br/>
	 *         3: "NotApproved"<br/>
	 *         4: "AsIs"<br/>
	 *         5: "Expired"<br/>
	 *         6: "NotForPublicRelease"<br/>
	 *         7: "Confidential"<br/>
	 *         8: "Final"<br/>
	 *         9: "Sold"<br/>
	 *         10: "Departmental"<br/>
	 *         11: "ForComment"<br/>
	 *         12: "TopSecret"<br/>
	 *         13: "ForPublicRelease"<br/>
	 *         14: "Accepted"<br/>
	 *         15: "Rejected"<br/>
	 *         16: "Witness"<br/>
	 *         17: "InitialHere"<br/>
	 *         18: "SignHere"<br/>
	 *         19: "Void"<br/>
	 *         20: "Completed"<br/>
	 *         21: "PreliminaryResults"<br/>
	 *         22: "InformationOnly"<br/>
	 *         23: "End"<br/>
	 */
	public int GetIcon()
	{
		return getObject().GetIcon();
	}

	/**
	 * remove annotation<br/>
	 * you should re-render page to display modified data.<br/>
	 * this method valid in professional or premium version
	 * 
	 * @return true or false
	 */
	public boolean RemoveFromPage()
	{
		return getObject().RemoveFromPage();
	}

}
