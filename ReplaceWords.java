import java.util.Arrays;
import java.util.List;

//Time Complexity: O(n.k + m.l)
//Space Complexity: O(n.k + m.l) ; where 
/*	n= Total number of words in dictionary
  	k= Average length of a word in dictionary
  	m= Total number of words in sentence
  	l= Average length of a word in sentence */
public class ReplaceWords {	
	/**Approach: Using Trie**/
	class TrieNode{
        boolean isEnd;        
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
        }        
        curr.isEnd=true;
    }
    
    TrieNode root;    
    public String replaceWords(List<String> dictionary, String sentence) {
        root=new TrieNode();   
        //insert dictionary words in Trie
        for(String word: dictionary){//O(n)
            insert(word);//O(k)
        }
        
        //Compress the sentence
        StringBuilder res= new StringBuilder();
        String[] strArr= sentence.split(" ");
        
        for(String word: strArr){//O(m)
            //find the replacement
            TrieNode curr=root;
            StringBuilder replacement= new StringBuilder();            
            for(char c: word.toCharArray()){//O(l)
                if(curr.isEnd || curr.children[c-'a']==null) break;
                replacement.append(c);
                curr= curr.children[c-'a'];                
            }  
            //Add final word to compressed sentence
            if(curr.isEnd){
                res.append(replacement);
            }else{
                res.append(word);
            }
            res.append(" ");
        }
        
        return res.toString().trim();
    }
	
	// Driver code to test above 
	public static void main (String[] args) {
		ReplaceWords ob= new ReplaceWords();
		String[] dictionary= {"cat","bat","rat"};
		String sentence="the cattle was rattled by the battery";
		
    	System.out.println("Sentence after replacement is: "+ ob.replaceWords(Arrays.asList(dictionary), sentence));
	}
}
