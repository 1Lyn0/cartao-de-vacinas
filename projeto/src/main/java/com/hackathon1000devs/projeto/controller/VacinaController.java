package com.hackathon1000devs.projeto.controller;

import com.hackathon1000devs.projeto.model.VacinaModel;
import com.hackathon1000devs.projeto.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vacinas")
public class VacinaController {

    @Autowired
    private VacinaRepository repository;

    @GetMapping("/consultar")
    public List<VacinaModel> listarTodas() {
        return repository.findAll();
    }

    @GetMapping("/consultar/faixa_etaria/{faixa}")
    public List<VacinaModel> consultarPorFaixa(@PathVariable String faixa) {
        // Assume que o valor venha como CRIANÇA, ADULTO, etc.
        return repository.findByPublicoAlvo(faixa);
    }

    @GetMapping("/consultar/idade_maior/{meses}")
    public List<VacinaModel> consultarPorIdadeMaior(@PathVariable Integer meses) {
        return repository.findVacinasRecomendadasAcima(meses);
    }
}
