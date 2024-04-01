package com.curd.security.service;

import com.curd.security.entity.Employe;
import com.curd.security.exception.EmployeNotFoundException;
import com.curd.security.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    public Employe saveEmploye(Employe employe){
        return employeRepository.save(employe);
    }

    public Employe getEmployeById(int id){
        Employe existingEmploye = employeRepository.findById(id).get();
        if(existingEmploye!=null){
            return existingEmploye;
        }else {
            throw new EmployeNotFoundException(" USER NOT FOUND WITH ID "+id);
        }
    }

    public List<Employe> saveAllEmployees(List<Employe> employes){
        return employeRepository.saveAll(employes);
    }

    public List<Employe> getAllEmployees(){
        return employeRepository.findAll();
    }

    public String deleteEmploye(int id){
        Employe existingEmployemployeObj = employeRepository.findById(id).orElseThrow(() -> new EmployeNotFoundException(" USER NOT FOUND WITH ID " + id));
        if (existingEmployemployeObj!=null){
            employeRepository.delete(existingEmployemployeObj);
        }
        return "Employe with id "+id+" deleted";
    }

    public void deleteByIds(List<Integer> ids){
        for(int id: ids){
            employeRepository.deleteById(id);
        }
    }

    public String updateEmploye(int id, Employe employe){
        Employe existEmp = employeRepository.findById(id)
                .orElseThrow(() -> new EmployeNotFoundException(" USER NOT FOUND WITH ID " + id));
        if (existEmp!=null){
            existEmp.setName(employe.getName());
            existEmp.setSalary(employe.getSalary());
            employeRepository.save(existEmp);
        }
        return "employe updated with new details succesfully";
    }
}
