package com.crud.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/query/employees")
public class EmployeQueryController {

  @Autowired
  private EmployeeQuery employeeQuery;

  @GetMapping
  public List<EmployeeJpa> getAllEmployees() {
    return employeeQuery.findAll();
  }

  @GetMapping("/{id}")
  public EmployeeJpa getEmployeeById(@PathVariable int id) {
    return employeeQuery.findById(id);
  }

  @PostMapping
  public String createEmployee(@RequestBody EmployeeJpa employee) {
    int result = employeeQuery.save(employee);
    return result + " record(s) saved.";
  }

  @PutMapping("/{id}")
  public String updateEmployee(@PathVariable int id, @RequestBody EmployeeJpa employee) {
    int result = employeeQuery.update(employee, id);
    return result + " record(s) updated.";
  }

  @DeleteMapping("/{id}")
  public String deleteEmployee(@PathVariable int id) {
    int result = employeeQuery.deleteById(id);
    return result + " record(s) deleted.";
  }
}
