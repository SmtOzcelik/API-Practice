import io.restassured.response.Response;
import org.junit.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class Get_Practice05 {
    @Test
    public void get05(){
        String Url="http://www.gmibank.com/api/tp-customers/114351";
        Response response=given().when().get(Url);


    }
}
