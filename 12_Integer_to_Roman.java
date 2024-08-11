import java.util.Map;
import java.util.LinkedHashMap;

class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> mpp = new LinkedHashMap<>();
        mpp.put(1000, "M");
        mpp.put(900, "CM");
        mpp.put(500, "D");
        mpp.put(400, "CD");
        mpp.put(100, "C");
        mpp.put(90, "XC");
        mpp.put(50, "L");
        mpp.put(40, "XL");
        mpp.put(10, "X");
        mpp.put(9, "IX");
        mpp.put(5, "V");
        mpp.put(4, "IV");
        mpp.put(1, "I");

        StringBuilder res = new StringBuilder();

        for (Map.Entry<Integer, String> entry : mpp.entrySet()) {
            int value = entry.getKey();
            String numeral = entry.getValue();
            
            while (num >= value) {
                res.append(numeral);
                num -= value;
            }
        }

        return res.toString();
    }
}
