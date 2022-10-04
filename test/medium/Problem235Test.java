package medium;

import medium.Problem235.Problem235;
import medium.Problem235.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem235Test {

    Problem235 sut;
    TreeNode tree = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))),
            new TreeNode(8, new TreeNode(7), new TreeNode(9)));

    @BeforeEach
    void setUp() {
        sut = new Problem235();
    }

    @Test
    void testInput1_shouldReturnRoot() {
        assertEquals(tree, sut.lowestCommonAncestor(tree, tree.left, tree.right));
    }

    @Test
    void testInput2_shouldReturnRoot() {
        assertEquals(tree.left, sut.lowestCommonAncestor(tree, tree.left, tree.left.right));
    }


}
