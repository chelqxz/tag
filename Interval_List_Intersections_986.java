/**
* methodology: two pointers
* bug1 : check if overlap, do !(not overlap)
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> ans = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < A.length && p2 < B.length) {
            Interval a = A[p1];
            Interval b = B[p2];
            if (overlap(a,b)) {
                ans.add(intersect(a,b));
            }
            if (a.end < b.end) p1++;
            else p2++;
        }
        
        Interval[] res = new Interval[ans.size()];
        int i = 0;
        for (Interval interval: ans) {
            res[i++] = interval;
        }
        return res;
    }
    
    public boolean overlap(Interval a, Interval b) {
        // if (a.end >= b.start || b.end >= a.start) return true; /// bug!!!!!
        if (!(a.end < b.start || b.end < a.start)) return true;// check if overlap, do !(not overlap)
        return false;
    }
    
    public Interval intersect(Interval a, Interval b) {
        return new Interval(Math.max(a.start, b.start), Math.min(a.end, b.end));
    }
}
