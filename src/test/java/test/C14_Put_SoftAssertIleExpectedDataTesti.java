package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssertIleExpectedDataTesti {


 /*
    https://dummy.restapiexample.com/api/v1/update/21 url’ine
     asagidaki   body’ye sahip bir PUT request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

            Request Body
            {
                "status":"success",
                "data":{
                        "name":“Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
            }

            Response Body

            {
            "status":"success",
            "data":{
                "status":"success",
                "data":{
                        "name":“Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
                   },
            "message":"Successfully! Record has been updated."
            }
                 */

/*
    git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/Sumeyracapar/T108_API_CALISMALARI.git
git push -u origin main
    */

    @Test
    public void put() {


    // 1-  url ve body hazırla

    String url = " https://dummy.restapiexample.com/api/v1/update/21";

       /* Request Body
        {
            "status":"success",
             "data":
             {
            "name":“Ahmet",
            "salary":"1230",
                    "age":"44",
                    "id":40
        }
*/


        JSONObject data = new JSONObject();

         data.put("name","Ahmet");
         data.put("salary","1230");
         data.put( "age","44");
         data.put( "id",40);

       JSONObject reqBody=new JSONObject();

         reqBody.put( "status","success");
         reqBody.put("data",data);

     // 2- expected data hazırla
/*
        Response Body

        {
            "status":"success",
              "data":{
            "status":"success",
                    "data":{
                "name":“Ahmet",
                "salary":"1230",
                        "age":"44",
                        "id":40
            }
        },
            "message":"Successfully! Record has been updated."
        }
    */

        JSONObject expBody=new JSONObject();

        expBody.put( "status","success");
        expBody.put("data",reqBody);
        expBody.put( "message","Successfully! Record has been updated.");



        // 3- response'i kaydet

        Response response = given().contentType(ContentType.JSON)
                           .when().body(reqBody.toString()).put(url);

        response.prettyPrint();

         // 4- assertion

        JsonPath responseJP=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(expBody.get("status"),responseJP.get("status"));
        softAssert.assertEquals(expBody.getJSONObject("data").getJSONObject("data").get("name"),
                   responseJP.get("data.data.name"));
        softAssert.assertEquals(expBody.getJSONObject("data").getJSONObject("data").get("id"),
                    responseJP.get("data.data.id"));
        softAssert.assertEquals(expBody.getJSONObject("data").getJSONObject("data").get("salary"),
                responseJP.get("data.data.salary"));
        softAssert.assertEquals(expBody.getJSONObject("data").getJSONObject("data").get("age"),
                responseJP.get("data.data.age"));

        softAssert.assertEquals(expBody.getJSONObject("data").get("status"),
                responseJP.get("data.status"));

        softAssert.assertEquals(expBody.get("message"),responseJP.get("message"));


    }

}
