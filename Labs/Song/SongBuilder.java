public class SongBuilder {
   public String[] artist1 = {"A", "The", "My", "They"};
   public String[] artist2 = {"Mighty", "Might Be", "Beyonce", "Guns", "Talking", "Queen", "Beatles", "Panic!", "Smash", "Modest"};
   public String[] artist3 = {"Giants", "Bosstones", "Aquabats!", "& Roses", "Bee", "At The Disco", "Mouse", "Mouth", "Heads"};
   public String[] song1 = {"Hello,", "THNKS FR TH", "Super", "Pizza", "Welcome to the", "Burning Down The", "Bohemian", "Killer", "Psycho"};
   public String[] song2 = {"Goodbye", "MMRS", "Rad", "Day", "Jungle", "House", "Rhapsody", "Queen", "Killer"};
   
   public SongBuilder() {
   }
   
   public Song newSong() {
      String artist = artist1[(int)(Math.random() * (4 - 0))] + " " + artist2[((int)Math.random() * (10 - 0))] + " " + artist3[(int)(Math.random() * (9 - 0))];
      String song = song1[(int)(Math.random() * (9 - 0))] + " " + song2[(int)(Math.random() * (9 - 0))];
      
      Song newSong = new Song(song, artist, (float)(Math.random() * (200 - 1) + 1));
      return newSong;
   }
} 
      