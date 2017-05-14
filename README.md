# Fluent Java FTW

All of the goodness lives in the basePage and baseTest classes.

Check out the project f=plan for the upcoming features that will be added to this framework.

## Running the tests and generating the reports

`mvn clean test -Dsurefire.suiteXmlFiles=all.xml site jetty:run`

### Test Phase

`clean test -Dsurefire.suiteXmlFiles=all.xml` 

The surefire plugin is there to run specific suite files.

Teh suite files are used so that entire suites can easily be shared and executed.

### Report Phase

`site`

### Showing off the Reports

`jetty:run`

Visit (http://localhost:8080)[http://localhost:8080] to view the HTML report

## Bonuses!

If this project is in IntelliJ Idea there is a shared runs so you can just use the built in `Run` commands in IntelliJ to run tests, generate reports and start up a Jetty Server with the results, instead of typing up the commands yourself.