package Factory;

import View.VinylListView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory
{
  private VinylListView vinylListView;
  private ViewModelFactory viewModelFactory;

  private final Stage primaryStage;
  private FXMLLoader fxmlLoader;


  public ViewFactory(ViewModelFactory viewModelFactory, Stage primaryStage)
  {
    this.viewModelFactory = viewModelFactory;
    this.primaryStage = primaryStage;
  }

  public VinylListView getVinylListView() throws IOException
  {
    if(vinylListView == null)
    {
      fxmlLoader = new FXMLLoader(getClass().getResource("../View/VinylListView.fxml"));
      fxmlLoader.setControllerFactory(controllerClass -> new VinylListView(viewModelFactory.getVinylListViewModel()));

      Scene vinylListScene = new Scene(fxmlLoader.load());
      primaryStage.setTitle("View Vinyls");
      primaryStage.setScene(vinylListScene);
      primaryStage.show();
      vinylListView = fxmlLoader.getController();
    }
    return vinylListView;
  }
/*
  public CreateUserView getCreateUserView() throws IOException
  {
    if(createUserView == null)
    {
      fxmlLoader = new FXMLLoader(getClass().getResource("../CreateUser/CreateUserView.fxml"));
      fxmlLoader.setControllerFactory(controllerClass -> new CreateUserView(viewModelFactory.getCreateUserViewModel()));

      Scene userListScene = new Scene(fxmlLoader.load());
      Stage secondaryStage = new Stage();
      secondaryStage.setTitle("Create User");
      secondaryStage.setScene(userListScene);
      secondaryStage.show();
      createUserView = fxmlLoader.getController();
    }
    return createUserView;
  }

 */

}
