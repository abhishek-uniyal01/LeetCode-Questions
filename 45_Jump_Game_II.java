class Solution {
    public int jump(int[] nums) {
        int n = nums.length-1;
        int near = 0, far = 0,jumps = 0;
        while(far<n){
            int farth = 0;
            for(int i=0;i<=far;i++){
                farth = Math.max(farth,i+nums[i]);
            }
            near = far+1;
            far = farth;
            jumps++;
        }
        return jumps;
    }
}
