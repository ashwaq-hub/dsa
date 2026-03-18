/**
 * Logic / Strategy : HashMap + Doubly Linked List Time: O(1) Space: O(capacity)
 */
public class LRUCache {
	private static class Node {
		int key, value;
		Node prev, next;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private Node head, tail;
	private HashMap<Integer, Node> map;
	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;
		Node node = map.get(key);
		remove(node);
		addHead(node);
		return node.value;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			remove(node);
			node.value = value;
			addHead(node);
		} else {
			Node node = new Node(key, value);
			addHead(node);
			map.put(key, node);
			if (map.size() > capacity) {
				Node nodeToRemove = tail.prev;
				remove(nodeToRemove);
				map.remove(nodeToRemove.key);
			}
		}
	}

	private void addHead(Node node) {
		node.prev = head;
		node.next = head.next;
		head.next.prev = node;
		head.next = node;
	}

	private void remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1)); // returns 1
		cache.put(3, 3); // evicts key 2
		System.out.println(cache.get(2)); // returns -1 (not found)
		cache.put(4, 4); // evicts key 3
		System.out.println(cache.get(3)); // returns -1 (not found)
		System.out.println(cache.get(4)); // returns 4
	}
}
