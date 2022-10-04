package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserTest {
    private User user;

    @BeforeEach
    void before() {
        List<Fraction> fractions = new ArrayList<>(List.of(new Fraction(), new Fraction(), new Fraction()));
        user = new User("1", "Test", "User", fractions);
    }

    @Test
    void testUserVoid() {
        user = new User();
        assertNotNull(user);
    }

    @Test
    void testGetId() {
        assertEquals("1", user.getId());
    }

    @Test
    void testGetName() {
        assertEquals("Test", user.getName());
    }

    @Test
    void testSetName() {
        user.setName("TestUser");
        assertEquals("TestUser", user.getName());
    }

    @Test
    void testGetFamilyName() {
        assertEquals("User", user.getFamilyName());
    }

    @Test
    void testSetFamilyName() {
        user.setFamilyName("UserTest");
        assertEquals("UserTest", user.getFamilyName());
    }

    @Test
    void testGetFractions() {
        assertEquals(3, user.getFractions().size());
    }

    @Test
    void testSetFractions() {
        List<Fraction> fractions = List.of(new Fraction(), new Fraction());
        user.setFractions(fractions);
        assertEquals(2, user.getFractions().size());
    }

    @Test
    void testAddFraction() {
        user.addFraction(new Fraction());
        assertEquals(4, user.getFractions().size());
    }

    @Test
    void testFullName() {
        assertEquals("Test User", user.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("T.", user.initials());
    }

    @Test
    void testToString() {
        String expectedString = "User{" +
                "id='1'" +
                ", name='Test'" +
                ", familyName='User'" +
                ", fractions=" + user.getFractions() +
                '}';
        assertEquals(expectedString, user.toString());
    }
}
