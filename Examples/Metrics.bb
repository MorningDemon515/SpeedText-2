; SpeedText 2 - Example
; Copyright © Christian Klaussner
; 
; Measure text strings

Include "..\Include\SpeedText.bb"
Include "Common.bb"

Graphics 640, 480, 0, 2
SetBuffer BackBuffer()

; Initialize the library and load common resources.
TextInitialize BackBuffer()
SamplesInitialize

; Load fonts.
Global small = TextLoadFont("Arial", 15, False, False, False, TEXT_NONANTIALIASED, "")
Global font = TextLoadFont("Times New Roman", 40, False, False, False, TEXT_ANTIALIASED, "")

Global txt$ = "Type some text..."
Global x = 40
Global y = 220

; Select the font and get font and string metrics.
TextSetFont font

Global ascent		= TextFontAscent()
Global descent	= TextFontDescent()
Global width		= TextStringWidth(txt, TEXT_ANSI)
Global height		= TextStringHeight(txt, TEXT_ANSI)

While Not KeyDown(1)
	Cls
	
	; Handle text input.
	Local key = GetKey()
	If key <> 0
		If key >= 32
			txt = txt + Chr(key)
			
			Else
			
			If key = 8
				Local length = Len(txt)
				If length > 0 txt = Left(txt, length-1)
			End If
		End If
		
		width = TextStringWidth(txt, TEXT_ANSI)
		height = TextStringHeight(txt, TEXT_ANSI)
	End If
	
	; Display font metrics using rectangles and lines.
	Color 255, 0, 0
	TextSetColor 255, 0, 0
	TextSetFont small
	
	; Draw width line.
	Line x, y + height + 10, x + width, y + height + 10
	TextDraw x + width / 2, y + height + 20, "Width: " + width, TEXT_CENTER, TEXT_TOP, TEXT_ANSI
	
	; Draw height line.
	Line x + width + 10, y, x + width + 10, y + height
	TextDraw x + width + 20, y + height / 2, "Height: " + height, TEXT_LEFT, TEXT_MIDDLE, TEXT_ANSI
	
	; Draw ascent rectangle.
	Color 0, 255, 0
	Rect x, y, width, ascent
	
	; Draw descent rectangle.
	Color 0, 0, 255
	Rect x, y + ascent, width, descent
	
	; Display the text.
	TextSetColor 0, 0, 0
	TextSetFont font
	TextDraw x, y, txt, TEXT_LEFT, TEXT_TOP, TEXT_ANSI
	
	SamplesDisplayInstructions("Type some text. Use backspace to delete the last character. The green area marks the ascent and the blue area marks the descent of the font")
	
	SamplesWait
	Flip 0
Wend

; Free resources and exit.
TextFreeFont small
TextFreeFont font

SamplesDeinitialize
TextDeinitialize

End