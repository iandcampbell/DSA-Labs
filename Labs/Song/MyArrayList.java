public class MyArrayList<T> implements MyList<T>{
   
   public static final int baseSize = 10;
   public int size = 0;
   public T[] playlist[baseSize];
   
   public MyArrayList(){
      playlist = (T[]) new Object[1];
      size = maxSize;
   }
   
   public MyArrayList(T[] o){
      for (int i = 0; i<o.length; i++)
         add(o[i]);
   }
   
	/**
	 * Inserts an element at a specified position.
	 */
	public boolean add(int index, T o){
      //check index bounds
      if (index < 0 || index > size)
         throw new IndexOutOfBoundsException(index + ", " + size);
      
      //check size capacity
      
      //move elements to the right
      for (int i = size - 1; i >= index; i--)
         playlist[i+1] = playlist[i];
      
      //insert element at specific index
      playlist[index] = o;
      
      //increment size
      size++;
	

	/**
	 * Appends an element to the end of the list.
	 */
	public boolean add(T o){
      playlist[size-1] = o;
      size++;
      return true;
	
	/**
	 * Removes all elements.
	 */
	public boolean clear(){
      playlist = (T[]) new Object[baseSize];
      size = 0;
   }
	
	/**
	 * Returns true if the list contains specified element.
	 */
	public boolean contains(T o){
      for(int i = 0; i < size; i++){
         if(playlist[i].equals(o)){
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
         throw new IndexOutOfBoundsException(index + ", " + size);
      
      return playlist[index];
   }
	
	/**
	 * Returns an index in the list of the first occurrence of the specified
	 * element, or -1 if this list does not contain such an element.
	 */
	public int indexOf(T o){
      for (int i = 0; i < size; i++){
         if(playlist[i].equals(o)){
            return i;
         else return -1;
	
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
      T object = playlist[index];
      playlist[index] = null;
      return object;
   }
	
	/**
	 * Removes the first occurrence of the specified element from the list.
	 */
	public T remove(T o){
      T object = null;
      for (int i = 0; i < playlist.length; i++){
         if(playlist[i].equals(o)){
            object = o;
         }
      return object;
   }
	
	/**
	 * Replaces the element in specified position in the list with the 
	 * provided element. This method throws an exception if position 
	 * value is less than 1 or greater than the list size.
	 */
	public boolean set(int index, T element){
      if(index < 0 || index > playlist.length)
         throw IndexOutOfBoundsError;
      else playlist[index] = element;
	
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
	public boolean shift(int positions) {
      
   }