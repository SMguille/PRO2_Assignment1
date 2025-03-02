package Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class Model implements PropertyChangeSubject
{
  private List<Vinyl> vinylList;
  private User user;
  private PropertyChangeSupport support;

  public Model(List<Vinyl> vinylList)
  {
    this.vinylList = vinylList;
    this.support = new PropertyChangeSupport(this);
  }

  public List<Vinyl> getVinylList()
  {
    return vinylList;
  }

  public void addVinyl(String title, String artist, int releaseYear) {
    vinylList.add(new Vinyl(title, artist, releaseYear));
    support.firePropertyChange("VinylAdded", null, vinylList);
}

  public void removeVinyl(Vinyl vinyl, String removingUserId)
  {
    if (vinyl.getCurrentState().toString().equals("AvailableState")
        || vinyl.getCurrentState().toString().equals("ReservedState") && vinyl.getReservedUserId().equals(removingUserId))
    {
      vinylList.remove(vinyl); //Anyone or the user that has reserved the vinyl can remove a vinyl that is in the store (It is still in the shop so he cannot steal it)
      support.firePropertyChange("VinylRemoved", null, vinylList);
    }
}

  public void reserveVinyl(Vinyl vinyl){
    vinyl.reserve();
  }
  public void borrowVinyl(Vinyl vinyl){
    vinyl.borrow();
  }
  public void returnVinyl(Vinyl vinyl){
    vinyl.onReturn();
  }

  @Override public void addPropertyChangeListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
    support.firePropertyChange(new PropertyChangeEvent(this, null, null, vinylList));
    // To tell ViewModel that the list has changed
  }

  @Override public void addPropertyChangeListener(String name, PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
    support.firePropertyChange(new PropertyChangeEvent(this, name, null, vinylList));
  }

  @Override public void removePropertyChangeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String name, PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }
}
