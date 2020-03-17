package page.action;

import exception.StopTest;
import page.api.WebUIApi;

public class GetValue extends WebUIApi {
	public GetValue(String object_repository) {
		super(object_repository);
	}

	@Override
	public String get() throws StopTest {
		String result;
		try {
			result = getElement().getAttribute("value");
		} catch (final Exception e) {
			throw new StopTest(e);
		}
		return result;
	}
}
