

public class LowestCommonAncestorBST{

  public TreeNode LCABST(TreeNode root, TreeNode p, TreeNode q){
    while( (root.val - p.val) * (root.val - q.val) > 0 ){
      root = root.val > p.val ? root.left : root.right;
    }

    return root;
  }

  public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  static void main(String args[]){
    LowestCommonAncestorBST lca = new LowestCommonAncestorBST();


  }
}
