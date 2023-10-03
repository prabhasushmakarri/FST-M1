package LiveProject;


import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PactConsumerTestExt.class)
public class ProjectConsumerTest {
//Headers MAP
    Map<String,String> headers=new HashMap<>();
    //create contract
    @Pact(consumer = "UserConsumer",provider = "UserProvider")
    public RequestResponsePact createpact(PactDslWithProvider builder){
     //set the headers
        headers.put("Content-Type","application/json");
     //set the requets and response
        DslPart requestresponsebody=new PactDslJsonBody().
                numberType("id",1234).
                stringType("firstName","sushma").
                stringType("lastName","karri").
                stringType("email","test@gmail.com");
     //set the contract
        return builder.given("POST Request").uponReceiving("a request to create a user").
                method("POST").
                path("/api/users").
                headers(headers).
                body(requestresponsebody).
                willRespondWith().
                status(201).
                body(requestresponsebody).
                toPact();
    }
    @Test
    @PactTestFor(providerName = "UserProvider",port="8989")
    public void consumerTest(){
        //Request Body
        Map<String,Object> reqbody=new HashMap<>();
        reqbody.put("id",27654);
        reqbody.put("firstName","sushma");
        reqbody.put("lastName","karri");
        reqbody.put("email","test@gmail.com");
        //send post request
        given().baseUri("http://localhost:8989/api/users").headers(headers).body(reqbody).log().all().
                when().post().then().statusCode(201).body("email",equalTo("test@gmail.com")).log().all();
    }
}
