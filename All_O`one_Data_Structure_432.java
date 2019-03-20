/**
* double linked list + hashmap
*/
class AllOne {
    Bucket head, tail;
    HashMap<Integer, Bucket> countBucketMap;
    HashMap<String, Integer> keyCountMap;
    /** Initialize your data structure here. */
    public AllOne() {
        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        countBucketMap = new HashMap<>();
        keyCountMap = new HashMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (keyCountMap.containsKey(key)) {
            changeKey(key, 1);
        } else {
            keyCountMap.put(key, 1);
            if (head.next.count != 1)
                addBucketAfter(new Bucket(1), head);
            head.next.set.add(key);
            countBucketMap.put(1, head.next);// 一个count对应一个bucket
        }
    }
    public void changeKey(String key, int offset) {
        int cnt = keyCountMap.get(key);
        Bucket bucket = countBucketMap.get(cnt);
        keyCountMap.put(key, cnt + offset); // update keyCountMap
        Bucket newBucket;
        if (countBucketMap.containsKey(cnt + offset)) {
            newBucket =  countBucketMap.get(cnt + offset);
        }else {
            newBucket = new Bucket(cnt+offset);
            if (offset == 1) 
                addBucketAfter(newBucket, bucket);
            else
                addBucketAfter(newBucket, bucket.prev);
            countBucketMap.put(cnt+offset, newBucket);
        }
        newBucket.set.add(key);
        removeKeyFromBucket(key, bucket);
        
    }
    
    public void removeKeyFromBucket(String key, Bucket bucket) {
        bucket.set.remove(key);
        if (bucket.set.size() == 0) {
            countBucketMap.remove(bucket.count);
            removeBucket(bucket);
        }
    }
    
    public void addBucketAfter(Bucket cur, Bucket prev) {
        cur.next = prev.next;
        prev.next.prev = cur;
        cur.prev = prev;
        prev.next = cur;
    }
    public void removeBucket(Bucket bucket) {
        bucket.prev.next = bucket.next;
        bucket.next.prev = bucket.prev;
        bucket.next = null;
        bucket.prev = null;
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (keyCountMap.containsKey(key)) {
            int cnt = keyCountMap.get(key);
            if (cnt == 1) {
                removeKeyFromBucket(key, countBucketMap.get(cnt));
                keyCountMap.remove(key);
            } else {
                changeKey(key, -1);
            }
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return (tail.prev == head) ? "" : tail.prev.set.iterator().next(); //学到了！ 怎么从set里面要任意一个entry
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return (head.next == tail) ? "" : head.next.set.iterator().next();
    }
    
    class Bucket {
        int count;
        HashSet<String> set;
        Bucket next;
        Bucket prev; // double linked list
        
        public Bucket(int count) {
            this.count = count;
            set = new HashSet<>();
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
