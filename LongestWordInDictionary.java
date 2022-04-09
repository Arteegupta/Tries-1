//Time Complexity: O(n.k); where n is number of words in dictionary and k is length of a word. 
//Space Complexity: O(n.k)
public class LongestWordInDictionary {	
	/**Approach1: Trie + DFS + Backtracking| Time  | Space O(n.k) ; **/
	class TrieNode{
        boolean isEnd;
        char ch;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];            
        }
    }
    private void insert(String word){
        TrieNode curr= root;
        for(char c: word.toCharArray()){            
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new TrieNode();
            }
            curr= curr.children[c-'a'];
            curr.ch=c;
        }        
        curr.isEnd=true;
    }
        
    TrieNode root;
    String res;
    public String longestWord(String[] words) {
        root= new TrieNode();
        res= "";
        //Insert all words in Trie
        for(String word: words){ //O(n)
            insert(word); //O(k)
        }                
        dfs(root, new StringBuilder());       
        return res;
    }
    private void dfs(TrieNode curr, StringBuilder path){
        //base
        if(path.length() > res.length()){
            res=path.toString();
        }
        
        //logic
        for(int i=0; i<26; i++){            
            if(curr.children[i]!=null && curr.children[i].isEnd){ 
            	//action
                path.append(curr.children[i].ch);  
                //recurse
                dfs(curr.children[i], path);  
                //backtrack
                path.setLength(path.length()-1); 
            }
        }
    }	
	
	// Driver code to test above 
	public static void main (String[] args) {
		LongestWordInDictionary ob= new LongestWordInDictionary();
		String[] words= {"a","banana","app","appl","ap","apply","apple"};
		
    	System.out.println("Longest word in dictionary: "+ ob.longestWord(words));
	}
}
