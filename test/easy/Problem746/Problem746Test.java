package easy.Problem746;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem746Test {
    Problem746 sut;

    @BeforeEach
    void setUp() {
        sut = new Problem746();
    }

    @Test
    void givenInput1_returnAnswer() {
        int[] cost = {10,15,20};
        assertEquals(15, sut.minCostClimbingStairs(cost));
    }

    @Test
    void givenInput2_returnAnswer() {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        assertEquals(6, sut.minCostClimbingStairs(cost));
    }
    @Test
    void givenInput3_returnAnswer() {
        int[] cost = {0,1,2,2};
        assertEquals(2, sut.minCostClimbingStairs(cost));
    }
}
