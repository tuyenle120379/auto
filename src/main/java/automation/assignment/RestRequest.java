package automation.assignment;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;

import com.cedarsoftware.util.io.JsonWriter;

public class RestRequest  {
	public String get(String url) throws Exception {
		return JsonWriter.formatJson(new BasicResponseHandler()
				.handleResponse(HttpClientBuilder.create().build().execute(new HttpGet(url))));
	}
}
