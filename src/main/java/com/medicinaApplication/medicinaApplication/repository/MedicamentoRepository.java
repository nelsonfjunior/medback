package com.medicinaApplication.medicinaApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicinaApplication.medicinaApplication.model.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, String> {
    
}
