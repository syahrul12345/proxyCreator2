package Controller;

import Model.Listeners.BackButtonListener;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


import java.net.URL;
import java.util.ResourceBundle;

public class CreateController implements Initializable{

    @FXML private Button backBtn;
    private BackButtonListener backButtonListener;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void googleCloudBtnClicked(ActionEvent actionEvent) {

    }

    public void awsBtnClicked(ActionEvent actionEvent) {
    }

    public void host1plusBtnClicked(ActionEvent actionEvent) {
    }

    public void digitalOceanBtnClicked(ActionEvent actionEvent) {
    }

    public void backBtnClicked(ActionEvent actionEvent) {

        if(backButtonListener != null) {
            backButtonListener.backButtonClicked();
        }
    }
    public void setBackButtonListener(BackButtonListener buttonListener) {
        this.backButtonListener = buttonListener;
    }


}
