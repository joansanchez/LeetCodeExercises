package easy.Problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    Problem1 sut;

    @BeforeEach
    void setUp() {
        sut = new Problem1();
    }

    @Test
    void givenInput1_answer() {
        int[] input = {2,7,11,15};
        int[] output = {0,1};
        assertEquals(output, sut.twoSum(input, 9));
    }

    @Test
    void givenInput2_answer() {
        int[] input = {3, 2, 4};
        int[] output = {1, 2};
        assertEquals(output, sut.twoSum(input, 6));
    }

    @Test
    void givenInput3_answer() {
        int[] input = {3,3};
        int[] output = {0,1};
        assertEquals(output, sut.twoSum(input, 6));
    }
}
