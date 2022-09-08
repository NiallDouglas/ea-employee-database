package com.kainos.ea.resources;

import com.kainos.ea.Employee;
import com.kainos.ea.Message;
import com.kainos.ea.EmployeesDB;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class WebService {

    @GET
    @Path("/print/{msg}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMsg(@PathParam("msg") String message) {
        return "Hello from a RESTful Web service: " + message;
    }

    @POST
    @Path("/print")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String sendMsg(Message message) {
        return "Hello from a RESTful Web service: " + message.getText();
    }

    @GET
    @Path("/employees")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployee() {
        return EmployeesDB.getEmployees();
    }

    @POST
    @Path("/employees")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void insertEmployee(Employee employee) {
        EmployeesDB.insertEmployee(employee);
    }

}
