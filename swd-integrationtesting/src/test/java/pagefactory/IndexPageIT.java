package pagefactory;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

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
	public void testCreateOrder() {		
		
		getDriver().get(getSiteBase().toString());
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		IndexPage indpg = new IndexPage(getDriver(), getSiteBase());		
		indpg.createOrder();
		
		assertTrue(CreateOrderPage.isAtCreateOrderPage(getDriver(), getSiteBase()));
	}
}
