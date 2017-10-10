public abstract class MyCircularLinkedList<T> extends MyList<T> {
   public Node<T> head, tail;
   
   public MyCircularLinkedList() {
   }
   
   public MyCircularLinkedList(T[] o) {
      super(o);
   }

	/**
	 * Inserts an element at a specified position.
	 */
	public boolean add(int index, T o){
      
      if (index == 0) {
         Node<T> node = new Node<>(o);//create a new node
         node.next = head;//Link with the head
         head = node; //head points to new node
         size++;
      }
      
      else if (index >= size) {
         Node<T> node = new Node<>(o); //Make a new node
         
         if (tail == null) {
            head = tail = node; //New node is alone
         }
         else {
            tail.next = node; //link node with the current tail
            tail = tail.next; //update the tail
         }
         
         size++;
      }
      else {
         Node<T> cur = head; //Start at the head
         for (int i = 1; i < index; i++) {
            cur = cur.next; //increment though the list
         }
         Node<T> temp = cur.next;
         cur.next = new Node<>o;
         (cur.next).next = temp;
         size++;
      }
	}

	/**
	 * Appends an element to the end of the list.
	 */
	public boolean add(T o){
      return add(size, o);
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
         Node<T> temp = cur.next;
         cur.next = new Node<>o;
         (cur.next).next = temp;
         size++;
      return playlist[index];
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
      return remove(get(index));
   }
	
	/**
	 * Removes the first occurrence of the specified element from the list.
	 */
	public T remove(T o){
      o.next.prev = o.prev;
      o.prev.next = o.next;
      size--;
      
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
      o old = null;
      for( int i = 0; i< size; i++) {
         old = cur.Song;
      
	
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
	public MyList subList(int fromIndex, int toIndex);
	
	/**
	 * Returns an array containing all of the elements in the list in proper sequence.
	 */
	public T[] toArray(){
      return playlist.toArray();
   }
	
	/**
	 * Swaps elements of the List located in the positions 1 and 2, respectively.
	 */
	public boolean swap(int position1, int position2){
      if(position1 > 0 && position1 < size && position2 > 0 && position2 < size){
         T temp = playlist[position1];
         playlist[position1] = playlist[position2];
         playlist[position2] = temp;
         return true;
      }
      else return false;
   }
	
	/**
	 * Shift all elements in the List by a specified number of locations.
	 * If the value of positions is positive then the elements are shifted
	 * from left to right. If the value of positions is negative then the
	 * elements are shifted from right to left.
	 */
	public boolean shift(int positions)
      