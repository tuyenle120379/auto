package page.action;

import exception.StopTest;
import page.api.WebUIApi;


public class Type extends WebUIApi {
	private final String enterValue;

	public Type(String object_repository, String enterValue) {
		super(object_repository);
		this.enterValue = enterValue;
	}


	@Override
	public void execute() throws StopTest {
	
		try {
			getElement().sendKeys(enterValue);	
		} catch (final Exception e) {
				throw new StopTest(e);
		}
	}
}