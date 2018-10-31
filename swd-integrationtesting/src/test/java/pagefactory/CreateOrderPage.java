package pagefactory;

import java.net.URI;

import org.openqa.selenium.WebDriver;

public class CreateOrderPage {
	/**
	 * @param driver
	 * 			A web driver
	 * @param siteBase
	 * 			The root URI of the expected site
	 * @return Whether or not the driver is at the index page of
	 * site
	*/
	
	private final WebDriver driver;
	private final URI siteBase;
	
	public WebDriver getDriver() {
		return driver;
	}

	public URI getSiteBase() {
		return siteBase;
	}

	public CreateOrderPage(WebDriver driver, URI siteBase) {
		if (!isAtCreateOrderPage(driver, siteBase)) {
			throw new IllegalStateException();
		}
		this.driver = driver;
		this.siteBase = siteBase;
	}
	
	public static boolean isAtCreateOrderPage(WebDriver driver, URI siteBase) {
		return driver.getCurrentUrl().equals(siteBase.toString() + "create-order.jsp");
	}
}
