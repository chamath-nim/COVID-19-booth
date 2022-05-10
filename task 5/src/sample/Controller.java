package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

    public Button btnAddDetails;
    public Button btnQuit;

    @FXML
    public void AddData(ActionEvent actionEvent) throws Exception{
        Stage newStage = new Stage();
        newStage.setTitle("Add Details");
        Parent root = FXMLLoader.load(getClass().getResource("addDetails.fxml"));
        newStage.setScene(new Scene(root, 750, 497));
        newStage.show();

        Stage previousStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        previousStage.close();
    }
    @FXML
    public void quit(javafx.event.ActionEvent actionEvent) {
        Stage previousStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        previousStage.setTitle("Vaccination Centre");
        previousStage.close();
    }
}
