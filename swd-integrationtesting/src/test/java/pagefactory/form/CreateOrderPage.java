package pagefactory.form;

import java.net.URI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(css = "form[name='create-order'] input[name='item']")
	private WebElement iteminput;
	
	@FindBy(css = "form[name='create-order'] input[name='amount']")
	private WebElement amountinput;
	
	@FindBy(css = "form[name='create-order'] input[name='submit']")
	private WebElement submit;

	public CreateOrderPage(WebDriver driver, URI siteBase) {
		if (!isAtCreateOrderPage(driver, siteBase)) {
			throw new IllegalStateException();
		}
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.siteBase = siteBase;
	}
	
	public CreateOrderPage submit(String item, String amount) {
		iteminput.sendKeys(item);
		amountinput.sendKeys(amount);
		submit.click();
		return new CreateOrderPage(driver, siteBase);
	}
	
	public static boolean isAtCreateOrderPage(WebDriver driver, URI siteBase) {
		return driver.getCurrentUrl().equals(siteBase.toString() + "create-order.jsp");
	}
}
