package LiveProject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class ProjectGitHub {
    String sshkey="ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIETroBRBJ+kHIb51wQYJQPpCC2fc9TYwXNyn8aT/k2O/";
    int id;
    RequestSpecification requestspec;
    ResponseSpecification responsespec;
    @BeforeClass
    public void setup(){
        //Request specification
        requestspec =new RequestSpecBuilder().
                setBaseUri("https://api.github.com").
                addHeader("Content-Type","application/json").
                addHeader("Authorization","token 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").build();
        //Response specification
        responsespec =new ResponseSpecBuilder().
                expectResponseTime(lessThanOrEqualTo(5000L)).
                build();
    }
    @Test(priority = 0)
    public void post(){
        Map<String,Object> reqbody=new HashMap<>();
        reqbody.put("title","sushmagit");
        reqbody.put("key",sshkey);

        Response response= given().spec(requestspec).body(reqbody).log().all().when().post("/user/keys");
        //Extract response
        id=response.then().extract().path("id");
        int statuscode=  response.statusCode();

        Assert.assertEquals(statuscode,201);

    }
    @Test(priority = 1)
    public void get(){
        Response response=given().spec(requestspec).pathParam("keyId",id).when().get("/user/keys/{keyId}");
        System.out.println(response.getBody().asPrettyString());
        int statuscode=response.statusCode();
        Assert.assertEquals(statuscode,200);
    }
    @Test(priority = 2)
    public void delete(){
        Response response=given().spec(requestspec).pathParam("keyId",id).when().delete("/user/keys/{keyId}");
        System.out.println(response.getBody().asPrettyString());
        int statuscode=response.statusCode();
        Assert.assertEquals(statuscode,204);

    }
}
