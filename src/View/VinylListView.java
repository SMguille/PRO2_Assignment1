package View;

import Model.Vinyl;
import ViewModel.VinylListViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class VinylListView
{
  @FXML
  private TableView<Vinyl> tableView;

  @FXML
    private TableColumn<Vinyl, String> titleColumn;

  @FXML
  private TableColumn<Vinyl, String> idColumn;

  @FXML
  private TableColumn<Vinyl, String> releaseYearColumn;

  @FXML private TableColumn<Vinyl, String> stateColumn;

  @FXML
  private Button logInButton;

  @FXML
  private Button reserveButton;

  @FXML
  private Button removeButton;

  @FXML
  private Button borrowButton;

  @FXML
  private TextField idText;

  @FXML
  private Label idLabel;


  private ObservableList<Vinyl> vinylList = FXCollections.observableArrayList();

  private VinylListViewModel vinylListViewModel;

  public VinylListView(VinylListViewModel vinylListViewModel){
    this.vinylListViewModel = vinylListViewModel;
  }

  @FXML
  private void onLogIn() {
    //Instead of this, I need to put the userID as a parameter in the methods.
    //vinylListViewModel.logIn();
  }

  @FXML
  private void onReserve() {
    vinylListViewModel.reserveVinyl(tableView.getSelectionModel().getSelectedItem());
  }

  @FXML
  private void onBorrow(){
    vinylListViewModel.borrowVinyl(tableView.getSelectionModel().getSelectedItem());
  }
  @FXML
  private void onReturn(){
    vinylListViewModel.returnVinyl(tableView.getSelectionModel().getSelectedItem());
  }

  @FXML
  private void onRemove() {
    vinylListViewModel.removeVinyl(tableView.getSelectionModel().getSelectedItem());
  }

  public void initialize() {
    // Asignar valores a las columnas
    titleColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTitle()));
    idColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getArtist()));
    releaseYearColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getReleaseYear())));
    stateColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().stateMessage()));


    idText.textProperty().bindBidirectional(vinylListViewModel.userIdProperty());

    tableView.setItems(vinylListViewModel.getVinyls());
  }
}
