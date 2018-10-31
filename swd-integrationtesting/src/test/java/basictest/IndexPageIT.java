package basictest;

import static org.junit.Assert.assertTrue;

import java.net.URI;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext-test.xml"})
public class IndexPageIT {
	
	@Autowired
	private URI siteBase;
	
	@Autowired
	private WebDriver driver;
	
	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");		
	}

	@Test
	public void testForGreeting() {
		driver.get(siteBase.toString());
		assertTrue(driver.getPageSource().contains("Hello World"));
	}
}
