**API Automation Test Framework**   
**CircleCI**   [![CircleCI](https://circleci.com/gh/ranit-geek/Api-Automation-Framework.svg?style=svg)](https://circleci.com/gh/ranit-geek/Api-Automation-Framework)

Api automation test framework created with java and restAssured. This framework is integrated with 
Allure reports which generates test reports in html format with all details.

Requirments:

1.Install maven command line tool to use below specified commands.

2.Install Allure report using the below command to see the reports:
```$xslt
brew install allure
```

Command to run the tests :

```$xslt
mvn clean test
```
Command to see the reports:

```$xslt
allure serve allure-results 
```
Run the above command in the root directory of the project where allure-results folder will
get generated after the test run.