package com.crud.crud;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//RESTful API
@RestController
public class CrudController {
  //READ
  //http://localhost:8080/hello
  @GetMapping("/hello") //EndpointRouter
  public String index() {
    return "Hello World Mantap";
  }

  //http://localhost:8080/hello/ISTD (ISTD = paramater dinamis inputan dari url)
  @GetMapping("/kurs/{kurs1}/{kurs2}/{ammount}") //Parameter
  public String index(@PathVariable String kurs1, @PathVariable String kurs2, @PathVariable String ammount) {
    return "Hello " + kurs1 + " " + kurs2 + " " + ammount;
  }

  // @GetMapping("/api/v1/master/system") //listing
  // @PostMapping("/api/v1/master/system") //create
  // @PutMapping("/api/v1/master/system") //update
  // @DeleteMapping("/api/v1/master/system") //delete
  // @GetMapping("/api/v1/master/system/{SYSTEM_CD}") //detail

  @GetMapping("/json")
  public Map<String, Object> json() {
    Map<String, Object> object = new HashMap<>();
    object.put("brand", "Toyota");
    object.put("model", "Camry");
    return object;
  }
  //CREATE
  //UPDATE
  //DELETE
}
