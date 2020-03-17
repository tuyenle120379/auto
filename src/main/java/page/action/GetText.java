package page.action;

import exception.StopTest;
import page.api.WebUIApi;

import org.openqa.selenium.WebElement;

public class GetText extends WebUIApi {
	public GetText(String object_repository) {
		super(object_repository);
	}

	@Override
	public String get() throws StopTest  {
		String result;
		try {
			final WebElement element = getElement();
			result = element.getText();
		} catch (final Exception e) {
			throw new StopTest(e);
		}
		return result;
	}
}
