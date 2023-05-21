package get_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get_Practice03 {
     /*
      http://dummy.restapiexample.com/api/v1/employees  url'ine
      GET request'i yolladigimda gelen response'un
      status kodunun 200 ve content type'inin "application/json"
      ve employees sayisinin 24
      ve employee'lerden birinin "Ashton Cox"
      ve gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin.
 */

    @Test
    public void get03(){
        //1-Set the url
        String url="http://dummy.restapiexample.com/api/v1/employees";
        //2-Set the expected data
        //3-Send the Request and get the Response
        Response response=given().when().get(url);
        //4-Do Assertions
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
        response.then().assertThat().body("data",hasSize(24),
                "data.employee_name",hasItem("Ashton Cox"),"data.employee_age",hasItems(21,61,23));



    }
}
