package es.upm.miw.iwvg_devops.rest.code;

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
        assertEquals(List.of(0.0, 1.0, 0.2, 0.5, 1.0),
                searches.findDecimalImproperFractionByUserName("Oscar").collect(Collectors.toList()));
        assertEquals(List.of(-0.2, 0.5),
                searches.findDecimalImproperFractionByUserName("Ana").collect(Collectors.toList()));
        assertEquals(List.of(1.0, 1.0, NaN, 1.0),
                searches.findDecimalImproperFractionByUserName("Paula").collect(Collectors.toList()));
        assertEquals(List.of(0.0, 0.0),
                searches.findDecimalImproperFractionByUserName("Antonio").collect(Collectors.toList()));
    }
}
