package tree;

public class BinaryTreeWithDFS {
	Node root;

	BinaryTreeWithDFS(){
		root=null;
	}

	/**
	 * traverse order is L-N-R
	 * */
	void inorder(Node node){
		if (node == null) return;
		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);	
	}

	/**
	 * traverse order is N-L-R
	 * */
	void preorder(Node node){
		if (node == null) return;
		System.out.print(node.data+" ");
		preorder(node.left);
		preorder(node.right);	
	}

	/**
	 * traverse order is L-R-N
	 * */
	void postorder(Node node){
		if (node == null) return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data+" ");	
	}

	void printInOrder(){inorder(root);}
	void printPreOrder(){preorder(root);}
	void printPostOrder(){postorder(root);}

	/**
	 * Main method to test above methods
	 * */
	public static void main(String[] args) {
		BinaryTreeWithDFS tree=new BinaryTreeWithDFS();
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);

		System.out.println("Inorder traversal of binary tree is ");
		tree.printInOrder();

		System.out.println("\nPreorder traversal of binary tree is ");
		tree.printPreOrder();

		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printPostOrder();
	}
}
