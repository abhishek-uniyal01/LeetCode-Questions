class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (mpp.containsKey(x)) {
                ans[0] = mpp.get(x);
                ans[1] = i;
                return ans;
            }
            mpp.put(nums[i], i);
        }
        return ans;
    }
}
