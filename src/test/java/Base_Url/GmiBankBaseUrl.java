package Base_Url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GmiBankBaseUrl {

    protected RequestSpecification spec;
    @Before
    public void setup(){
        spec=new RequestSpecBuilder().setBaseUri("https://www.gmibank.com/api").build();

    }
}
