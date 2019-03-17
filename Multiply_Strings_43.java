/**
* Run through a example to find the relation
* i and j result put into i+j, i+j+1, and do in the order from right to left 
* bug1: switched i and j result in index out of bound
* bug2: 0 0 -> "" , need to check sb length ==0 case
*/
class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] nums = new int[m+n]; // enough space for the answer
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                int p1 = i+j, p2 = i+j+1;
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); // bug1: switched i and j result in index out of bound
                sum += nums[p2];
                nums[p1] += sum/10;
                nums[p2] = sum%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m+n; i++) {
            if (!(sb.length()==0 && nums[i] ==0)) {
                sb.append(nums[i]);
            }
        }
        return (sb.length() == 0)? "0":sb.toString(); // bug2: 0 0 -> "" , need to check sb length ==0 case
    }
}
