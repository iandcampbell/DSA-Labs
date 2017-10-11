public class DEMO_MyArrayList {
   public static void main(String[] args) {
      
      //Instantiate playlist
      
      MyArrayList<Song> list = new MyArrayList<Song>();
      
      list.add(new Song("Queen", "Killer Queen", 1));
      list.add(new Song("Queen", "Killer Queen", 1));
      list.add(new Song("Queen", "Killer Queen", 1));
      list.add(new Song("The Beatles", "Hello Goodbye", 5));
      
      list.add(1, new Song("TMBG", "Older", 3));
      list.set(0, new Song("TMBG", "Older", 3));
      list.remove(3);
      list.remove(new Song("TMBG", "Older", 3));

      for (int i = 0; i < list.size-1; i++) {
         System.out.println( i + ": " + list.get(i).getArtist() + ", " +
                            list.get(i).getSongName() + ", " +
                            list.get(i).getPlayTime() + "\n");
      }
   }
}