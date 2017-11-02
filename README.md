##### About:
Code sample for test-automation of website: 
http://mendeley.com

The project is built using the following:
* Java 1.8
* Selenium WebDriver 3.6.0
* Cucumber 1.2.5
* Spring 4.3.8
* Maven 3.3.9


##### Test Cases: Cucumber feature files should serve as Test Cases.Click below link:
* [Cucumber feature files](/src/test/resources/features)
* Once you run the program see cucumber reports in target directory to see colourful TestCases
  all in one place coupled with screenshots of any failed tests

##### how to run:
* Need Java1.8 and maven3.3.9 to run.
  If you do not have maven installed, the project can also be run within a java ide
  as most Java IDEs come with maven bundled.
* Download the project and run maven command: mvn verify. 
  The command runs with headless browser htmlunit.Be warned that htmlunit throws a lot
  warnings but it still does the job.
  After running; Cucumber reports will be generated in 'target/cucumber' directory.
  Within that directory click on index.html to see Cucumber reports.
* Works with any browser For eg: to run with chrome:
  Download the latest chrome driver binary into /src/test/drivers directory.
  Chrome driver url : https://chromedriver.storage.googleapis.com/index.html?path=2.33 
  Change browser property in pom.xml to chrome or pass the same options via mvn commandline
  <br>For eg:  mvn verify -Dbrowser="chrome" -Dwebdriver.chrome.driver="file location of driver exe file"


##### tested on:
* os : windows 10
* htmlunit and chrome 61 and driver-version: 2.33
* default browser choice : htmlunit 



  
  


