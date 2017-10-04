public class Song
{
   String name, artist;
   float playtime;
   
   public Song(String name, String artist, float playtime)
   {
      this.name = name;
      this.artist = artist;
      this.playtime = playtime;
   }
   
   public String toString()
   {
      return ("song: " + name + ", artist: " + artist + ", playtime: " + playtime);
   }
   
   public double getPlayTime()
   {
      return playtime;
   }
   
   public String getArtist()
   {
      return artist;
   }
   
   public String getSongName()
   {
      return name;
   }
   
   @Override
   public boolean equals(Object o)
   {
      //Compare object to this Song instance
      if(o == this)
         return true;
      //Check if o is a Song object.
      if (!(o instanceof Song))
      {
         return false;
      }
      
      //typecast o to Song
      Song s = (Song) o;
      
      return name.equals(s.name) == true && artist.equals(s.artist) == true && Float.compare(playtime, s.playtime) == 0;
   }
 }
