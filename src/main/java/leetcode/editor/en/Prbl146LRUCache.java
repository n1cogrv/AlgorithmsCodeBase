package leetcode.editor.en;

import xyz.mijazz.leetcode.utils.MyMath;

import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Stream;

//2021-04-10 14:27:05
//java: LRU Cache
//QuestionId: 146
public class Prbl146LRUCache {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        Prbl146LRUCache prbl146LRUCache = new Prbl146LRUCache();
        LRUCache instance = prbl146LRUCache.new LRUCache(3);
        Stream.of(1, 2, 3, 4, 5).forEach(
                key ->
                {
                    instance.put(key, MyMath.randomInt(1, 1_000));
                    Optional optional = Optional.ofNullable(instance.get(MyMath.randomInt(1, 3)));
                    optional.ifPresent(System.out::println);
                }
        );
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        private final NodeEntry head = new NodeEntry(Integer.MAX_VALUE, Integer.MAX_VALUE);

        private class NodeEntry {
            int key;
            int value;
            NodeEntry next;

            NodeEntry() {
            }

            NodeEntry(int key, int value) {
                this.key = key;
                this.value = value;
            }

            NodeEntry(int key, int value, NodeEntry next) {
                this.key = key;
                this.value = value;
                this.next = next;
            }
        }

        private final int CAPACITY;
        private int size;

        public LRUCache(int capacity) {
            this.CAPACITY = capacity;
            this.size = 0;
        }

        public int get(int key) {
            if (null == head.next) {
                // Never Put anything in it
                return -1;
            }
            NodeEntry curr = head.next;
            NodeEntry curr_prev = head;
            do {
                if (curr.key == key) {
                    int valToBeReturn = curr.value;
                    curr_prev.next = curr.next;
                    size--;
                    put(key, valToBeReturn);
                    return valToBeReturn;
                }
                curr_prev = curr;
                curr = curr.next;
            } while (curr != null);
//            if (curr.key == key) {
//                return curr.value;
//            }
            return -1;
        }

        public void put(int key, int value) {
            if (get(key) != -1) {
                NodeEntry curr = this.head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.value = value;
                return;
            }
            NodeEntry toBePut = new NodeEntry(key, value, null);
            NodeEntry curr = this.head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = toBePut;
            size++;
            if (size > CAPACITY) {
                this.head.next = this.head.next.next;
                size--;
//                logger.warning("Trigger auto-sizing");
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}

//Design a data structure that follows the constraints of a Least Recently Used 
//(LRU) cache. 
//
// Implement the LRUCache class: 
//
// 
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity. 
//
// int get(int key) Return the value of the key if the key exists, otherwise ret
//urn -1. 
// void put(int key, int value) Update the value of the key if the key exists. O
//therwise, add the key-value pair to the cache. If the number of keys exceeds the
// capacity from this operation, evict the least recently used key. 
// 
//
// Follow up: 
//Could you do get and put in O(1) time complexity? 
//
// 
// Example 1: 
//
// 
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// At most 3 * 104 calls will be made to get and put. 
// 
// Related Topics Design 
// 👍 8202 👎 336
