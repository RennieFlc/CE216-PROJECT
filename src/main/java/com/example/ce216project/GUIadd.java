package com.example.ce216project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GUIadd implements Initializable {
    @FXML
    public ChoiceBox<String> myChoiceBox;
    @FXML
    public Button addButton;
    @FXML
    public TextField wordTextField;
    @FXML
    public TextField addtext1;
    @FXML
    public TextField addtext2;
    @FXML
    public TextField addtext3;
    @FXML
    public TextField addtext4;

    public String[]language={"Turkish","English","French","Italian","Swedish","German","Modern Greek"};
    public static String mainLanguage;
    public static Graph graph;
    public static Dictionary dictionary;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        myChoiceBox.getItems().addAll(language);
    }
    public String getLanguage()
    {
        mainLanguage = myChoiceBox.getValue();
        this.mainLanguage = mainLanguage;
        return mainLanguage;
    }
    public void displayAddWordForm(ActionEvent event)throws IOException
    {
        addtext1.setVisible(true);
        addtext2.setVisible(true);
        addtext3.setVisible(true);
        addtext4.setVisible(true);

        if (getLanguage().equals("English"))
        {
            //graph.addWord(wordTextField.getText(), "English", "Turkish", addtext1.getText());
            //


        }
        if (getLanguage().equals("Turkish"))
        {}
        if (getLanguage().equals("Swedish"))
        {}
        if (getLanguage().equals("Italian"))
        {}
        if (getLanguage().equals("Modern Greek"))
        {}
        if (getLanguage().equals("French"))
        {}
        if (getLanguage().equals("German"))
        {}

    }
}
