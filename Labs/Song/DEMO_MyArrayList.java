import java.util.*;
public class DEMO_MyArrayList {
   public static void main(String[] args) {
      
      //Instantiate playlist
      Date date = new Date();
      MyArrayList<Song> list = new MyArrayList<Song>();
      //populate list
      for (int i = 0; i < 1000000; i++) {
         list.add(new Song("Queen", "Killer Queen", i));
      }
      for (int i = 10; i < 100; i++) {   
         System.out.print(list.remove(new Song("Queen", "Killer Queen", i)));
      }
      
      /*
      //test 1
      System.out.print("Test 1 start: " + date.toString());
      for (int i = 0; i < 5000000; i++) {
         list.add((int)(Math.random() * (9 - 1) + 1), new Song("Queen", "Killer Queen", i));
      }
      System.out.print("Test 1 end: " + date.toString());
      //test 2
      System.out.print("Test 2 start: " + date.toString());
      for (int i = 0; i < 5000000; i++) {
         list.get((int) Math.random() * (list.size - 1) + 1);
      }
      System.out.print("Test 2 end: " + date.toString());
      //test 3
      System.out.print("Test 3 start: " + date.toString());
      for (int i = 0; i < 5000000; i++) {
         list.swap((int) Math.random() * (list.size - 1) + 1, (int) Math.random() * (list.size - 1) + 1);
      }
      System.out.print("Test 3 end: " + date.toString());
      //test 4
      System.out.print("Test 4 start: " + date.toString());
      for (int i = 0; i < 5000000; i++) {
         list.shift((int) Math.random() * (1000000000 - 1) + 1);
      }
      System.out.print("Test 4 end: " + date.toString());
      */
   }
}