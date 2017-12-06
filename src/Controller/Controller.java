package Controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane buttonPane;
    @FXML
    private StackPane createPane;
    @FXML
    private StackPane checkPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createPane.setVisible(false);
        checkPane.setVisible(false);

        Group root = new Group();
        root.getChildren().addAll(buttonPane,createPane,checkPane);
        stackPane.getChildren().add(root);


        try {
            // inject individual fxml to a a single pane
            StackPane pane = FXMLLoader.load(getClass().getResource("/FXML/createStart.fxml"));
            createPane.getChildren().add(pane);
            AnchorPane pane2 = FXMLLoader.load(getClass().getResource("/FXML/check.fxml"));
            checkPane.getChildren().add(pane2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void createImgClicked(MouseEvent mouseEvent) {
        clearPanes();
        createPane.setVisible(true);
    }

    public void CheckServersClicked(MouseEvent mouseEvent) {
        clearPanes();
        checkPane.setVisible(true);
    }
    public void clearPanes() {
        buttonPane.setVisible(false);
        createPane.setVisible(false);
        checkPane.setVisible(false);

    }
}
