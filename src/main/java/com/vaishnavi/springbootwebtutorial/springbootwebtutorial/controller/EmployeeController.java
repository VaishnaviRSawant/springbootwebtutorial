package com.vaishnavi.springbootwebtutorial.springbootwebtutorial.controller;

import com.vaishnavi.springbootwebtutorial.springbootwebtutorial.DTO.EmployeeDTO;
import com.vaishnavi.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.vaishnavi.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")

public class EmployeeController {
//    @GetMapping(path="/getSecretMessage")
//    public String getMySuperSecretMessage(){
//        return "Secret message :hello";



    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @GetMapping ("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable (name = "employeeId")Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false,name = "inputAge")Integer age, @RequestParam(required = false) String sortBy){
        return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
       return employeeRepository.save(inputEmployee);
    }


    @PutMapping String updateEmployeeById(){
        return "hello from Put";
    }



}
