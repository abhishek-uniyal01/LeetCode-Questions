class Solution {
    public int minimumPushes(String word) {
        int[] arr = new int[26];
        for (char ch : word.toCharArray()) {
            arr[ch - 'a']++;
        }
        Arrays.sort(arr);
        int count = 0;
        int minKey = 0;
        for (int i = 25; i >= 0; i--) {
            int value = arr[i] * (count / 8 + 1);
            minKey += value;
            count++;
        }
        return minKey;

    }
}
