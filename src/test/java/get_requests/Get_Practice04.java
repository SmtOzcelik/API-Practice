package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get_Practice04 {
    @Test
    public void get04(){

        String Url="http://www.gmibank.com/api/tp-customers";
        String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXRjaDgxIiwiYXV0aCI6IlJPTEVfQURNSU4iLCJleHAiOjE2ODcwMDUwMjd9.5nA_MlQHutUJLRXiYCy6JZs0oMczZ9eUPZlsXFDgym6fwTWqXV54NmqQisDI1ugIfSr6x0Ef5oR95Xk41QSO0w";

        Response response=given().headers("Authorization","Bearer "+token).when().get(Url);
        response.prettyPrint();
    }
}
