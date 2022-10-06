package medium.Problem200;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem200Test {

    Problem200 sut;

    @BeforeEach
    void setUp() {
        sut = new Problem200();
    }

    @Test
    void givenInput1_shouldReturnResult() {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        assertEquals(1, sut.numIslands(grid));
    }

    @Test
    void givenInput2_shouldReturnResult() {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        assertEquals(3, sut.numIslands(grid));
    }
}
