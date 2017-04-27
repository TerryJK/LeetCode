/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // Java Solution 2 - Preorder Traversal

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String str = new String();
        str.append("a");
        // test

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

    }


    // Supporting Methods

    public int inOrder(TreeNode root){
        if(root == null) return -1;
        inOrder(root.left);
        return root.val;
        inOrder(root.right);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
