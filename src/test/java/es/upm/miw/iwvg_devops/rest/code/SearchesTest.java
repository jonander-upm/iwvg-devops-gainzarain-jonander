package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.Searches;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Double.NaN;
import static java.lang.Double.POSITIVE_INFINITY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SearchesTest {
    Searches searches;

    @BeforeEach
    void before() {
        searches = new Searches();
    }

    @Test
    void testFindDecimalImproperFractionByUserName() {
        assertEquals(List.of(0.0, 1.0, 0.2, 0.5, 1.0),
                searches.findDecimalImproperFractionByUserName("Oscar").collect(Collectors.toList()));
        assertEquals(List.of(-0.2, 0.5),
                searches.findDecimalImproperFractionByUserName("Ana").collect(Collectors.toList()));
        assertEquals(List.of(1.0, 1.0, NaN, 1.0),
                searches.findDecimalImproperFractionByUserName("Paula").collect(Collectors.toList()));
        assertEquals(List.of(0.0, 0.0),
                searches.findDecimalImproperFractionByUserName("Antonio").collect(Collectors.toList()));
    }

    @Test
    void testFindUserIdBySomeProperFraction() {
        assertEquals(List.of("1", "2", "3", "5", "6"), searches.findUserIdBySomeProperFraction().collect(Collectors.toList()));
    }

    @Test
    void testFindFractionMultiplicationByUserFamilyName() {
        assertEquals(0.0, searches.findFractionMultiplicationByUserFamilyName("Fernandez").decimal());
        assertEquals(-0.0, searches.findFractionMultiplicationByUserFamilyName("Blanco").decimal());
        assertEquals(-0.05, searches.findFractionMultiplicationByUserFamilyName("López").decimal());
        assertEquals(NaN, searches.findFractionMultiplicationByUserFamilyName("Torres").decimal());
    }

    @Test
    void findFirstProperFractionByUserId() {
        assertEquals(2, searches.findFirstProperFractionByUserId("1").decimal());
        assertEquals(2, searches.findFirstProperFractionByUserId("2").decimal());
        assertEquals(-0.5, searches.findFirstProperFractionByUserId("3").decimal());
        assertNull(searches.findFirstProperFractionByUserId("4"));
        assertEquals(-0.0, searches.findFirstProperFractionByUserId("5").decimal());
        assertEquals(POSITIVE_INFINITY, searches.findFirstProperFractionByUserId("6").decimal());
    }
}
