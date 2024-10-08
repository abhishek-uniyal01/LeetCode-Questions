class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int tempMax = 0;
        int n = arr.length;
        int minSum = Integer.MAX_VALUE;
        int arrSum = 0;
        int tempMin = 0;

        for (int i = 0; i < n; i++) {
            arrSum += arr[i];
            tempMax += arr[i];
            tempMin += arr[i];
        
            if (tempMax > maxSum) {
                maxSum = tempMax;
            }
            if (tempMax < 0) {
                tempMax = 0;
            }
            if (tempMin < minSum) {
                minSum = tempMin;
            }
            if (tempMin > 0) {
                tempMin = 0;
            }
        }
        if (arrSum == minSum) {
            return maxSum;
        }
        
        return Math.max(maxSum, arrSum - minSum);
    }
}
