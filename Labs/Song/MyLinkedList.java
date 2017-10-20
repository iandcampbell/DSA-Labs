public class MyLinkedList<T> implements MyList<T>{
   
   public Node<T> head;
   public int size;
   
   public MyLinkedList(){
      head = null;
      size = 0;
   }
   
   public MyLinkedList(T[] o){
      head = null;
      size = 0;
      Node<T> cur = head.next;
      for (int i = 0; i<o.length; i++){
         Node<T> newNode = new Node(o[i]);
         cur.next = newNode;
         cur = cur.next;
         size++;
      }
   }
   
	/**
	 * Inserts an element at a specified position.
	 */
	public boolean add(int index, T o){
      if (this.contains(o)){
         System.out.println("Sorry, no doubles.");
         return false;
      }
      
      Node<T> newNode = new Node(o);
      Node<T> cur = head;
      for (int i = 0; i < size; i++) {
         if (i == index) {
            Node temp = cur.next;
            cur.next = newNode;
            newNode.next = temp;
            break;
         }
         cur = cur.next;
      }
      size++;
      return true;
	}

	/**
	 * Appends an element to the end of the list.
	 */
	public boolean add(T o){
      
      Node<T> newNode = new Node(o);
      Node<T> cur = head.next;
      if (cur == null) {
         cur.data = o;
         size++;
         return true;
      }
      while (cur.next != null){
         cur = cur.next;
      }
      cur.data = o;
      size++;
      return true;
   }
	
	/**
	 * Removes all elements.
	 */
	public boolean clear(){
      size = 0;
      head = null;
      return true;
   }
	
	/**
	 * Returns true if the list contains specified element.
	 */
	public boolean contains(T o){
      Node<T> cur = head.next;
      if (cur.data.equals(o)) {
         return true;
      }
      
      while (cur.next != null) {
         cur = cur.next;
         
         if  (cur.data.equals(o)) {
            return true;
         }
      }
      return false;
   }
	
	/**
	 * Returns the element located in the specified position of this list.
	 * This method throws an exception if position value is less than 1 or
	 * greater than the list size.
	 */
	public T get(int index){
      //check index bounds
      if (index < 0 || index > size)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      Node<T> cur = head.next; //Start at the head
         for (int i = 0; i < index; i++) {
            cur = cur.next; //increment though the list
         }
      return cur.data;
   }
	
	/**
	 * Returns an index in the list of the first occurrence of the specified
	 * element, or -1 if this list does not contain such an element.
	 */
	public int indexOf(T o){
      Node<T> cur = head.next;
      for (int i = 0; i < size; i++){
         if (cur.data.equals(o)) {
            return i;
         }
      }
      return -1;
   }
	
	/**
	 * Returns true if the list contains no elements.
	 */
	public boolean isEmpty(){
      return size == 0;
   }
	
	/**
	 * Removes the element at the specified position in this list This method
	 * throws an exception if position value is less than 1 or greater than
	 * the list size.
	 */
	public T remove(int index){
      if (index < 0 || index > size)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      Node<T> prev = head;
      Node<T> des = head.next;
      for (int i = 0; i < index; i++) {
         prev = prev.next;
         des = des.next;
      }
      prev.next = des.next;
      des = null;
      size--;
      return des.data;
   }
	
	/**
	 * Removes the first occurrence of the specified element from the list.
	 */
	public T remove(T o){
      if (this.isEmpty()) {
         System.out.println("Nothing to return");
         return null;
      }
      Node<T> prev = head;
      Node<T> cur = head.next;
      
      while (cur != null) {
         if (cur.data.equals(o)) {
            prev.next = cur.next;
            cur = null;
            return o;
         } else {
            prev = prev.next;
            cur = cur.next;
         }
      }
      return null;
   }
	
	/**
	 * Replaces the element in specified position in the list with the 
	 * provided element. This method throws an exception if position 
	 * value is less than 1 or greater than the list size.
	 */
	public boolean set(int index, T element){
      if(index < 0 || index > size)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      Node<T> cur = head;
      for (int i = 0; i <= index; i++) {
         cur = cur.next;
      }
      cur.data = element;
      return true;
   }
	
	/**
	 * Returns the number of elements in the list.
	 */
	public int size(){
      return size;
   }
	
	/**
	 * Returns a new list that contains the portion of the original list 
	 * between the specified fromIndex, inclusive, and toIndex, exclusive.
	 */
	public MyList subList(int fromIndex, int toIndex){
   
      return null;
   }
	
	/**
	 * Returns an array containing all of the elements in the list in proper sequence.
	 */
	public T[] toArray(){
      T[] newArray = (T[]) new Object[size];
      Node<T> temp = head.next;
      for (int i = 0; i < size; i++){
         while (temp == null){
            temp = temp.next;
         }
         newArray[i] = temp.data;
      }
      return newArray; 
   }
	
	/**
	 * Swaps elements of the List located in the positions 1 and 2, respectively.
	 */
	public boolean swap(int position1, int position2){
      int i = position1, j = position2;
      if (i >= size || j >= size || i < 0 || j < 0) {
         return false;
      }
      if (i == j) {
         return true;
      }
      if (j < i) {
         return swap(j, i);
      } 
      
      Node<T> iNode = head.next;
      Node<T> jNode = head.next;
      for (int x = 0; x < i; x++) {
         iNode = iNode.next;
      }
      for (int y = 0; y < j; y++) {
         jNode = jNode.next;
      }
      T temp = iNode.data;
      iNode.data = jNode.data;
      jNode.data = temp;
      return true;
   }
	
	/**
	 * Shift all elements in the List by a specified number of locations.
	 * If the value of positions is positive then the elements are shifted
	 * from left to right. If the value of positions is negative then the
	 * elements are shifted from right to left.
	 */
	public boolean shift(int positions){
      return false;
   }
}/*
      if (positions == 0){
         return true;
      }
      Node<T> cur = head.next;
      int count = 0;
      if (positions > 0) {
         while (count < positions && cur!= null) {
            cur = cur.next;
            count++;
         }
         
         if (cur == null){
            return false;
         }
         
         Node<T> temp = cur;
         
         while (cur.next != null) {
            
      if (
      */