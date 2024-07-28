class Solution {
    public String minWindow(String s, String t) {
        int m = t.length();
        int n = s.length();
        int[] arr = new int[256];
        int left = 0, right = 0, minLength = Integer.MAX_VALUE, sIndex = -1, count = 0;
        
        for (int i = 0; i < m; i++) {
            arr[t.charAt(i)]++;
        }
        
        while (right < n) {
            if (arr[s.charAt(right)] > 0) {
                count++;
            }
            arr[s.charAt(right)]--;
            right++;
            
            while (count == m) {
                if (right - left < minLength) {
                    minLength = right - left;
                    sIndex = left;
                }
                arr[s.charAt(left)]++;
                if (arr[s.charAt(left)] > 0) {
                    count--;
                }
                left++;
            }
        }
        
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLength);
    }
}
