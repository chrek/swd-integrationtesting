package inheritance;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext-test.xml"})
public class IndexPageIT extends AbstractIT {
	
	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");		
	}

	@Test
	public void testForGreeting() {
		//driver.get(siteBase.toString());
		getDriver().get(getSiteBase().toString());
		assertTrue(getDriver().getPageSource().contains("Hello World"));
	}
}
