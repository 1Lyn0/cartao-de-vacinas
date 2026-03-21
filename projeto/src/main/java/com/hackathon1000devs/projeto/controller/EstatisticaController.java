package com.hackathon1000devs.projeto.controller;

import com.hackathon1000devs.projeto.repository.ImunizacaoRepository;
import com.hackathon1000devs.projeto.repository.VacinaRepository;
import com.hackathon1000devs.projeto.service.EstatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticaController {
    @Autowired
    private EstatisticaService service;

    @Autowired
    private ImunizacaoRepository imuRepo;

    @Autowired
    private VacinaRepository vacinaRepo;

    // Qtde de vacinas aplicadas por paciente
    @GetMapping("/imunizacoes/paciente/{id}")
    public ResponseEntity<Long> getQuantidadePorPaciente(@PathVariable Long id) {
        long count = imuRepo.findByPacienteId(id).size();
        return ResponseEntity.ok(count);
    }

    // Qtde de vacinas aplicáveis no próximo mês
    @GetMapping("/proximas_imunizacoes/paciente/{id}")
    public ResponseEntity<Long> getProximoMes(@PathVariable Long id) {
        return ResponseEntity.ok(service.getVacinasProximoMes(id));
    }

    // Qtde de vacinas atrasadas
    @GetMapping("/imunizacoes_atrasadas/paciente/{id}")
    public ResponseEntity<Long> getAtrasadas(@PathVariable Long id) {
        return ResponseEntity.ok(service.getVacinasAtrasadas(id));
    }

    // Qtde de vacinas acima de uma determinada idade (baseado na recomendação)
    @GetMapping("/imunizacoes/idade_maior/{meses}")
    public ResponseEntity<Long> getVacinasAcimaIdade(@PathVariable Integer meses) {
        long count = vacinaRepo.countVacinasAcimaIdade(meses);
        return ResponseEntity.ok(count);
    }
}

