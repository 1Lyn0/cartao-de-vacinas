package com.hackathon1000devs.projeto.controller;

import com.hackathon1000devs.projeto.model.ImunizacaoModel;
import com.hackathon1000devs.projeto.repository.ImunizacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imunizacao")
public class ImunizacaoController {
    @Autowired
    private ImunizacaoRepository repository;

    @PostMapping("/inserir")
    public ResponseEntity<ImunizacaoModel> inserir(@RequestBody ImunizacaoModel imu) {
        return ResponseEntity.status(201).body(repository.save(imu));
    }

    @DeleteMapping("/excluir/paciente/{id}")
    @Transactional
    public ResponseEntity<String> excluirPorPaciente(@PathVariable Long id) {
        repository.deleteByPacienteId(id);
        return ResponseEntity.ok("Imunizações excluídas com sucesso.");
    }

    @GetMapping("/consultar/paciente/{id}")
    public List<ImunizacaoModel> consultarPorPaciente(@PathVariable Long id) {
        return repository.findByPacienteId(id);
    }
}

