/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, sum, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(TreeNode root, int sum, List<Integer> crt, List<List<Integer>> res) {
        if (root == null) return;
        sum -= root.val;
        crt.add(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(crt));
        }
        dfs(root.left, sum, crt, res);
        dfs(root.right, sum, crt, res);
        crt.remove(crt.size() - 1);
    }
}