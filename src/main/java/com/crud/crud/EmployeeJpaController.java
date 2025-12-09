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
@RequestMapping("/jpa/employees")
public class EmployeeJpaController {

  @Autowired
  private EmployeeRepository employeeRepository;

  @GetMapping
  public List<EmployeeJpa> getAllEmployees() {
    return employeeRepository.findAll();
  }

  @GetMapping("/{id}")
  public EmployeeJpa getEmployeeById(@PathVariable int id) {
    return employeeRepository.findById(id).orElse(null);
  }

  @PostMapping
  public EmployeeJpa createEmployee(@RequestBody EmployeeJpa employee) {
    return employeeRepository.save(employee);
  }

  @PutMapping("/{id}")
  public EmployeeJpa updateEmployee(@PathVariable int id, @RequestBody EmployeeJpa employeeDetails) {
    EmployeeJpa employee = employeeRepository.findById(id).orElse(null);
    if (employee != null) {
      employee.setName(employeeDetails.getName());
      employee.setEmail(employeeDetails.getEmail());
      employee.setPassword(employeeDetails.getPassword());
      employee.setNoreg(employeeDetails.getNoreg());
      return employeeRepository.save(employee);
    }
    return null;
  }

  @DeleteMapping("/{id}")
  public String deleteEmployee(@PathVariable int id) {
    employeeRepository.deleteById(id);
    return "Employee deleted with id: " + id;
  }
}
