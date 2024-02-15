; SpeedText 2 - Example
; Copyright © Christian Klaussner
; 
; Performance comparison

Include "..\Include\SpeedText.bb"
Include "Common.bb"

Graphics 640, 480, 0, 2
SetBuffer BackBuffer()

; Initialize the library.
TextInitialize BackBuffer()

; Load a SpeedText and a Blitz3D font for comparison.
Global font_speedtext = TextLoadFont("Tahoma", 13, False, False, False, TEXT_NONATIALIASED, "")
Global font_blitz = LoadFont("Tahoma", 13)

Global mode = 0

While Not KeyDown(1)
	Cls
	
	If KeyHit(28) mode = 1 - mode
	
	; Use standard Blitz3D mode.
	If mode = 0
		SetFont font_blitz
		
		time = MilliSecs()
		
		For y = 30 To 450 Step 12
			Text 10, y, "BlitzText BlitzText BlitzText BlitzText BlitzText BlitzText BlitzText BlitzText BlitzText BlitzText BlitzText BlitzText BlitzText BlitzText"
		Next
		
		time = MilliSecs() - time
	End If
	
	; Use SpeedText mode.
	If mode = 1
		TextSetFont font_speedtext
		
		time = MilliSecs()
		
		For y = 30 To 450 Step 12
			TextDraw 10, y, "SpeedText SpeedText SpeedText SpeedText SpeedText SpeedText SpeedText SpeedText SpeedText SpeedText SpeedText", TEXT_LEFT, TEXT_TOP, TEXT_ANSI
		Next
		
		time = MilliSecs() - time
	End If
	
	; Display rendering time.
	TextSetFont font_speedtext
	TextDraw 10, 10, "Time: " + time + " ms", TEXT_LEFT, TEXT_TOP, TEXT_ANSI
	
	Flip 0
Wend

; Free resources and exit.
FreeFont font_blitz
TextFreeFont font_speedtext

TextDeinitialize
End