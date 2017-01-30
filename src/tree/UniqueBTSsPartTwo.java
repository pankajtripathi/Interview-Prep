/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class UniqueBTSsPartTwo{
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new LinkedList<TreeNode>();
        return generateTrees(1, n);
    }
    
    public List<TreeNode> generateTrees(int m, int n){
        List<TreeNode> res = new LinkedList<TreeNode>();
        
        if(m>n){
            res.add(null);
            return res;
        } 
        
        for(int i=m; i<=n; i++){
            List<TreeNode> ls = generateTrees(m, i-1);
            List<TreeNode> rs = generateTrees(i+1, n);
            
            for(TreeNode l: ls){
                for(TreeNode r: rs){
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }
        }
        return res;
    }
}