# practice-playwright
Practicing against: 
- https://candymapper.com/
- https://www.candymapper.net

# Playwright, TestNG, Allure Reports Project

This project is generated from an archetype. It exists out of TestNG, Playwright, Allure and OWNER as the main dependencies.

## Selenium vs Playwright

In Selenium, using the WebDriver protocol, the tests (client) sends HTTP requests to the selenium server (holding the webdriver). 
The server then sends response back to the client. However, there is a disconnect afterward.

In Playwright, using the WebSocket protocol, it just needs to establish connection once, and there is no disconnect.
Since there is no disconnection, it is much faster in comparison.

## What is WebSocket protocol?
Unlike http based protocols, it only needs to make a connection once.
It enables real-time, two-way communication between a client and a server by establishing a persistent TCP connection,
where data can be sent and received simultaneously without the need for repeated HTTP requests.

## Playwright codegen
Playwright comes with the ability to record and generate code with the locators. 
When launched it comes with two windows, one with the browser and the other with code generating as you interact with the site.
To launch, simply enter this maven command:<br>
```mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen https://candymapper.com"```<br>
Refer to: https://playwright.dev/java/docs/codegen-intro

## Playwright inspector
Another way to access the codegen is via the inspector/debugging feature that playwright provides. 

Put `PWDEBUG=1` as environment variable to debug from the beginning,
or add in your code `page.pause();`, which will start debugger from that point
<br>
Refer to: https://playwright.dev/java/docs/debug

## About auto wait
https://playwright.dev/java/docs/actionability

## Trace Viewer
Basically a recorder, but much more powerful than a video recorder, as it records e.g. console, network events, before and after of actions. 
I can see how this would be really helpful for debugging!
<br>Added this to BeforeMethod to start and AfterMethod to stop.
<br>
https://playwright.dev/java/docs/trace-viewer-intro

## About Browser Context
Browser Context allows to open several instances of the browser.
It is like different browser profiles, with its own set of cookies and cache.
This allows for multiple users to login and test their interactions with each other instead having to log out each time.
E.g.
- Chatting between different users
- Users and custodians with different roles on the same platform

## Run tests

`mvn clean test`

## Run tests in specific browser

`mvn clean test -Dbrowser=chromium`

`mvn clean test -Dbrowser=chromium_headed`

`mvn clean test -Dbrowser=firefox`

`mvn clean test -Dbrowser=firefox_headed`

`mvn clean test -Dbrowser=webkit`

`mvn clean test -Dbrowser=webkit_headed`

`mvn clean test -Dbrowser=chrome`

`mvn clean test -Dbrowser=chrome_headless`

`mvn clean test -Dbrowser=msedge`

`mvn clean test -Dbrowser=msedge_headed`

## Generate report

`mvn allure:report`

## Serve report

`mvn allure:serve`

## Check for dependency updates

`mvn versions:display-dependency-updates`

## Update to the latest release version
