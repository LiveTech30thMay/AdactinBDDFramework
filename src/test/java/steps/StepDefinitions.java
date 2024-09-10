package steps;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefinitions {
	
WebDriver driver;

@Before(order=0)
public void setUp()
{
	System.out.println("In before hook ..");
}
@Before(order=1)
public void setUp2()
{
	System.out.println("In before hook2 ..");
}

@After(order=1)
public void teardown2()
{
	System.out.println("In after hook2 ..");
}
@After(order=2)
public void teardown3()
{
	System.out.println("In after hook3 ..");
}
@After(order=0)
public void teardown()
{
	System.out.println("In after hook ..");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.quit();
}

@Given("user starts {string} browser")
public void user_starts_browser(String browserName) {
	
	if(browserName.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else if(browserName.equalsIgnoreCase("edge"))
	{
		driver=new EdgeDriver();
	}
    
}

@Given("user launch app using url {string}")
public void user_launch_app_using_url(String url) {
    
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
}

@When("user enters text {string} in textbox using xpath {string}")
public void user_enters_text_in_textbox_using_xpath(String text, String xpath) {
    
	driver.findElement(By.xpath(xpath)).sendKeys(text);
}

@When("user clicks button using xpath {string}")
public void user_clicks_button_using_xpath(String xpath) {
   
	driver.findElement(By.xpath(xpath)).click();
}

@Then("user validates title to be {string}")
public void user_validates_title_to_be(String expTitle) {
	
	Assert.assertEquals(expTitle, driver.getTitle());
    
}

@Then("user validates error text to be {string}")
public void user_validates_error_text_to_be(String expErrorText) {
  
	String actErrorText=driver.findElement(By.xpath("//div[@class='auth_error']/b")).getText();
	
	Assert.assertTrue(actErrorText.contains(expErrorText));
	
}

@When("user clicks link using xpath {string}")
public void user_clicks_link_using_xpath(String xpath) {
    
	driver.findElement(By.xpath(xpath)).click();
}

@When("user clicks checkbox using xpath {string}")
public void user_clicks_checkbox_using_xpath(String xpath) {
    
	driver.findElement(By.xpath(xpath)).click();
}

@When("user enters registration form")
public void user_enters_registration_form(DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
    
	List<List<String>> allRows=dataTable.asLists();
	
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(allRows.get(0).get(0));
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(allRows.get(0).get(1));
	driver.findElement(By.xpath("//input[@name='re_password']")).sendKeys(allRows.get(0).get(2));
	driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(allRows.get(0).get(3));
	driver.findElement(By.xpath("//input[@name='email_add']")).sendKeys(allRows.get(0).get(4));
	driver.findElement(By.xpath("//input[@name='captcha']")).sendKeys(allRows.get(0).get(5));
	
}


@When("user enters registration form2")
public void user_enters_registration_form2(DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
   
	List<Map<String, String>> listOfDataMap=dataTable.asMaps();
	
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(listOfDataMap.get(0).get("username"));
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(listOfDataMap.get(0).get("password"));
	driver.findElement(By.xpath("//input[@name='re_password']")).sendKeys(listOfDataMap.get(0).get("confirm password"));
	driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(listOfDataMap.get(0).get("full name"));
	driver.findElement(By.xpath("//input[@name='email_add']")).sendKeys(listOfDataMap.get(0).get("email id"));
	driver.findElement(By.xpath("//input[@name='captcha']")).sendKeys(listOfDataMap.get(0).get("captcha"));
	
}

	
}
