package com.curd.security.controller;

import com.curd.security.entity.Employe;
import com.curd.security.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeRestController {

    @Autowired
    private EmployeService employeService;

    @GetMapping("/message")
    public String message(){
        return "Hello world";
    }

    @PostMapping("/save")
    public Employe saveEmploye(@RequestBody Employe employe){
        return employeService.saveEmploye(employe);
    }


    @PostMapping("/saveall")
    public List<Employe> saveAllEmployees(@RequestBody List<Employe> employes){
        return employeService.saveAllEmployees(employes);
    }

    @GetMapping("/get/{id}")
    public Employe getEmpById(@PathVariable int id){
        return employeService.getEmployeById(id);
    }


    @GetMapping("/getAll")
    public List<Employe> getAllEmps(){
        return employeService.getAllEmployees();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmpById(@PathVariable int id){
        return employeService.deleteEmploye(id);
    }

    @DeleteMapping("/deleteListOfIds")
    public void deleteAllEmployees(@RequestBody List<Integer> ids){
         employeService.deleteByIds(ids);
    }

    @PutMapping("/update/{id}")
    public String update(@RequestBody Employe employe, @PathVariable int id){
        return employeService.updateEmploye(id,employe);
    }
}
