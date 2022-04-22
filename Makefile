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
APPTESTINPUT = app/test/**/*.java app/test/TestRunner.java
DBINPUT = dbms/custom/src/*.java
DBTESTINPUT = dbms/custom/test/*.java
CLIINPUT = client/cli/*.java
WEBINPUT =

APPOUTPUT = app/src/**/*.class
APPTESTOUTPUT = app/test/**/*.class app/test/*.class
DBOUTPUT = dbms/custom/src/*.class
DBTESTOUTPUT = dbms/custom/test/*.class
CLIOUTPUT = client/cli/*.class
WEBOUTPUT =

all: compile

compile:
	$(CC) $(OPT) $(VERSION) $(HEADERS) $(FLAGS) $(WARNINGS) $(REMOVE_WARN) $(APPINPUT)
	@echo

test: compile
	$(CC) $(OPT) $(VERSION) $(HEADERS) $(FLAGS) $(WARNINGS) $(REMOVE_WARN) $(LIBS) $(APPTESTINPUT)
	$(JAVA) $(LIBS) app/test/TestRunner

testdb:
	$(CC) $(OPT) $(VERSION) $(HEADERS) $(FLAGS) $(WARNINGS) $(REMOVE_WARN) $(LIBS) $(DBINPUT) $(DBTESTINPUT)
	$(JAVA) $(LIBS) dbms/custom/test/TestRunner

cli:
	$(CC) $(OPT) $(VERSION) $(HEADERS) $(FLAGS) $(WARNINGS) $(REMOVE_WARN) $(CLIINPUT)
	$(JAVA) client/cli/EntryPoint

web:

clean:
	$(RM) $(APPOUTPUT) $(APPTESTOUTPUT) $(CLIOUTPUT) $(GUIOUTPUT) $(WEBOUTPUT) $(DBOUTPUT) $(DBTESTOUTPUT) dbms/custom/src/*.db
