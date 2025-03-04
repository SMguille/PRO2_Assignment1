package Model;

public class BorrowedReservedState implements VinylState
{
  @Override public void onReserve(Vinyl vinyl)
  {
    vinyl.changeToBorrowed(); //Cancel only the reservation
  }

  @Override public void onBorrow(Vinyl vinyl)
  {
    //Nothing because it is already borrowed
  }

  @Override public void onReturn(Vinyl vinyl)
  {
    vinyl.changeToReserved();
  }

  @Override public String stateMessage(Vinyl vinyl)
  {
    return "Borrowed by " + vinyl.getBorrowedUserId() + " and reserved by " + vinyl.getReservedUserId();
  }

  @Override public String toString(){
    return "BorrowedReservedState";
  }
}
