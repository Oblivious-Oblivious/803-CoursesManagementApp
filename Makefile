JAVA = java
CC = $(JAVA)c
OPT =
VERSION =

FLAGS =
WARNINGS =
REMOVE_WARN =
HEADERS =
LIBS = -cp ./libs/jspec.jar

INPUT = src/**/*.java
OUTPUT = src/**/*.class

all: compiler

compiler:
	$(CC) $(OPT) $(VERSION) $(HEADERS) $(FLAGS) $(WARNINGS) $(REMOVE_WARN) $(LIBS) $(INPUT)
	@echo

#run:
#	cd src && $(JAVA) client/EntryPoint

test: compiler
# -cp ../libs/jspec.jar 
	cd test && $(JAVA) TestRunner

clean:
	$(RM) $(OUTPUT)
