import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.Authentication;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get_Practice05 extends Authentication {
    @Test
    public void get05(){
        String Url="http://www.gmibank.com/api/tp-customers/114351";
        Response response=given().headers("Authorization","Bearer "+generateToken()).when().get(Url);
        response.prettyPrint();
        // Do assertion
        // Matcher class ile dogrulama yöntemi
        response.then().assertThat().body("id",equalTo(114351));
        response.then().assertThat().body("country.name",equalTo("USA"));
        response.then().assertThat().body("accounts[0].balance",equalTo(69700));
        response.then().assertThat().body("accounts[1].balance",equalTo(11190));


        // JsonPath ile dogrulama yöntemi
        JsonPath json=response.jsonPath();
        assertEquals(114351,json.getInt("id"));
        assertEquals("Della",json.getString("firstName"));
        assertEquals("75164 McClure Stream",json.getString("address"));
        assertEquals("USA",json.getString("country.name"));
        assertEquals(69700,json.getInt("accounts[0].balance"));
        assertEquals("CHECKING",json.getString("accounts[1].accountType"));


    }
}
