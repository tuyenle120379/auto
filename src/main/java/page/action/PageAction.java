package page.action;

import exception.StopTest;
import page.api.WebUIApi;

public class PageAction {
	private WebUIApi type;
	private WebUIApi open;
	private WebUIApi close;
	private WebUIApi click;
	private WebUIApi selectByValue;
	private WebUIApi selectByText;
	private WebUIApi chooseByText;
	private WebUIApi getAttribute;
	private WebUIApi countCellsByColumnAndCondition;
	private WebUIApi getValue;
	private WebUIApi getText;

	public PageAction() {
		close = new Close();
	}

	public PageAction(String locator) {
		open = new Open(locator);
		click = new Click(locator);
		getValue = new GetValue(locator);
		getText = new GetText(locator);
	}

	public PageAction(String locator, String value) {
		type = new Type(locator, value);
		getAttribute = new GetAttribute(locator, value);
	}

	public PageAction(String locator, int iAtCol, String requestStatus, int iAtCol2, int iYear) {
		countCellsByColumnAndCondition = new CountCellsByColumnAndCondition( locator,  iAtCol,  requestStatus,  iAtCol2, iYear);
	}

	

	public void click() throws StopTest {
		click.execute();
	}

	public void close() throws StopTest {
		close.execute();
	}

	public void type() throws StopTest {
		type.execute();
	}

	public void open() throws StopTest {
		open.execute();
	}

	public void selectByText() throws StopTest {
		// TODO Auto-generated method stub
		selectByText.execute();
	}

	public void chooseByText() throws StopTest {
		// TODO Auto-generated method stub
		chooseByText.execute();
	}

	public void selectByValue() throws StopTest {
		selectByValue.execute();
	}

	public String getAttribute() throws StopTest {
		return getAttribute.get();
	}

	public String getValue() throws StopTest {
		// TODO Auto-generated method stub
		return getValue.get();
	}

	public String getText() throws StopTest {
		// TODO Auto-generated method stub
		return getText.get();
	}

	public int countCellsByColumnAndCondition() throws StopTest {
		// TODO Auto-generated method stub
		return countCellsByColumnAndCondition.countCells();
	}

}
