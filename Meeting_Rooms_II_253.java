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
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, (a,b) -> a.start - b.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int numRoom = 0;
        for (Interval interval : intervals) {
            if (!pq.isEmpty() && interval.start >= pq.peek()) {
                pq.poll();
            } else {
                numRoom++;
            }
            pq.offer(interval.end);
        }
        return numRoom;
    }
    
}
