package View;

import Model.Vinyl;
import ViewModel.VinylListViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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

  @FXML
  private TableColumn<Vinyl, String> stateColumn;

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

  private VinylListViewModel listViewModel;



  @FXML
  private void onLogIn() {
    // Lógica para iniciar sesión
  }

  @FXML
  private void onReserve() {
    listViewModel.reserveVinyl(tableView.getSelectionModel().getSelectedItem());
  }

  @FXML
  private void onBorrow() {
    listViewModel.borrowVinyl(tableView.getSelectionModel().getSelectedItem());
  }

  @FXML
  private void onRemove() {
    listViewModel.removeVinyl(tableView.getSelectionModel().getSelectedItem(), String.valueOf(idText));
  }

  private ObservableList<Vinyl> vinylList = FXCollections.observableArrayList();

  public void initialize() {
    // Asignar valores a las columnas
    titleColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTitle()));
    idColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getArtist()));
    releaseYearColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getReleaseYear())));
    //stateColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getState())); IMPLEMENT THIS LATER

    // Agregar datos de prueba
    vinylList.add(new Vinyl("Abbey Road", "The Beatles", 1969));
    vinylList.add(new Vinyl("Dark Side of the Moon", "Pink Floyd", 1973));

    idText.textProperty().bindBidirectional(listViewModel.userIdProperty());

    tableView.setItems(listViewModel.getVinyls());
  }


}
