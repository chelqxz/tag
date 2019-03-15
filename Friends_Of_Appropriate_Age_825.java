/**
* !only thought of brute force solution, O(n^2)
* Idea: counting: if ages both 16, the same party + prefix sum
* 
* Clarify: It is a trick they use to trip you up during interviews to see if you're paying attention.
*          Redundant! age[B] > age[A] ; age[B] > 100 && age[A] < 100
*
* Solution: use an array to store number of people in age i, use another array to store number of people with age <= age i where i is the index in that array. so the array is of size 121. to compute the requests, note that the range for valid requests are (0.5*age + 7, age] , the formula is numInAge[i] * (sumInAge[hi] - sumInAge[lo]) - numInAge[hi].
* 
* Bug 1: int lo = (int) (0.5*i+7); wrote int lo =(int) 0.5*i + 7; //15, 7.5+7 -> 14 and 0.5 would be first cast to 0 result in being 7
* Bug 2: requests += numInAge[i] * (sumInAge[hi] - sumInAge[lo]) - numInAge[hi]; //
wrote requests += sumInAge[hi] - sumInAge[lo] - numInAge[hi]; sumInAge[hi] - sumInAge[lo] is for every          person in age hi
*/

class Solution {
    public int numFriendRequests(int[] ages) {
        int[] numInAge = new int[121]; // 1 - 120
        for (int age: ages) {
            numInAge[age] ++;
        }
        int[] sumInAge = new int[121]; // #people <= age i 
        for (int i = 1; i <= 120; i++) {
            sumInAge[i] = sumInAge[i-1] + numInAge[i]; 
            // System.out.println(sumInAge[i]);
        }
        int requests = 0;
        for (int i = 15; i <= 120; i++) { // not 14 because condition 1, 14 would not friend 14 (lo , hi]
            
            // int lo =(int) 0.5*i + 7; //15, 7.5+7 -> 14  bug 
            int lo = (int) (0.5*i+7);
            int hi = i;
            // System.out.println(lo + " "+ hi + " "+ sumInAge[lo]+ " "+ sumInAge[hi]+" "+ (sumInAge[hi] - sumInAge[lo] - numInAge[hi]));
            if (numInAge[i] != 0) 
                 // requests += sumInAge[hi] - sumInAge[lo] - numInAge[hi];// bug 
                requests += numInAge[i] * (sumInAge[hi] - sumInAge[lo]) - numInAge[hi];//not gonna friend itself 
        }
        return requests;
    }
}
