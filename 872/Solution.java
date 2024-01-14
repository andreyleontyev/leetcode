/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        ArrayList<Integer> array1 = new ArrayList();
        ArrayList<Integer> array2 = new ArrayList();
        passthroughTreeNode(root1, array1);
        passthroughTreeNode(root2, array2);

        return array1.equals(array2);

    }

    private void passthroughTreeNode(TreeNode root, ArrayList<Integer> array) {

        if (root.left == null && root.right == null ) {
            array.add(root.val);
            return;
        }

        if (root.left != null){
            passthroughTreeNode(root.left, array);
        }
        if (root.right != null) {
            passthroughTreeNode(root.right, array);
        }
    }
}
