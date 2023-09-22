package labOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Leen {
  WebDriver driver ;
  SoftAssert softAssert;


  @BeforeTest
  public void myBeforeTest() {
	  // Initialize the WebDriver
	  WebDriver driver= new ChromeDriver();

 
      // Navigate to the Almosafer website
      String Url = "https://www.almosafer.com/ar";
      driver.get(Url);

      // Initialize SoftAssert
      softAssert = new SoftAssert();
    
  }
  @Test
  public void f() {
	// Find and click the button element
	  WebElement buttonElement = driver.findElement(By.className("cta__saudi"));

	      buttonElement.click();
	 

	  // Assertion 1: Check the language
	  WebElement languageElement = driver.findElement(By.xpath("//a[normalize-space()='English']"));
	  String languageText = languageElement.getText();
	  softAssert.assertEquals(languageText, "English", "Language is not as expected");

	  // Assertion 2: Check the currency
	  WebElement currencyElement = driver.findElement(By.xpath("//button[normalize-space()='SAR']"));
	  String currencyText = currencyElement.getText();
	  softAssert.assertEquals(currencyText, "SAR", "Currency is not as expected");

	  // Assertion 3: Check the hotel tab is selected
	  WebElement hotelTabElement = driver.findElement(By.xpath("//a[@id='hotelsTab' and @class='active']"));
	  boolean isHotelTabSelected = hotelTabElement.getAttribute("class").contains("active");
	  softAssert.assertTrue(isHotelTabSelected, "Hotel tab is not as expected");

	  // Perform all assertions
	  softAssert.assertAll();

  }

  @AfterTest
  public void myAfterTest() {
      // Perform all assertions
      softAssert.assertAll();

      // Close the WebDriver
      driver.quit();
  }
}
