class MyArrayList<T> implements MyList<T>{
   
   public int size;
   public T[] playlist;
   
   public MyArrayList(){
      playlist = (T[]) new Object[1];
      size = 10;
   }
   
	/**
	 * Inserts an element at a specified position.
	 */
	public boolean add(int index, T o){
      playlist[index] = o;
	

	/**
	 * Appends an element to the end of the list.
	 */
	public boolean add(T o){
      playlist[size] = o;
      size++;
      return true;
	
	/**
	 * Removes all elements.
	 */
	public boolean clear(){
      playlist = (T[]) new Object[1];
      size = 10;
   }
	
	/**
	 * Returns true if the list contains specified element.
	 */
	public boolean contains(T o);
	
	/**
	 * Returns the element located in the specified position of this list.
	 * This method throws an exception if position value is less than 1 or
	 * greater than the list size.
	 */
	public T get(int index){
      return playlist[index];
	
	/**
	 * Returns an index in the list of the first occurrence of the specified
	 * element, or -1 if this list does not contain such an element.
	 */
	public int indexOf(T o);
	
	/**
	 * Returns true if the list contains no elements.
	 */
	public boolean isEmpty();
	
	/**
	 * Removes the element at the specified position in this list This method
	 * throws an exception if position value is less than 1 or greater than
	 * the list size.
	 */
	public T remove(int index);
	
	/**
	 * Removes the first occurrence of the specified element from the list.
	 */
	public T remove(T o);
	
	/**
	 * Replaces the element in specified position in the list with the 
	 * provided element. This method throws an exception if position 
	 * value is less than 1 or greater than the list size.
	 */
	public boolean set(int index, T element);
	
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
	public T[] toArray();
	
	/**
	 * Swaps elements of the List located in the positions 1 and 2, respectively.
	 */
	public boolean swap(int position1, int position2);
	
	/**
	 * Shift all elements in the List by a specified number of locations.
	 * If the value of positions is positive then the elements are shifted
	 * from left to right. If the value of positions is negative then the
	 * elements are shifted from right to left.
	 */
	public boolean shift(int positions);