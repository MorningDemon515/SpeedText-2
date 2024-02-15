; SpeedText 2 - Example
; Copyright © Christian Klaussner
; 
; Text alignment

Include "..\Include\SpeedText.bb"
Include "Common.bb"

Graphics 640, 480, 0, 2
SetBuffer BackBuffer()

; Initialize the library and load common resources.
TextInitialize BackBuffer()
SamplesInitialize

Global font = TextLoadFont("Times New Roman", 20, False, False, False, TEXT_ANTIALIASED, "")
TextSetFont font

Global xalign = TEXT_CENTER, yalign = TEXT_TOP

Global x = 320, y = 220
Global demo$ = "The big brown fox jumps over the lazy dog."
Global width = TextStringWidth(demo, TEXT_ANSI)
Global height = TextStringHeight(demo, TEXT_ANSI)

While Not KeyDown(1)
	Cls

	; Change alignment mode.
	If KeyHit(2) xalign = TEXT_LEFT
	If KeyHit(3) xalign = TEXT_CENTER
	If KeyHit(4) xalign = TEXT_RIGHT
	
	If KeyHit(5) yalign = TEXT_TOP
	If KeyHit(6) yalign = TEXT_MIDDLE
	If KeyHit(7) yalign = TEXT_BOTTOM

	; Display lines to illustrate text position.
	Color 255, 255, 255
	Line x - width / 2, y, x + width / 2, y
	Line x - width / 2, y + height, x + width / 2, y + height
	
	Color 255, 0, 0
	Line x, y - 20, x, y + 40
	
	; Draw text with specified alignment.
	TextDraw x, y, demo, xalign, yalign, TEXT_ANSI

	SamplesDisplayInstructions("Press 1, 2 or 3 to change horizontal alignment and 4, 5 or 6 to change the vertical alignment.")
	
	SamplesWait
	Flip 0
Wend

; Free resources and exit.
TextFreeFont font

SamplesDeinitialize
TextDeinitialize

End