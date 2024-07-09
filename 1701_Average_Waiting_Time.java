class Solution {
    public double averageWaitingTime(int[][] customers) {
        long chefBusy = 0;
        int n = customers.length;
        long totalWaitingTime = 0;

        for (int i = 0; i < n; i++) {
            long arrival = customers[i][0];
            int time = customers[i][1];

            long startTime = Math.max(arrival, chefBusy);
            long endTime = startTime + time;

            totalWaitingTime += endTime - arrival;
            chefBusy = endTime;
        }

        return (totalWaitingTime * 1.0) / n;
    }
}
