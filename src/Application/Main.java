package Application;

import Factory.ModelFactory;
import Factory.ViewFactory;
import Factory.ViewModelFactory;
import Model.User;
import Model.Model;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

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

    Model model = modelFactory.getModel();

    viewFactory.getVinylListView();
    viewFactory.getCreateVinylView();

    List<User> userList = new ArrayList<>();
    List<Thread> threads = new ArrayList<>();

    // Number of users
    int numUsers = 3;

    // Create users in a loop
    for (int i = 1; i <= numUsers; i++) {
      User user = new User("User " + i, model);
      userList.add(user);

      // Create a thread for each user
      Thread thread = new Thread(user);
      thread.setDaemon(true);
      threads.add(thread);
    }
    for (Thread thread : threads){
      thread.start();
    }
  }
}
