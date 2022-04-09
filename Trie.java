//Time Complexity: O(L); where L is length of the word
//Space Complexity: O(L)
public class Trie {	
	class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
           children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    public Trie() {
        root= new TrieNode();        
    }
    
    public void insert(String word) { //Time O(L) | Space O(L)
        TrieNode curr= root;
        for(int i=0; i<word.length(); i++){
            char c= word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a']= new TrieNode();                
            }
            curr= curr.children[c-'a'];
        }
        curr.isEnd=true;
    }
    
    public boolean search(String word) { //Time O(L) | Space O(1)
        TrieNode curr= root;
        for(int i=0; i<word.length(); i++){
            char c= word.charAt(i);
            if(curr.children[c-'a'] == null) return false;
            curr= curr.children[c-'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) { //Time O(L) | Space O(1)
        TrieNode curr= root;
        for(int i=0; i<prefix.length(); i++){
            char c= prefix.charAt(i);
            if(curr.children[c-'a'] == null) return false;
            curr= curr.children[c-'a'];
        }
        return true;
    }
	
	// Driver code to test above 
	public static void main (String[] args) {
		Trie ob = new Trie();
    	ob.insert("apple");
    	System.out.println("Found word apple: "+ ob.search("apple"));
    	System.out.println("Found word app: "+ ob.search("app"));
    	System.out.println("Found prefix app: "+ ob.startsWith("app"));
    	ob.insert("app");
    	System.out.println("Found word app: "+ ob.search("app"));
	}
}
