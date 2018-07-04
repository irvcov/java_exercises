package excersices;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
           3
          / \
         9  20
           /  \
         15   7
 return its zigzag level order traversal as:
         [
         [3],
         [20,9],
         [15,7]
         ]
 */
public class BinaryTreeZigZag {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> nodequeue = new LinkedList<>();
        Queue<TreeNode> nodequeue2 = new LinkedList<>();
        List<Integer> line;

        if (root != null)
            nodequeue.add(root);

        while (!nodequeue.isEmpty()) {

            line = new LinkedList<>();
            while (!nodequeue.isEmpty()) {
                TreeNode nd = nodequeue.remove();
                line.add(nd.val);

                if (nd.left != null)
                    nodequeue2.add(nd.left);
                if (nd.right != null)
                    nodequeue2.add(nd.right);
            }
            if (line.size() > 0)
                result.add(line);

            line = new LinkedList<>();
            while (!nodequeue2.isEmpty()) {
                TreeNode nd = nodequeue2.remove();
                line.add(nd.val);

                if (nd.left != null)
                    nodequeue.add(nd.left);
                if (nd.right != null)
                    nodequeue.add(nd.right);
            }
            Collections.reverse(line);
            if (line.size() > 0)
                result.add(line);
        }

        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
