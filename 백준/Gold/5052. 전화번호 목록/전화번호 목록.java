import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Main {
	
	public static class Trie {
		class Node{
			HashMap<Character, Node> child;
			boolean end;
			
			public Node() {
				this.child = new HashMap<>();
				this.end = false;
			}
		}
		
	    Node root;
	    
	    public Trie(){
	        this.root = new Node();
	    }

	    public void insert(String str){
		    Node node = this.root;

		    for(int i = 0 ; i < str.length() ; i++){
		        char c = str.charAt(i);
		        node.child.putIfAbsent(c, new Node());
		        node = node.child.get(c);
		    }
		    node.end = true;
		}
	    
	    boolean search(String str) {
	    	Node node = this.root;

	        for(int i = 0 ; i < str.length() ; i++){
	            char c = str.charAt(i);
	            node = node.child.get(c);
	            if(node.end && i < str.length() - 1) {
	            	return false;
	            }
	        }
	        return true;
	    }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		loop:
		for(int ti = 0 ; ti < T ; ti++) {
			int N = Integer.parseInt(br.readLine());
			String[] calls = new String[N];
			Trie trie = new Trie();
			
			for(int i = 0 ; i < N ; i++) {
				calls[i] = br.readLine();
				trie.insert(calls[i]);
			}
			
			for(int i = 0 ; i < N ; i++) {
				boolean able = trie.search(calls[i]);
				if(!able) {
					System.out.println("NO");
					continue loop;
				}
			}
			System.out.println("YES");
		}
		
	}
}