package test;

import io.restassured.internal.RequestSpecificationImpl;
import org.junit.Test;

public class C25_Put_PojoClass {
    private RequestSpecificationImpl specJsonPlace;


/*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
 body’e sahip bir PUT request yolladigimizda donen response’in
 response body’sinin asagida verilen ile ayni oldugunu test ediniz
     Request Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
    Expected Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */


    @Test
    public  void put01(){

       // 1- Url ve Body Hazirla

/*
        specJsonPlace.pathParams("pp1","post","pp2",70);
        JsonPlaceHolderReqBodyPojo reqBodyPojo = new  JsonPlaceHolderReqBodPojo("Ahmet", "Merhaba");

*/

    }



}
