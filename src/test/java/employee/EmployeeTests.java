package employee;

import client.EmployeeClient;
import data.EmployeeDataFactory;
import io.restassured.response.Response;
import models.request.EmployeeRequestModelPOSTPUT;
import models.response.EmployeeResponseModelDELETE;
import models.response.EmployeeResponseModelGETAll;
import models.response.EmployeeResponseModelGETById;
import models.response.EmployeeResponseModelPOSTPUT;
import org.junit.Test;

import static mother.EmployeeMother.createBodyForEmployeesPost;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class EmployeeTests {

    @Test
    public void getAllEmployeesTest(){

        Response getResponse = new EmployeeClient()
                .getAllEmployees();

        EmployeeResponseModelGETAll employeesResponse = getResponse.body().as(EmployeeResponseModelGETAll.class);

        employeesResponse.getData().get(0).getEmployee_name();

        assertEquals(200, getResponse.statusCode());
        assertEquals("success", employeesResponse.getStatus());
        assertFalse(employeesResponse.getData().isEmpty());
        assertEquals("Successfully! All records has been fetched.",employeesResponse.getMessage());
    }

    @Test
    public void updateEmployeeTest(){
        EmployeeRequestModelPOSTPUT requestBody = new EmployeeDataFactory(createBodyForEmployeesPost())
                .setAge("30")
                .setName("Petko")
                .setSalary("10 000")
                .createRequest();

        Response postResponse = new EmployeeClient()
                . putEmployee(requestBody,"5");

        EmployeeResponseModelPOSTPUT employeesResponse = postResponse.body().as(EmployeeResponseModelPOSTPUT.class);

        assertEquals(200, postResponse.statusCode());
        assertEquals("success",employeesResponse.getStatus());
        assertEquals("Petko",employeesResponse.getData().getName());
        assertEquals("30",employeesResponse.getData().getAge());
        assertEquals("10 000",employeesResponse.getData().getSalary());
        assertEquals("Successfully! Record has been updated.",employeesResponse.getMessage());
    }

    @Test
    public void getEmployeeByIdTest(){

        Response getResponse = new EmployeeClient()
                .getEmployee("5");

        EmployeeResponseModelGETById employeesResponse = getResponse.body().as(EmployeeResponseModelGETById.class);

        assertEquals(200, getResponse.statusCode());
        assertEquals("success",employeesResponse.getStatus());
        assertEquals("Airi Satou",employeesResponse.getData().getEmployee_name());
        assertEquals(162700,employeesResponse.getData().getEmployee_salary());
        assertEquals(33,employeesResponse.getData().getEmployee_age());
        assertEquals("Successfully! Record has been fetched.",employeesResponse.getMessage());

    }

    @Test
    public void deleteEmployee(){
        String id = "10";

        Response deleteResponse = new EmployeeClient()
                .deleteEmployee(id);

        EmployeeResponseModelDELETE employeeResponse = deleteResponse.body().as(EmployeeResponseModelDELETE.class);

        assertEquals(200,deleteResponse.statusCode());
        assertEquals("success",employeeResponse.getStatus());
        assertEquals(id,employeeResponse.getData());
        assertEquals("Successfully! Record has been deleted",employeeResponse.getMessage());
    }

    @Test
    public void employeeRequestDefaultValuesTest() {
        EmployeeRequestModelPOSTPUT requestBody = new EmployeeDataFactory(createBodyForEmployeesPost())
                .createRequest();

        Response postResponse = new EmployeeClient()
                .postEmployee(requestBody);

        EmployeeResponseModelPOSTPUT employeesResponse = postResponse.body().as(EmployeeResponseModelPOSTPUT.class);

        assertEquals(200, postResponse.statusCode());
        assertEquals("success", employeesResponse.getStatus());
        assertEquals("Default name", employeesResponse.getData().getName());
        assertEquals("Default age", employeesResponse.getData().getAge());
        assertEquals("Default salary", employeesResponse.getData().getSalary());
        assertEquals("Successfully! Record has been added.", employeesResponse.getMessage());
    }

    @Test
    public void employeeRequestTest(){
        EmployeeRequestModelPOSTPUT requestBody = new EmployeeDataFactory(createBodyForEmployeesPost())
                .setAge("30")
                .setName("Petko")
                .setSalary("10 000")
                .createRequest();

        Response postResponse = new EmployeeClient()
                .postEmployee(requestBody);

        EmployeeResponseModelPOSTPUT employeesResponse = postResponse.body().as(EmployeeResponseModelPOSTPUT.class);

        assertEquals(200, postResponse.statusCode());
        assertEquals("success",employeesResponse.getStatus());
        assertEquals("Petko",employeesResponse.getData().getName());
        assertEquals("30",employeesResponse.getData().getAge());
        assertEquals("10 000",employeesResponse.getData().getSalary());
        assertEquals("Successfully! Record has been added.",employeesResponse.getMessage());
    }
}
