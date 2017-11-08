public class Node {
   public Comparable data;
   public Node next;
   public Node prev;
   
   public Node() {
      this.data = null;
      this.prev = null;
      this.next = null;
   }
   
   public Node(Comparable o) {
      this.data = o;
      this.next = null;
      this.prev = null;
   }
}