package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    // verification que retour retourne bien 1
    public void testRetour() {
        // preparation des donnees
        Main m = new Main();
        // appel de la methode
        int val = m.retour();
        // verifications
        assertEquals(1, val,"devrait etre egal à 1");
    }

}
