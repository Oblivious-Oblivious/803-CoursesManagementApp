JAVA = java
CC = $(JAVA)c
OPT =
VERSION =

FLAGS =
WARNINGS =
REMOVE_WARN =
HEADERS =
LIBS = -classpath ./libs/jspec.jar:./libs/commons-math3-3.6.1.jar:.

APPINPUT = app/src/**/*.java
APPTESTINPUT = app/test/**/*.java app/test/TestRunner.java
DBINPUT = persistence/**/src/*.java persistence/TestRunner.java
DBTESTINPUT = persistence/**/test/*.java
CLIINPUT = client/cli/*.java
WEBINPUT =

APPOUTPUT = app/src/**/*.class
APPTESTOUTPUT = app/test/**/*.class app/test/*.class
DBOUTPUT = persistence/**/src/*.class persistence/TestRunner.class
DBTESTOUTPUT = persistence/**/test/*.class persistence/*.class persistence/custom/src/*.db
CLIOUTPUT = client/cli/*.class
WEBOUTPUT =

all: compile

compile:
	$(CC) $(LIBS) $(OPT) $(VERSION) $(HEADERS) $(FLAGS) $(WARNINGS) $(REMOVE_WARN) $(APPINPUT) $(DBINPUT)
	@echo

test: compile
	$(CC) $(OPT) $(VERSION) $(HEADERS) $(FLAGS) $(WARNINGS) $(REMOVE_WARN) $(LIBS) $(APPTESTINPUT)
	$(JAVA) $(LIBS) app/test/TestRunner

testdb:
	$(CC) $(OPT) $(VERSION) $(HEADERS) $(FLAGS) $(WARNINGS) $(REMOVE_WARN) $(LIBS) $(DBINPUT) $(DBTESTINPUT)
	$(JAVA) $(LIBS) persistence/TestRunner

cli:
	$(CC) $(OPT) $(VERSION) $(HEADERS) $(FLAGS) $(WARNINGS) $(REMOVE_WARN) $(CLIINPUT)
	$(JAVA) client/cli/EntryPoint

web:

clean:
	$(RM) $(APPOUTPUT) $(APPTESTOUTPUT) $(CLIOUTPUT) $(GUIOUTPUT) $(WEBOUTPUT) $(DBOUTPUT) $(DBTESTOUTPUT)
