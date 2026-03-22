package com.hackathon1000devs.projeto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class VacinaModelTest {

    @Test
    void testarGettersSetters() {
        VacinaModel v = new VacinaModel();

        v.setNome_vacina("Vacina X");
        v.setDescricao_vacina("Descrição");
        v.setLimite_aplicacao(2);
        v.setPublico_alvo(PublicoAlvo.ADULTO);

        assertEquals("Vacina X", v.getNome_vacina());
        assertEquals("Descrição", v.getDescricao_vacina());
        assertEquals(2, v.getLimite_aplicacao());
        assertEquals(PublicoAlvo.ADULTO, v.getPublico_alvo());
    }
}