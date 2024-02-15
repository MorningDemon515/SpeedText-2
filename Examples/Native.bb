; SpeedText 2 - Example
; Copyright © Christian Klaussner
; 
; Draw text using native Blitz3D functions

; Include SpeedTextNative to override the standard functions.
Include "..\Include\SpeedTextNative.bb"
Include "Common.bb"

Graphics 640, 480, 0, 2
SetBuffer BackBuffer()

; Initialize the library and load common resources.
TextInitialize BackBuffer()
SamplesInitialize

SeedRnd MilliSecs()

; Load and set a font using standard commands.
Global font = LoadFont("Tahoma", 40)
SetFont font

Global x = 100, y = 200

While Not KeyDown(1)
	Cls
	
	; Get random position.
	If KeyHit(28)
		x = Rand(20, 180)
		y = Rand(100, 400)
	End If
	
	Text x, y, "Using standard Text function."
	
	SamplesDisplayInstructions("Press Enter to place the text at a random position.")
	
	SamplesWait
	Flip 0
Wend

; Free resources and exit.
FreeFont font

SamplesDeinitialize
TextDeinitialize

End