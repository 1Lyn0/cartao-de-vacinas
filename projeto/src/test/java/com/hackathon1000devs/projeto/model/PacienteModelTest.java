package com.hackathon1000devs.projeto.model;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class PacienteModelTest {

    @Test
    void testarGettersSetters() {
        PacienteModel p = new PacienteModel();

        p.setNome_paciente("João");
        p.setCpf_paciente("123");
        p.setSexo(Sexo.M);
        p.setData_nascimento(LocalDate.of(2000,1,1));

        assertEquals("João", p.getNome_paciente());
        assertEquals("123", p.getCpf_paciente());
        assertEquals(Sexo.M, p.getSexo());
        assertEquals(LocalDate.of(2000,1,1), p.getData_nascimento());
    }
}