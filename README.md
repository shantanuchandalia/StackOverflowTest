# StackOverflowTest

This is a Test Automation Framework designed to test "StackOverflow.com". 

It uses Selenium - Java for automation and assertion is done using TestNg. It implements Page Object Model. For every [web]page there is a separate java class where the locators are identified and the actions upon them are performed. Then for all these separate webpages, separate test classes are defined. 

The framework uses Maven to run the tests. After Execution, Extent Report is generated showing the status of the test execution. 

To run the suite, you need to have either of these options:
  1. maven installed on your system > open cmd, navigate to the folder and type : mvn clean install
  2. Eclipse with Maven plugin > import the project in Eclipse and run as > Maven build > goals : clean install
  3. Eclipse with TestNg plugin installed > go to src/main/resources > right click on testng.xml > run as > TestNg Suite  

Test Report: 

* Report generated when the test is run through Maven [Approach : 1,2] :<ProjectName>/target/surefire-reports/ExtentReportStackOverflow.html
* Report generated when the test is run through TestNg [Approach : 3] :<ProjectName>/test-output/ExtentReportStackOverflow.html
* Screenshot is captured for Failed scenarios at <ProjectName>/screenshots
* Logs for Failed Testcase are shown separately in a tab in Extent Report
* Extent Report includes Environment Parameters

Test Suite could be run on below browsers: 

[We have to specify the browser name in this file: "<ProjectName>/src/main/java/com/stackOverflow/qa/configuration/config.properties"]
1. Chrome
2. Firefox
3. Edge

Versions of Dependencies / tools used:

* Java : 1.8
* TestNg : 7.3.0
* selenium-java : 3.141.59
* maven-surefire-plugin : 3.0.0-M5
* webdrivermanager : 3.8.1
* extentreports : 2.41.2
