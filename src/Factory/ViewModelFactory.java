package Factory;

import ViewModel.CreateVinylViewModel;
import ViewModel.VinylListViewModel;

public class ViewModelFactory
{
  private VinylListViewModel vinylListViewModel;
  private CreateVinylViewModel createVinylViewModel;

  private ModelFactory modelFactory;


  public ViewModelFactory(ModelFactory modelFactory){
    this.modelFactory = modelFactory;
  }


  public VinylListViewModel getVinylListViewModel()
  {
    if(vinylListViewModel == null)
    {
      vinylListViewModel = new VinylListViewModel(modelFactory.getModel());
    }
    return vinylListViewModel;
  }

  public CreateVinylViewModel getCreateVinylViewModel()
  {
    if (createVinylViewModel == null){
      createVinylViewModel = new CreateVinylViewModel(modelFactory.getModel());
    }
    return createVinylViewModel;
  }
}
