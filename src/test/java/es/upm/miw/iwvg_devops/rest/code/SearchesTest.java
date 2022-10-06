package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.Searches;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchesTest {
    Searches searches;

    @BeforeEach
    void before() {
        searches = new Searches();
    }

    @Test
    void testFindDecimalImproperFractionByUserName() {
        assertEquals(List.of(0.0, 0.2, 0.5),
                searches.findDecimalImproperFractionByUserName("Oscar").collect(Collectors.toList()));
        assertEquals(List.of(-0.2, 0.5),
                searches.findDecimalImproperFractionByUserName("Ana").collect(Collectors.toList()));
        assertEquals(0,
                searches.findDecimalImproperFractionByUserName("Paula").count());
        assertEquals(List.of(0.0, 0.0),
                searches.findDecimalImproperFractionByUserName("Antonio").collect(Collectors.toList()));
    }

    @Test
    void testFindUserIdBySomeProperFraction() {
        assertEquals(List.of("1", "2", "3", "4", "5", "6"), searches.findUserIdBySomeProperFraction().collect(Collectors.toList()));
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
        assertEquals(1, searches.findFirstProperFractionByUserId("1").decimal());
        assertEquals(2, searches.findFirstProperFractionByUserId("2").decimal());
        assertEquals(-0.5, searches.findFirstProperFractionByUserId("3").decimal());
        assertEquals(1, searches.findFirstProperFractionByUserId("4").decimal());
        assertEquals(-0.0, searches.findFirstProperFractionByUserId("5").decimal());
        assertEquals(NaN, searches.findFirstProperFractionByUserId("6").decimal());
    }
}
