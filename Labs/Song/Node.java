public class Node<T> {
   public T data;
   public Node<T> next;
   public Node<T> prev;
   
   public Node() {
      this.data = null;
      this.prev = null;
      this.next = null;
   }
   
   public Node(T object) {
      this.data = object;
      this.next = null;
      this.prev = null;
   }
}