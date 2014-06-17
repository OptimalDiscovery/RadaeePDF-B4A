package com.rootsoft.pdfviewer;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class readercontroller extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.rootsoft.pdfviewer.readercontroller");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            if (ba.getClass().getName().endsWith("ShellBA")) {
			    ba.raiseEvent2(null, true, "CREATE", true, "com.rootsoft.pdfviewer.readercontroller",
                    ba);
		    }
        }
        ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _meventname = "";
public boolean _mlockresize = false;
public int _msavewidth = 0;
public int _msaveheight = 0;
public int _mcurpage = 0;
public com.rootsoft.rspdfviewer.pdf.RSPDFViewDual _vpdf = null;
public com.rootsoft.rspdfviewer.pdf.RSReaderView _mpdfreaderview = null;
public com.rootsoft.pdfviewer.main _main = null;
public com.rootsoft.rspdfviewer.pdf.RSReaderView  _asview() throws Exception{
 //BA.debugLineNum = 28;BA.debugLine="Public Sub AsView As PDFReaderView";
 //BA.debugLineNum = 29;BA.debugLine="Return mPDFReaderView";
if (true) return _mpdfreaderview;
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return null;
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Private Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Private mEventName As String";
_meventname = "";
 //BA.debugLineNum = 6;BA.debugLine="Private mLockResize As Boolean : mLockResize = False";
_mlockresize = false;
 //BA.debugLineNum = 6;BA.debugLine="Private mLockResize As Boolean : mLockResize = False";
_mlockresize = __c.False;
 //BA.debugLineNum = 7;BA.debugLine="Private mSaveWidth As Int : mSaveWidth = 0";
_msavewidth = 0;
 //BA.debugLineNum = 7;BA.debugLine="Private mSaveWidth As Int : mSaveWidth = 0";
_msavewidth = (int) (0);
 //BA.debugLineNum = 8;BA.debugLine="Private mSaveHeight As Int : mSaveHeight = 0";
_msaveheight = 0;
 //BA.debugLineNum = 8;BA.debugLine="Private mSaveHeight As Int : mSaveHeight = 0";
_msaveheight = (int) (0);
 //BA.debugLineNum = 9;BA.debugLine="Private mCurPage As Int : mCurPage = 0";
_mcurpage = 0;
 //BA.debugLineNum = 9;BA.debugLine="Private mCurPage As Int : mCurPage = 0";
_mcurpage = (int) (0);
 //BA.debugLineNum = 13;BA.debugLine="Private vPDF As PDFViewDual";
_vpdf = new com.rootsoft.rspdfviewer.pdf.RSPDFViewDual();
 //BA.debugLineNum = 14;BA.debugLine="Private mPDFReaderView As PDFReaderView";
_mpdfreaderview = new com.rootsoft.rspdfviewer.pdf.RSReaderView();
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public String  _close() throws Exception{
 //BA.debugLineNum = 40;BA.debugLine="Public Sub Close";
 //BA.debugLineNum = 41;BA.debugLine="If vPDF <> Null Then";
if (_vpdf!= null) { 
 //BA.debugLineNum = 42;BA.debugLine="vPDF.Close";
_vpdf.Close();
 };
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,String _eventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 22;BA.debugLine="Public Sub Initialize (EventName As String)";
 //BA.debugLineNum = 23;BA.debugLine="mEventName = EventName";
_meventname = _eventname;
 //BA.debugLineNum = 24;BA.debugLine="vPDF.Initialize(\"PDFView\")";
_vpdf.Initialize(ba,"PDFView");
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public String  _invalidate() throws Exception{
 //BA.debugLineNum = 47;BA.debugLine="Public Sub Invalidate";
 //BA.debugLineNum = 48;BA.debugLine="mPDFReaderView.Invalidate";
_mpdfreaderview.Invalidate();
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return "";
}
public String  _open(com.rootsoft.rspdfviewer.pdf.RSPDFDocument _document) throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Public Sub Open (Document As PDFDocument)";
 //BA.debugLineNum = 33;BA.debugLine="vPDF.Open(Document, 4, 4291611852)";
_vpdf.Open((com.radaee.pdf.Document)(_document.getObject()),(int) (4),(int) (4291611852L));
 //BA.debugLineNum = 34;BA.debugLine="mPDFReaderView.Initialize2(\"PDFReaderView\", vPDF)";
_mpdfreaderview.Initialize2(ba,"PDFReaderView",(com.radaee.view.PDFView)(_vpdf.getObject()));
 //BA.debugLineNum = 35;BA.debugLine="mPDFReaderView.Open(Document)";
_mpdfreaderview.Open((com.radaee.pdf.Document)(_document.getObject()));
 //BA.debugLineNum = 36;BA.debugLine="mPDFReaderView.Invalidate";
_mpdfreaderview.Invalidate();
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public String  _pdfreaderview_computescroll() throws Exception{
 //BA.debugLineNum = 73;BA.debugLine="Private Sub PDFReaderView_ComputeScroll";
 //BA.debugLineNum = 74;BA.debugLine="If vPDF == Null Then";
if (_vpdf== null) { 
 //BA.debugLineNum = 75;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 77;BA.debugLine="vPDF.ComputeScroll";
_vpdf.ComputeScroll();
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
public String  _pdfreaderview_draw(Object _canvas1) throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Private Sub PDFReaderView_Draw (Canvas1 As Object)";
 //BA.debugLineNum = 54;BA.debugLine="vPDF.Draw(Canvas1)";
_vpdf.Draw((android.graphics.Canvas)(_canvas1));
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public String  _pdfreaderview_sizechanged(int _width,int _height,int _oldwidth,int _oldheight) throws Exception{
 //BA.debugLineNum = 57;BA.debugLine="Private Sub PDFReaderView_SizeChanged (Width As Int, Height As Int, OldWidth As Int, OldHeight As Int)";
 //BA.debugLineNum = 58;BA.debugLine="mSaveWidth = Width";
_msavewidth = _width;
 //BA.debugLineNum = 59;BA.debugLine="mSaveHeight = Height";
_msaveheight = _height;
 //BA.debugLineNum = 60;BA.debugLine="If vPDF <> Null AND Not(mLockResize) Then";
if (_vpdf!= null && __c.Not(_mlockresize)) { 
 //BA.debugLineNum = 61;BA.debugLine="vPDF.Resize(Width, Height)";
_vpdf.Resize(_width,_height);
 };
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return "";
}
public boolean  _pdfreaderview_touchevent(Object _motionevent) throws Exception{
 //BA.debugLineNum = 65;BA.debugLine="Private Sub PDFReaderView_TouchEvent (MotionEvent As Object) As Boolean";
 //BA.debugLineNum = 66;BA.debugLine="If vPDF <> Null Then";
if (_vpdf!= null) { 
 //BA.debugLineNum = 67;BA.debugLine="Return vPDF.TouchEvent(MotionEvent)";
if (true) return _vpdf.TouchEvent((android.view.MotionEvent)(_motionevent));
 }else {
 //BA.debugLineNum = 69;BA.debugLine="Return True";
if (true) return __c.True;
 };
 //BA.debugLineNum = 71;BA.debugLine="End Sub";
return false;
}
public boolean  _pdfview_pdfdoubletapped(float _x,float _y) throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Private Sub PDFView_PDFDoubleTapped (X As Float, Y As Float) As Boolean";
 //BA.debugLineNum = 83;BA.debugLine="ToastMessageShow(\"Double tapped on location: X\" & X & \",Y: \" & Y, False)";
__c.ToastMessageShow("Double tapped on location: X"+BA.NumberToString(_x)+",Y: "+BA.NumberToString(_y),__c.False);
 //BA.debugLineNum = 85;BA.debugLine="Return False";
if (true) return __c.False;
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return false;
}
public String  _pdfview_pdffound(boolean _found) throws Exception{
 //BA.debugLineNum = 118;BA.debugLine="Private Sub PDFView_PDFFound (Found As Boolean)";
 //BA.debugLineNum = 120;BA.debugLine="End Sub";
return "";
}
public String  _pdfview_pdfinvalidate(boolean _post) throws Exception{
 //BA.debugLineNum = 94;BA.debugLine="Private Sub PDFView_PDFInvalidate (Post As Boolean)";
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return "";
}
public String  _pdfview_pdflongpressed(float _x,float _y) throws Exception{
 //BA.debugLineNum = 98;BA.debugLine="Private Sub PDFView_PDFLongPressed (X As Float, Y As Float)";
 //BA.debugLineNum = 100;BA.debugLine="End Sub";
return "";
}
public String  _pdfview_pdfpagedisplayed(Object _canvas1,Object _page) throws Exception{
 //BA.debugLineNum = 122;BA.debugLine="Private Sub PDFView_PDFPageDisplayed (Canvas1 As Object, Page As Object)";
 //BA.debugLineNum = 123;BA.debugLine="Invalidate";
_invalidate();
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public String  _pdfview_pdfposchanged(Object _pos) throws Exception{
 //BA.debugLineNum = 102;BA.debugLine="Private Sub PDFView_PDFPosChanged (Pos As Object)";
 //BA.debugLineNum = 104;BA.debugLine="End Sub";
return "";
}
public String  _pdfview_pdfselectend() throws Exception{
 //BA.debugLineNum = 106;BA.debugLine="Private Sub PDFView_PDFSelectEnd";
 //BA.debugLineNum = 108;BA.debugLine="End Sub";
return "";
}
public String  _pdfview_pdfselecting(Object _canvas1,int[] _arg1,int _arg2) throws Exception{
 //BA.debugLineNum = 110;BA.debugLine="Private Sub PDFView_PDFSelecting (Canvas1 As Object, arg1() As Int, arg2 As Int)";
 //BA.debugLineNum = 112;BA.debugLine="End Sub";
return "";
}
public String  _pdfview_pdfshowpressed(float _x,float _y) throws Exception{
 //BA.debugLineNum = 114;BA.debugLine="Private Sub PDFView_PDFShowPressed(X As Float, Y As Float)";
 //BA.debugLineNum = 116;BA.debugLine="End Sub";
return "";
}
public boolean  _pdfview_pdfsingletapped(float _x,float _y) throws Exception{
 //BA.debugLineNum = 88;BA.debugLine="Private Sub PDFView_PDFSingleTapped (X As Float, Y As Float) As Boolean";
 //BA.debugLineNum = 89;BA.debugLine="ToastMessageShow(\"X: \" & X & \",Y: \" & Y, False)";
__c.ToastMessageShow("X: "+BA.NumberToString(_x)+",Y: "+BA.NumberToString(_y),__c.False);
 //BA.debugLineNum = 91;BA.debugLine="Return False";
if (true) return __c.False;
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return false;
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
ba.sharedProcessBA.sender = sender;
return BA.SubDelegator.SubNotFound;
}
}
