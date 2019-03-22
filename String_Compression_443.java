class Solution {
    public int compress(char[] chars) {
        int indexAns = 0, index = 0;
        while(index < chars.length){ // end scenario
            char cur = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == cur){// while so would not miss the last count and say 
                index++;
                count++;
            }
            chars[indexAns++] = cur; 
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray())  // use method like this. if not know the exact syntax assume having such a function
                    chars[indexAns++] = c;
        }
        return indexAns;
    }
}
