; SpeedText 2
; Copyright © Christian Klaussner
; 
; Common Example Functions

Global samples_font_small, samples_font_big
Global samples_timer

Function SamplesInitialize()
	samples_font_small = TextLoadFont("Tahoma", 13, False, False, False, TEXT_ANTIALIASED, "")
	samples_font_big = TextLoadFont("Trebuchet MS", 30, True, False, False, TEXT_ANTIALIASED, "")
	
	samples_timer = CreateTimer(60)
End Function

Function SamplesDeinitialize()
	TextFreeFont samples_font_small
	TextFreeFont samples_font_big
	
	FreeTimer samples_timer
End Function

Function SamplesDisplayInstructions(ins$)
	Local prev = TextGetFont()
	
	Local red = TextColorRed()
	Local green = TextColorGreen()
	Local blue = TextColorBlue()
	
	TextSetColor 255, 255, 255
	
	TextSetFont samples_font_big
	TextDraw 20, 15, "SpeedText - Example", TEXT_LEFT, TEXT_TOP, TEXT_ANSI
	
	TextSetFont samples_font_small
	TextDrawRect 20, 50, 260, 200, ins, TEXT_LEFT, TEXT_WORDWRAP, TEXT_ANSI
	
	TextSetFont prev
	TextSetColor red, green, blue
End Function

Function SamplesWait()
	WaitTimer samples_timer
End Function