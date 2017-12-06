package Controller;


import Model.Listeners.BackButtonListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

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
        root.getChildren().addAll(buttonPane, createPane, checkPane);
        stackPane.getChildren().add(root);

        FXMLLoader createLoader =new FXMLLoader(getClass().getResource("/FXML/createStart.fxml"));
        // I want to extract the controller from
        createLoader.setControllerFactory(new Callback<Class<?>, Object>() {

            @Override
            public Object call(Class<?> controllerClass) {
                if (controllerClass == CreateController.class) {
                    CreateController createController = new CreateController();
                    //upon extraction of controller ... i will set this main class Controller to set a backbutton listener
                    // to the createController
                    createController.setBackButtonListener(new BackButtonListener() {
                        @Override
                        public void backButtonClicked() {
                            clearPanes();
                            buttonPane.setVisible(true);
                        }
                    });
                    return createController;
                } else {
                    try {
                        return controllerClass.newInstance();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }

        });

        FXMLLoader checkLoader = new FXMLLoader(getClass().getResource("/FXML/check.fxml"));
        try {

           StackPane pane = createLoader.load();
           createPane.getChildren().add(pane);

            AnchorPane pane2 = checkLoader.load();
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
