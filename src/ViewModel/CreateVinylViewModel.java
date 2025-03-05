package ViewModel;

import Model.Model;
import javafx.beans.property.*;

public class CreateVinylViewModel
{

  private StringProperty title;
  private StringProperty artist;
  private StringProperty releaseYear;

  private Model model;

  public CreateVinylViewModel(Model model){
    this.model = model;
    this.title = new SimpleStringProperty();
    this.artist = new SimpleStringProperty();
    this.releaseYear = new SimpleStringProperty();
  }
  //StringProperty title, StringProperty artist, IntegerProperty releaseYear
  public void addVinyl(){
    model.addVinyl(title.getValue(), artist.getValue(),
        Integer.parseInt(releaseYear.getValue()));
  }

  public String getReleaseYear()
  {
    return releaseYear.get();
  }

  public StringProperty releaseYearProperty()
  {
    return releaseYear;
  }

  public String getArtist()
  {
    return artist.get();
  }

  public StringProperty artistProperty()
  {
    return artist;
  }

  public String getTitle()
  {
    return title.get();
  }

  public StringProperty titleProperty()
  {
    return title;
  }
}
