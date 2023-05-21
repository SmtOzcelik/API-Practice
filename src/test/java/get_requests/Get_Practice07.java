package get_requests;


import Base_Url.GmiBankBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication.generateToken;

public class Get_Practice07 extends GmiBankBaseUrl {
      /*
   http://www.gmibank.com/api/tp-customers/110472 adresindeki müşteri bilgilerini doğrulayın

   "firstName": "Melva",
   "lastName": "Bernhard",
   "email": "chas.kuhlman@yahoo.com"
   "zipCode": "40207"
   "country.name": "San Jose"
   "login": "delilah.metz"
    */
    @Test
    public void get07(){
        //Set the url
        spec.pathParams("1","tp-customers","2",110472);
        //Set the expected data

        //Send the request and the response
        Response response = given().spec(spec).headers("Authorization", "Bearer " + generateToken())
                .when()
                .get("/{1}/{2}");
        response.prettyPrint();
        // Matcher ile doğrula
        response.then().assertThat().body("firstName", equalTo("Melva")
                , "lastName", equalTo("Bernhard")
                , "email", equalTo("chas.kuhlman@yahoo.com")
                , "zipCode", equalTo("40207")
                , "country.name", equalTo("San Jose"), "user.login", equalTo("delilah.metz"));

        // Json Path ile doğrula
        JsonPath json = response.jsonPath();
        assertEquals("Melva", json.getString("firstName"));
        assertEquals("Bernhard", json.getString("lastName"));
        assertEquals("chas.kuhlman@yahoo.com", json.getString("email"));
        assertEquals("40207", json.getString("zipCode"));
        assertEquals("San Jose", json.getString("country.name"));
        assertEquals("delilah.metz", json.getString("user.login"));

    }

}
