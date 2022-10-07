package medium.Problem438;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Problem438Test {
    Problem438 sut;

    @BeforeEach
    void setUp() {
        sut = new Problem438();
    }

    @Test
    void givenInput1_returnResult() {
        assertEquals(Arrays.asList(0,6), sut.findAnagrams("cbaebabacd", "abc"));
    }

    @Test
    void givenInput2_returnResult() {
        assertEquals(Arrays.asList(0,1,2), sut.findAnagrams("abab", "ab"));
    }
}
