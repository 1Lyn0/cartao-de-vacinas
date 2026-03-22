package com.hackathon1000devs.projeto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SexoEnumTest {

    @Test
    void testarEnumValues() {
        assertEquals(Sexo.M, Sexo.valueOf("M"));
        assertEquals(Sexo.F, Sexo.valueOf("F"));
    }
}