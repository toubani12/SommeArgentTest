package usmba.est;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SommeArgentTest {

    @Test
    void testEgalite() {
        SommeArgent s1 = new SommeArgent(50, "EUR");
        SommeArgent s2 = new SommeArgent(50, "EUR");
        assertEquals(s1, s2);
    }

    @Test
    void testAdditionMemeDevise() {
        SommeArgent s1 = new SommeArgent(20, "EUR");
        SommeArgent s2 = new SommeArgent(30, "EUR");
        SommeArgent attendu = new SommeArgent(50, "EUR");
        assertEquals(attendu, s1.additionner(s2));
    }

    @Test
    void testAdditionDeviseDifferente() {
        SommeArgent s1 = new SommeArgent(10, "EUR");
        SommeArgent s2 = new SommeArgent(10, "USD");
        assertThrows(IllegalArgumentException.class, () -> s1.additionner(s2));
    }

    @Test
    void testAdditionCorrecteSommeArgent() {
        SommeArgent s1 = new SommeArgent(30, "EUR");
        SommeArgent s2 = new SommeArgent(20, "EUR");
        SommeArgent resultat = s1.additionner(s2);
        SommeArgent attendu = new SommeArgent(50, "EUR");
        assertEquals(attendu, resultat, "L'addition devrait donner 50 EUR");
    }

    @Test
    void testAdditionDH() {
        SommeArgent m12DH = new SommeArgent(12, "DH");
        SommeArgent m14DH = new SommeArgent(14, "DH");
        SommeArgent expected = new SommeArgent(26, "DH");
        SommeArgent result = m12DH.add(m14DH);
        assertTrue(expected.equals(result), "L'addition de 12 DH et 14 DH doit donner 26 DH");
    }
}

