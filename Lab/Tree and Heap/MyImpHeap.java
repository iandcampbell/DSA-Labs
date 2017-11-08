
public class MyImpHeap implements MyHeap {
	public int defaultSize = 10;
   public int maxSize;
   public Comparable heap[];
   public int heapSize;
   
	
	public Node makeHeap(Comparable value);
	
	public boolean isEmpty(){
      return  heapSize <= 0;
	
	public boolean insert(){
      int position = heapSize;
      heap[heapSize] = object;
      
      while(pos > 0 && heap[position].compareTo(heap[(position+1)/2-1]) < 0){
         Comparable temp = heap[position];
         heap[position] = heap[(position+1)/2-1];
         heap[(position+1)/2-1] = temp;
         position = (position+1)/2-1;
      }
   }
	
	public boolean deleteMin(){
      int position;
      Comparable returnable = null;
      
      heapSize--;
      returnable = this.heap[heapSize];
      position = 0;
      
      while (position < this.heapSize){
         int childOne = ////;
         int childTwo = ////;
         
         if(childOne >= this.heapSize && childTwo >= this.heapSize){
         }
         else if (childOne >= this.heapSize && childTwo < this.heapSize && heap[position].compareTo(heap[childTwo] > 0){
         }
         else if (childOne < this.heapSize && childTwo >= this.heapSize && heap[position].compareTo(heap[childOne] > 0){
         }
         else if (childOne < this.heapSize && childTwo < this.heaSize){
         }
         else {
            position = this.heapSize;
         }
      }
      return returnable;
   }
	
	public boolean decreaseKey(Node key, Comparable updateValue){
      if( compare(key.data, newVal) > 0) {
         throw new RunTimeException();
      }
      key.data = newVal; 
      ///
      return true;
   }
	
	public boolean delete(Node del){
      this.
	
	public boolean union(MyHeap heap);
	
	public Comparable findMin();
}
