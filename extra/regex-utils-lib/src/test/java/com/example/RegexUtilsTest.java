package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class RegexUtilsTest {
    @Test void testEmail() {
        assertTrue(RegexUtils.isValidEmail("test@mail.com"));
        assertFalse(RegexUtils.isValidEmail("bad-email"));
    }
}
