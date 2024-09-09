Feature: To validate login functionality

Scenario: To validate login using valid credentials

Given user starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user enters text "reyaz0806" in textbox using xpath "//input[@name='username']"
And user enters text "reyaz123" in textbox using xpath "//input[@name='password']"
And user clicks button using xpath "//input[@name='login']"
Then user validates title to be "Adactin.com - Search Hotel"


Scenario Outline: To validate login using Invalid credentials

Given user starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user enters text '<username>' in textbox using xpath "//input[@name='username']"
And user enters text '<password>' in textbox using xpath "//input[@name='password']"
And user clicks button using xpath "//input[@name='login']"
Then user validates error text to be '<errorText>'

Examples: 
| username | password | errorText | 
| reyaz0806 | reyaz456 | Invalid Login details or Your Password might have expired. |
| reyaz1212 | reyaz123 | Invalid Login details or Your Password might have expired. |
| reyaz1212 | reyaz456 | Invalid Login details or Your Password might have expired. |


