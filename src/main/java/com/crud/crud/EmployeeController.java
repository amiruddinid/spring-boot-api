package com.crud.crud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//RESTful API
// Controller
@RestController
public class EmployeeController {
  //InMemory Database
  // [key, value]
  private List<Employee> employeeList = new ArrayList<>();
  //READ
  //http://localhost:8080/hello
  @GetMapping("/hello") //EndpointRouter
  public String index() {
    return "Hello World Mantap";
  }

  //READ
  @GetMapping("/employees")
  public List<Employee> getEmployee(){
    return employeeList;
  }

  //READ by ID
  // Array ["data1", "data2"]
  @GetMapping("/employees/{id}")
  public Employee getEmployeeById(@PathVariable int id){
    return employeeList.stream()
    .filter(e->e.id == id)
    .findFirst()
    .orElse(null);
  }

  //CREATE
  @PostMapping("/employees")
  public Employee createEmployee(@RequestBody Employee employee){
    employeeList.add(employee);
    return employee;
  }

  //UPDATE
  @PutMapping("/employees/{id}")
  public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee){
    Employee employeeById = getEmployeeById(id);
    employeeById.name = employee.name;
    employeeById.email = employee.email;
    employeeById.password = employee.password;
    employeeById.noreg = employee.noreg;

    employeeList.set(id, employeeById);
    return employeeById;
  }

  //DELETE
  @DeleteMapping("/employees/{id}")
  public void deleteEmployee(@PathVariable int id){
    Employee employeeById = getEmployeeById(id);

    employeeList.remove(employeeById);
  }
}
