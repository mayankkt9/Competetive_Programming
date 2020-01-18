//package trie_package;
//
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class LC_211_Add_Search_Word {
//	public static void main(String[] args) {
//		WordDictionary word = new WordDictionary();
////		word.addWord("bad");
////		word.addWord("dad");
////		word.addWord("mad");
////		System.out.println(word.search("pad"));
////		System.out.println(word.search("bad"));
////		System.out.println(word.search(".ad"));
////		System.out.println(word.search("b.."));
//
////		word.addWord("a");
////		word.addWord("a");
////
////		System.out.println(word.search("."));
////		System.out.println(word.search("a"));
////		System.out.println(word.search("aa"));
////		System.out.println(word.search("a"));
////		System.out.println(word.search(".a"));
////		System.out.println(word.search("a."));
//		
//		
//		word.addWord("at");
//		word.addWord("and");
//		word.addWord("an");
//		word.addWord("add");
//		System.out.println(word.search("a"));
//		System.out.println(word.search(".at"));
//		word.addWord("bat");
//		System.out.println(word.search(".at"));
//		System.out.println(word.search("an."));
//		System.out.println(word.search("a.d."));
//		System.out.println(word.search("b."));
//		System.out.println(word.search("a.d"));
//		System.out.println(word.search("."));
//	}
//}
//
//class TrieNode {
//	boolean isWord;
//	TrieNode[] children = new TrieNode[26];
//
//	TrieNode() {
//	}
//}
//
//class WordDictionary {
//	TrieNode root;
//
//	/** Initialize your data structure here. */
//	public WordDictionary() {
//		root = new TrieNode();
//	}
//
//	/** Adds a word into the data structure. */
//	public void addWord(String word) {
//		TrieNode current = root;
//		for (int i = 0; i < word.length(); i++) {
//			char c = word.charAt(i);
//			if (current.children[c - 'a'] == null)
//				current.children[c - 'a'] = new TrieNode();
//			current = current.children[c - 'a'];
//		}
//		current.isWord = true;
//	}
//
//	/**
//	 * Returns if the word is in the data structure. A word could contain the dot
//	 * character '.' to represent any one letter.
//	 */
//	public boolean search(String word) {
//		if (word.length() == 0)
//			return false;
//		TrieNode current = root;
//		Queue<TrieNode> q = new LinkedList<TrieNode>();
//		List<TrieNode> child = getChild(current, word.charAt(0));
//		if (child == null)
//			return false;
//		q.addAll(child);
//
//		int i = 0;
//		if (word.length() == 1) {
//			if (word.charAt(0) != '.') {
//				if (root.children[word.charAt(0) - 'a'] != null && root.children[word.charAt(0) - 'a'].isWord == true)
//					return true;
//			} else {
//				for (int k = 0; k <= 25; k++) {
//					if (root != null && root.children[k] != null && root.children[k].isWord == true)
//						return true;
//				}
//			}
//		}
//		i = 1;
//		int ans = 0;
//		while (!q.isEmpty()) {
//			// TrieNode curr = q.poll();
//			int n = q.size();
//			int flag = 0;
//			if (i >= word.length())
//				break;
//			if (word.charAt(i) == '.') {
//				for (int j = 0; j < n; j++) {
//					TrieNode temp = q.poll();
//					q.addAll(getChild(temp, word.charAt(i)));
//					if (i == word.length() - 1) {
//						for (int k = 0; k <= 25; k++)
//							if (temp.children[k] != null && temp.children[k].isWord==true) {
//								ans = 1;
//								return true;
//							}
//					}
//				}
//				flag = 1;
//
//			} else {
//				for (int j = 0; j < n; j++) {
//					TrieNode temp = q.poll();
//					if (temp.children[word.charAt(i) - 'a'] != null) {
//						q.add(temp.children[word.charAt(i) - 'a']);
//						flag = 1;
//					}
//					if (i == word.length() - 1 && temp!=null && temp.children[word.charAt(i)-'a']!=null && temp.children[word.charAt(i) - 'a'].isWord == true) {
//						ans = 1;
//						return true;
//					}
//				}
//			}
//			if (flag == 0)
//				return false;
//
//			i++;
//		}
//		return false;
//
//	}
//
//	public List<TrieNode> getChild(TrieNode current, char c) {
//		List<TrieNode> list = new LinkedList<>();
//		if (c != '.') {
//			if (current.children[c - 'a'] != null)
//				list.add(current.children[c - 'a']);
//			else
//				return null;
//			return list;
//		}
//		for (int i = 0; i <= 25; i++) {
//			if (current.children[i] != null)
//				list.add(current.children[i]);
//		}
//		return list;
//
//	}
//}
//
///**
// * Your WordDictionary object will be instantiated and called as such:
// * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
// * = obj.search(word);
// */