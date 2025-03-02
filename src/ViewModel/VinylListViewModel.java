package ViewModel;

import Model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Vinyl;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class VinylListViewModel
{
  private Model model;
  private ObservableList<Vinyl> vinyls;
  private StringProperty userId;

  public VinylListViewModel(Model model)
  {
    this.model = model;
    this.userId = new SimpleStringProperty();
    vinyls = FXCollections.observableArrayList();
    model.addPropertyChangeListener("VinylAdded", this::update);
    model.addPropertyChangeListener("VinylRemoved", this::update);
  }

  private void update(PropertyChangeEvent event)
  {
    List<Vinyl> newVinyls = (List<Vinyl>) event.getNewValue();
    vinyls.clear();
    vinyls.addAll(newVinyls);
  }
  public StringProperty userIdProperty(){
    return userId;
  }

  public ObservableList<Vinyl> getVinyls(){
    return vinyls;
  }

  public void removeVinyl(Vinyl vinyl, String removingUserId){
    model.removeVinyl(vinyl, removingUserId);
  }
  public void reserveVinyl(Vinyl vinyl){
    model.reserveVinyl(vinyl);
  }
  public void borrowVinyl(Vinyl vinyl){
    model.borrowVinyl(vinyl);
  }
  public void returnVinyl(Vinyl vinyl){
    model.returnVinyl(vinyl);
  }

}
