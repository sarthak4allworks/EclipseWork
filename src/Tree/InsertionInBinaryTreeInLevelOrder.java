/**
 * 
 */
package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author sarthak agarwal
 *
 */
public class InsertionInBinaryTreeInLevelOrder {
	Node root;
	InsertionInBinaryTreeInLevelOrder()
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
		InsertionInBinaryTreeInLevelOrder tree = new InsertionInBinaryTreeInLevelOrder();
//		tree.root = new Node(1);
//		tree.root.left = new Node(2);
//		tree.root.left.right = new Node(4);
//		tree.root.left.left = new Node(3);
		System.out.println("Level order before Insertion: ");
		tree.printLevelOrderTraversal();
		tree.insert(5);
		System.out.println("Level order traversal after Insertion: ");
		tree.printLevelOrderTraversal();
	}

	/**
	 * @param i
	 */
	private void insert(int i)
	{
		if(root == null)
		{
			root = new Node(i);
			return;
		}
		Queue<Node> qe = new LinkedList<>();
		Node tempNode = root;
		while(tempNode != null)
		{
			qe.add(tempNode);
			if(tempNode.left != null)
			{
				qe.add(tempNode.left);
			}
			else
			{
				tempNode.left = new Node(i);
				break;
			}
			if(tempNode.right != null)
			{
				qe.add(tempNode.right);
			}
			else
			{
				tempNode.right = new Node(i);
				break;
			}
		}
	}

	/**
	 * 
	 */
	private void printLevelOrderTraversal() {
		printLevelOrder(root);
	}

	/**
	 * @param root
	 */
	private void printLevelOrder(Node root) {
		if(root == null)
		{
			return;
		}
		Queue<Node> stack = new LinkedList<>();
		stack.add(root);
		while(!stack.isEmpty())
		{
			Node tempNode = stack.poll();
			System.out.println(tempNode.data);
			if(tempNode.left != null)
			{
				stack.add(tempNode.left);
			}
			if(tempNode.right!=null)
			{
				stack.add(tempNode.right);
			}
		}
	}
}
