import java.util.HashMap;

public class LFUCache {

    HashMap<Integer,Node> cache = new HashMap();
    HashMap<Integer,DoublyLinkedList> freqMap = new HashMap();
    int minFreq ;
    int currSize;
    int capacity;
    LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq=0;
        this.currSize=0;
    }

    int get(int key) {
        Node node = cache.get(key);
        if(node==null)
            return -1;
        update(node);
        return node.value;
    }

    void put(int key, int value) {
        if(capacity==0)
            return;
        if(cache.containsKey(key))
        {
            Node node = cache.get(key);
            node.value = value;
            update(node);
        }
        else
        {
            currSize++;
            if(currSize>capacity)
            {
                DoublyLinkedList doublyLinkedList = freqMap.getOrDefault(1, new DoublyLinkedList());
                cache.remove(doublyLinkedList.tail.prev.key);
                doublyLinkedList.removeNode(doublyLinkedList.tail.prev);
                currSize--;
            }
            minFreq=1;
            Node node1 = new Node(key,value);
            cache.put(key, node1);
            DoublyLinkedList doublyLinkedList = freqMap.getOrDefault(minFreq, new DoublyLinkedList());
            doublyLinkedList.addNode(node1);
            freqMap.put(1,doublyLinkedList);
        }
    }
    
    
    void update(Node node)
    {
        int frequency = node.freq;
        DoublyLinkedList doublyLinkedList = freqMap.get(frequency);
        doublyLinkedList.removeNode(node);
        if(doublyLinkedList.listSize==0 && frequency==minFreq )
            minFreq++;
        node.freq++;
        DoublyLinkedList doublyLinkedList2 = freqMap.getOrDefault(node.freq,new DoublyLinkedList());
        doublyLinkedList.addNode(node);
        freqMap.put(node.freq, doublyLinkedList2);
            
    }
    
    
    class Node
    {
        int key;
        int value;
        int freq;
        Node next;
        Node prev;
        
        Node(int key,int value)
        {
            this.key = key;
            this.value = value;
            this.freq=1;
        }
    }
    
    class DoublyLinkedList
    {
        int listSize;
        Node head;
        Node tail;
        
        DoublyLinkedList()
        {
            this.listSize = 0;
            this.head = new Node(0,0);
            this.tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }
        
        public void addNode(Node node)
        {
            node.next = head.next;
            node.prev =head;
            node.next.prev =node;
            head.next = node;
            listSize++;
        }
        
        public void removeNode(Node node)
        {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            listSize--;
        }
        
    }
    }