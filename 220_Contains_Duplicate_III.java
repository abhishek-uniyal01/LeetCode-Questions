import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums.length == 0 || indexDiff <= 0) {
            return false;
        }
    
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long num = (long) nums[i];
            
            Long floor = set.floor(num + valueDiff);
            Long ceiling = set.ceiling(num - valueDiff);
            
            if ((floor != null && floor >= num) || (ceiling != null && ceiling <= num)) {
                return true;
            }
            
            set.add(num);
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }
}
