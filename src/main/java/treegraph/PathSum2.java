package treegraph;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/path-sum-ii/solution/

For this tree as input and sum 4 : result is [[1,2,1], [1,3]]
      1
     /  \
    2    3
   /  \
  4   1
DFS preorder approach, because the main logic is in the leaves: read node val if its leaf, check the value against target(sum) and update result.
T : O(N^2) : In worst case( complete tree) we need to visit all the nodes : O(N) and when condition satisfied copy node result into result O(N)
M : O(N) : In worst case (skew tree) we need to add all nodes to node path. We dont include result in the space complexity, otherwise O(N^2)

 */
public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        findPath(result, targetSum, new ArrayList<>(), root);

        return result;

    }

    private void findPath(List<List<Integer>> result, int targetSum, List<Integer> nodePath, TreeNode node) {
        // base condition
        if (node == null) {
            return;
        }
        nodePath.add(node.val);
        // recursion condition
        if (node.left == null && node.right == null && node.val == targetSum) {
            // result.add(nodePath); because nodePath might be updated later, and it will impact the value in the result.
            result.add(new ArrayList<>(nodePath));
        } else {
            findPath(result, targetSum - node.val, nodePath, node.left);
            findPath(result, targetSum - node.val, nodePath, node.right);
        }
        //backtrack
        // We need to pop the node once we are done processing ALL of it's subtrees.
        nodePath.remove(nodePath.size() - 1);
    }
}
