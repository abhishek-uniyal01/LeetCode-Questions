public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = 0 - nums[i];
            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[low] + nums[high];
                
                if (sum == target) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[low]);
                    triplet.add(nums[high]);
                    res.add(triplet);

                    low++;
                    while (low < high && nums[low] == nums[low - 1])
                        low++;

                    high--;
                    while (low < high && nums[high] == nums[high + 1])
                        high--;
                } else if (sum > target) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return res;
    }
}
