package other;

/*
https://leetcode.com/problems/integer-to-english-words/solution/

T: O(N)
Space : O(1)
 */
public class NumberToWords {
    private final String[] belowTen = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty =
            new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords1(int num) {
        if (num == 0) return "Zero";
        return helper(num);
    }

    private String helper(int num) {
        String result;
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num - 10];
        else if (num < 100) result = belowHundred[num / 10] + " " + helper(num % 10);
        else if (num < 1000) result = helper(num / 100) + " Hundred " + helper(num % 100);
        else if (num < 1000000) result = helper(num / 1000) + " Thousand " + helper(num % 1000);
        else if (num < 1000000000) result = helper(num / 1000000) + " Million " + helper(num % 1000000);
        else result = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
        return result.trim();
    }


    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        //1,234,567,890 > 1
        int billion = num / 1000000000;
        // 234 (1,234,567,890 - 1000,000,000)/1,000,000
        int million = (num - billion * 1000000000) / 1000000;
        // 567
        int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
        // 890
        int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

        String result = "";
        if (billion != 0)
            result = convertThreeDigits(billion) + " Billion";
        if (million != 0) {
            if (! result.isEmpty())
                result += " ";
            result += convertThreeDigits(million) + " Million";
        }
        if (thousand != 0) {
            if (! result.isEmpty())
                result += " ";
            result += convertThreeDigits(thousand) + " Thousand";
        }
        //890
        if (rest != 0) {
            if (! result.isEmpty())
                result += " ";
            result += convertThreeDigits(rest);
        }
        return result;
    }

    //890
    public String convertThreeDigits(int num) {
        //8
        int hundred = num / 100;
        //90
        int rest = num - hundred * 100;
        String res = "";
        if (hundred*rest != 0)
            res = convertOneDigit(hundred) + " Hundred " + convertTwoDigits(rest);
        else if ((hundred == 0) && (rest != 0))
            res = convertTwoDigits(rest);
        else if ((hundred != 0) && (rest == 0))
            res = convertOneDigit(hundred) + " Hundred";
        return res;
    }

    //90
    public String convertTwoDigits(int num) {
        if (num == 0)
            return "";
        else if (num < 10)
            return convertOneDigit(num);
        else if (num < 20)
            return twoLessThan20(num);
        else { //90
            //9
            int tenner = num / 10;
            //0
            int rest = num - tenner * 10;
            if (rest != 0)
                return convertTens(tenner) + " " + convertOneDigit(rest);
            else
                return convertTens(tenner);
        }
    }

    public String convertOneDigit(int num) {
        switch(num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            default:
                return "";
        }

    }

    public String twoLessThan20(int num) {
        switch(num) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
            default: return "";
        }
    }

    public String convertTens(int num) {
        switch(num) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
            default: return "";
        }
    }

}
