package com.hackathon1000devs.projeto.repository;

import com.hackathon1000devs.projeto.model.ImunizacaoModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ImunizacaoRepository extends JpaRepository<ImunizacaoModel, Long> {

    @Query("SELECT i FROM ImunizacaoModel i WHERE i.paciente.id_paciente = :id")
    List<ImunizacaoModel> findByPacienteId(Long id);

    @Query("SELECT i FROM ImunizacaoModel i WHERE i.paciente.id_paciente = :id " +
            "AND i.data_aplicacao BETWEEN :inicio AND :fim")
    List<ImunizacaoModel> findByPacienteAndPeriodo(Long id, LocalDate inicio, LocalDate fim);

    @Modifying
    @Transactional
    @Query("DELETE FROM ImunizacaoModel i WHERE i.paciente.id_paciente = :id")
    void deleteByPacienteId(Long id);
}
