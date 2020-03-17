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
	private final int iYear;
	private final int iAtCol;

	public CountCellsByColumnAndCondition(String locator, int iAtCol, int iYear) {
		super(locator, locator + Dom.TABLE_TR.toString());
		this.iYear = iYear;
		this.iAtCol = iAtCol;
	}

	@Override
	public int countCells() throws StopTest {
		List<WebElement> domTRs = getChildElements();
		List<String> cells = new ArrayList<String>();
		int colNumber;
		for (WebElement domTR : domTRs) {
			List<WebElement> domTDs = domTR.findElements(By.xpath(Dom.TD.toString()));
			colNumber = 1;
			for (WebElement domTD : domTDs) {
				String cellText = domTD.getText();
				if ((colNumber == iAtCol) && (getYear(cellText) == iYear))
					cells.add(cellText);
					colNumber++;
			}
		}
		return cells.size();
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