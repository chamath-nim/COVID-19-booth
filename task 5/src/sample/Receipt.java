package sample;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Receipt {
    public Button enclose;
    public Label l1;
    public Label l2;
    public Label l3;
    public Label l4;
    public Label l5;
    public Label l6;
    public Label l7;
    public Label l8;

    @FXML
    public void close(javafx.event.ActionEvent actionEvent) {
        Stage previousStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        previousStage.close();
    }
    @FXML
    public void print(String name1,String name2,String age,String city,String nic,String vaccine, String booth) {
        l1.setText(name1 + " " + name2);
        l2.setText(age);
        l3.setText(city);
        l4.setText(nic);
        l5.setText(vaccine);
        l6.setText(booth);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        l7.setText(dateFormat.format(date));
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        l8.setText(timeFormat.format(cal.getTime()));
    }
}
