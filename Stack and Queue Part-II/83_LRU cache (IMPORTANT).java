import java.util.HashMap;

public class LRUCache
{
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    HashMap<Integer,Node> map = new HashMap();
    int capacity;
    LRUCache(int capacity)
    {
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key)
    {
        if(!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        remove(node);
        insert(node.key,node.data);
        return node.data;
    }

    public void put(int key, int value)
    {
        if(map.containsKey(key))
            remove(map.get(key));
        if(map.size()==capacity)
            remove(tail.prev);
        insert(key, value);
            
    }
  
    public void insert(int key,int value)
    {
        Node node = new Node(key,value);
          map.put(key,node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev =head;
    }
    
    public void remove(Node node)
    {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
   
    class Node
    {
        int key;
        int data;
        Node prev;
        Node next;
        
        Node(int key,int data)
        {
            this.key = key;
            this.data = data;
        }

    }
}