package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pankajtripathi
 * */
public class BinaryTreeWithBFS {
	Node root;

	BinaryTreeWithBFS(){
		root=null;
	}

	/**
	 * height method return height of the tree
	 * */
	int height(Node root){
		if(root == null)
			return 0;
		else{
			int lheight=height(root.left);
			int rheight=height(root.right);
			return lheight > rheight? lheight+1:rheight+1;
		}
	}

	/**Function to print level order traversal of tree
	 * printLevelorder(tree)
	 * for d = 1 to height(tree)
	 * printGivenLevel(tree, d);
	 **/
	void printLevelorder(){
		int h=height(root);
		for (int i = 1; i <= h; i++) printGivenLevel(root, i);
	}

	/**	Function to print all nodes at a given level
	 *  printGivenLevel(tree, level)
	 *  if tree is NULL then return;
	 *  if level is 1, then
	 *     print(tree->data); 
	 *     else if level greater than 1, then
	 *          printGivenLevel(tree->left, level-1);
	 *          printGivenLevel(tree->right, level-1);
	 **/
	void printGivenLevel(Node root,int level){
		if(root==null) return;
		if(level == 1) System.out.print(root.data+" ");
		if(level>1){
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
	}

	/**	printLevelorder(tree)
	 *	1) Create an empty queue q
	 *	2) temp_node = root start from root
	 *	3) Loop while temp_node is not NULL
	 *	    a) print temp_node->data.
	 *	    b) Enqueue temp_node’s children (first left then right children) to q
	 *	    c) Dequeue a node from q and assign it’s value to temp_node
	 **/
	void printLevelOrderWithQueue(){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while(!queue.isEmpty()){
			Node temp = queue.poll();
			System.out.print(temp.data+" ");
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
		}
	}

	/**
	 * Main method to test above methods
	 * */
	public static void main(String[] args) {
		BinaryTreeWithBFS tree=new BinaryTreeWithBFS();
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);

		System.out.println("Level Order traversal of binary tree is ");
		tree.printLevelorder();

		System.out.println("\nLevel Order traversal of binary tree using queue is ");
		tree.printLevelOrderWithQueue();
	}
}
