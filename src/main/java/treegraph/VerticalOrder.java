package treegraph;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 Solution : BFS! queue contains pairs of column and node. A hashmap to group visited nodes by column.
 mincolumn and maxColumn to avoid sorting map. move left : column-1 , right : column + 1
O(N) : we visit each node once.
O(N) : For the hash map. In any case it contains all the nodes of size n.
 */
public class VerticalOrder {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> columnNodesMap = new HashMap<>();
        Queue<Pair<Integer, TreeNode>> queue = new ArrayDeque<>();
        int column = 0;
        int minColumn = 0;
        int maxColumn = 0;
        queue.offer(new ImmutablePair<>(column, root));
        while (!queue.isEmpty()) {
            Pair<Integer, TreeNode> current = queue.poll();

            column = current.getKey();

            minColumn = Math.min(minColumn, column);
            maxColumn = Math.max(maxColumn, column);

            TreeNode node = current.getValue();

            if (!columnNodesMap.containsKey(column)) {
                columnNodesMap.put(column, new ArrayList<>());
            }
            columnNodesMap.get(column).add(node.val);
            if (node.left != null) {
                queue.offer(new ImmutablePair<>(column - 1, node.left));
            }
            if (node.right != null) {
                queue.offer(new ImmutablePair<>(column + 1, node.right));
            }
        }
        for (int i = minColumn; i <= maxColumn; i++) {
            result.add(columnNodesMap.get(i));
        }
        return result;
    }
}
