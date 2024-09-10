Feature: to validate Registration functionality

@wip1009a
Scenario: to validate Registration using valid data 
Given user starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user clicks link using xpath "//a[text()='New User Register Here']"
Then user validates title to be "Adactin.com - New User Registration"
When user enters registration form
|mahesh1009|mahesh123|mahesh123|mahesh s|mahesh@gmail.com|india|
And user clicks checkbox using xpath "//input[@name='tnc_box']"
And user clicks button using xpath "//input[@name='Submit']"