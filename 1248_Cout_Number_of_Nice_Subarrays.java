class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return maxm(nums, k) - maxm(nums, k - 1);
    }

    private int maxm(int[] nums, int k) {
        int count = 0;
        int ans = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] % 2 != 0)
                count++;
            while (count > k) {
                if (nums[start] % 2 != 0)
                    count--;
                start++;
            }
            ans += (end - start + 1);
        }
        return ans;
    }
}
