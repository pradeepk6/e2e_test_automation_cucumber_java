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
* One feature with many scenarios implemented
* Once you run the program see cucumber reports in target directory to see colourful TestCases
  all in one place coupled with screenshots of any failed tests

##### how to run:
* Need Java1.8 and maven3.3.9 to run.
  If you do not have maven installed, the project can also be run within a java ide
  as most Java IDEs come with maven bundled.
* Download the latest chrome driver binary into /src/test/drivers directory.
  Chrome driver url https://chromedriver.storage.googleapis.com/index.html?path=2.33
  Run mvn command : mvn verify 
* Works with most browsers including headless For eg: to run with firefox: 
  Change browser property in pom.xml to firefox or pass the same options via mvn commandline
  <br>For eg:  mvn verify -Dbrowser="firefox" -Dwebdriver.gecko.driver="file location of driver exe file"
* To run headless chrome or firefox change the browser option to chromeheadless or firefoxheadless

##### tested on:
* os : windows 10
* Java8
* htmlunit, chrome 61 with driver-version: 2.33
* default browser choice : chrome 



  
  


