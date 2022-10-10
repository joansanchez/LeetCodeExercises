package medium.Problem424;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem424Test {
    Problem424 sut;

    @BeforeEach
    void setUp() {
        sut = new Problem424();
    }

    @Test
    void givenInput1_shouldReturnReplacements() {
        assertEquals(4, sut.characterReplacement("ABAB", 2));
    }

    @Test
    void givenInput2_shouldReturnReplacements() {
        assertEquals(4, sut.characterReplacement("AABABBA", 1));
    }
}
