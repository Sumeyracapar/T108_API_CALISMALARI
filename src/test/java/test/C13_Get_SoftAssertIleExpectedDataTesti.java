package test;

import org.json.JSONObject;

public class C13_Get_SoftAssertIleExpectedDataTesti {
/*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Response Body
        {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }
     */

    // 1- Url 'i hazirla

    String url="http://dummy.restapiexample.com/api/v1/employee/3";

    // 2-

    JSONObject expBody= new JSONObject();


    

}
