
/**
 * The AVL Tree class manages a tree that must be
 * kept height balanced.
 * 
 * @author Christopher Kinney
 */
public class AVLTree {
	//attributes
	public AVLNode root;    //self-explanatory, the root of the tree
	private AVLNode searchComp = null;     //saves the last existing node in a search
	private int nodes;
	
	//Constructor that generates a new tree
	public AVLTree(Comparable obj) {
		root = new AVLNode(obj);
		nodes++;
	}
	
	//Constructor that designates a tree starting from a given node
	
	
	//Traverses the tree searching for a matching case
	public boolean search(Comparable o) {
		//checks if the root contains data
		if(root.data == null && o != null) {   //and that the object exists
			return false;
		} else {                //otherwise we go here
			AVLNode check = searchUtil(o, root);   //utilizes the searchUtil to parse through the tree
			if(check == null) {     //no match was found
				return false;
			} else {        //Otherwise a match was found
				return true;
			}
		}
	}
	
	//A utility for parsing through a tree
	private AVLNode searchUtil(Comparable o, AVLNode pres) {
		//Object to be returned
		AVLNode returnNode = null;    //null by default in case no match is found
		boolean returnable = false; //manages condition of search
		
		//handles current position in the tree
		AVLNode cur = pres;
		int compared = 666;  //holds the result of compareTo
		while(!returnable && cur != null && (cur.leftNode != null && cur.rightNode != null)) {
			//handles value checking
			switch(o.compareTo(cur.data)) {
			case -1: returnable = false;      //less than
				compared = -1;
				break;
			case 0: returnable = true;        //equal to
				compared = 0;
				break;
			case 1: returnable = false;       //greater than
				compared = 1;
				break;
			}
			
			//Saves the last existing node in the search
			searchComp = cur; //bypasses return data only allowing matches
			
			//recursively parses through the tree while no match is found
			if(compared == -1) {    //goes to the left child
				searchUtil(o, cur.leftNode);
			} else if(compared == 1) {    //goes to the right child
				searchUtil(o, cur.rightNode);
			} else if(compared == 0){    
				returnNode = cur;     //sets cur to the returned if it matches
			}
		}
		return returnNode;
	}
	
	//Inserts an object into the tree at the appropriate position
	public AVLTree insert(AVLTree tree, Comparable o) {
		//The return tree
		AVLTree returnTree = tree;
		//Uses the search utility to find a matching case
		AVLNode checkable = searchUtil(o, returnTree.root);
		
		//Inserts the new node at the appropriate location
		if(checkable != null && searchComp != null) {   //prevents object duplication
			switch(o.compareTo(searchComp.data)) {
			case -1: searchComp.leftNode = new AVLNode(o);      //assigns a new node to the left node
				searchComp.leftNode.parent = searchComp;    //designates the new node's parent
				break;
			case 1: searchComp.rightNode = new AVLNode(o);      //assigns a new node to the right node
				searchComp.rightNode.parent = searchComp;   //designates the new node's parent
				break;
			}
		}
		nodes++;
		return returnTree;
	}
	
	//
	public AVLTree delete(AVLTree tree, Comparable o) {
		//The return tree
		AVLTree returnTree = tree;
		//Uses the search utility to find a matching case
		AVLNode removable = searchUtil(o, returnTree.root);
		//Checks to see if a match was found at all
		if(removable != null) {
			//Removes the removable
			if(removable.parent != null) {     //the case where it is not the root
				//Assigns new parents to orphaned nodes if children exist
				if(!(removable.leftNode == null && removable.rightNode == null)) {
					//The case where only a right child exists
					if(removable.leftNode == null && removable.rightNode != null) {
						insert(returnTree, removable.rightNode.data);
						nodes--;    //accounts for pre-existing node
					}
					
					//The case where only a left child exists
					if(removable.leftNode != null && removable.rightNode == null) {
						insert(returnTree, removable.leftNode.data);
						nodes--;    //accounts for pre-existing node
					}
					
					//The case where both a left and right child exist
					if(removable.leftNode != null && removable.rightNode != null) {
						insert(returnTree, removable.rightNode.data);
						insert(returnTree, removable.leftNode.data);
						nodes -= 2;   //accounts for pre-existing nodes
					}
					
				}
				
				//The actual removing
				AVLNode formerParent = removable.parent;
				switch(formerParent.data.compareTo(removable.data)) {
				case -1: formerParent.leftNode = null;
					break;
				case 1: formerParent.rightNode = null;
					break;
				}
			} else {       //the case where it is the root
				//The case where only a left child exists
				if(removable.leftNode != null && removable.rightNode == null) {
					returnTree.root = removable.leftNode;    //the left orphan is now the root
				}
				
				//The case where only a right child exists
				if(removable.leftNode == null && removable.rightNode != null) {
					returnTree.root = removable.rightNode;   //the right orphan is now the root
				}
				
				//The case where both a left and right child exists
				if(removable.leftNode != null && removable.rightNode != null) {
					returnTree.root = removable.rightNode;     //the right orphan is now the root
					insert(returnTree, removable.leftNode.data);     //inserts the left orphan at the appropriate place
				}
				
				//The actual removing
				removable = null;    //If there are no children you now have an empty tree, congratulations
			}
		}
		return returnTree;
	}
	
	//Takes an AVLTree and returns an ordered list of node data
	public Comparable[] inOrder(AVLTree tree) {}
	
	//Counts the number of nodes that exist between a given minimum and maximum
	public int count(Comparable min, Comparable max) {}

}
