import java.util.Scanner;
import java.util.HashMap;

public class ContactTrie {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Trie trie = new Trie();
		for (int i = 0; i < n; i++) {
			String operation = scan.next();
			String contact   = scan.next();
			if (operation.equals("add")) {
				trie.add(contact);
			} else if (operation.equals("find")) {
				System.out.println(trie.find(contact));
			}
		}
		scan.close();
	}
}

class TrieNode {
	private HashMap<Character, TrieNode> node = new HashMap<>();
	public int size;

	public void add(char ch) {
		node.putIfAbsent(ch, new TrieNode());
	}

	public TrieNode find(char ch) {
		return node.get(ch);
	}
}

class Trie {
	TrieNode root = new TrieNode();

	public Trie() {
	}

	public Trie(String[] names) {
		for (String name : names) {
			add(name);
		}
	}

	public void add(String name) {
		TrieNode cur = root;
		for (int i=0; i<name.length(); i++) {
			Character ch = name.charAt(i);
			cur.add(ch);
			cur = cur.find(ch);
			cur.size++;
		}
	}

	public int find(String name) {
		TrieNode cur = root;

		for (int i=0; i<name.length(); i++) {
			Character ch = name.charAt(i);
			cur = cur.find(ch);
			if (cur == null) {
				return 0;
			}
		}
		return cur.size;
	}
}
