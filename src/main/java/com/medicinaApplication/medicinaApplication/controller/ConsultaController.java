package com.medicinaApplication.medicinaApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicinaApplication.medicinaApplication.model.Medicamento;
import com.medicinaApplication.medicinaApplication.service.MedicamentoService;



@RestController
@RequestMapping("/api/consulta")
public class ConsultaController {
    
    @Autowired
    private MedicamentoService consultaService;

    @PostMapping("/save")
    public ResponseEntity<Medicamento> save(@RequestBody Medicamento consulta) {
        return consultaService.save(consulta);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Medicamento> findById(@PathVariable String id) {
        return consultaService.findById(id);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Medicamento>> findAll() {
        return consultaService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        return consultaService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Medicamento> update(@PathVariable String id, @RequestBody Medicamento consulta) {
        return consultaService.update(id, consulta);
    }

}
