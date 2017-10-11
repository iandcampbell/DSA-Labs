import java.util.*;
public class DEMO_MyCircularLinkedList {
   public static void main(String[] args) {

      //Instantiate playlist
      Date date;
      MyCircularLinkedList<Song> list = new MyCircularLinkedList<Song>();
      //populate list
      for (int i = 0; i < 1000000; i++) {
         list.add(new Song("Queen", "Killer Queen", i));
      }
      System.out.println();
      System.out.println();
      System.out.println(list.remove(1));
      list.set(5, (new Song("TMBG", "Older", 3)));
      list.set(6, (new Song("TMBG", "Older", 3)));
      System.out.println(list.remove(4));
      System.out.println(list.remove(96));
      list.set(0, (new Song("TMBG", "Older", 3)));
      
      //System.out.println(list.remove(1));
      //System.out.println(list.remove(new Song("TMBG", "Older", 3)));
      /*
      list.set(0, new Song("Smash Mouth", "All Stars", 2));
      
      System.out.println(list.subList(0, 2).get(0).toString());
      list.swap(0, 3);
      list.shift(2);
      
      System.out.println();
      
      for (int i = 0; i < list.size; i++) {
         System.out.println(i);
         System.out.println(list.get(i).getArtist() + ", " +
                            list.get(i).getSongName() + ", " +
                            list.get(i).getPlayTime() + "\n");
      }
      */
      //test 1
      date = new Date();
      System.out.print("Test 1 start: " + date.toString());
      for (int i = 0; i < 5000000; i++) {
         list.add((int)(Math.random() * (9 - 1) + 1), new Song("Queen", "Killer Queen", i));
      }
      date = new Date();
      System.out.print("Test 1 end: " + date.toString());
      //test 2
      date = new Date();
      System.out.print("Test 2 start: " + date.toString());
      for (int i = 0; i < 5000000; i++) {
         list.get((int) Math.random() * (list.size - 1) + 1);
      }
      date = new Date();
      System.out.print("Test 2 end: " + date.toString());
      //test 3
      date = new Date();
      System.out.print("Test 3 start: " + date.toString());
      for (int i = 0; i < 5000000; i++) {
         list.swap((int) Math.random() * (list.size - 1) + 1, (int) Math.random() * (list.size - 1) + 1);
      }
      date = new Date();
      System.out.print("Test 3 end: " + date.toString());
      //test 4
      date = new Date();
      System.out.print("Test 4 start: " + date.toString());
      for (int i = 0; i < 5000000; i++) {
         list.shift((int) Math.random() * (1000000000 - 1) + 1);
      }
      date = new Date();
      System.out.print("Test 4 end: " + date.toString());

   }
}