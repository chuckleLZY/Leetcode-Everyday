class LRUCache {
    private LinkedList<Integer> Cache;
    private HashMap<Integer,Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
        Cache = new LinkedList<Integer>();
        map = new HashMap<Integer,Integer>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(Cache.contains(key)){
            Cache.remove((Integer)key);
            Cache.add(key);
            return (int)map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(Cache.contains(key)){
            Cache.remove((Integer)key);
            Cache.add(key);
            map.put(key, value);
            return;
        }
        if(Cache.size() == capacity){
            Cache.remove(0);
        }
        Cache.add(key);
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */