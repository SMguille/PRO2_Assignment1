package Model;

public interface VinylState
{
  void onReserve(Vinyl vinyl);
  void onBorrow(Vinyl vinyl);
  void onReturn(Vinyl vinyl);
  //void onDelete(Vinyl vinyl);
  String stateMessage(Vinyl vinyl);

}
