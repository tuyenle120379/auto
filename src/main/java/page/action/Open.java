package page.action;

import java.net.URI;
import java.net.URISyntaxException;

import exception.StopTest;
import page.api.WebUIApi;

public class Open extends WebUIApi {
	private String url;

	public Open(String url) {
		super();
		this.url = url;
	}

	@Override
	public void execute() {
		if (!url.contains("://")) {
			String baseURL = driver.getCurrentUrl();
			if (!baseURL.isEmpty() && baseURL.charAt(baseURL.length() - 1) != '/') {
				baseURL += "/";
			}
			try {
				url = new URI(baseURL).resolve(url).toASCIIString();
			} catch (final URISyntaxException e) {
				try {
					throw new StopTest(" Invalid URL: baseURL=[" + baseURL + "] / parameter=[" + url + "]", e);
				} catch (final Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		driver.navigate().to(url);
	}

}