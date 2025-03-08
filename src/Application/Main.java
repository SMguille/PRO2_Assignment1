package Application;

import Factory.ModelFactory;
import Factory.ViewFactory;
import Factory.ViewModelFactory;
import Model.User;
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
    viewFactory.getCreateVinylView();

    User user1 = new User("1");
    User user2 = new User("2");
    User user3 = new User("3");
    User user4 = new User("4");

    Thread thread1 = new Thread(user1);
    Thread thread2 = new Thread(user2);
    Thread thread3 = new Thread(user3);
    Thread thread4 = new Thread(user4);

    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();

    thread1.setDaemon(true);
    thread2.setDaemon(true);
    thread3.setDaemon(true);
    thread4.setDaemon(true);
  }
}
