package page.action;

import exception.StopTest;
import page.api.WebUIApi;

public class Click extends WebUIApi {

	public Click(String object_repository) {
		super(object_repository);
	}

	@Override
	public void execute() throws StopTest {
		try {
			getElement().click();
		} catch (final Exception e) {
			throw new StopTest(e);
		}

	}
}
