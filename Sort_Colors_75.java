/**
* method 1 
*  bug1: nums[r--] = 2; what is in the end are ignored, should use swap or (store and deal with it)
*  bug2: i <= r , wrote i < r, when i == r, r is not processed, so it need to be finished. 
*/
 
class Solution {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length-1;
        for (int i = 0; i < nums.length && i <= r; i++) {
            if (nums[i] == 0) {
                nums[l++] = 0;
            } else if (nums[i] == 2) {
                nums[i--] = nums[r]; // need the position to fill 2, so miss the number on that position to current and process it next round
                nums[r--] = 2;
            }
        }
        for (int i = l; i <= r; i++) {
            nums[i] = 1;
        }
        return;
    }
}


/**
* method 2, more like one pass, but sometimes each i need to do more than one operation
*/
 
class Solution {
    public void sortColors(int[] nums) {
        int zero = -1, one = -1, two = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[++two] = 2; nums[++one] = 1; nums[++zero] = 0;
            } else if (nums[i] == 1) {
                nums[++two] = 2; nums[++one] = 1;
            } else {
                nums[++two] = 2;
            }
        }
        return;
       
    }
}

/**
* method 3,swap 2 to right , swap 0 to left, so in the end all one in the middle (because used swap)
* bug1: 试图用for loop 去维护i不变的情况， 但是这样比较不好达成i < r 和 i > l 的检查， 而满足这个条件才有swap的价值
*/
 
class Solution {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        for (int i = 0; i <= r ; i++) { // r not processed
            /**bug
            if (nums[i] == 2) {
                swap(nums, i, r--); // swap 2 to right 
            } else if (nums[i] == 0) {
                swap(nums, i, l++); // swap 0 to left
            }
            // so in the end all one in the middle (because used swap)
            */ 
            
            //用while 保证i swap之后不变 ， 其实可以就for 但是用i-- <- 很容易出错
            // while (nums[i] == 2&& i < r) 
            while (nums[i] == 2 && i < r) {swap(nums, i, r--);} // i<r 所以还有swap的价值
            while (nums[i] == 0 && i > l) {swap(nums, i, l++);} 
        }
        return;
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
