Type=Class
Version=3.2
@EndOfDesignText@
'Class module
Private Sub Class_Globals
	
	'Declaration of variables
	Private mEventName As String
	Private mLockResize As Boolean : mLockResize = False
	Private mSaveWidth As Int : mSaveWidth = 0
	Private mSaveHeight As Int : mSaveHeight = 0
	Private mCurPage As Int : mCurPage = 0
	
	
	'Declaration of views
	Private vPDF As PDFViewDual
	Private mPDFReaderView As PDFReaderView


	'Declaration of libraries
	
End Sub

'Initializes the ReaderController.
Public Sub Initialize (EventName As String)
	mEventName = EventName
	vPDF.Initialize("PDFView")
End Sub

'Returns the view.
Public Sub AsView As PDFReaderView
	Return mPDFReaderView
End Sub

Public Sub Open (Document As PDFDocument)
	vPDF.Open(Document, 4, 4291611852)
	mPDFReaderView.Initialize2("PDFReaderView", vPDF)
	mPDFReaderView.Open(Document)
	mPDFReaderView.Invalidate
	
End Sub

Public Sub Close
	If vPDF <> Null Then
		vPDF.Close
	End If
	
End Sub

Public Sub Invalidate
	mPDFReaderView.Invalidate
End Sub

' ! --------------- ! PDFREADERVIEW EVENTS ! --------------- !

Private Sub PDFReaderView_Draw (Canvas1 As Object)
	vPDF.Draw(Canvas1)
End Sub

Private Sub PDFReaderView_SizeChanged (Width As Int, Height As Int, OldWidth As Int, OldHeight As Int)
	mSaveWidth = Width
	mSaveHeight = Height
	If vPDF <> Null AND Not(mLockResize) Then
		vPDF.Resize(Width, Height)
	End If
End Sub

Private Sub PDFReaderView_TouchEvent (MotionEvent As Object) As Boolean
	If vPDF <> Null Then
		Return vPDF.TouchEvent(MotionEvent)
	Else
		Return True
	End If
End Sub

Private Sub PDFReaderView_ComputeScroll
	If vPDF == Null Then
		Return
	End If
	vPDF.ComputeScroll
End Sub

' ! --------------- ! PDFVIEW EVENTS ! --------------- !

Private Sub PDFView_PDFDoubleTapped (X As Float, Y As Float) As Boolean
	ToastMessageShow("Double tapped on location: X" & X & ",Y: " & Y, False)

	Return False
End Sub

Private Sub PDFView_PDFSingleTapped (X As Float, Y As Float) As Boolean
	ToastMessageShow("X: " & X & ",Y: " & Y, False)

	Return False
End Sub

Private Sub PDFView_PDFInvalidate (Post As Boolean)
	
End Sub

Private Sub PDFView_PDFLongPressed (X As Float, Y As Float)
	
End Sub

Private Sub PDFView_PDFPosChanged (Pos As Object)
	
End Sub

Private Sub PDFView_PDFSelectEnd
	
End Sub

Private Sub PDFView_PDFSelecting (Canvas1 As Object, arg1() As Int, arg2 As Int)
	
End Sub

Private Sub PDFView_PDFShowPressed(X As Float, Y As Float)
	
End Sub

Private Sub PDFView_PDFFound (Found As Boolean)
	
End Sub

Private Sub PDFView_PDFPageDisplayed (Canvas1 As Object, Page As Object)
	Invalidate
End Sub







