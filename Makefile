run:
	g++ -o output src/main/*.c -lallegro -lallegro_image -lallegro_primitives -mwindows
	.\output.exe