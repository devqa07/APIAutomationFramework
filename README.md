Rest-API Automation framework:

Install Maven and Import as Maven project in IntelliJ or Eclipse

Framework Structure:

base:

db:

pojo:

requestBuilder:

responseParser

utils:

resources: 

config.properties - all service urls , db connections and usernames

testData:This consists of all the .csv files test data

test: All Success and Error test cases

How to run test cases:

Eclipse/IntelliJ -Right click to any test class

CMD Line :

mvn clean test -Denvironment=${environment} -DsuiteXmlFile=${suiteXmlFile} 
-Dtestng.dtd.http=true -DdbPwd=${dbPwd} 

Example: mvn clean test -Denvironment=qa -DsuiteXmlFile=testNG.xml -Dtestng.dtd.http=true -DdbPwd=qa-db-pwd

Reports Generation(REST-API-AutomationReport.html)