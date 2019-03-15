/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
/**
* 难点： 思路
*/
// discussion: thoughts
//the moment you realize a call to knows(i,j) eliminates either i or j the problem is solved. knows(i,j) == true then i can't be a celeb. since a celeb knows nobody and knows(i,j) == false then j can't be a celeb since everyone must know the celeb.

//The key part is the first loop. To understand this you can think the knows(a,b) as a a < b comparison, if a knows b then a < b, if a does not know b, a > b. Then if there is a celebrity, he/she must be the "maximum" of the n people.
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(candidate, i)) { // candidate < i
                candidate = i; // candidate the max
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != candidate && knows(candidate, i)) { //candidate knows anyone (except self)
                return -1;
            }
            if (!knows(i, candidate)) { // if any one does not know candidate
                return -1;
            }
        }
        return candidate;
    }
}
