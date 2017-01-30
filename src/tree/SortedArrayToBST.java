/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBST(nums, 0, nums.length-1);       
    }
    
    public TreeNode arrayToBST(int nums[], int start, int end){
        if(start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = arrayToBST(nums, start, mid-1);
        node.right = arrayToBST(nums, mid+1, end);
        
        return node;
    }
}