package client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.EmployeeRequestModelPOSTPUT;
import util.Configuration;

public class EmployeeClient {

    public Response getAllEmployees(){
        return RestAssured
                .given()
                .when().log().all()
                .get(Configuration.EMPLOYEE_GET_ALL)
                .thenReturn();
    }

    public Response getEmployee(String id){
        return RestAssured
                .given()
                .when().log().all()
                .get(Configuration.EMPLOYEE_GET_BY_ID + "/" + id)
                .thenReturn();
    }

    public Response updateEmployee(EmployeeRequestModelPOSTPUT request, String id){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .put(Configuration.EMPLOYEE_UPDATE + "/" + id)
                .thenReturn();
    }

    public Response postEmployee(EmployeeRequestModelPOSTPUT request){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .post(Configuration.EMPLOYEE_POST)
                .thenReturn();
    }

    public Response deleteEmployee(String id){
        return RestAssured.given()
                .when().log().all()
                .delete(Configuration.EMPLOYEE_DELETE + "/" + id)
                .thenReturn();
    }
}
