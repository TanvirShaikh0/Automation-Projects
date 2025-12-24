import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BasicFlow {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://demo.opencart.com/");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}

}
