import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	int num;
	Node left;
	Node right;
	
	Node() {}
	
	Node(int num){
		this.num = num;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[n+1];
		
		for(int i = 0 ; i < n ; i++) {
			nodes[i] = new Node();
			nodes[i].num = 'A'+i;
		}
		
		for(int ni = 0 ; ni < n ; ni++) {
			st = new StringTokenizer(br.readLine());
			char pa = st.nextToken().charAt(0);
			char l = st.nextToken().charAt(0);
			char r = st.nextToken().charAt(0);
			
			if(l-'A' >= 0 && l-'A' < 26) {
				nodes[pa-'A'].left = nodes[l-'A'];
			}
			if(r-'A' >= 0 && r-'A' < 26) {
				nodes[pa-'A'].right = nodes[r-'A'];				
			}
		}
		
		preorder(nodes[0]);
		System.out.println();
		inorder(nodes[0]);
		System.out.println();
		postorder(nodes[0]);
	}
	
	public static void preorder(Node node) {
		if(node == null) {
			return;
		}
		
		System.out.print((char)(node.num));
		preorder(node.left);
		preorder(node.right);
	}
	
	public static void inorder(Node node) {
		if(node == null) {
			return;
		}
		
		inorder(node.left);
		System.out.print((char)(node.num));
		inorder(node.right);
	}
	
	public static void postorder(Node node) {
		if(node == null) {
			return;
		}
		
		postorder(node.left);
		postorder(node.right);
		System.out.print((char)(node.num));
	}
}
