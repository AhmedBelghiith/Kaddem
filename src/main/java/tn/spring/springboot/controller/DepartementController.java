package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Departement;
import tn.spring.springboot.service.IDepartementService;

import java.util.List;

@RestController
@AllArgsConstructor
public class DepartementController {

    IDepartementService departementService;

    @GetMapping("/getalldepart")
    public List<Departement> getAllDepartement(){
        return departementService.getAllDepartement();
    }

    @PostMapping("/addDepart")
    public Departement addDepartement(@RequestBody Departement departement){
        return departementService.addDepartement(departement);
    }

    @PutMapping("/updateDepart")
    public Departement updateDepartement(@RequestBody Departement departement){
        return departementService.updateDepartement(departement);
    }

    @DeleteMapping("deleteDepart/{id}")
    public void deleteDepartement(@PathVariable("id") Long id){
        departementService.deleteDepartement(id);
    }
}
