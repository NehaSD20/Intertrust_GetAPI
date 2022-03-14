import io.restassured.RestAssured;
		import io.restassured.path.json.JsonPath;

		import static io.restassured.RestAssured.*;

		import org.testng.Assert;
public class GetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	
		       
				 RestAssured.baseURI ="http://api.planetos.com";
				 
				 String Title1 ="Global Ocean Biogeochemical Analysis and Forecast";
				//Get
			String GetTitle = given().log().all().queryParam("apikey", "0a8c736520c14f34861757525161a9e0")
			.when().get("v1/datasets/copernicus_goba_global_weekly")
			.then().assertThat().log().all().statusCode(200).extract().response().asString();
			
			JsonPath js1 = new JsonPath(GetTitle);
			String ActualTitle = js1.getString("Title");
			System.out.println(ActualTitle);
			
			//Testng
			Assert.assertEquals(ActualTitle,Title1);
			
	}

}
