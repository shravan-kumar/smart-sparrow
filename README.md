Smart Sparrow Coding Challenge

Prerequisites

Java (JDK or JRE) 7 or higher
Gradle (see here: https://docs.gradle.org/current/userguide/installation.html)
Testing

Via bash/sh etc, 'cd' to the project root
Execute 'gradle test'
Test results in HTML format will be found at 'build/reports/tests/test/index.html'
Test results in XML format will be found at 'build/test-results/test/'
Build

Via bash/sh etc, 'cd' to the project root
Execute 'gradle clean jar'
Include the arg '-i' for more logging. E.g. 'gradle -i clean jar'
A runnable jar file called robot.jar will be found at 'build/libs/robot.jar'
Note: This jar will be roughly 7MB as it includes the Groovy runtime as well
Run

Via CLI with manual input

Navigate to where the robot.jar file is located
Execute 'java -jar coding_challenge.jar'
Issue commands to the app as per acceptable commands (type "help" for more info)

Example Usage

Via stdin

$ java -jar coding_challenge.jar
help
Application accepts the input commands [BR, CP, AN, SP, TC, HELP, EXIT, BYE].
These can be issued in lowercase or uppercase.


Example Build Output

$ gradle build
  :compileJava UP-TO-DATE
  :compileGroovy UP-TO-DATE
  :processResources UP-TO-DATE
  :classes UP-TO-DATE
  :jar UP-TO-DATE
  :assemble UP-TO-DATE
  :compileTestJava UP-TO-DATE
  :compileTestGroovy
  :processTestResources UP-TO-DATE
  :testClasses
  :test
  :check
  :build

BUILD SUCCESSFUL

Total time: 13.15 secs
