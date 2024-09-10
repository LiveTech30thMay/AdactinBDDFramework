Feature: to validate Registration functionality

@wip1009
Scenario: to validate Registration using valid data 
Given user starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user clicks link using xpath "//a[text()='New User Register Here']"
Then user validates title to be "Adactin.com - New User Registration"
When user enters text "mahesh1009" in textbox using xpath "//input[@name='username']"
And user enters text "mahesh123" in textbox using xpath "//input[@name='password']"
And user enters text "mahesh123" in textbox using xpath "//input[@name='re_password']"
And user enters text "mahesh s" in textbox using xpath "//input[@name='full_name']"
And user enters text "mahesh@gmail.com" in textbox using xpath "//input[@name='email_add']"
And user enters text "india" in textbox using xpath "//input[@name='captcha']"
And user clicks checkbox using xpath "//input[@name='tnc_box']"
And user clicks button using xpath "//input[@name='Submit']"