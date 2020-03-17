package page.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Enum.Dom;
import exception.StopTest;
import page.api.WebUIApi;

public class CountCellsByColumnAndCondition extends WebUIApi {
	private final int iAtCol;
	private final String requestStatus;
	private final int iYear;
	private final int iAtCol2;


	public CountCellsByColumnAndCondition(String locator, int iAtCol, String requestStatus, int iAtCol2, int iYear) {
		super(locator, locator + Dom.TABLE_TR.toString());
		this.iAtCol = iAtCol;
		this.requestStatus = requestStatus;
		this.iAtCol2 = iAtCol2;
		this.iYear = iYear;
		
		
	}

	@Override
	public int countCells() throws StopTest {
		List<WebElement> domTRs = getChildElements();
		int count=0;
		for (WebElement domTR : domTRs) {
			List<WebElement> domTDs = domTR.findElements(By.xpath(Dom.TD.toString()));
			if ((domTDs.get(iAtCol).getText().compareToIgnoreCase(requestStatus)==0) && (getYear(domTDs.get(iAtCol2).getText()) == iYear)) count++;
		}
		return count;
	}

	@SuppressWarnings("deprecation")
	public int getYear(String sDate) {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		try {
			return dateFormat.parse(sDate).getYear() + 1900;
		} catch (ParseException e) {
			return 0;
		}
	}
	
}