package Model;

import java.util.List;

public class Vinyl
{
  private String title;
  private String artist;
  private int releaseYear;
  private VinylState currentState;
  private String borrowedUserId;
  private String reservedUserId;
  private List<Vinyl> vinylList;


  public Vinyl(String title, String artist, int releaseYear)
  {
    this.title = title;
    this.artist = artist;
    this.releaseYear = releaseYear;
    currentState = new AvailableState();

    borrowedUserId = null;
    reservedUserId = null;
  }

  public void changeToAvailable(){
    borrowedUserId = null;
    reservedUserId = null;
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

  public String getBorrowedUserId()
  {
    return borrowedUserId;
  }

  public String getReservedUserId()
  {
    return reservedUserId;
  }
  public VinylState getCurrentState(){
    return currentState;
  }

  public void setBorrowedUserId(String borrowedUserId){
    this.borrowedUserId = borrowedUserId;
  }

  public void setReservedUserId(String reservedUserId)
  {
    this.reservedUserId = reservedUserId;
  }

  public void reserve()
  {
    currentState.onReserve(this);
  }

  public void borrow()
  {
    currentState.onBorrow(this);
  }

  public void onReturn()
  {
    currentState.onReturn(this);
  }

  public void onDelete(Vinyl vinyl){
    //currentState.onDelete(this);
  }

  public String stateMessage(){
    return currentState.stateMessage(this);
  }

  @Override public String toString()
  {
    final StringBuilder sb = new StringBuilder("Vinyl{");
    sb.append("title='").append(title).append('\'');
    sb.append(", artist='").append(artist).append('\'');
    sb.append(", releaseYear=").append(releaseYear);
    sb.append(", currentState=").append(currentState);
    sb.append(", borrowedUserId='").append(borrowedUserId).append('\'');
    sb.append(", reservedUserId='").append(reservedUserId).append('\'');
    sb.append(", vinylList=").append(vinylList);
    sb.append('}');
    return sb.toString();
  }
}
