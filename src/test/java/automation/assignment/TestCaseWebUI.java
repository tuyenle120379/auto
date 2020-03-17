package automation.assignment;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Enum.ColumnsInWebTable;
import exception.StopTest;
import automation.assignment.FillSetUpInfo;
import automation.assignment.WebUITest;

public class TestCaseWebUI {
	@Before
	public void setUp() {
		FillSetUpInfo fillsetup = new FillSetUpInfo();
		fillsetup.fillRemoteSlaveNode("http://127.0.0.1:4444/wd/hub");
		fillsetup.fillBrowser("Chrome");
	}

	@Test
	public void testWebUI() throws StopTest, ParseException {
		WebUITest action = new WebUITest();
		action.open("http://ktvn-test.s3-website.us-east-1.amazonaws.com");
		action.type("id=formHorizontalEmail", "admin@test.com");
		action.type("id=formHorizontalPassword", "test123");
		action.click("linkText=LOG IN");
		assertEquals(5,
				action.countDateSubmitted(
						"xpath=//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div/div[1]/div[2]/table",
						ColumnsInWebTable.REQUEST_STATUS.getValue(), "Approved", ColumnsInWebTable.DATE_SUBMITTED.getValue(), 2019));
	}

	@After
	public void tearDown() throws StopTest {
		new WebUITest().close();
	}
}
