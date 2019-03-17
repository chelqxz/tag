/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */

/**
* pass at first try, all sol by myself, nice
* this question tricky at the end part.
*/
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    
    String buffer = "";
    public int read(char[] buf, int n) {
        // System.out.println(buffer);
        boolean eof = false;
        int total = 0;
        // deal with buffer
        if (buffer.length()!=0) {
            int cnt = Math.min(n, buffer.length());
            for (int i = 0; i < cnt; i++) {
                buf[total++] = buffer.charAt(i); // can be improved
            }
            if (cnt < buffer.length()) {
                buffer = buffer.substring(cnt);
                return cnt;
            } else {
                buffer = "";
            }
        }
        
        int cnt = 0;
        int cur = 0;
        char[] tmp = new char[4];
        while (total < n && !eof) { // same idead of read n with no multiple calls 
            // System.out.println("stage2 " + buffer);
            cnt = read4(tmp);
            eof = (cnt < 4);
            cur = Math.min(cnt, n-total);
            for (int i = 0; i< cur;i++) {
                buf[total++] =  tmp[i];
            }
        }
        // update buffer in the end if necessary 
        if (cur < cnt) { //  bug2  wrote cnt < cnt
            for (int i = cur; i< cnt; i++) {
                buffer += tmp[i]; //  bug1 tmp[i] wrote tmp[cur]
            }
        }
        return total;
    }
}
