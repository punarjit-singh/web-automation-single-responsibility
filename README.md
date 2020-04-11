# Flipkart Web Automation

### Framework Pattern
This project follows the Single Responsibility Principle to design Page Objects.
It also uses Java 8 factory pattern for local driver management. 

The project was designed on Mac OS Mojave using IntelliJ Idea 2019 community edition.   

### Dependencies:
* Java 8 Lambda etc.
* Selenium 3.141.59
* Maven for dependency management
* TestNG 7.1.0
* gson 2.8.6 to parse Json data
* Grid Selenium Server Standalone 3.141.59

## Setup
Corresponding drivers are required for the tests to run successfully.

```$xslt
cd com/flipkart/framework/grid
```

### Starting the Hub
```java -jar selenium-server-standalone-3.141.59.jar -role hub -hubConfig hubConfig.json -debug```

### Starting the Nodes

Note: please change corresponding paths to driver files before running this command:

```java -Dwebdriver.gecko.driver=/Users/punarjitsingh/drivers/geckodriver -Dwebdriver.chrome.driver=/Users/punarjitsingh/drivers/chromedriver -jar selenium-server-standalone-3.141.59.jar -role node```

### Running tests on grid
Right-click on TestNG.xml and select Run

## Directory Structure:
```$xslt
~root
        TestNG.xml for grid setup and parameterised execution
        
        pom.xml for dependencies
        
        .gitignore - to ignore target and other files from source code
        
        src
            main
                java
                    com.flipkart.framework
                                          driver
                                                local - not in use when using grid but it contains Abstract Driver manager class and driver Factory classes
                                                 CapabilityFactory and OptionsManager classes for use in grid run
                                          
                                          grid - contain grid Selenium Server Standalone jar and json configs for Hub and Nodes 
                                          
                                          pages
                                                common - contains Abstract Component and Abstract Page classes
                                                         also contains any common components that are visible on all flipkart pages
                                                         Each component class follows single responsibility pricinciple for easy maintainance in long run
                                                home - contains HomePage class - component consumed from /common
                                                productDetails - contains ProductDetailsPage and corresponding unique components
                                                searchResults -  contains SearchResultsPage and corresponding unique components
                                          
                                         utils - contains JsonHelper util and may contain many other utils in future 
                    
                    com.flipkart.test
                                    base (contains BaseTest class that is extended by all tests (one one test in this case)
                                    purchase (contains the flipkart ProductDetailsComparison test)
                                    testdata (contains testdata json)
```

### Important note regarding current flipkart.com
Due to COVID-19 Flipkart.com has temporarily disabled the Add to Cart and Purchase functionalty. Hence to complete the assignment this test actually compares product details on Search Results page against product details on the Product Details page. Also, because flipkart.com requires an India based mobile number I just used my own flipkart.com credentials and will be changes the password in a few days.

### Test Scenario Automated
Using test data from external source (json)
* Login to Flipkart.com
* Search using the keyword from the json
* Assert result list and capture product details
* Goto product details page 
* Compare product details with details captured from search results page
    
### Further
This project can be further enhanced by including automatic CI/CD, docker grid setup, test reporting, logging, file input output utils, api testing utils and methods, data driven capabilities, mock servers and other latest testing techniques. Since this follows the single responsibility principle it is very easy to extend and add more functionality. 