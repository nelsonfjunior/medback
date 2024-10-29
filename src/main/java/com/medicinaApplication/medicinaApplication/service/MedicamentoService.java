package com.medicinaApplication.medicinaApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medicinaApplication.medicinaApplication.model.Medicamento;
import com.medicinaApplication.medicinaApplication.repository.MedicamentoRepository;


@Service
public class MedicamentoService {
    
    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public ResponseEntity<Medicamento> save(Medicamento consulta) {
        return ResponseEntity.ok(medicamentoRepository.save(consulta));
    }

    public ResponseEntity<Medicamento> findById(String id) {
        return ResponseEntity.ok(medicamentoRepository.findById(id).orElse(null));
    }

    public ResponseEntity<Iterable<Medicamento>> findAll() {
        return ResponseEntity.ok(medicamentoRepository.findAll());
    }

    public ResponseEntity<Void> deleteById(String id) {
        medicamentoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Medicamento> update(String id, Medicamento consulta) {
        Medicamento consultaToUpdate = medicamentoRepository.findById(id).orElse(null);
        if (consultaToUpdate == null) {
            return null;
        }
        consultaToUpdate.setNomeRemedio(consulta.getNomeRemedio());
        consultaToUpdate.setFormaDeUso(consulta.getFormaDeUso());
        consultaToUpdate.setDosagem(consulta.getDosagem());
        consultaToUpdate.setDescricao(consulta.getDescricao());
        return ResponseEntity.ok(medicamentoRepository.save(consultaToUpdate));
    }
}
