//package trie_package;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class LC_720_Trie_BFS {
//
//}
//
//
//class Solution {
//    public String longestWord(String[] words) {
//        Trie obj = new Trie();
//        for(String w : words)
//            obj.insert(w);
//        return obj.bfs();
//    }
//}
//
//
//class TrieNode{
//    String word;
//    TrieNode children[] = new TrieNode[26];
//    boolean isWord;
//    TrieNode(){
//    }
//}
//
//class Trie{
//    TrieNode root;
//    Trie(){
//        root=new TrieNode();
//    }
//    
//    public void insert(String word){
//        TrieNode current = root;
//        for(int i=0;i<word.length();i++){    
//            if(current.children[word.charAt(i)-'a']==null)
//                current.children[word.charAt(i)-'a'] = new TrieNode();
//            current = current.children[word.charAt(i)-'a'];
//        }
//        current.isWord = true;
//        current.word=word;
//    }
//    
//    public String bfs(){
//        TrieNode current = root;
//        Queue<TrieNode> q = new LinkedList<>();
//        q.add(current);
//        String result="";
//        while(!q.isEmpty()){
//            int n = q.size();
//            for(int i=0;i<n;i++){
//                TrieNode temp = q.poll();
//                for(int j=25;j>=0;j--){
//                    if(temp.children[j]!=null && temp.children[j].isWord){
//                        result = temp.children[j].word;
//                        q.offer(temp.children[j]);
//                    }
//                }
//            }
//        }
//        return result;
//    }
//    
//    
//}