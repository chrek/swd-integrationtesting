package basictest;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.TestCase;

public class BasicTestWithSWDIT extends TestCase {
	
	private URI siteBase;
	private WebDriver driver;
	
	String driverPath = "drivers/geckodriver.exe";

	@Override
	protected void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", driverPath);			
		
		super.setUp();
		
		siteBase = new URI("http://localhost:8080/swd-integrationtesting");
		System.out.println(siteBase.toString());
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		driver.close();
	}

	@Test
	public void testForGreeting() {
		driver.get(siteBase.toString());
		assertTrue(driver.getPageSource().contains("Hello World"));
	}
}
