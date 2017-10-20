
public class MyArrayList<T> implements MyList<T> {
   
   public int size;
   public T[] playlist = (T[])new Object[size];
   
   public MyArrayList(){
      size = 0;
      this.playlist = (T[])new Object[size];
   }
  
   public MyArrayList(T[] o){
      for (int i = 0; i < o.length; i++)
         add(o[i]);
   }
   
	/**
	 * Inserts an element at a specified position.
	 */
	public boolean add(int index, T o) {
      System.out.println("Trying to add at spot. " + String.valueOf(o));
      if (size >= this.playlist.length-1){
         T[] newArray = (T[])new Object[(size*2)+1];
         for (int i = 0; i < size; i++) {
            newArray[i] = this.playlist[i];
         }
         this.playlist = newArray;
      }
      
      for (int i = size; index < i; i--) {
         this.playlist[i] = this.playlist[i-1];
      }
      this.playlist[index]  = o;  
      size++;
      return true;
   }
	

	/**
	 * Appends an element to the end of the list.
	 */
	public boolean add(T o){
      if(contains(o)){
         System.out.println("No dupes.");
         return false;
      }
      if (size == this.playlist.length){
         T[] newArray = (T[])new Object[(size*2)+1];
         for (int i = 0; i < size; i++) {
            newArray[i] = this.playlist[i];
         }
         this.playlist = newArray;
      }
      this.playlist[size] = o;
      size++;
      return true;
   }
	
	/**
	 * Removes all elements.
	 */
	public boolean clear(){
      size = 0;
      this.playlist = (T[]) new Object[size];
      return true;
   }
	
	/**
	 * Returns true if the list contains specified element.
	 */
	public boolean contains(T o){
      for(int i = 0; i < this.playlist.length-1; i++){
         if (this.playlist[i] == null) {
            return false;
         }
         if (this.playlist[i].equals(o)) {
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
      
      return this.playlist[index];
   }
	
	/**
	 * Returns an index in the list of the first occurrence of the specified
	 * element, or -1 if this list does not contain such an element.
	 */
	public int indexOf(T o){
      for (int i = 0; i < size; i++){
         if (this.playlist[i].equals(o)){
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
      //check index bounds
      if (index < 0 || index > size)
         throw new IndexOutOfBoundsException(index + ", " + size);
      T object = this.playlist[index];
      
      for (int i = index; i < size; i++) {
         this.playlist[i] = this.playlist[i+1];
      }
      
      this.playlist[size-1] = null;
      size--;
      
      return object;
   }
	
	/**
	 * Removes the first occurrence of the specified element from the list.
	 */
	public T remove(T o){
      T object = null;
      int index = -1;
      for (int i = 0; i < this.playlist.length; i++){
         System.out.println(i);
         if(this.playlist[i].equals(o)){
            return this.remove(i);
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
      if(index < 0 || index > this.playlist.length)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      if (size >= this.playlist.length) {
         T[] newArray = (T[])new Object[size*2];
         newArray = this.playlist.clone();
         this.playlist = newArray;
      }
      this.playlist[index] = element;
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
      if (fromIndex < 0 || toIndex > size || fromIndex >= toIndex) {
         throw new IndexOutOfBoundsException("Index: " + fromIndex + ", " + toIndex + ", Size: " + size);
      }
      T[] subArray = (T[])new Object[toIndex - fromIndex + 1];
      for (int i = toIndex; i <= fromIndex; i++) {
         subArray[i] = this.playlist[i];
      }
      MyArrayList<T> subList = new MyArrayList<T>(subArray);
      return subList;
   }
	
	/**
	 * Returns an array containing all of the elements in the list in proper sequence.
	 */
	public T[] toArray(){
      T[] temp = (T[])new Object[size];
      for (int i = 0, j = 0; i < size; i++) {
         if (this.playlist[i] != null) {
            temp[j] = this.playlist[i];
            j++;
         }
      }
      return temp;
   }
	
	/**
	 * Swaps elements of the List located in the positions 1 and 2, respectively.
	 */
	public boolean swap(int position1, int position2){
      if (position1 < 0 || position1 > size || position2 < 0 || position2 > size)
         throw new IndexOutOfBoundsException("Index: " + position1 + ", " + position2  + ", Size: " + size);
      T temp = this.playlist[position1];
      this.playlist[position1] = this.playlist[position2];
      this.playlist[position2] = temp;
      return true;
   }
	
	/**
	 * Shift all elements in the List by a specified number of locations.
	 * If the value of positions is positive then the elements are shifted
	 * from left to right. If the value of positions is negative then the
	 * elements are shifted from right to left.
	 */
	public boolean shift(int positions) {
      T[] temp = (T[])new Object[this.playlist.length];
      if (positions >= 0) {
         for (int i = 0; i < this.playlist.length; i++) {
            int spot = (i + positions) % this.playlist.length;
            temp[spot] = this.playlist[i]; 
         }
         return true;
      }
      else if (positions < 0) {
         for (int i = 0; i < this.playlist.length; i++) {
            int spot = (i + positions) + this.playlist.length;
            while (spot < 0) {
               spot = (i + positions) + this.playlist.length;
            }
            temp[spot] = this.playlist[i];
         }
         return true;
      }
      else return false;
   }
   
   public String toString() {
      String print = "[ ";
      for (int i = 0; i < size; i++) {
         System.out.println(this.playlist[i]);
         print = print + String.valueOf(this.playlist[i]) + " ::";
      }
      print = print + "]";
      return print;
   }
}
