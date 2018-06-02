# Assignment 1
Unit testing

## Environment
OS: macOS 10.13.5

Java: Oracle JDK 1.8

IDE used: Intellij IDEA Community Edition 2018.1

Junit: 4.11

Maven: Model version - 4.0.0

## Instructions to build and test
To get the repository: `git clone https://github.com/hardingliu/dal-cs5308.git`

Then cd into the A1 directory: `cd dal-cs5308/A1/`

To build a jar: `mvn package`

To run the program: `java -jar target/a1-1.0-SNAPSHOT.jar filename.xml`

To run unit tests: `mvn test`

To clean the build: `mvn clean`

## Regarding test coverage
I did not write unit tests for the *DOMGenerator* class, since the methods of that class will
be called according to different cases of the returned XML file. For example, if the deliveryaddress
is invalid, the method to generate a DOM object for that case will be called. All the methods for
handling different cases are tested. Thus, to me, it seems that there is no need to write tests for the
*DOMGenerator* class. Besides, the methods of that class all return a DOM object, which is hard to test
as well, at least in my opinion.
