package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {


/*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
                        Response Body - Expected Body
                   {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
         */


    @Test
    public void post01() {

        // 1 - Url ve Resquest hazirla

        String url = " https://restful-booker.herokuapp.com/booking";


/*
        Request body
        {
            "firstname" : "Ahmet",
                "lastname" : “Bulut",
            "totalprice" : 500,
                "depositpaid" : false,
                "bookingdates" : {
            "checkin" : "2021-06-01",
                    "checkout" : "2021-06-10"
        },
            "additionalneeds" : "wi-fi"


    }
*/
        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkout", "2021-06-10");

        JSONObject reqBody = new JSONObject();

        reqBody.put("firstname", "Ahmet");
        reqBody.put("lastname", "Bulut");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid", false);
        reqBody.put("bookingdates", bookingdates);
        reqBody.put("additionalneeds", "wi-fi");

         // 2- Expected Data HAzirla

        /*
             Response Body - Expected Body
                   {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
         */



       JSONObject expBody=new JSONObject();

       expBody.put( "bookingid",24);
       expBody.put(  "booking",reqBody);

        System.out.println("expBody = " + expBody);


       // 3 - Response Kaydet
        Response response = given()
                         .contentType(ContentType.JSON).
                          when().
                           body(reqBody.toString()).
                           post(url);

        response.prettyPrint();

      // 4 - Assertion

        JsonPath resJS=response.jsonPath();
        assertEquals(expBody.getJSONObject("booking").get("firstname"), resJS.get("booking.firstname"));
        assertEquals(expBody.getJSONObject("booking").get("lastname"), resJS.get("booking.lastname"));
        assertEquals(expBody.getJSONObject("booking").get("totalprice"), resJS.get("booking.totalprice"));
        assertEquals(expBody.getJSONObject("booking").get("depositpaid"), resJS.get("booking.depositpaid"));
        assertEquals(expBody.getJSONObject("booking").get("additionalneeds"), resJS.get("booking.additionalneeds"));







    }
    }


