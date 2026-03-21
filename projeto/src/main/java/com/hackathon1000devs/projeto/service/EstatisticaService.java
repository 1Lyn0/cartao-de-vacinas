package com.hackathon1000devs.projeto.service;

import com.hackathon1000devs.projeto.model.DoseModel;
import com.hackathon1000devs.projeto.model.PacienteModel;
import com.hackathon1000devs.projeto.repository.DoseRepository;
import com.hackathon1000devs.projeto.repository.ImunizacaoRepository;
import com.hackathon1000devs.projeto.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstatisticaService {

    @Autowired
    private ImunizacaoRepository imuRepo;

    @Autowired
    private PacienteRepository pacRepo;

    @Autowired
    private DoseRepository doseRepo;

    // Método auxiliar para calcular idade em meses
    public long calcularIdadeMeses(LocalDate nascimento) {
        if (nascimento == null) return 0;
        return ChronoUnit.MONTHS.between(nascimento, LocalDate.now());
    }

    // Lógica para Vacinas Atrasadas
    public long getVacinasAtrasadas(Long pacienteId) {
        PacienteModel p = pacRepo.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        long idadeAtualMeses = calcularIdadeMeses(p.getData_nascimento());

        // 1. Pegar todas as doses que existem no sistema
        List<DoseModel> todasAsDoses = doseRepo.findAll();

        // 2. Filtrar as que o paciente já tomou
        List<Long> idsDosesTomadas = imuRepo.findByPacienteId(pacienteId).stream()
                .map(imu -> imu.getDose().getId_dose())
                .collect(Collectors.toList());

        // 3. Contar as que ele deveria ter tomado (idade recomendada <= idade atual)
        // e que NÃO estão na lista de tomadas
        return todasAsDoses.stream()
                .filter(d -> d.getIdade_recomendada_aplicacao() <= idadeAtualMeses)
                .filter(d -> !idsDosesTomadas.contains(d.getId_dose()))
                .count();
    }

    // Lógica para Vacinas no Próximo Mês
    public long getVacinasProximoMes(Long pacienteId) {
        PacienteModel p = pacRepo.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        long idadeProximoMes = calcularIdadeMeses(p.getData_nascimento()) + 1;

        // Doses recomendadas exatamente para a idade do mês que vem
        List<DoseModel> dosesMesQueVem = doseRepo.findByIdadeRecomendada((int) idadeProximoMes);

        // Filtra as que ele já tomou
        List<Long> idsDosesTomadas = imuRepo.findByPacienteId(pacienteId).stream()
                .map(imu -> imu.getDose().getId_dose())
                .collect(Collectors.toList());

        return dosesMesQueVem.stream()
                .filter(d -> !idsDosesTomadas.contains(d.getId_dose()))
                .count();
    }
}

