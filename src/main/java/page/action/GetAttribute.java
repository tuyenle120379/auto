package page.action;

import exception.StopTest;
import page.api.WebUIApi;

public class GetAttribute extends WebUIApi {
	private final String attrName;

	public GetAttribute(String object_repository, String attrName) {
		super(object_repository);
		this.attrName = attrName;
	}

	@Override
	public String get() throws StopTest {
		String result = "";
		try {
			result = getElement().getAttribute(attrName);
		} catch (final Exception e) { // or your specific exception
			throw new StopTest(e);
		}
		return result;
	}

}