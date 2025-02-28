package Model;

public interface VinylState
{
  void onReserve(Vinyl vinyl);
  void onBorrow(Vinyl vinyl);
  void onReturn(Vinyl vinyl);
  void onRemove(Vinyl vinyl);

}
