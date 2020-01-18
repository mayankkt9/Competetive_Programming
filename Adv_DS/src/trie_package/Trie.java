package trie_package;

class TrieNode {
	public int countWord; // zero if word is not terminating there
	public TrieNode[] children = new TrieNode[26];

	public TrieNode() {
	}
}

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (current.children[c - 'a'] == null)
				current.children[c - 'a'] = new TrieNode();
			current = current.children[c - 'a'];
		}
		current.countWord += 1;
	}

	public boolean search(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (current.children[c - 'a'] == null)
				return false;
			current = current.children[c - 'a'];
		}
		return current.countWord >= 1 ? true : false;

	}

	public boolean startsWith(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (current.children[c - 'a'] == null)
				return false;
			current = current.children[c - 'a'];
		}
		return true;

	}

	public int getFrequency(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (current.children[c - 'a'] == null)
				return 0;
			current = current.children[c - 'a'];
		}
		return current.countWord;

	}

}
