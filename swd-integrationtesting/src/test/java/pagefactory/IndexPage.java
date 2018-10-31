package pagefactory;

import java.net.URI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(css="a[href='create-order.jsp']")
	private WebElement createOrderLink;

	public IndexPage(WebDriver driver, URI siteBase) {
		if (!isAtIndexPage(driver, siteBase)) {
			throw new IllegalStateException();
		}
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.siteBase = siteBase;
	}
	
	public static boolean isAtIndexPage(WebDriver driver, URI siteBase) {
		return driver.getCurrentUrl().equals(siteBase.toString());
	}
	
	public CreateOrderPage createOrder() {
		createOrderLink.click();
		return new CreateOrderPage(driver, siteBase);
	}
}
