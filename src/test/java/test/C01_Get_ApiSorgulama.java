package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {


    /*
        https://restful-booker.herokuapp.com/booking/9856 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
*/

  @Test
    public void get01(){

      // 1- Gonderecigimiz Request icin gerekli olan URL ve ihtiyacımız varsa Request Body hazirla
      // 2- Eger soruda bize verilmise Expected Data hazirla
      // 3- Bize donen Response'i Actual Data olarak kaydet
      // 4- Expected Data ile Actual Datayi karsılastirmamiz yani Assertion yapmamiz gerek




      // 1- Gonderecigimiz Request icin gerekli olan URL ve ihtiyacımız varsa Request Body hazirla
       String url="https://restful-booker.herokuapp.com/booking/9856";

      // 2- Eger soruda bize verilmise Expected Data hazirla


      // 3- Bize donen Response'i Actual Data olarak kaydet
      Response response = given().when().get(url);

        System.out.println(response);

        response.prettyPrint();

      System.out.println("Status Code :"  + response.getStatusCode());
      System.out.println("Content Type :"  + response.getContentType());
      System.out.println("Server Header Dgeri :" + response.getHeader("Server"));
      System.out.println("Status Line :"     + response.getStatusLine());
      System.out.println("Response Suresi :" + response.getTime());
  }
}
