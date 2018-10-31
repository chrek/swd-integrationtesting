package pageobject;

import java.net.URI;

import org.openqa.selenium.WebDriver;

public class IndexPage {
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

	public IndexPage(WebDriver driver, URI siteBase) {
		if (!isAtIndexPage(driver, siteBase)) {
			throw new IllegalStateException();
		}
		this.driver = driver;
		this.siteBase = siteBase;
	}
	
	public static boolean isAtIndexPage(WebDriver driver, URI siteBase) {
		return driver.getCurrentUrl().equals(siteBase.toString());
	}
}
