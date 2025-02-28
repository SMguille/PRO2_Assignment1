package Model;

import java.beans.PropertyChangeSupport;
import java.util.List;

public class Vinyl
{
  private String title;
  private String artist;
  private int releaseYear;
  private VinylState availableState, borrowedState, reservedState, borrowedReservedState;
  private VinylState currentState;
  private User user;
  private List<Vinyl> vinylList;
  private PropertyChangeSupport support;


  public Vinyl(String title, String artist, int releaseYear)
  {
    this.title = title;
    this.artist = artist;
    this.releaseYear = releaseYear;
    currentState = availableState;

    user = null;
    support = new PropertyChangeSupport(this);
  }

  public void changeToAvailable(){
    currentState = new AvailableState();;
  }
  public void changeToReserved(){
    currentState = new ReservedState();
  }
  public void changeToBorrowed(){
    currentState = new BorrowedState();
  }
  public void changeToBorrowedReserved(){
    currentState = new BorrowedReservedState();
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

  public void setUser(User user){
    this.user = user;
  }

  public void reserve(Vinyl vinyl)
  {
    currentState.onReserve(this);;
  }

  public void borrow(Vinyl vinyl)
  {
    currentState.onBorrow(this);
  }

  public void onReturn(Vinyl vinyl)
  {
    currentState.onReturn(this);
  }

  public void remove(Vinyl vinyl)
  {
    currentState.onRemove(this);
  }

  public void removeFromList(Vinyl vinyl){
    vinylList.remove(vinyl);
    support.firePropertyChange("remove", null, vinylList); //Warning that the list has been changed
  }
}
