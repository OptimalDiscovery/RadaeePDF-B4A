package com.rootsoft.rspdfviewer.pdf;

import android.graphics.Canvas;
import android.view.MotionEvent;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper;

import com.radaee.pdf.Document;
import com.radaee.view.PDFVPage;
import com.radaee.view.PDFView.PDFPos;
import com.radaee.view.PDFView.PDFViewListener;
import com.radaee.view.PDFViewVert;

@ShortName("PDFViewVert")
public class RSPDFViewVert extends AbsObjectWrapper<PDFViewVert> {

	// Attributes
	private BA ba;
	private String eventName;

	// Constructors

	/**
	 * Initializes the PDFView class.
	 */
	public void Initialize(final BA ba, String EventName) {
		this.ba = ba;
		this.eventName = EventName.toLowerCase(BA.cul);
		setObject(new PDFViewVert(BA.applicationContext));
	}

	// Methods

	public void Resize(int width, int height) {
		getObject().vResize(width, height);
	}

	public void ComputeScroll() {
		getObject().vComputeScroll();
	}

	public void Draw(CanvasWrapper canvas) {
		getObject().vDraw(canvas.canvas);
	}

	public void Open(Document doc, int page_gap, int back_color) {
		getObject().vOpen(doc, page_gap, back_color, pdfViewListener);
	}

	public void Close() {
		getObject().vClose();
	}

	public boolean TouchEvent(MotionEvent motionEvent) {
		return getObject().vTouchEvent(motionEvent);
	}

	public void GotoPage(int pageno) {
		getObject().vGotoPage(pageno);
	}

	public void Render(PDFVPage page) {
		getObject().vRender(page);
	}

	public void FindStart(String key, boolean match_case, boolean whole_word) {
		getObject().vFindStart(key, match_case, whole_word);
	}

	public int Find(int dir) {
		return getObject().vFind(dir);
	}

	public void FindEnd() {
		getObject().vFindEnd();
	}

	public void CenterPage(int pageno) {
		getObject().vCenterPage(pageno);
	}

	public void ClearSel() {
		getObject().vClearSel();
	}

	// Getters & Setters

	public int getX() {
		return getObject().vGetX();
	}

	public int getY() {
		return getObject().vGetY();
	}

	public int getWinW() {
		return getObject().vGetWinW();
	}

	public int getWinH() {
		return getObject().vGetWinH();
	}

	public void setBackColor(int color) {
		getObject().vSetBackColor(color);
	}

	public void setPageGap(int gap) {
		getObject().vSetPageGap(gap);
	}

	public PDFVPage getPage(int pageno) {
		return getObject().vGetPage(pageno);
	}

	/**
	 * get Position from point in view coordinate, implement in derived class.
	 * pass (0,0) to get position of left-top corner
	 * 
	 * @param vx
	 * @param vy
	 * @return
	 */
	public PDFPos getPos(int vx, int vy) {
		return getObject().vGetPos(vx, vy);
	}

	public void setPos(PDFPos pos, int vx, int vy) {
		getObject().vSetPos(pos, vx, vy);
	}

	public void setScale(float scale, float fx, float fy) {
		getObject().vSetScale(scale, fx, fy);
	}

	public float getScale() {
		return getObject().vGetScale();
	}

	public float getMinScale() {
		return getObject().vGetMinScale();
	}

	public float getMaxScale() {
		return getObject().vGetMaxScale();
	}

	public void setLock(int lock) {
		getObject().vSetLock(lock);
	}

	public int getLock() {
		return getObject().vGetLock();
	}

	public void setSelected(float x1, float y1, float x2, float y2) {
		getObject().vSetSel(x1, y1, x2, y2);
	}

	public String getSelected() {
		return getObject().vGetSel();
	}

	public void setSelectedStatus(boolean set) {
		getObject().vSetSelStatus(set);
	}

	public boolean setSelectedMarkup(int type) {
		return getObject().vSetSelMarkup(type);
	}

	// Callbacks
	PDFViewListener pdfViewListener = new PDFViewListener() {

		@Override
		public boolean OnPDFDoubleTapped(float x, float y) {
			boolean yesno = false;
			if (ba.subExists(eventName + "_pdfdoubletapped") == true) {
				(yesno) = (Boolean) ba.raiseEvent(this, eventName
						+ "_pdfdoubletapped", new Object[] { x, y });
			}
			return yesno;
		}

		@Override
		public void OnPDFFound(boolean found) {
			if (ba.subExists(eventName + "_pdffound") == true) {
				ba.raiseEvent(this, eventName + "_pdffound",
						new Object[] { found });
			}

		}

		@Override
		public void OnPDFInvalidate(boolean post) {
			if (ba.subExists(eventName + "_pdfinvalidate") == true) {
				ba.raiseEvent(this, eventName + "_pdfinvalidate",
						new Object[] { post });
			}

		}

		@Override
		public void OnPDFLongPressed(float x, float y) {
			if (ba.subExists(eventName + "_pdflongpressed") == true) {
				ba.raiseEvent(this, eventName + "_pdflongpressed",
						new Object[] { x, y });
			}

		}

		@Override
		public void OnPDFPageDisplayed(Canvas canvas, PDFVPage page) {
			if (ba.subExists(eventName + "_pdfpagedisplayed") == true) {
				ba.raiseEvent(this, eventName + "_pdfpagedisplayed",
						new Object[] { canvas, page });
			}

		}

		@Override
		public void OnPDFPosChanged(PDFPos pos) {
			if (ba.subExists(eventName + "_pdfposchanged") == true) {
				ba.raiseEvent(this, eventName + "_pdfposchanged",
						new Object[] { pos });
			}

		}

		@Override
		public void OnPDFSelectEnd() {
			if (ba.subExists(eventName + "_pdfselectend") == true) {
				ba.raiseEvent(this, eventName + "_pdfselectend");
			}

		}

		@Override
		public void OnPDFSelecting(Canvas canvas, int[] arg1, int[] arg2) {
			if (ba.subExists(eventName + "_pdfselecting") == true) {
				ba.raiseEvent(this, eventName + "_pdfselecting", new Object[] {
						canvas, arg1, arg2 });
			}
		}

		@Override
		public void OnPDFShowPressed(float x, float y) {
			if (ba.subExists(eventName + "_pdfshowpressed") == true) {
				ba.raiseEvent(this, eventName + "_pdfshowpressed",
						new Object[] { x, y });
			}

		}

		@Override
		public boolean OnPDFSingleTapped(float x, float y) {
			boolean yesno = false;
			if (ba.subExists(eventName + "_pdfsingletapped") == true) {
				(yesno) = (Boolean) ba.raiseEvent(this, eventName
						+ "_pdfsingletapped", new Object[] { x, y });
			}
			return yesno;
		}

	};

	@ShortName("PDFPos")
	public class RSPDFPos extends AbsObjectWrapper<PDFPos> {

		public int getPageNo() {
			return getObject().pageno;
		}

		public float getX() {
			return getObject().x;
		}

		public float getY() {
			return getObject().y;
		}

	}

}
