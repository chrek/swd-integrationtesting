package inheritance;

import java.net.URI;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext-test.xml"})
public class AbstractIT {
	
	@Autowired
	private URI siteBase;
	
	@Autowired
	private WebDriver driver;

	public URI getSiteBase() {
		return siteBase;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	

}
