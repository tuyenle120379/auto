package automation.assignment;

import exception.StopTest;
import page.action.PageAction;

public class WebUITest {

	public boolean open(final String sUrl) throws StopTest {
		final PageAction pageAction = new PageAction(sUrl);
		pageAction.open();
		return true;

	}

	public boolean type(final String locator, final String sValue) throws StopTest {
		new PageAction(locator, sValue).type();
		return true;
	}

	public boolean click(final String element) throws StopTest {
		new PageAction(element).click();
		return true;
	}

	public boolean close() throws StopTest {
		new PageAction().close();
		return true;

	}

	public String storeAttribute(final String element, final String attribute) throws StopTest {
		return new PageAction(element, attribute).getAttribute();

	}

	public String storeValue(final String element) throws StopTest {
		return new PageAction(element).getValue();

	}

	public String storeText(final String element) throws StopTest {
		return new PageAction(element).getText();

	}

	public int countDateSubmitted(String xpath, int iAtCol, int year) throws StopTest {
		// TODO Auto-generated method stub
		return new PageAction(xpath, iAtCol, year).countCellsByColumnAndCondition();
	}

}