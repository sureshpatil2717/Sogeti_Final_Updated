Sogeti_poc-WebUIAutomatiom
That Automation Testing is BDD framework which Uses
1.Selenium
2.Maven
3.Cucumber BDD (Gherkin language) via Junit ,
4.using Cucumber 6 Extent report for generating PDF & Spark reports
5.Using junit for assertions
6.Reading from Properties files for storing environment variables

Structure of Project:
1- src/main/java
com.qa.util : Package includes a class of methods to read the config properties and Util functions

2- src/test/java
Pageobjects:Page wise object with page object model with page factory
stepDefinitions : Package includes steps class that has the implementations of the feature files
TestRunner:Package include the test runner that run the step definitionns along with the designated feature file

3- src/test/resources
AppFeature : Package includes the feature file
config.properties that contains the environment variables ( URL to run against & Testdata)
cucumber.properties file includes the properties of the display of the cucumber report over the browser
extent-config xml file includes the properties of the display of the extent report over the browser
extent.properties includes the location of the generated reports and some system info to be displayed in the report

Running the project
Download the project on your local machine
Import the project to your editor(Eg: Eclipse)
Right Click on the project , choose Maven and Click on Update Project
After the Update Project is completed go to the MyTestRunner under testRunner Package
Right click on the MyTestRunner and Run As Juint Test

Generating The Test Reports :
(open test output folder) and you will get a generated pdf report contains all the details of the execution (pass/fail)
