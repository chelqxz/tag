class Solution {
    int[] nums;
    Random rnd;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }
    
    public int pick(int target) {
        int result = -1;
        //At first, let's get clear that count is used to count the target number in nums. 
        //Say we now we have nums=[1,5,5,6,5,7,9,0] and the target is 5.


        int count = 0;
/**
Great idea! I was wondering if every index probability distributes equally. 
I did some math and looks like yes, all the indexes of the duplicate numbers 
have equal 1/n probability (where n is a number of duplicates). This is trivial 
for the last index, it's just 1/count. But what about the first one? At first 
try, the first index will be selected with a probability of 100%, but what's 
next? Let's try to multiply 1 * (1 - 1/2) * (1 - 1/3) * (1 - 1/4) * ... * (1 - 1/n) 
= 1 * 1/2 * 2/3 * 3/4 * ... * n-1/n = (n - 1)! / n! = 1 / n
*/
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (rnd.nextInt(++count) == 0)
                result = i;
        }
        
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
