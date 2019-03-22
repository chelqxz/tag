class Solution {
    public String addBinary(String a, String b) {
        int base = 2;
        char[] arr = a.toCharArray(); 
        char[] brr = b.toCharArray();
        int aptr = arr.length - 1;
        int bptr = brr.length - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (aptr >= 0 || bptr >= 0) { // or
            int adigit = (aptr >= 0) ? arr[aptr] - '0' : 0;
            int bdigit = (bptr >= 0) ? brr[bptr] - '0': 0;
            sb.append((adigit+bdigit+carry)%base);
            carry = (adigit+bdigit+carry)/base;
            aptr--;
            bptr--;
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
    // 11 , 1
    // aptr -1
    // bptr -2
    // carry 1
    // sb : 0 0 1
    // adigit : 1
    // bdigit: 0
}
