; SpeedText 2
; Copyright © Christian Klaussner
; 
; SpeedTextLegacy.bb

Const ST_ANSI		= 0
Const ST_UTF8		= 1

Const ST_LEFT		= 0
Const ST_CENTER	= 1
Const ST_RIGHT	= 2

Const ST_TOP		= 0
Const ST_MIDDLE	= 1
Const ST_BOTTOM	= 2

Const ST_DEFAULT			= 0
Const ST_NONANTIALIASED	= 1
Const ST_ANTIALIASED		= 2
Const ST_CLEARTYPE			= 3

Const ST_WORDWRAP	= 1
Const ST_CLIPRECT	= 2

Function ST_Initialize(buffer)
	Return TextInitialize(buffer)
End Function

Function ST_SetBuffer(buffer)
	TextSetBuffer(buffer)
End Function

Function ST_GetBuffer()
	Return TextGetBuffer()
End Function

Function ST_LoadFont(fontname$, height, bold, italic, underline, quality)
	Return TextLoadFont(fontname, height, bold, italc, underline, quality, "")
End Function

Function ST_FreeFont(font)
	TextFreeFont(font)
End Function

Function ST_SetFont(font)
	TextSetFont(font)
End Function

Function ST_DrawText(x, y, txt$, ax, ay)
	TextDraw(x, y, txt, ax, ay, ST_ANSI)
End Function

Function ST_DrawTextRect(x, y, width, height, txt$, ax, format)
	Local nativeformat
	If format And ST_WORDWRAP nativeformat = nativeformat + 1
	If Not (format And ST_CLIPRECT) nativeformat = nativeformat + 2
	
	TextDrawRect(x, y, width, height, txt, ax, format, ST_ANSI)
End Function

Function ST_TextColor(red, green, blue)
	TextSetColor(red, green, blue)
End Function

Function ST_TextBackground(red, green, blue)
	TextSetBackground(red, green, blue)
End Function

Function ST_StringWidth(txt$)
	Return TextStringWidth(txt, ST_ANSI)
End Function

Function ST_StringHeight(txt$)
	Return TextStringHeight(txt, ST_ANSI)
End Function

Function ST_FontWidth()
	Return TextFontWidth()
End Function

Function ST_FontHeight()
	Return TextFontHeight()
End Function

Function ST_LockBuffer()
	TextLockBuffer()
End Function

Function ST_UnlockBuffer()
	TextUnlockBuffer()
End Function

Function ST_DrawTextFast(x, y, txt$, ax, ay)
	TextDraw(x, y, txt, ax, ay, ST_ANSI)
End Function

Function ST_DrawTextRectFast(x, y, width, height, txt$, ax, format)
	ST_DrawTextRect(x, y, width, height, txt, ax, format)
End Function