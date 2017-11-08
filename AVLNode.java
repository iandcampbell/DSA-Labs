/**
 * Handles the data of each node in the tree.
 * 
 * @author Ian
 */
public class AVLNode {

		public Comparable data;
		public AVLNode leftNode; 
		public AVLNode rightNode;
		public AVLNode parent;
		
		//default constructor
		public AVLNode() {
			this.data = null;
			this.leftNode = null;
			this.rightNode = null;
		}
		
		//Constructor that takes an object for data
		//to construct the root of the tree.
		public AVLNode(Comparable o) {
			this.data = o;
			this.leftNode = null;
			this.rightNode = null;
		}
}
