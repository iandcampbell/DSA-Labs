public class Node<T> {
   public T data;
   public Node<T> next;
   public Node<T> prev;
   
   public Node(T object) {
      data = object;
      next = null;
      prev = null;
   }
}