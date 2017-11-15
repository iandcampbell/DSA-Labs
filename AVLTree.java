
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
	private int nodes;    //number of nodes in the tree
	Comparable[] nodesData = new Comparable[10];    //list of all data of all nodes
	
	//Constructor that generates a new tree
	public AVLTree(Comparable obj) {
		root = new AVLNode(obj);
		nodes++;
	}
	
	//Constructor that designates a tree starting from a given node
	public AVLTree(AVLNode node) {
		root = node;    //not much to it eh
		nodes++;
	}
	
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
		int compared = 666;  //holds the result of compareTo   //eclipse yelled at me to instantiate it so here it is
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
			} else if(compared == 0) {
				returnNode = cur;   //sets returnNode to cur in a matching case
			}
		}
		return returnNode;
	}
	
	//A utility for balancing the AVL tree
	private void balanceUtil(AVLNode node) {
		//lambda to handle rebalancing
		java.util.function.Consumer<AVLNode> rebalance = (n) -> {
			setBalance(n);
		};
		//lambda to handle left rotations
		java.util.function.Function<AVLNode, AVLNode> rotateLeft = (a) -> {
			AVLNode b = a.rightNode;
			b.parent = a.parent;
			a.rightNode = b.leftNode;
			if(a.rightNode != null) {
				a.rightNode.parent = a;
			}
			b.leftNode = a;
			a.parent = b;
			if(b.parent != null) {
				if(b.parent.rightNode == a) {
					b.parent.rightNode = b;
				} else {
					b.parent.leftNode = b;
				}
			}
			setBalance(a, b);
			return b;
		};
		//lambda to handle right rotations
		java.util.function.Function<AVLNode, AVLNode> rotateRight = (a) -> {
			AVLNode b = a.rightNode;
			b.parent = a.parent;
			a.leftNode = b.rightNode;
			if(a.leftNode != null) {
				a.leftNode.parent = a;
			}
			b.rightNode = a;
			a.parent = b;
			if(b.parent != null) {
				if(b.parent.rightNode == a) {
					b.parent.rightNode = b;
				} else {
					b.parent.leftNode = b;
				}
			}
			setBalance(a, b);
			return b;
		};
		//lambda to handle left then right rotations
		java.util.function.Function<AVLNode, AVLNode> rotateLeftThenRight = (a) -> {
			a.leftNode = rotateLeft.apply(a.leftNode);
			return rotateRight.apply(a);
		};
		//lambda to handle right then left rotations
		java.util.function.Function<AVLNode, AVLNode> rotateRightThenLeft = (a) -> {
			a.rightNode = rotateRight.apply(a.rightNode);
			return rotateLeft.apply(a);
		};
		
		//The part that matters
		setBalance(node);
		if (node.balance == -2) {
            if (node.leftNode.leftNode.height >= node.leftNode.rightNode.height) {
                node = rotateRight.apply(node);
            } else {
                node = rotateLeftThenRight.apply(node);
            }
 
        } else if (node.balance == 2) {
            if (node.rightNode.rightNode.height >= node.rightNode.leftNode.height)
                node = rotateLeft.apply(node);
            else
                node = rotateRightThenLeft.apply(node);
        }
 
        if (node.parent != null) {
            balanceUtil(node.parent);
        } else {
            root = node;
        }
	}
	
	//Utility to reassign height values
	private void reheight(AVLNode node) {
		if(node != null) {
			node.height = 1 + Math.max(node.leftNode.height, node.rightNode.height);
		}
	}
	
	//Utility to set balance values
	private void setBalance(AVLNode... nodes) {
		for(AVLNode n : nodes) {
			reheight(n);
			n.balance = n.rightNode.height - n.leftNode.height;
		}
	}
	
	//Utility to handle nodesData
	private void reData(boolean i, Comparable o) {
		if(!(nodesData.length == nodes)) {   //handles sizing issues of the array
			//true for additions to the array, false for subtractions
			if(i) {   //additions to the array
				Comparable[] temp = nodesData;
				//adds at appropriate position
				for(int j = 0; j < nodesData.length; j++) {  //passes through the array
					//parse from temp to nodesData
					if(o.compareTo(temp[j]) == 1){  //catches first value greater than it
						Comparable ntemp = temp[j];
						nodesData[j] = o;    //adds the inserted object
						nodesData[j + 1] = ntemp;  //adds at the next index
						j++;   //accounts for inserted object
					} else {
						nodesData[j] = temp[j];  //adds all other values
					}
				}
			} else if(!i) {    //subtractions from the array
				Comparable[] temp = nodesData;
				//removes at appropriate position
				for(int j = 0; j < nodesData.length; j++) {  //passes through the array
					//parse from temp to nodesData
					if(o.compareTo(temp[j]) == 0){  //catches matching value
						nodesData[j] = temp[j + 1];    //skips adding the matching object
						j++;   //accounts for skipped object
					} else {
						nodesData[j] = temp[j];  //adds all other values
					}
				}
			}
		} else { //resizes the array
			Comparable[] temp = nodesData;  //temporarily holds data
			nodesData = new Comparable[nodesData.length + 10]; //adds 10 spaces
			//reinserts data into array
			for(int j = 0; j < temp.length; j++) {  //from the temporary array
				nodesData[j] = temp[j];
			}
			//once it has been resized, recall the method
			reData(i, o);
		}
	}
	
	//Inserts an object into the tree at the appropriate position
	public AVLTree insert(AVLTree tree, Comparable o) {
		//The return tree
		AVLTree returnTree = tree;
		//Uses the search utility to find a matching case
		AVLNode checkable = searchUtil(o, returnTree.root);
		
		//Inserts the new node at the appropriate location
		if(checkable != null && searchComp != null) {   //prevents object duplication
			reData(true, o);
			switch(o.compareTo(searchComp.data)) {
			case -1: searchComp.leftNode = new AVLNode(o);      //assigns a new node to the left node
				searchComp.leftNode.parent = searchComp;    //designates the new node's parent
				balanceUtil(searchComp);
				break;
			case 1: searchComp.rightNode = new AVLNode(o);      //assigns a new node to the right node
				searchComp.rightNode.parent = searchComp;   //designates the new node's parent
				balanceUtil(searchComp);
				break;
			}
		}
		nodes++;
		return returnTree;
	}
	
	//Removes a given object from the tree
	public AVLTree delete(AVLTree tree, Comparable o) {
		//The return tree
		AVLTree returnTree = tree;
		//Uses the search utility to find a matching case
		AVLNode removable = searchUtil(o, returnTree.root);
		//Checks to see if a match was found at all
		if(removable != null) {
			//Removes the removable
			//After handling parents, and children
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
			}
			//The actual removing
			AVLNode formerParent = removable.parent;
			reData(false, o);
			switch(formerParent.data.compareTo(removable.data)) {
			case -1: formerParent.leftNode = null;
				balanceUtil(formerParent);
				break;
			case 1: formerParent.rightNode = null;
				balanceUtil(formerParent);
				break;                                  
			}     //If there are no children, and it's the root you now have an empty tree. Congratulations.
		}
		return returnTree;
	}
	
	//Takes an AVLTree and returns an ordered list of node data
	public Comparable[] inOrder(AVLTree tree) {
		return tree.nodesData;
	}
	
	//Counts the number of nodes that exist between a given minimum and maximum
	public int count(AVLTree tree, Comparable min, Comparable max) {
		Comparable[] nodes = tree.nodesData;  //grabs the node data array
		int count = 0; //holds the total count
		for(int i = 0; i < nodes.length; i++) {  //iterates through the entire array
			if(nodes[i].compareTo(min) >= 0 && nodes[i].compareTo(max) != 1) {  //inclusive boundaries
				count++;
			}
		}
		return count;
	}

}
