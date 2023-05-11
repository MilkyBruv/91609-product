run:
	javac -d classfiles -sourcepath src/java/main/*.java;src/java/awtgl/window/*.java src/java/main/*.java src/java/awtgl/window/*.java
	java -cp classfiles main/Main