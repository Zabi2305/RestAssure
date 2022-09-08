package genericUtilities;

import io.restassured.response.Response;

/**
 * This class contains rest assured specific reusable methods
 * @author Zabiulla
 *
 */
public class RestAssuresLibrary {
	/**
	 * This method will get the json Data through jsonPath from response body
	 * @param response
	 * @param path
	 * @return
	 */
	public String getJsonData(Response response,String path ) {

		String jsonData = response.jsonPath().get(path);
		return jsonData; 
	}
}



