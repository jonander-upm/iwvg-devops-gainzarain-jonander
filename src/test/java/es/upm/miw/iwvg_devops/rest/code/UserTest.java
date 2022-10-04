package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {
    private User user;

    @BeforeEach
    public void before() {
        List<Fraction> fractions = new ArrayList<>(List.of(new Fraction(), new Fraction(), new Fraction()));
        user = new User("1", "Test", "User", fractions);
    }

    @Test
    public void testUserVoid() {
        user = new User();
        assertNotNull(user);
    }

    @Test
    public void testGetId() {
        assertEquals("1", user.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("Test", user.getName());
    }

    @Test
    public void testSetName() {
        user.setName("TestUser");
        assertEquals("TestUser", user.getName());
    }

    @Test
    public void testGetFamilyName() {
        assertEquals("User", user.getFamilyName());
    }

    @Test
    public void testSetFamilyName() {
        user.setFamilyName("UserTest");
        assertEquals("UserTest", user.getFamilyName());
    }

    @Test
    public void testGetFractions() {
        assertEquals(3, user.getFractions().size());
    }

    @Test
    public void testSetFractions() {
        List<Fraction> fractions = List.of(new Fraction(), new Fraction());
        user.setFractions(fractions);
        assertEquals(2, user.getFractions().size());
    }

    @Test
    public void testAddFraction() {
        user.addFraction(new Fraction());
        assertEquals(4, user.getFractions().size());
    }

    @Test
    public void testFullName() {
        assertEquals("Test User", user.fullName());
    }

    @Test
    public void testInitials() {
        assertEquals("T.", user.initials());
    }

    @Test
    public void testToString() {
        String expectedString = "User{" +
                "id='1'" +
                ", name='Test'" +
                ", familyName='User'" +
                ", fractions=[Fraction{}, Fraction{}, Fraction{}]" +
                '}';
        assertEquals(expectedString, user.toString());
    }
}
