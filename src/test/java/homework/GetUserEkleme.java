package homework;

import Base_Url.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojo.PetStorePojo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;

public class GetUserEkleme extends PetStoreBaseUrl {
    //pojo-Matcher body ve JsonPath ile cözüm

    /*
    1-https://petstore.swagger.io/v2/user
    2-verilen body post yap
    3-status code 200
    {
  "id": 5,
  "username": "ahmet1453",
  "firstName": "smt",
  "lastName": "oz",
  "email": "smt@gmail.com",
  "password": "123",
  "phone": "123",
  "userStatus": 2
}
4-Response data böyle olmali
{
    "code": 200,
    "type": "unknown",
    "message": "5"
}
     */
    @Test
    public void getuser(){
        //Set url
        spec.pathParam("1","user");
        //Set the expected data
        PetStorePojo expectedData=new PetStorePojo(5,"ahmet1453","smt","oz","smt@gmail.com","123","123",2);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{1}");
        response.prettyPrint();
        //Do Assertions
        assertEquals(200,response.statusCode());
        response.then().assertThat().body("code",equalTo(200)); //body ile assertion
        assertEquals(response.jsonPath().getInt("code"),200); //jsonPath ile assertion

        response.then().assertThat().body("type",equalTo("unknown"));
        assertEquals(response.jsonPath().getString("type"),"unknown");

        response.then().assertThat().body("message",equalTo("5"));
        assertEquals(response.jsonPath().getString("message"),"5");


    }
}
