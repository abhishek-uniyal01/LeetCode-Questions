class Solution {

    private int currIndex = 0;
    private HashMap<Integer, Integer> mpp;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        currIndex = 0;
        mpp = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mpp.put(inorder[i], i);
        }
        return constTree(preorder, inorder, 0, preorder.length - 1);
    }

    public TreeNode constTree(int[] preorder, int[] inorder, int start, int end) {
        if (currIndex >= preorder.length || start > end) {
            return null;
        }

        int headNodeValue = preorder[currIndex++];
        TreeNode head = new TreeNode(headNodeValue);

        int targetIndex = mpp.get(headNodeValue);

        head.left = constTree(preorder, inorder, start, targetIndex - 1);
        head.right = constTree(preorder, inorder, targetIndex + 1, end);

        return head;
    }
}
