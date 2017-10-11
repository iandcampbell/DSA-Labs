public class DEMO_MyCircularLinkedList {
   public static void main(String[] args) {
      
      //Instantiate playlist
      
      MyCircularLinkedList<Song> list = new MyCircularLinkedList<Song>();
            
      list.add(new Song("Queen", "Killer Queen", 1));
      
      list.add(0, new Song("TMBG", "Older", 3));
      list.add(1, new Song("1TMBG", "Older", 3));
      list.add(2, new Song("2TMBG", "Older", 3));
      list.add(3, new Song("3TMBG", "Older", 3));
      
      list.remove(new Song("TMBG", "Older", 3));
      
      list.set(0, new Song("Smash Mouth", "All Stars", 2));
      
      System.out.println(list.subList(0, 2).get(0).toString());
      list.swap(0, 3);
      list.shift(2);
      
      System.out.println();
      
      for (int i = 0; i < list.size; i++) {
         System.out.println(list.get(i).getArtist() + ", " +
                            list.get(i).getSongName() + ", " +
                            list.get(i).getPlayTime() + "\n");
      }
   }
}