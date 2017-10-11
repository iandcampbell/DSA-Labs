public class DEMO_MyCircularLinkedList {
   public static void main(String[] args) {
      
      //Instantiate playlist
      
      MyCircularLinkedList<Song> list = new MyCircularLinkedList<Song>();
            
      list.add(new Song("Queen", "Killer Queen", 1));
      
      for (int i = 0; i < 200; i++) {
         list.add(new Song("TMBG", "Older", 3));
         System.out.println(list.));
      }
      System.out.println(list.get(1).toString());
      for (int i = 0; i < list.size(); i++) {
         System.out.println(list.get(i).getArtist() + ", " +
                            list.get(i).getSongName() + ", " +
                            list.get(i).getPlayTime() + "\n");
      }
   }
}