package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testMoveTondeuse() {
        // Test déplacement simple vers le nord
        App.moveTondeuse(1, 1, 'N', 5, 5, "A");
        assertEquals("1 2 N", outContent.toString().trim());

        // Test déplacement vers le bord de la pelouse
        App.moveTondeuse(5, 5, 'N', 5, 5, "A");
        assertEquals("5 5 N", outContent.toString().trim());

        // Test déplacement avec rotation
        App.moveTondeuse(1, 2, 'N', 5, 5, "GAGAGAGAA");
        assertEquals("1 3 N", outContent.toString().trim());

        // Test déplacement avec plusieurs instructions
        App.moveTondeuse(3, 3, 'E', 5, 5, "AADAADADDA");
        assertEquals("5 1 E", outContent.toString().trim());
    }
}
