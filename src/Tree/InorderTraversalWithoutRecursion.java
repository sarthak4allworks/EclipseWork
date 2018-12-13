/**
 * 
 */
package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author sarthak agarwal
 *
 */
public class InorderTraversalWithoutRecursion {
	Node root;
	InorderTraversalWithoutRecursion()
	{
		root = null;
	}
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Start...");
		InorderTraversalWithoutRecursion itwr = new InorderTraversalWithoutRecursion();
		itwr.root = new Node(1);
		itwr.root.left = new Node(2);
		itwr.root.right = new Node(3);
		itwr.root.left.left = new Node(4);
		itwr.root.right.right = new Node(5);
		System.out.println("Print Inorder Traversal: ");
		itwr.printInorderTraversalWithoutRecursion();
	}

	/**
	 * 
	 */
	private void printInorderTraversalWithoutRecursion() {
		Stack<Node> s = new Stack<>();
		Node current = root;
		while(current != null || !s.isEmpty())
		{
			while(current != null)
			{
				s.push(current);
				current = current.left;
			}
			current = s.pop();
			System.out.println(current.data);
			current = current.right;
		}
	}
}
