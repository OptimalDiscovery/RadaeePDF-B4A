package com.rootsoft.rspdfviewer.pdf;


import android.graphics.Canvas;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.ViewWrapper;

import com.radaee.pdf.Document;
import com.radaee.reader.ReaderController;
import com.radaee.view.PDFVPage;
import com.radaee.view.PDFView;
import com.radaee.view.PDFView.PDFPos;
import com.radaee.view.PDFView.PDFViewListener;

@ShortName("PDFReaderView")
@ActivityObject
public class RSReaderView extends ViewWrapper<ReaderController>{

	
	//Attributes
	private BA ba;
	private String eventName;
	
	//Constructors

	/**
	 * Initializes the PDFView class.
	 */
	public void Initialize(final BA ba, String EventName) {
		this.ba = ba;
		this.eventName = EventName.toLowerCase(BA.cul);
		setObject(new ReaderController(ba.activity, ba, EventName.toLowerCase(BA.cul)));
	}
	
	public void Initialize2(final BA ba, String EventName, PDFView view) {
		this.ba = ba;
		this.eventName = EventName.toLowerCase(BA.cul);
		setObject(new ReaderController(ba.activity, view, ba, EventName.toLowerCase(BA.cul)));
	}
	
	//Methods
	
	public void Open(Document doc) {
		getObject().open(doc, pdfViewListener);
	}
    
    
    public PDFView getPDFView() {
    	return getObject().getPDFView();
    }
    
    public void Invalidate4() {
    	getObject().invalidate4();
    }
    

		
		//Callbacks
		PDFViewListener pdfViewListener = new PDFViewListener() {

			@Override
			public boolean OnPDFDoubleTapped(float x, float y) {
				boolean yesno = false;
				if (ba.subExists(eventName + "_pdfdoubletapped")==true) {
					(yesno) = (Boolean) ba.raiseEvent(this, eventName + "_pdfdoubletapped", new Object[] { x, y } );
				}
				return yesno;
			}

			@Override
			public void OnPDFFound(boolean found) {
				if (ba.subExists(eventName + "_pdffound")==true) {
					ba.raiseEvent(this, eventName + "_pdffound", new Object[] { found } );
				}
				
			}

			@Override
			public void OnPDFInvalidate(boolean post) {
				if (ba.subExists(eventName + "_pdfinvalidate")==true) {
					ba.raiseEvent(this, eventName + "_pdfinvalidate", new Object[] { post } );
				}
				
			}

			@Override
			public void OnPDFLongPressed(float x, float y) {
				if (ba.subExists(eventName + "_pdflongpressed")==true) {
					ba.raiseEvent(this, eventName + "_pdflongpressed", new Object[] { x, y } );
				}
				
			}

			@Override
			public void OnPDFPageDisplayed(Canvas canvas, PDFVPage page) {
				if (ba.subExists(eventName + "_pdfpagedisplayed")==true) {
					ba.raiseEvent(this, eventName + "_pdfpagedisplayed", new Object[] { canvas, page } );
				}
				
			}

			@Override
			public void OnPDFPosChanged(PDFPos pos) {
				if (ba.subExists(eventName + "_pdfposchanged")==true) {
					ba.raiseEvent(this, eventName + "_pdfposchanged", new Object[] { pos } );
				}
				
			}

			@Override
			public void OnPDFSelectEnd() {
				if (ba.subExists(eventName + "_pdfselectend")==true) {
					ba.raiseEvent(this, eventName + "_pdfselectend" );
				}
				
			}

			@Override
			public void OnPDFSelecting(Canvas canvas, int[] arg1, int[] arg2) {
				if (ba.subExists(eventName + "_pdfselecting")==true) {
					ba.raiseEvent(this, eventName + "_pdfselecting", new Object[] { canvas, arg1, arg2 } );
				}
			}

			@Override
			public void OnPDFShowPressed(float x, float y) {
				if (ba.subExists(eventName + "_pdfshowpressed")==true) {
					ba.raiseEvent(this, eventName + "_pdfshowpressed", new Object[] { x, y } );
				}
				
			}

			@Override
			public boolean OnPDFSingleTapped(float x, float y) {
				boolean yesno = false;
				if (ba.subExists(eventName + "_pdfsingletapped")==true) {
					(yesno) = (Boolean) ba.raiseEvent(this, eventName + "_pdfsingletapped", new Object[] { x, y } );
				}
				return yesno;
			}
			
		};

	


}
