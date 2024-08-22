class Solution {
    public void flatten(TreeNode root) {
        x(root,null);
    }
    public TreeNode x(TreeNode a,TreeNode b){
        if(a == null){
            return b;
        }
        a.right = x(a.left,x(a.right,b));
        a.left = null;
        return a; 
    }
}
