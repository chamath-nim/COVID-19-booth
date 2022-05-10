package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddDetails {

    public Button btnSubmit;
    public Button btnReceipt;
    public TextField firstname ;
    public TextField surname;
    public TextField age;
    public TextField city;
    public TextField nic;
    public TextField reqVac;
    public TextField booth;
    private Parent root;

    @FXML
    public void submitQuit(javafx.event.ActionEvent actionEvent) throws Exception {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        newStage.setTitle("First Window");
        newStage.setScene(new Scene(root, 750, 497));
        newStage.show();

        Stage previousStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        previousStage.close();
    }
    @FXML
    String fname;
    String sname,Age,City,NIC,vaccine,Booth;

    public void genReceipt(javafx.event.ActionEvent actionEvent) throws Exception {
        fname = firstname.getText();
        sname = surname.getText();
        Age = age.getText();
        City = city.getText();
        NIC = nic.getText();
        vaccine = reqVac.getText();
        Booth = booth.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Receipt.fxml"));
        root = loader.load();
        Receipt receipt = loader.getController();
        receipt.print(fname,sname,Age,City,NIC,vaccine,Booth);

        Stage newStage = new Stage();
        newStage.setTitle("Receipt");
        newStage.setScene(new Scene(root, 750, 497));
        newStage.show();
    }
}
