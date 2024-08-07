class Solution {
    String[] lessThanTwenty = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    String[] lessThanHundred = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return Words(num).trim();
    }

    private String Words(int num) {
        if (num < 20) {
            return lessThanTwenty[num];
        } else if (num < 100) {
            return lessThanHundred[num / 10] + (num % 10 != 0 ? " " + lessThanTwenty[num % 10] : "");
        } else if (num < 1000) {
            return lessThanTwenty[num / 100] + " Hundred" + (num % 100 != 0 ? " " + Words(num % 100) : "");
        } else if (num < 1000000) {
            return Words(num / 1000) + " Thousand" + (num % 1000 != 0 ? " " + Words(num % 1000) : "");
        } else if (num < 1000000000) {
            return Words(num / 1000000) + " Million" + (num % 1000000 != 0 ? " " + Words(num % 1000000) : "");
        } else {
            return Words(num / 1000000000) + " Billion" + (num % 1000000000 != 0 ? " " + Words(num % 1000000000) : "");
        }
    }
}
