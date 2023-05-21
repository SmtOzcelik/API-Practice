package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get_Practice02 {
   @Test
    public void get02(){
       String url = "https://reqres.in/api/users";
       Response response = given().when().get(url);
       // given().when().get(url) -> request
       // Response response -> response

       // Body Test
        /* id'si 1 olanın datalarınının aşağıdaki gibi olduğunu test ediniz
             "email": "george.bluth@reqres.in",
            "first_name": "George",
            "last_name": "Bluth",
         */

       // Matcher class ile test
       response.then().body("data[0].email",equalTo("george.bluth@reqres.in"));
       response.then().body("data[0].first_name",equalTo("George"));
       response.then().body("data[0].last_name",equalTo("Bluth"));
   }
}
