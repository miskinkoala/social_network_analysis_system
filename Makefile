# Makefile for Java project

# Variables
SRC_DIR = src
BUILD_DIR = build
MAIN_CLASS = Main
INPUT_DIR = src

# Java compiler
JAVAC = javac
JAVA = java
JDFLAGS = -protected -splitindex -use -author -version -d docs/javadocs


# Compile Java files
compile:
	mkdir -p $(BUILD_DIR)
	$(JAVAC) -d $(BUILD_DIR) $(wildcard $(SRC_DIR)/*.java)
# Run the main class
run:
	$(JAVA) -cp $(BUILD_DIR) $(MAIN_CLASS)

# Clean build files
clean:
	rm -rf $(BUILD_DIR)
	
cleandoc:
	rm -rf docs/javadocs
	
doc:
	javadoc $(JDFLAGS) $(SRC_DIR)/*.java 
