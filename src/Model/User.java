package Model;

import java.util.Random;

public class User implements Runnable
{
  private String name;
  private Model model;

  public User(String name)
  {
    this.name = name;
    this.model = new Model();
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Override public void run()
  {
    while (true)
    {
      Random random = new Random();
      int option = random.nextInt(2) + 1;
      int vinylsSize = model.getVinylList().size();
      int selectedVinyl = random.nextInt(vinylsSize);

      switch (option)
      {
        case 1:
          model.reserveVinyl(model.getVinylList().get(selectedVinyl),
              this.getName());
          break;
        case 2:
          model.borrowVinyl(model.getVinylList().get(selectedVinyl),
              this.getName());
          break;
        case 3:
          model.returnVinyl(model.getVinylList().get(selectedVinyl),
              this.getName());
          break;
      }
    }
  }
}
