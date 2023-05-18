run:
	
	python make.py

	java -cp classfiles main/Main

test:

	javac -d classfiles -cp .;lib/jbox2d-jbox2d-2.2.1.1.jar -sourcepath src/java/awtgl/math/*.java;src/java/awtgl/image/*.java;src/java/awtgl/particle/*.java;src/java/awtgl/window/*.java;src/java/main/*.java;src/java/game/entity/*.java;src/java/game/entity/tile/*.java src/java/awtgl/math/*.java src/java/awtgl/image/*.java src/java/awtgl/particle/*.java src/java/awtgl/window/*.java src/java/main/*.java src/java/game/entity/*.java src/java/game/entity/tile/*.java && java -cp classfiles main/Main