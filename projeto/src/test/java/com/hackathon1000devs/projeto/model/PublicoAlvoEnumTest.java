package com.hackathon1000devs.projeto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class PublicoAlvoEnumTest {

    @Test
    void testarEnumValues() {
        assertEquals(PublicoAlvo.CRIANÇA, PublicoAlvo.valueOf("CRIANÇA"));
        assertEquals(PublicoAlvo.ADOLESCENTE, PublicoAlvo.valueOf("ADOLESCENTE"));
        assertEquals(PublicoAlvo.ADULTO, PublicoAlvo.valueOf("ADULTO"));
        assertEquals(PublicoAlvo.GESTANTE, PublicoAlvo.valueOf("GESTANTE"));
    }
}