package automation.assignment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import Enum.ApiResource;
import automation.assignment.RestRequest;

public class TestCaseApi {

	@Test
	public void testApi() throws Exception {
		String json = new RestRequest().get("https://my-json-server.typicode.com/typicode/demo/posts/1");
		JsonElement element = new JsonParser().parse(json);
		assertEquals(1, element.getAsJsonObject().get(ApiResource.ID.toString()).getAsInt());
		assertEquals("Post 1", element.getAsJsonObject().get(ApiResource.TITLE.toString()).getAsString());
	}

}
