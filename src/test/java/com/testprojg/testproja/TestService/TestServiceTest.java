package com.testprojg.testproja.TestService;

import com.testprojg.testproja.Service.TestService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceTest {
    private final TestService testService = new TestService();

    @Test
    void testAddNumbers_Positive() {
        int result = testService.addNumbers(5, 7);
        assertEquals(12, result, "Sum of 5 and 7 should be 12");
    }

    @Test
    void testAddNumbers_WithZero() {
        int result = testService.addNumbers(0, 10);
        assertEquals(10, result, "Sum of 0 and 10 should be 10");
    }

    @Test
    void testAddNumbers_NegativeNumbers() {
        int result = testService.addNumbers(-3, -7);
        assertEquals(-10, result, "Sum of -3 and -7 should be -10");
    }
}
