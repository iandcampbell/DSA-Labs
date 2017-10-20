import java.util.Date;
public class DEMO_MyArrayList {
   public static void main(String[] args) {

      //Instantiate playlist
      Date date = new Date();
      SongBuilder sb = new SongBuilder();
      MyArrayList<Song> list = new MyArrayList<Song>();
      
      //populate list
      for (int i = 0; i < 999999; i++) {
         list.add(sb.newSong());
      }
   
      //test 1
      date = new Date();
      System.out.println("Test 1 start: " + date.toString());
      
      for (int i = 0; i < 499999; i++) {
         list.add(0, sb.newSong());
      }
      
      date = new Date();
      System.out.println("Test 1 end: " + date.toString());
      
      //test 2
      date = new Date();
      System.out.println("Test 2 start: " + date.toString());
      
      for (int i = 0; i < 499999; i++) {
         list.get((int) Math.random() * (list.size - 1) + 1);
      }
      
      date = new Date();
      System.out.println("Test 2 end: " + date.toString());
      
      //test 3
      date = new Date();
      System.out.println("Test 3 start: " + date.toString());
      
      for (int i = 0; i < 499999; i++) {
         list.swap((int) Math.random() * (list.size - 1) + 1, (int) Math.random() * (list.size - 1) + 1);
      }
      
      date = new Date();
      System.out.println("Test 3 end: " + date.toString());
      
      //test 4
      date = new Date();
      System.out.println("Test 4 start: " + date.toString());
      
      for (int i = 0; i < 499999; i++) {
         list.shift((int) Math.random() * (1000000000 - (-1000000)) + (-1000000));
      }
      
      date = new Date();
      System.out.println("Test 4 end: " + date.toString()); 
   }
}