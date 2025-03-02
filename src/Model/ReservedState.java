package Model;

public class ReservedState implements VinylState
{

  @Override public void onReserve(Vinyl vinyl)
  {
    //Nothing because it is already reserved
  }

  @Override public void onBorrow(Vinyl vinyl)
  {
    vinyl.changeToBorrowed();
  }

  @Override public void onReturn(Vinyl vinyl)
  {
    //We should be able to unreserve the vinyl
  }

  @Override public void onRemove(Vinyl vinyl)
  {
    //Nothing because it is reserved, possibly wait until available.
  }
}
