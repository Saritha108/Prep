package Prg;

public class NumberToWords {

    private static final String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] special = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    public static String convertToWords(int num) {
        if (num < 0 || num > 99_99_99_99) {
            return "Number out of range!";
        }

        if (num == 0) {
            return "zero";
        }

        StringBuilder result = new StringBuilder();

        // Crore place
        int crore = num / 100_00_000;
        if (crore > 0) {
            result.append(convertLessThanHundred(crore)).append(" crore ");
        }

        // Lakh place
        int lakh = (num / 100_000) % 100;
        if (lakh > 0) {
            result.append(convertLessThanHundred(lakh)).append(" lakh ");
        }

        // Thousands place
        int thousands = (num / 1000) % 100;
        if (thousands > 0) {
            result.append(convertLessThanHundred(thousands)).append(" thousand ");
        }

        // Hundreds place
        int hundreds = (num / 100) % 10;
        if (hundreds > 0) {
            result.append(ones[hundreds]).append(" hundred ");
        }

        // Last two digits
        int lastTwo = num % 100;
        if (lastTwo > 0) {
            result.append(convertLessThanHundred(lastTwo));
        }

        return result.toString().trim();
    }

    private static String convertLessThanHundred(int num) {
        if (num < 10) {
            return ones[num];
        } else if (num < 20) {
            return special[num - 10];
        } else {
            int tensDigit = num / 10;
            int onesDigit = num % 10;
            return tens[tensDigit] + (onesDigit > 0 ? "-" + ones[onesDigit] : "");
        }
    }

    public static void main(String[] args) {
        int num = 1285;  // Example 2 cr number
        String words = convertToWords(num);
        System.out.println(words);
    }
}