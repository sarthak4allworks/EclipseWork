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

class Node
{
	Node left, right;
	int data;
	Node(int data)
	{
		this.data = data;
		left=right=null;
	}
}

public class BinaryTreeTraversal {
	Node root;
	BinaryTreeTraversal()
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
		BinaryTreeTraversal bt = new BinaryTreeTraversal();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.left.left = new Node(12);
		bt.root.right = new Node(3);
		bt.root.right.left = new Node(4);
		System.out.println("pre order traversal: ");
		bt.printPreOrderTraversal();
		System.out.println("post order traversal: ");
		bt.printPostOrderTraversal();
		System.out.println("Inorder Traversal: ");
		bt.printInOrderTraversal();
		System.out.println("Level order traversal: ");
		bt.printLevelOrderTraversal();
		System.out.println("Level order traversal Two with o^n complexity: ");
		bt.printLevelOrderTraversalTwo();
	}

	/**
	 * 
	 */
	private void printLevelOrderTraversalTwo() {	// o(n^2) complexity
		int h = height(root);
		for(int i=1 ; i<=h ; i++)
		{
			printGivenLevel(root, i);
		}
	}

	/**
	 * @param root2
	 * @param i
	 */
	private void printGivenLevel(Node root2, int i) {
		if(root2 == null)
		{
			return;
		}
		if(i == 1)
		{
			System.out.println(root2.data);
		}
		else
		{
			printGivenLevel(root2.left, i-1);
			printGivenLevel(root2.right, i-1);
		}
	}

	/**
	 * @param root2
	 * @return
	 */
	private int height(Node root2) {
		if(root2 == null)
		{
			return 0;
		}
		else
		{
			int lheight = height(root2.left);
			int rheight = height(root2.right);
			if(lheight>rheight)
			{
				return lheight+1;
			}
			else
			{
				return rheight+1;
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
	 * @param root2
	 */
	private void printLevelOrder(Node root2) {
		Queue<Node> qe = new LinkedList<>();
		if(root2 == null)
		{
			return;
		}
		qe.add(root2);
		while(!qe.isEmpty())
		{
			Node tempNode = qe.poll();
			System.out.println(tempNode.data);
			if(tempNode.left != null)
			{
				qe.add(tempNode.left);
			}
			if(tempNode.right != null)
			{
				qe.add(tempNode.right);
			}
		}
	}

	/**
	 * 
	 */
	private void printInOrderTraversal() {
		printInOrder(root);
	}

	/**
	 * @param root2
	 */
	private void printInOrder(Node root2) {
		if(root2 == null)
		{
			return;
		}
		printInOrder(root2.left);
		System.out.println(root2.data);
		printInOrder(root2.right);
	}

	/**
	 * 
	 */
	private void printPostOrderTraversal() {
		printPostOrder(root);
	}

	/**
	 * @param root2
	 */
	private void printPostOrder(Node root2) {
		if(root2 == null)
		{
			return;
		}
		printPostOrder(root2.left);
		printPostOrder(root2.right);
		System.out.println(root2.data);
	}

	/**
	 * 
	 */
	private void printPreOrderTraversal() {
		printPreOrder(root);
	}

	/**
	 * @param root2
	 */
	private void printPreOrder(Node root2) {
		if(root2 == null)
		{
			return;
		}
		System.out.println(root2.data);
		printPreOrder(root2.left);
		printPreOrder(root2.right);
	}

}
