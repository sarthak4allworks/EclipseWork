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
public class DeletionFromBinaryTree {
	Node root;
	DeletionFromBinaryTree()
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
		DeletionFromBinaryTree tree = new DeletionFromBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		System.out.println("Level OrderTraversal: ");
		tree.printLevelOrderTraversal();
		System.out.println("Level Order Traversal after deleting 2: ");
		tree.deleteNode(2);
		tree.printLevelOrderTraversal();
		System.out.println("Level Order Traversal after deleting 3: ");
		tree.deleteNode(3);
		tree.printLevelOrderTraversal();
		System.out.println("Level Order Traversal after deleting 5: ");
		tree.deleteNode(5);
		tree.printLevelOrderTraversal();
		System.out.println("Level Order Traversal after deleting 1: ");
		tree.deleteNode(1);
		tree.printLevelOrderTraversal();
		System.out.println("Level Order Traversal after deleting 4: ");
		tree.deleteNode(4);
		tree.printLevelOrderTraversal();
		System.out.println("Level Order Traversal after deleting 6: ");
		tree.deleteNode(6);
		tree.printLevelOrderTraversal();
		System.out.println("Level Order Traversal after deleting 7: ");
		tree.deleteNode(7);
		tree.printLevelOrderTraversal();
	}

	/**
	 * @param i
	 */
	private void deleteNode(int i) {
		if(root == null)
		{
			System.out.println("Tree is null ");
			return;
		}
		Node deleteNode = null;
		Node endNode = null;
		Queue<Node> qe = new LinkedList<>();
		qe.add(root);
		while(!qe.isEmpty())
		{
			Node tempNode = qe.poll();	
			if(tempNode.data == i)
			{
				deleteNode = tempNode;
			}
			if(tempNode.left!=null)
			{
				qe.add(tempNode.left);
			}
			if(tempNode.right!= null)
			{
				qe.add(tempNode.right);
			}
			endNode = tempNode;
		}
		int data = endNode.data;
		deleteDeepest(endNode);
		deleteNode.data = data;
	}

	/**
	 * @param endNode
	 */
	private void deleteDeepest(Node endNode) {
		if(root == null)
		{
			return;
		}
		Queue<Node> qe = new LinkedList<>();
		qe.add(root);
		while(!qe.isEmpty())
		{
			Node tempNode = qe.poll();
			if(tempNode.data == endNode.data)
			{
				root = null;
				return;
			}
			if(tempNode.left!=null)
			{
				if(tempNode.left.data == endNode.data)
				{
					tempNode.left = null;
					return;
				}
				else
				{
					qe.add(tempNode.left);
				}
			}
			if(tempNode.right != null)
			{
				if(tempNode.right.data == endNode.data)
				{
					tempNode.right = null;
					return;
				}
				else
				{
					qe.add(tempNode.right);
				}
			}
			
		}
	}

	/**
	 * 
	 */
	private void printLevelOrderTraversal() {
		if(root == null)
		{
			return;
		}
		Queue<Node> qe = new LinkedList<>();
		qe.add(root);
		while(!qe.isEmpty())
		{
			Node tempNode = qe.poll();
			System.out.print(tempNode.data+" ");
			if(tempNode.left != null)
			{
				qe.add(tempNode.left);
			}
			if(tempNode.right!=null)
			{
				qe.add(tempNode.right);
			}
		}
		System.out.println();
	}
}
