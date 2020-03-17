package page.api;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;

import exception.StopTest;
import selenium.session.DriverPool;

//import Enum.Wait.StopCondition;

public abstract class WebUIApi {
	protected final WebDriver driver;
	protected final String locator;
	protected final String childLocator;

	public WebUIApi(String locator) {
		this.locator = locator;
		this.childLocator = "";
		this.driver = DriverPool.INSTANCE.getDriver();
	}

	public WebUIApi(String locator, String childLocator) {
		this.locator = locator;
		this.childLocator = childLocator;
		this.driver = DriverPool.INSTANCE.getDriver();
	}
	
	public WebUIApi() {
		this.locator = "";
		this.childLocator = "";
		this.driver = DriverPool.INSTANCE.getDriver();
	}

	public By createElementLocator(final String type, final String what) {
		switch (type) {
		case "className":
			return By.className(what);
		case "css":
			return By.cssSelector(what);
		case "id":
			return By.id(what);
		case "linkText":
			return By.linkText(what);
		case "name":
			return By.name(what);
		case "partialLinkText":
			return By.partialLinkText(what);
		case "tagName":
			return By.tagName(what);
		case "xpath":
			return By.xpath(what);
		case "IdOrName":
			return new ByIdOrName(what);
		default:
			throw new IllegalArgumentException("Unsupported locator type: " + type + " with value: " + what);
		}
	}
	
	protected WebElement getElement() throws StopTest {
		String type = locator.split("=", 2)[0];
		String what = locator.split("=", 2)[1];
		return driver.findElement(createElementLocator(type, what));
	}

	protected List<WebElement> getChildElements() throws StopTest {
		String type = childLocator.split("=", 2)[0];
		String what = childLocator.split("=", 2)[1];
		return getElement().findElements(createElementLocator(type, what));
	}

	public void execute() throws StopTest {
	}

	public String get() throws StopTest {
		// TODO Auto-generated method stub
		return null;
	}

	public int countCells() throws StopTest {
		// TODO Auto-generated method stub
		return 0;
	}
}