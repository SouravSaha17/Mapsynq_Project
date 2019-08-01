  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
#           		MAPYSYNQ Automation			    #
#		       Version 1.0.0      			    #
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Contents
---------------------------------------------------------------------
    * Concepts Included
    * Tools
    * Requirements
    * Test Framework Setup
    * Usage
    * Reporting

Concepts Included
*********************************************************************
	Data Driven Testing Approach
	Dependency injection Via Maven
        Page Object pattern
        Execution using Command Prompt
        Common web page interaction methods
        Commonly used test utility classes
        Reporting 
*********************************************************************
Tools
*********************************************************************
                   Eclispe
                   JAVA
                   Maven
                   TestNG
                   Apache POI
                   Selenium Webdriver
		   Extent Report
                   Chrome Driver
                   
Requirements
*********************************************************************
In order to utilise this project you need to have the following installed locally:

                 Maven 3.1
                 Chrome and Chromedriver (UI tests use Chrome by default, can be changed in config)
                 Java 1.8.0.121	


Test Framework Setup
*********************************************************************
Clone Repo - https://github.com/SouravSaha17/Mapsynq_Project.git


Usage
*********************************************************************
The project is broken into separate modules for sperate modules based on test scenarios,It can easily be utilised independently of the others using maven profiles.

To run all modules, navigate to directory and run:
mvn test

To run parallel test cases: 
Change the testng file passed in pom.xmlfrom testng1.xml to testngparallel.xml and execute pom.xml

To do Headless execution:
Change Browser_Name from Chrome to Chrome_Headless in application.properties file (path: src/main/resources/application.properties)

Reporting
*********************************************************************
Test result comes in a HTML report(Mapsynq Automation) concatineted with timestamp to maintain log in Reports folder.

To get detail report select the testcase and the test step report is visible.

In the case of test failures of any step will be reflelected in the report with screenshot.

The logs for screenshots are maintained in a Screenshot folder.


*********************************************************************
			Contact Information
*********************************************************************
Support: 
	
	Email Id: saha.sourav17@gmail.com
	Phone No: 09875606928
*********************************************************************

