package com.hackathon1000devs.projeto.model;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ImunizacaoModelTest {

    @Test
    void testarGettersSetters() {
        ImunizacaoModel im = new ImunizacaoModel();

        im.setFabricante("ABC");
        im.setLote("123");
        im.setLocal_aplicacao("UBS");
        im.setProfissional_aplicador("Maria");
        im.setData_aplicacao(LocalDate.of(2020,1,1));

        assertEquals("ABC", im.getFabricante());
        assertEquals("123", im.getLote());
        assertEquals("UBS", im.getLocal_aplicacao());
        assertEquals("Maria", im.getProfissional_aplicador());
        assertEquals(LocalDate.of(2020,1,1), im.getData_aplicacao());
    }
}