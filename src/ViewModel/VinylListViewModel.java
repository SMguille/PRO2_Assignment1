package ViewModel;

import Factory.ModelFactory;
import Factory.ViewFactory;
import Factory.ViewModelFactory;
import Model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Vinyl;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
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
    model.addPropertyChangeListener("listChanged", this::update);
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

  public void removeVinyl(Vinyl vinyl){
    model.removeVinyl(vinyl, userId.getValue());
  }
  public void reserveVinyl(Vinyl vinyl){
    model.reserveVinyl(vinyl, userId.getValue());
  }
  public void borrowVinyl(Vinyl vinyl){
    model.borrowVinyl(vinyl, userId.getValue());
  }
  public void returnVinyl(Vinyl vinyl){
    model.returnVinyl(vinyl, userId.getValue());
  }
}