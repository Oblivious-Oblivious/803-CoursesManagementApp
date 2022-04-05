JAVA = java
CC = $(JAVA)c
OPT =
VERSION =

FLAGS =
WARNINGS =
REMOVE_WARN =
HEADERS =
LIBS = -classpath ./libs/jspec.jar:.

APPINPUT = app/src/**/*.java
CLIINPUT = client/cli/*.java
APPTESTINPUT = app/test/**/*.java app/test/TestRunner.java
GUIINPUT =
WEBINPUT =

APPOUTPUT = app/src/**/*.class
APPTESTOUTPUT = app/test/**/*.class app/test/*.class
CLIOUTPUT = client/cli/*.class
GUIOUTPUT =
WEBOUTPUT =

all: compile

compile:
	$(CC) $(OPT) $(VERSION) $(HEADERS) $(FLAGS) $(WARNINGS) $(REMOVE_WARN) $(APPINPUT)
	@echo

test: compile
	$(CC) $(OPT) $(VERSION) $(HEADERS) $(FLAGS) $(WARNINGS) $(REMOVE_WARN) $(LIBS) $(INPUT) $(APPTESTINPUT)
	$(JAVA) $(LIBS) app/test/TestRunner

run_cli:
	$(CC) $(OPT) $(VERSION) $(HEADERS) $(FLAGS) $(WARNINGS) $(REMOVE_WARN) $(CLIINPUT)
	$(JAVA) client/cli/EntryPoint

run_gui:

run_web:

clean:
	$(RM) $(APPOUTPUT) $(APPTESTOUTPUT) $(CLIOUTPUT) $(GUIOUTPUT) $(WEBOUTPUT)
