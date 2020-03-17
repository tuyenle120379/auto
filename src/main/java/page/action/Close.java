package page.action;

import page.api.WebUIApi;


public class Close extends WebUIApi {

	public Close() {
		super();
	}

	@Override
	public void execute() {
		driver.close();
	}

}