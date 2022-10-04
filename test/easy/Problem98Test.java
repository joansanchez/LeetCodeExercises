package easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem98Test {

    Problem98 sut;

    @BeforeEach
    void setUp() {
        sut = new Problem98();
    }

    @Test
    void testInput1_shouldReturnTrue() {
        assertTrue(sut.isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
    }

    @Test
    void testInput2_shouldReturnFalse() {
        assertFalse(sut.isValidBST(new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)))));
    }

    @Test
    void testInput3_shouldReturnFalse() {
        assertFalse(sut.isValidBST(new TreeNode(2, new TreeNode(2), new TreeNode(2))));
    }

    @Test
    void testInput4_shouldReturnFalse() {
        assertFalse(sut.isValidBST(new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)))));
    }
}
