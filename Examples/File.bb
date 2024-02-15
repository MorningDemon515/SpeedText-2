; SpeedText 2 - Example
; Copyright © Christian Klaussner
; 
; Load a font from file

Include "..\Include\SpeedText.bb"
Include "Common.bb"

Graphics 640, 480, 0, 2
SetBuffer BackBuffer()

; Initialize the library and load common resources.
TextInitialize BackBuffer()
SamplesInitialize

Global example$
example = example + "This is some example text. "
example = example + "The quick brown fox jumps over the lazy dog. "
example = example + "Lorem ipsum dolor sit amet..."

; Loads the font "Kaileen" from Fonts\kaileen.ttf.
Function ReloadFont()
	Return TextLoadFont("Kaileen", size, False, False, False, TEXT_ANTIALIASED, "Fonts\kaileen.ttf")
End Function

Global size = 60
Global font = ReloadFont()

While Not KeyDown(1)
	Cls
	
	; Change the size and reload the font if arrow keys are hit.
	If KeyHit(200)
		size = size - 5
		If size < 25 size = 25
		
		TextFreeFont font
		font = ReloadFont()
	End If
	
	If KeyHit(208)
		size = size + 5
		If size > 300 size = 300
		
		TextFreeFont font
		font = ReloadFont()
	End If
	
	; Display the example text.
	TextSetFont font
	TextDrawRect 40, 110, 560, 0, example, TEXT_LEFT, TEXT_WORDWRAP Or TEXT_DONTCLIP, TEXT_ANSI
	
	SamplesDisplayInstructions("Use arrow keys up and down to change the font size.")
	
	SamplesWait
	Flip 0
Wend

; Free resources and exit.
TextFreeFont font

SamplesDeinitialize
TextDeinitialize

End