package com.hackathon1000devs.projeto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class DoseModelTest {

    @Test
    void testarGettersSetters() {
        DoseModel d = new DoseModel();

        d.setDescricao_dose("Dose 1");
        d.setIdade_recomendada_aplicacao(12);

        assertEquals("Dose 1", d.getDescricao_dose());
        assertEquals(12, d.getIdade_recomendada_aplicacao());
    }
}