class Solution {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int maxDepth = 0;
        for(Node node : root.children){
            if(node != null){
                maxDepth = Math.max(maxDepth,maxDepth(node));
            }
        }
        return (1+maxDepth);
    }
}
