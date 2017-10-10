public abstract class MyCircularLinkedList<T> extends MyList<T> {
   public Node<T> head, tail;
   int size;
   
   public MyCircularLinkedList() {
      this.size = 0;
      this.head = new Node<T>();
      this.tail = new Node<T>();
      this.head.next = this.tail;
      this.tail.prev = this.head;
   }
   
   public MyCircularLinkedList(T[] o) {
      super(o);
   }

	/**
	 * Inserts an element at a specified position.
	 */
	public boolean add(int index, T o){
      if (index < 0 || index > size){
         throw new IndexOutOfBoundsException();
      }
      Node<T> newNode = new Node<T>(o);
      Node<T> pointer = head;
      for (int i = 0; i <= index; i++) {
         pointer = pointer.next;
      }
      Node<T> prev = pointer.prev;
      prev.next = newNode;
      newNode.prev = prev;
      newNode.next = pointer;
      pointer.prev = newNode;
      size++;
      return true;
	}

	/**
	 * Appends an element to the end of the list.
	 */
	public boolean add(T o){
      Node<T> newNode = new Node<T>(o); //Holds our object
      Node<T> prev = tail.prev; //hold the last element next to the tail
      prev.next = newNode; //links last element to new element
      newNode.prev = prev; //links new element to last element
      newNode.next = tail; //links new element to tail
      tail.prev = newNode; //links tail to new element
      size++;
      return true;
   }
	
	/**
	 * Removes all elements.
	 */
	public boolean clear(){
      size = 0;
      head = null;
      tail = null;
   }
	
	/**
	 * Returns true if the list contains specified element.
	 */
	public boolean contains(T o){
      Node<T> cur = head;
      for (int i = 0; i < size; i++) {
         if (cur.data.equals(o))
            return true;
         cur = cur.next;
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
         throw new IndexOutOfBoundsException(index + ", " + size);
      Node<T> cur = head; //Start at the head
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
      Node<T> cur = head;
      for (int i = 0; i < size; i++) {
         if (cur.data.equals(o))
            return i;
         cur = cur.next;
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
         throw new IndexOutOfBoundsException(index + ", " + size);
      Node<T> des = head;
      for (int i = 0; i <= index; i++) {
         des = des.next;
      }
      Node<T> prev = des.prev;
      Node<T> next = des.next;
      prev.next = next;
      nrext.prev = prev;
      size--;
      return des.data;
   }
 
	/**
	 * Removes the first occurrence of the specified element from the list.
	 */
	public T remove(T o){
     int i = 1;
     Node<T> temp = head;
     if (temp.data.equals(o)) {
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = null;
        temp.prev = null;
        return temp.data;
     } 
     while (i < size) {
        temp = temp.next;
        if (temp.data.equals(o)) {
           temp.prev.next = temp.next;
           temp.next.prev = temp.prev;
           temp.next = null;
           temp.prev = null;
           return temp.data; 
        }
        i++;
     }
     return o; 
   }
	
	/**
	 * Replaces the element in specified position in the list with the 
	 * provided element. This method throws an exception if position 
	 * value is less than 1 or greater than the list size.
	 */
	public boolean set(int index, T element){
      if(index < 0 || index > playlist.length)
         throw IndexOutOfBoundsError;
      Node<T> cur = head;
      for (int i = 0; i <= index; i++) {
         cur = cur.next;
      }
      cur.daata = element;
      return element;
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
	public MyList<T> subList(int fromIndex, int toIndex){
      if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
      throw new IndexOutOfBoundsException();
   }
      MyCircularLinkedList<T> subList = new MyCircularLinkedList<T>();
      Node<T> oPoint = head.next;
      Node<T> slPoint = subList.head;
      int stop = fromIndex - toIndex;
      for (int i = 0; i < stop; i++) {
         slPoint.next = oPoint;
         slPoint = oPoint.next;
         oPoint = oPoint.next;
         subList.size++;
      }
   
      return subList
	}
   
	/**
	 * Returns an array containing all of the elements in the list in proper sequence.
	 */
	public T[] toArray(){
      T[] newArray = (T[]) new Object[size];
      Node<T> temp = head;
      for (int i = 0; i < size; i++) {
         newArray[i] = temp.data;
         temp = temp.next;
      }
       return newArray;   
   }
	
	/**
	 * Swaps elements of the List located in the positions 1 and 2, respectively.
	 */
	public boolean swap(int position1, int position2){
      if (position1 < 0 || position1 > size || position2 < 0 || position1 > size) { //Index boundaries
        throw new IndexOutOfBoundsException();
      }
      if (position1 > position2) { //For instance, swap index 3 for index 1, works easier as swapping index 1 for 3
         int temp = position1;
         position1 = position2;
         position2 = temp;
      }
      int space = position1 - position2; //Increments between position 1 and 2
      int count = 0;
      Node<T> tempNode = head;
      Node<T> swapOne = null; 
      Node<T> swapTwo = null;
      while(count < position1) { //count up to pos 1
         tempNode = tempNode.next;
         count++;
      }
     
      count= 0;
      swapOne = tempNode;
      while(count < space) { //count to pos2
          tempNode = tempNode.next;
          count++;
      }
      count = 0;        //swap values
      swapTwo = tempNode;
      tempNode = swapOne;
      while(space > count) {
         tempNode = tempNode.prev;
         space--;
      }
      tempNode = swapTwo;
      return true;
   }
	
	/**
	 * Shift all elements in the List by a specified number of locations.
	 * If the value of positions is positive then the elements are shifted
	 * from left to right. If the value of positions is negative then the
	 * elements are shifted from right to left.
	 */
	public boolean shift(int positions) {
		if(positions < 0) {
			positions *= -1;
			for(int i = 0, i < positions, i++) {
				tail = tail.prev;
				head = head.prev;
			}
			return true;
		}
		if(positions == 0) {
			return true;
		}
		if(positions > 0) {
			for(int i = 0, i < positions, i++) {
				head = head.next;
				tail = tail.next;
			}
			return true;
		}
		return false;
	}
}
