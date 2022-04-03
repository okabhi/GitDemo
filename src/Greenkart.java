import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Greenkart {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chrome drive\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};
		Thread.sleep(3000L);
		addItems(driver,itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		Thread.sleep(5000L);
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		//explicit wait
		WebDriverWait w=new WebDriverWait(driver,5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		//driver.findElement(By.xpath("//button[contains(text(),'Place Order']")).click();
	    System.out.println("ok this is new editied file for git hub");
		
		
	}
	
	public static void addItems(WebDriver driver,String[] itemsNeeded) {

	List<WebElement> products= driver.findElements(By.cssSelector("h4.product-name"));
	
	
	for(int i=0;i<products.size();i++) {
	String[] name=products.get(i).getText().split("-");
	String formattedName =name[0].trim();//trim method is used to remove blank spaces
	//format it to get actual vegetable name
	//convert array into array list for easy search
	//check whether name you extracted is present in arrayList or not
	@SuppressWarnings("rawtypes")
	List itemsNeededList= Arrays.asList(itemsNeeded);
	int j=0;
	if(itemsNeededList.contains(formattedName)) {
		j++;
		driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
		if(j==itemsNeeded.length) {
		break;
		
	}
	}
	
}
}}
	