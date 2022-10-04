package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTest {

    private Fraction fraction;

    @BeforeEach
    void before() {
        fraction = new Fraction(2, 4);
    }

    @Test
    void testGetNumerator() {
        assertEquals(2, fraction.getNumerator());
    }

    @Test
    void testSetNumerator() {
        fraction.setNumerator(1);
        assertEquals(1, fraction.getNumerator());
    }

    @Test
    void testGetDenominator() {
        assertEquals(4, fraction.getDenominator());
    }

    @Test
    void testSetDenominator() {
        fraction.setDenominator(2);
        assertEquals(2, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        assertEquals(0.5, fraction.decimal());
    }

    @Test
    void testToString() {
        String expectedString = "Fraction{" +
                "numerator=2" +
                ", denominator=4" +
                '}';
        assertEquals(expectedString, fraction.toString());
    }
}
