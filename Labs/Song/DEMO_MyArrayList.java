public class MyArrayListDemo {
   public static void main(String[] args) {
      
      //Instantiate playlist
      
      MyList<> list = new MyArrayList<>();
      
      list.add(new Song("Queen", "Killer Queen", "1"));
      
      list.add(0, new Song("TMBG", "Older", "3"));
      
      for (int i = 0; i < list.length; i++) {
         System.out.println(list.get(i).getArtist() + ", " +
                            list.get(i).getName() + ", " +
                            list.get(i).getTime() + "\n");
      }
   }
}