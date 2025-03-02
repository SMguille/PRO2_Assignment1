package Model;

public class BorrowedReservedState implements VinylState
{
  @Override public void onReserve(Vinyl vinyl)
  {
    //Nothing because it is already reserved
  }

  @Override public void onBorrow(Vinyl vinyl)
  {
    //Nothing because it is already borrowed
  }

  @Override public void onReturn(Vinyl vinyl)
  {
    vinyl.changeToBorrowed(); //Right now this works because there is no cancel reservation method
  }

  @Override public void onRemove(Vinyl vinyl)
  {
    // It cannot be removed
  }
}
