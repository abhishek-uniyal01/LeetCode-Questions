class Solution {
    public int[] closestPrimes(int left, int right) {
        int firstPrime = -1;
        int secondPrime = -1;
        int closestDistance = Integer.MAX_VALUE;
        int prevPrime = -1;

        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                if (prevPrime != -1) {
                    int distance = i - prevPrime;
                    if (distance < closestDistance) {
                        closestDistance = distance;
                        firstPrime = prevPrime;
                        secondPrime = i;
                    }
                }
                prevPrime = i;
            }
        }

        if (firstPrime != -1 && secondPrime != -1) {
            return new int[]{firstPrime, secondPrime};
        } else {
            return new int[]{-1, -1};
        }
    }

    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
