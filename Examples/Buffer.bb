; SpeedText 2 - Example
; Copyright © Christian Klaussner
; 
; Render text into a buffer

Include "..\Include\SpeedText.bb"
Include "Common.bb"

Graphics3D 640, 480, 0, 2

; Initialize the library and load common resources.
TextInitialize BackBuffer()
SamplesInitialize

; Create objects for the 3D scene.
MoveEntity CreateCamera(), 0, 0, -3.5
LightColor CreateLight(), 128, 128, 128

Global texture = CreateTexture(512, 512)

Global cube = CreateCube()
EntityTexture cube, texture

; Load the font to be displayed on the cube.
Global font = TextLoadFont("Times New Roman", 60, True, False, False, TEXT_ANTIALIASED, "")
TextSetFont font

; Draw to the texture's buffer.
TextSetBuffer TextureBuffer(texture)

	SetBuffer TextureBuffer(texture)
	Color 0, 0, 127
	Rect 0, 0, 512, 512, True
	
	Color 0, 0, 64
	Oval 150, 250, 512, 512
	SetBuffer BackBuffer()
	
	TextDraw 20, 20, "Text rendered into", TEXT_LEFT, TEXT_TOP, TEXT_ANSI
	TextDraw 20, 100, "a texture's buffer.", TEXT_LEFT, TEXT_TOP, TEXT_ANSI
TextSetBuffer BackBuffer()

While Not KeyDown(1)

	; Rotate the cube using arrow keys.
	If KeyDown(200) TurnEntity cube, 1, 0, 0
	If KeyDown(208) TurnEntity cube, -1, 0, 0
	If KeyDown(203) TurnEntity cube, 0, -1, 0
	If KeyDown(205) TurnEntity cube, 0, 1, 0
	
	RenderWorld
	SamplesDisplayInstructions("Use arrow keys to rotate the cube.")
	
	SamplesWait
	Flip 0
Wend

; Free resources and exit.
TextFreeFont font

SamplesDeinitialize
TextDeinitialize

End