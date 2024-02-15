; SpeedText 2 - Example
; Copyright � Christian Klaussner
; 
; Strings with UTF-8 encoding

Include "..\Include\SpeedText.bb"
Include "Common.bb"

Graphics 640, 480, 0, 2
SetBuffer BackBuffer()

SeedRnd MilliSecs()

; Initialize the library and load common resources.
TextInitialize BackBuffer()
SamplesInitialize

Global font = TextLoadFont("Times New Roman", 80, False, False, False, TEXT_ANTIALIASED, "")
TextSetFont font

TextSetColor Rand(0, 255), Rand(0, 255), Rand(0, 255)

While Not KeyDown(1)
	Cls
	
	; Choose random color.
	If KeyHit(28)
		TextSetColor Rand(0, 255), Rand(0, 255), Rand(0, 255)
	End If
	
	; Draw text using the TEXT_UTF8 flag.
	TextDraw 320, 190, "Ψ♫Юڮ☺♠№", TEXT_CENTER, TEXT_TOP, TEXT_UTF8
	
	SamplesDisplayInstructions("Press Enter to choose a random color.")
	
	SamplesWait
	Flip 0
Wend

; Free resources and exit.
TextFreeFont font

SamplesDeinitialize
TextDeinitialize

End