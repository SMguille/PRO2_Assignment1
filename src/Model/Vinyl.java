package Model;

public class Vinyl
{ //A Vinyl has at least a title, artist, release year, and a lending state. The Vinyl can be in different states depending on availability.

  // A Vinyl that is not borrowed, and has no reservation is said to be available.


  private String title;
  private String artist;
  private int releaseYear;
  private boolean state;
  private VinylState currentState;

  public Vinyl(String title, String artist, int releaseYear,
      boolean state)
  {
    this.title = title;
    this.artist = artist;
    this.releaseYear = releaseYear;
    this.state = state;
  }

  public void changeToAvailable(){

  }

  public String getTitle()
  {
    return title;
  }

  public String getArtist()
  {
    return artist;
  }

  public int getReleaseYear()
  {
    return releaseYear;
  }

  public void setState(Boolean lendingState){
    this.state = lendingState;
  }

  public boolean isAvailable()
  {
    return state;
  }
}
