236. Lowest Common Ancestor of a Binary Tree


Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in
the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is
defined between two nodes v and w as the lowest node in T that has both v and w
as descendants (where we allow a node to be a descendant of itself).”


      _______3______
     /              \
  ___5__          ___1__
 /      \        /      \
6       _2       0       8
       /  \
      7    4


For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another
example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
according to the LCA definition.



Same solution in several languages. It's recursive and expands the meaning of
the function. If the current (sub)tree contains both p and q, then the function
result is their LCA. If only one of them is in that subtree, then the result is
that one of them. If neither are in that subtree, the result is null/None/nil.

Update: I also wrote two iterative solutions now, one of them being a version of
the solution here. They're more complicated than this simple recursive solution,
but I do find them interesting.



public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    return left == null ? right : right == null ? left : root;
}
