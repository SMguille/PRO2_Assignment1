package Application;

import Factory.ModelFactory;
import Factory.ViewFactory;
import Factory.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
  public static void main(String[] args)
  {
    launch();
  }

  @Override public void start(Stage primaryStage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewFactory viewFactory = new ViewFactory(viewModelFactory, primaryStage);

    viewFactory.getVinylListView();
    //viewFactory.getUserListView(); --> CreateVinylView

  }
}
