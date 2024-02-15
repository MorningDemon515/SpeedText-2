; SpeedText 2
; Copyright © Christian Klaussner
; 
; SpeedTextNative.bb

Const TEXT_ANSI = 0
Const TEXT_UTF8 = 1

Const TEXT_LEFT	= 0
Const TEXT_CENTER	= 1
Const TEXT_RIGHT	= 2

Const TEXT_TOP	= 0
Const TEXT_MIDDLE	= 1
Const TEXT_BOTTOM	= 2

Const TEXT_DEFAULT			= 0
Const TEXT_NONANTIALIASED	= 1
Const TEXT_ANTIALIASED		= 2
Const TEXT_CLEARTYPE		= 3

Const TEXT_WORDWRAP	= 1
Const TEXT_DONTCLIP	= 2

Global speedtext_encoding = TEXT_ANSI

Function SetEncoding(encoding)
	speedtext_encoding = encoding
End Function

Function LoadFont(fontname$, height = 10, bold = False, italic = False, underline = False)
	Return TextLoadFont(fontname, height, bold, italic, underline, TEXT_ANTIALIASED, "")
End Function

Function FreeFont(font)
	TextFreeFont(font)
End Function

Function SetFont(font)
	TextSetFont(font)
End Function

Function Text(x, y, txt$, centre_x = False, centre_y = False)
	Local ax, ay
	If centre_x ax = TEXT_CENTER
	If centre_y ay = TEXT_MIDDLE
	
	TextSetColor ColorRed(), ColorGreen(), ColorBlue()
	
	TextDraw(x, y, txt, ax, ay, speedtext_encoding)
End Function

Function FontWidth()
	Return TextFontWidth()
End Function

Function FontHeight()
	Return TextFontHeight()
End Function

Function FontAscent()
	Return TextFontAscent()
End Function

Function FontDescent()
	Return TextFontDescent()
End Function

Function StringWidth(txt$)
	Return TextStringWidth(txt, speedtext_encoding)
End Function

Function StringHeight(txt$)
	Return TextStringHeight(txt, speedtext_encoding)
End Function