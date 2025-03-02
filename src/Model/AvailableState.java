package Model;

public class AvailableState implements VinylState
{
  @Override public void onReserve(Vinyl vinyl)
  {
    vinyl.changeToReserved();;
  }

  @Override public void onBorrow(Vinyl vinyl)
  {
    vinyl.changeToBorrowed();
  }

  @Override public void onReturn(Vinyl vinyl)
  {
    //Nothing because it is available
  }

  @Override public void onRemove(Vinyl vinyl)
  {
    vinyl.removeFromList(vinyl); //Remove the vinyl from the list.
  }
}
