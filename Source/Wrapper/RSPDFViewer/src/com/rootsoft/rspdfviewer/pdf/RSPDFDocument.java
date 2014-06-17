package com.rootsoft.rspdfviewer.pdf;

import android.graphics.Bitmap;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;

import com.radaee.pdf.Document;
import com.radaee.pdf.Document.DocFont;
import com.radaee.pdf.Document.DocGState;
import com.radaee.pdf.Document.DocImage;
import com.radaee.pdf.Document.ImportContext;
import com.radaee.pdf.Document.Outline;
import com.radaee.pdf.Document.PDFStream;
import com.radaee.pdf.Page;
import com.radaee.pdf.PDFHttpStream;

@ShortName("PDFDocument")
public class RSPDFDocument extends AbsObjectWrapper<Document> {

	// Attributes

	// Constructors - Initialization

	/**
	 * Initializes the PDFDocument.
	 */
	public void Initialize() {
		setObject(new Document());
	}

	/**
	 * check if opened.
	 * 
	 * @return true or false.
	 */
	public boolean is_opened() {
		return getObject().is_opened();
	}

	/**
	 * create a empty PDF document
	 * 
	 * @param path
	 *            path to create
	 * @return 0 or less than 0 means failed, same as Open.
	 */
	public int Create(String path) {
		return getObject().Create(path);
	}

	/**
	 * create a empty PDF document
	 * 
	 * @param stream
	 *            stream to create
	 * @return 0 or less than 0 means failed, same as Open.
	 */
	public int CreateForStream(PDFStream stream) {
		return getObject().CreateForStream(stream);
	}

	/**
	 * set cache file to PDF.<br/>
	 * a premium license is needed for this method.
	 * 
	 * @param path
	 *            a path to save some temporary data, compressed images and so
	 *            on
	 * @return true or false
	 */
	public boolean setCache(String path) {
		return getObject().SetCache(path);
	}

	/**
	 * open document.<br/>
	 * first time, SDK try password as user password, and then try password as
	 * owner password.
	 * 
	 * @param path
	 *            PDF file to be open.
	 * @param password
	 *            password or null.
	 * @return error code:<br/>
	 *         0:succeeded, and continue<br/>
	 *         -1:need input password<br/>
	 *         -2:unknown encryption<br/>
	 *         -3:damaged or invalid format<br/>
	 *         -10:access denied or invalid file path<br/>
	 *         others:unknown error
	 */
	public int Open(String path, String password) {
		return getObject().Open(path, password);
	}

	/**
	 * open document in memory. first time, SDK try password as user password,
	 * and then try password as owner password.
	 * 
	 * @param data
	 *            data for whole PDF file in byte array. developers should
	 *            retain array data, till document closed.
	 * @param password
	 *            password or null.
	 * @return error code:<br/>
	 *         0:succeeded, and continue<br/>
	 *         -1:need input password<br/>
	 *         -2:unknown encryption<br/>
	 *         -3:damaged or invalid format<br/>
	 *         -10:access denied or invalid file path<br/>
	 *         others:unknown error
	 */
	public int OpenMem(byte[] data, String password) {
		return getObject().OpenMem(data, password);
	}

	/**
	 * open document from stream. first time, SDK try password as user password,
	 * and then try password as owner password.
	 * 
	 * @param stream
	 *            PDFStream object.
	 * @param password
	 *            password or null.
	 * @return error code:<br/>
	 *         0:succeeded, and continue<br/>
	 *         -1:need input password<br/>
	 *         -2:unknown encryption<br/>
	 *         -3:damaged or invalid format<br/>
	 *         -10:access denied or invalid file path<br/>
	 *         others:unknown error
	 */
	public int OpenStream(PDFStream stream, String password) {
		return getObject().OpenStream(stream, password);
	}

	/**
	 * get permission of PDF, this value defined in PDF reference 1.7<br/>
	 * bit 1-2 reserved<br/>
	 * bit 3(0x4) print<br/>
	 * bit 4(0x8) modify<br/>
	 * bit 5(0x10) extract text or image<br/>
	 * others: see PDF reference
	 * 
	 * @return permission flags
	 */
	public int getPermission() {
		return getObject().GetPermission();
	}

	/**
	 * get permission of PDF, this value defined in "Perm" entry in Catalog
	 * object
	 * 
	 * @return 0 means not defined<br/>
	 *         1 means can't modify<br/>
	 *         2 means can modify some form fields<br/>
	 *         3 means can do any modify<br/>
	 */
	public int getPerm() {
		return getObject().GetPerm();
	}

	/**
	 * close the document.
	 */
	public void Close() {
		getObject().Close();
	}

	/**
	 * get a Page object for page NO.
	 * 
	 * @param pageno
	 *            0 based page NO. range:[0, GetPageCount()-1]
	 * @return Page object
	 */
	public Page getPage(int pageno) {
		return getObject().GetPage(pageno);
	}

	/**
	 * get pages count.
	 * 
	 * @return pages count.
	 */
	public int getPageCount() {
		return getObject().GetPageCount();
	}

	/**
	 * get page width by page NO.
	 * 
	 * @param pageno
	 *            0 based page NO. range:[0, GetPageCount()-1]
	 * @return width value.
	 */
	public float getPageWidth(int pageno) {
		return getObject().GetPageWidth(pageno);
	}

	/**
	 * get page height by page NO.
	 * 
	 * @param pageno
	 *            0 based page NO. range:[0, GetPageCount()-1]
	 * @return height value.
	 */
	public float getPageHeight(int pageno) {
		return getObject().GetPageHeight(pageno);
	}

	/**
	 * get meta data for document.
	 * 
	 * @param tag
	 *            Predefined values:"Title", "Author", "Subject", "Keywords",
	 *            "Creator", "Producer", "CreationDate", "ModDate".<br/>
	 *            or you can pass any key that self-defined.
	 * @return Meta string value, or null.
	 */
	public String getMeta(String tag) {
		return getObject().GetMeta(tag);
	}

	/**
	 * set meta data for document.<br/>
	 * this method valid only in premium version.
	 * 
	 * @param tag
	 *            Predefined values:"Title", "Author", "Subject", "Keywords",
	 *            "Creator", "Producer", "CreationDate", "ModDate".<br/>
	 *            or you can pass any key that self-defined.
	 * @param val
	 *            string value.
	 * @return true or false.
	 */
	public boolean setMeta(String tag, String val) {
		return getObject().SetMeta(tag, val);
	}

	/**
	 * get first root outline item.
	 * 
	 * @return handle value of first root outline item. or null if no outlines.<br/>
	 */
	public Outline getOutlines() {
		return getObject().GetOutlines();
	}

	public PDFStream getURLStream(String url) {
		PDFHttpStream m_stream = new PDFHttpStream();
		m_stream.open(url);
		return m_stream;
	}

	/**
	 * check if document can be modified or saved.<br/>
	 * this always return false, if no license actived.
	 * 
	 * @return true or false.
	 */
	public boolean CanSave() {
		return getObject().CanSave();
	}

	/**
	 * save the document.<br/>
	 * this always return false, if no license actived.
	 * 
	 * @return true or false
	 */
	public boolean Save() {
		return getObject().Save();
	}

	/**
	 * save as the document to another file. it remove any security information.<br/>
	 * this always return false, if no license actived.
	 * 
	 * @param path
	 *            path to save.
	 * @return true or false.
	 */
	public boolean SaveAs(String path) {
		return getObject().SaveAs(path);
	}

	/**
	 * check if document is encrypted.
	 * 
	 * @return true or false.
	 */
	public boolean IsEncrypted() {
		return getObject().IsEncrypted();
	}

	/**
	 * new a root outline to document, it insert first root outline to Document.<br/>
	 * the old first root outline, shall be next of this outline.
	 * 
	 * @param label
	 *            label to display
	 * @param pageno
	 *            pageno to jump
	 * @param top
	 *            y position in PDF coordinate
	 * @return true or false
	 */
	public boolean NewRootOutline(String label, int pageno, float top) {
		return getObject().NewRootOutline(label, pageno, top);
	}

	/**
	 * Start import operations, import page from src<br/>
	 * a premium license is needed for this method.<br/>
	 * you shall maintenance the source Document object until all pages are
	 * imported and ImportContext.Destroy() invoked.
	 * 
	 * @param src
	 *            source Document object that opened.
	 * @return a context object used in ImportPage.
	 */
	public ImportContext ImportStart(Document src) {
		return getObject().ImportStart(src);
	}

	/**
	 * import a page to the document.<br/>
	 * a premium license is needed for this method.<br/>
	 * do not forget to invoke ImportContext.Destroy() after all pages are
	 * imported.
	 * 
	 * @param ctx
	 *            context object created from ImportStart
	 * @param srcno
	 *            0 based page NO. from source Document that passed to
	 *            ImportStart.
	 * @param dstno
	 *            0 based page NO. to insert in this document object.
	 * @return true or false.
	 */
	public boolean ImportPage(ImportContext ctx, int srcno, int dstno) {
		return getObject().ImportPage(ctx, srcno, dstno);
	}

	/**
	 * insert a page to Document<br/>
	 * if pagheno >= page_count, it do same as append.<br/>
	 * otherwise, insert to pageno.<br/>
	 * a premium license is needed for this method.
	 * 
	 * @param pageno
	 *            0 based page NO.
	 * @param w
	 *            page width in PDF coordinate
	 * @param h
	 *            page height in PDF coordinate
	 * @return Page object or null means failed.
	 */
	public Page NewPage(int pageno, float w, float h) {
		return getObject().NewPage(pageno, w, h);
	}

	/**
	 * remove page by page NO.<br/>
	 * a premium license is needed for this method.
	 * 
	 * @param pageno
	 *            0 based page NO.
	 * @return true or false
	 */
	public boolean RemovePage(int pageno) {
		return getObject().RemovePage(pageno);
	}

	/**
	 * move the page to other position.<br/>
	 * a premium license is needed for this method.
	 * 
	 * @param pageno1
	 *            page NO, move from
	 * @param pageno2
	 *            page NO, move to
	 * @return true or false
	 */
	public boolean MovePage(int pageno1, int pageno2) {
		return getObject().MovePage(pageno1, pageno2);
	}

	/**
	 * create a font object, used to write texts.<br/>
	 * a premium license is needed for this method.
	 * 
	 * @param font_name
	 * <br/>
	 *            font name exists in font list.<br/>
	 *            using Global.getFaceCount(), Global.getFaceName() to enumerate
	 *            fonts.
	 * @param style
	 * <br/>
	 *            (style&1) means bold,<br/>
	 *            (style&2) means Italic,<br/>
	 *            (style&8) means embed,<br/>
	 *            (style&16) means vertical writing, mostly used in Asia fonts.
	 * @return DocFont object or null is failed.
	 */
	public DocFont NewFontCID(String font_name, int style) {
		return getObject().NewFontCID(font_name, style);
	}

	/**
	 * create a ExtGraphicState object, used to set alpha values.<br/>
	 * a premium license is needed for this method.
	 * 
	 * @return DocGState object or null.
	 */
	public DocGState NewGState() {
		return getObject().NewGState();
	}

	/**
	 * create an image from Bitmap object.<br/>
	 * a premium license is needed for this method.
	 * 
	 * @param bmp
	 *            Bitmap object in ARGB_8888 format.
	 * @param has_alpha
	 *            generate alpha channel information?
	 * @return DocImage object or null.
	 */
	public DocImage NewImage(Bitmap bmp, boolean has_alpha) {
		return getObject().NewImage(bmp, has_alpha);
	}

	/**
	 * create an image from JPEG/JPG file.<br/>
	 * supported image color space:<br/>
	 * --GRAY<br/>
	 * --RGB<br/>
	 * --CMYK<br/>
	 * a premium license is needed for this method.
	 * 
	 * @param path
	 *            path to JPEG file.
	 * @return DocImage object or null.
	 */
	public DocImage NewImageJPEG(String path) {
		return getObject().NewImageJPEG(path);
	}

	/**
	 * create an image from JPX/JPEG 2k file.<br/>
	 * a premium license is needed for this method.
	 * 
	 * @param path
	 *            path to JPX file.
	 * @return DocImage object or null.
	 */
	public DocImage NewImageJPX(String path) {
		return getObject().NewImageJPX(path);
	}

	/**
	 * change page rect.<br/>
	 * a premium license is needed for this method.
	 * 
	 * @param pageno
	 *            0 based page NO.
	 * @param dl
	 *            delta to left, page_left += dl;
	 * @param dt
	 *            delta to top, page_top += dt;
	 * @param dr
	 *            delta to right, page_right += dr;
	 * @param db
	 *            delta to bottom, page_bottom += db;
	 * @return true or false.
	 */
	public boolean ChangePageRect(int pageno, float dl, float dt, float dr,
			float db) {
		return getObject().ChangePageRect(pageno, dl, dt, dr, db);
	}

	/**
	 * set page rotate.<br/>
	 * a premium license is needed for this method.
	 * 
	 * @param pageno
	 *            0 based page NO.
	 * @param degree
	 *            rotate angle in degree, must be 90 * n.
	 * @return true or false
	 */
	public boolean setPageRotate(int pageno, int degree) {
		return getObject().SetPageRotate(pageno, degree);
	}

	@ShortName("PDFImportContext")
	public class RSPDFImportContext extends AbsObjectWrapper<ImportContext> {

		/**
		 * Initializes the import context.
		 */
		public void Initialize(ImportContext importContext) {
			setObject(importContext);
		}

		/**
		 * Destroy context object and free memory used.
		 */
		public void Destroy() {
			getObject().Destroy();
		}
	}

	@ShortName("PDFDocOutline")
	public class RSPDFDocOutline extends AbsObjectWrapper<Outline> {

		/**
		 * Initializes the document outline.
		 */
		public void Initialize(Outline outline) {
			setObject(outline);
		}

		public String getTitle() {
			return getObject().GetTitle();
		}

		/**
		 * set label of Outline.<br/>
		 * a premium license is needed for this method.
		 * 
		 * @param title
		 *            title to set
		 * @return true or false.
		 */
		public boolean setTitle(String title) {
			return getObject().SetTitle(title);
		}

		/**
		 * get next
		 * 
		 * @return
		 */
		public Outline getNext() {
			return getObject().GetNext();
		}

		/**
		 * get first child
		 * 
		 * @return
		 */
		public Outline getChild() {
			return getObject().GetChild();
		}

		/**
		 * get jumping page NO.
		 * 
		 * @return 0 based page NO.
		 */
		public int getDest() {
			return getObject().GetDest();
		}

		/**
		 * insert outline after of this Outline.<br/>
		 * a premium license is needed for this method.
		 * 
		 * @param label
		 *            label of new outline.
		 * @param pageno
		 *            0 based page NO.
		 * @param top
		 *            y in PDF coordinate.
		 * @return true of false.
		 */
		public boolean AddNext(String label, int pageno, float top) {
			return getObject().AddNext(label, pageno, top);
		}

		/**
		 * insert outline as first child of this Outline.<br/>
		 * a premium license is needed for this method.
		 * 
		 * @param label
		 *            label of new outline.
		 * @param pageno
		 *            0 based page NO.
		 * @param top
		 *            y in PDF coordinate.
		 * @return true or false.
		 */
		public boolean AddChild(String label, int pageno, float top) {
			return getObject().AddChild(label, pageno, top);
		}

		/**
		 * remove this Outline, and all children of this Outline.<br/>
		 * this method connect previous Outline and next Outline.<br/>
		 * a premium license is needed for this method.
		 * 
		 * @return true or false.
		 */
		public boolean RemoveFromDoc() {
			return getObject().RemoveFromDoc();
		}
	}

	@ShortName("PDFDocFont")
	public class RSPDFDocFont extends AbsObjectWrapper<DocFont> {

		/**
		 * Initializes the doc font.
		 */
		public void Initialize(DocFont pdfFont) {
			setObject(pdfFont);
		}

		/**
		 * get ascent
		 * 
		 * @return ascent based in 1, for example: 0.88f
		 */
		public float getAscent() {
			return getObject().GetAscent();
		}

		/**
		 * get descent
		 * 
		 * @return ascent based in 1, for example: -0.12f
		 */
		public float getDescent() {
			return getObject().GetDescent();
		}
	}

	@ShortName("PDFDocGState")
	public class RSPPDFDocGState extends AbsObjectWrapper<DocGState> {

		/**
		 * Initializes the DocGState
		 */
		public void Initialize(DocGState docGState) {
			setObject(docGState);
		}

		/**
		 * set alpha value for fill and other non-stroke operation
		 * 
		 * @param alpha
		 *            range: [0, 255]
		 * @return true or false
		 */
		public boolean setFillAlpha(int alpha) {
			return getObject().SetFillAlpha(alpha);
		}

		/**
		 * set alpha value for stroke operation
		 * 
		 * @param alpha
		 *            range: [0, 255]
		 * @return true or false
		 */
		public boolean setStrokeAlpha(int alpha) {
			return getObject().SetStrokeAlpha(alpha);
		}
	}
}
