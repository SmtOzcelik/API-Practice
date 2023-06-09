package get_requests;

import Base_Url.GmiBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest08MapYontemi extends GmiBankBaseUrl {
    /*
    bu soru map yöntemi ile cozum
          http://www.gmibank.com/api/tp-customers/43703

          "firstName": "Alda",
          "lastName": "Monahan",
          "middleInitial": "Nichelle Hermann Kohler",
          "email": "com.github.javafaker.Name@7c011174@gmail.com",
          "mobilePhoneNumber": "909-162-8114",
          "city": "St Louis",
          "ssn": "108-53-6655"

          1) MATCHERS CLASS
          2) JSON PATH
          3) De-Serialization
    */
    @Test
    public void getRequest(){
        //Set the url
        spec.pathParams("1","tp-customers","2",43703);
        //Set the expected data
        Map<String,Object>expectedData=new HashMap<>();
        expectedData.put("firstName", "Alda");
        expectedData.put("lastName", "Monahan");
        expectedData.put("middleInitial", "Nichelle Hermann Kohler");
        expectedData.put("email", "com.github.javafaker.Name@7c011174@gmail.com");
        expectedData.put("mobilePhoneNumber", "909-162-8114");
        expectedData.put("city", "St Louis");
        expectedData.put("ssn", "108-53-6655");
        System.out.println("expectedData = " + expectedData);
        //Send the request and get the response
        Response response=given().spec(spec).headers("Authorization", "Bearer"+ generateToken()).when().get("/{1}/{2}");
        response.prettyPrint();
        //Do assertion
        Map<String,Object>actualData=response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.get("firstName"), actualData.get("firstName"));
        assertEquals(expectedData.get("lastName"), actualData.get("lastName"));
        assertEquals(expectedData.get("middleInitial"), actualData.get("middleInitial"));
        assertEquals(expectedData.get("email"), actualData.get("email"));
        assertEquals(expectedData.get("mobilePhoneNumber"), actualData.get("mobilePhoneNumber"));
        assertEquals(expectedData.get("city"), actualData.get("city"));
        assertEquals(expectedData.get("ssn"), actualData.get("ssn"));

    }
}
