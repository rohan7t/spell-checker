# Spell Checker
Web application to spell check a file.


##Project Members:
1) Rahul Manjunath Ashlesh

2) Rohan Tigadi

###Implementation:
We chose to design an application for Spell checking for a provided input file.
We configured this web application on the Spring framework, maven build tool and an Apache Tomcat server.

Programming language: Java (jdk 1.8)

Framework: Spring

###Usage
The web application exposes one endpoint `/spellCheck` as a POST request method with a required `path` parameter. The `path` parameter contains the location of the input file to be spell checked.
The web application returns the mispelled words in the provided input file after the endpoint `/spellCheck` is hit with valid parameter.