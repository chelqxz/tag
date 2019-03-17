/**
* structure
* main: billion, million, thousand, num, each three() + "..."
* three, one, two, twoUnder20, twoComplete
*/

class Solution {
    public String numberToWords(int n) {
        StringBuilder sb = new StringBuilder();
        if (n < 0) sb.append("Negative ");
        if (n == 0) return "Zero";
        // System.out.println(Integer.MIN_VALUE);
        // int billion
        long num = n;
        int billion = (int)(num/1000000000);
        num -= billion * 1000000000;
        int million = (int)(num/1000000);
        num  -= million * 1000000;
        int thousand = (int)(num/1000);
        num -= thousand * 1000;
        

        if (billion != 0) {
            sb.append(three(billion)).append(" Billion");
        }
        
        if (million != 0) {
            if (sb.length() != 0) sb.append(" ");
            sb.append(three(million)).append(" Million");
        }
        
        if (thousand != 0) {
            if (sb.length() != 0) sb.append(" ");
            sb.append(three(thousand)).append(" Thousand");
        }
        
        if (num != 0) {
            if (sb.length() != 0) sb.append(" ");
            sb.append(three((int)num)); 
        }
        
        return sb.toString();
    }
    
    public String three(int num) {
        if (num == 0) return "";
        int third = num/100; // 百位数
        int left = num%100;  // 两位数
        // 三种情况： 两个都不是0， 其中一个是0 * 2
        if (third * left != 0) // both not zero 
            return one(third) + " Hundred " + two(left);
        else if (third == 0)
            return two(left);
        else 
            return one(third) + " Hundred";
    }
    
    // deal with 两位数: 0, 一位数，十位数+个位数 （< 20 >=20
    public String two(int num) {
        if (num == 0) 
            return "";
        if (num < 10) 
            return one(num);
        if (num < 20)
            return tenUnder20(num);
        int tendigit = num/10;
        int left = num%10;
        if (left == 0) // 有多种情况的时候， 考虑那种在前面也可以很大程度的影响代码的简洁度
            return ten(tendigit);
        return ten(tendigit) + " " + one(left);
    }
    
    public String one(int num) {
        switch (num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }
    
    public String tenUnder20(int num) {
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
        }
        return "";
    }
    
    public String ten(int num) {
        switch(num) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        return "";
    }
}
