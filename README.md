[![Build Status](https://travis-ci.org/lazycoderio/FluentJava.svg?branch=master)](https://travis-ci.org/lazycoderio/FluentJava) [![codecov](https://codecov.io/gh/lazycoderio/FluentJava/branch/master/graph/badge.svg)](https://codecov.io/gh/lazycoderio/FluentJava) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/1cc6b08410c349e5818f04dbca1eab68)](https://www.codacy.com/app/LazyCoderIO/FluentJava?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=lazycoderio/FluentJava&amp;utm_campaign=Badge_Grade) [![Dependency Status](https://www.versioneye.com/user/projects/59188d72eb858e0051b5964f/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/59188d72eb858e0051b5964f) [![Join the chat at https://gitter.im/lazycoderio/FluentJava](https://badges.gitter.im/lazycoderio/FluentJava.svg)](https://gitter.im/lazycoderio/FluentJava?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge) [![Stories in Ready](https://badge.waffle.io/lazycoderio/FluentJava.svg?label=ready&title=Ready)](http://waffle.io/lazycoderio/FluentJava)

# Fluent Java FTW

All of the goodness lives in the basePage and baseTest classes.

Check out the project f=plan for the upcoming features that will be added to this framework.
## Setup

Run these commands depending on your base OS.

### On Mac OS

Copy this bootstrap script and run it in a Terminal shell window:

   ```
   sh -c "$(curl -fsSL https://raw.githubusercontent.com/lazycoderio/FluentJava/master/mac-bootstrap.sh)"
   ```

It installs the following if it is not already installed:

1. Install Homebrew `/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"`
2. Install Caskroom `brew tap caskroom/cask`
3. If you dont have the Java Development Kit (JDK) run this command `brew cask install java`
4. Install Maven `brew install maven`
5. Run `./mac_install_browsers.sh`

The script also runs the test.

### On Windows

> This is currently having a few issue

1. Download the zip file or clone this repository.
2. Navigate to the unzipped folder within the file browser.
3. Right-Click on `windows_install.bat` and select `Run as Administrator`
4. Test the installation by running the following from a command window in the directory of this project

   `mvn test  -Dsurefire.suiteXmlFiles=windows-only.xml`

#### Longer Instructions

1. The script should install Chocolatey the Windows package manager.
2. Install latest versions of 
    a. Firefox
    b. Chrome
    c. PhantomJS
3. Selenium drivers for the above and the Edgedriver


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