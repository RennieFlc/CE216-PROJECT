package com.example.ce216project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GUI implements Initializable {
    @FXML
    public ChoiceBox<String> myChoiceBox;
    @FXML
    public Label myLabel;
    @FXML
    public Button myButton;
    @FXML
    public Button editButton;
    @FXML
    private TextField myTextField;
    @FXML
    private ScrollPane myScrollpane;

    //edit part
    @FXML
    public TextField editTextField;

    @FXML
    public ChoiceBox editChoiceBox;

    @FXML
    public Button editShowTranslationsButton;

    @FXML
    public TextField editNewWordTextField;

    @FXML
    public Button editEditButton;

    @FXML
    public ScrollPane editScrollPane;

    public String[]language={"Turkish","English","French","Italian","Swedish","German","Modern Greek"};
    public static String mainLanguage;
    public String searchWord;
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
    public String getWord() {
        searchWord = myTextField.getText().toLowerCase();
        if (searchWord.isEmpty()) {
            // Return null or empty string, or show an error message
            return null;
        } else {
            return searchWord;
        }
    }



    public static void displayManual() {

    }

    public  void displaySearchResults(ActionEvent event) {
        if (getLanguage().equals("English"))
        {
            List<String> translationstr = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Turkish");
            List<String> translationsger = Dictionary.graph.getTranslations(getWord(),getLanguage(),"German");
            List<String> translationsmd = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Modern Greek");
            List<String> translationssw = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Swedish");
            List<String> translationsfr = Dictionary.graph.getTranslations(getWord(),getLanguage(),"French");
            List<String> translationsita = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Italian");
            StringBuilder sb = new StringBuilder();

            sb.append("---Turkish---").append("\n");
            for (String translation : translationstr) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---German---").append("\n");
            for (String translation : translationsger) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---Modern Greek---").append("\n");
            for (String translation : translationsmd) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---Swedish---").append("\n");
            for (String translation : translationssw) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---French---").append("\n");
            for (String translation : translationsfr) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---Italian---").append("\n");
            for (String translation : translationsita) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            myScrollpane.setContent(myLabel);
            myScrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            myScrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            System.out.println(sb.toString());
            myLabel.setText(sb.toString());
        }
        if (getLanguage().equals("Turkish"))
        {
            List<String> translationseng = Dictionary.graph.getTranslations(getWord(),getLanguage(),"English");
            List<String> translationsger = Dictionary.graph.getTranslations(getWord(),getLanguage(),"German");
            List<String> translationsmd = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Modern Greek");
            List<String> translationssw = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Swedish");
            List<String> translationsfr = Dictionary.graph.getTranslations(getWord(),getLanguage(),"French");
            List<String> translationsita = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Italian");
            StringBuilder sb = new StringBuilder();

            sb.append("---English---").append("\n");
            for (String translation : translationseng) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---German---").append("\n");
            for (String translation : translationsger) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---Modern Greek---").append("\n");
            for (String translation : translationsmd) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---Swedish---").append("\n");
            for (String translation : translationssw) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---French---").append("\n");
            for (String translation : translationsfr) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---Italian---").append("\n");
            for (String translation : translationsita) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            myScrollpane.setContent(myLabel);
            myScrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            myScrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            System.out.println(sb.toString());
            myLabel.setText(sb.toString());
        }
        if (getLanguage().equals("Swedish"))
        {
            List<String> translationstr = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Turkish");
            List<String> translationsger = Dictionary.graph.getTranslations(getWord(),getLanguage(),"German");
            List<String> translationsmd = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Modern Greek");
            List<String> translationseng = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Swedish");
            List<String> translationsfr = Dictionary.graph.getTranslations(getWord(),getLanguage(),"French");
            List<String> translationsita = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Italian");
            StringBuilder sb = new StringBuilder();

            sb.append("---Turkish---").append("\n");
            for (String translation : translationstr) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---German---").append("\n");
            for (String translation : translationsger) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---Modern Greek---").append("\n");
            for (String translation : translationsmd) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---English---").append("\n");
            for (String translation : translationseng) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---French---").append("\n");
            for (String translation : translationsfr) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---Italian---").append("\n");
            for (String translation : translationsita) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            myScrollpane.setContent(myLabel);
            myScrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            myScrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            System.out.println(sb.toString());
            myLabel.setText(sb.toString());
        }
        if (getLanguage().equals("Italian"))
        {

            List<String> translationstr = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Turkish");
            List<String> translationsger = Dictionary.graph.getTranslations(getWord(),getLanguage(),"German");
            List<String> translationsmd = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Modern Greek");
            List<String> translationssw = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Swedish");
            List<String> translationsfr = Dictionary.graph.getTranslations(getWord(),getLanguage(),"French");
            List<String> translationseng = Dictionary.graph.getTranslations(getWord(),getLanguage(),"English");
            StringBuilder sb = new StringBuilder();

            sb.append("---Turkish---").append("\n");
            for (String translation : translationstr) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---German---").append("\n");
            for (String translation : translationsger) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---Modern Greek---").append("\n");
            for (String translation : translationsmd) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---Swedish---").append("\n");
            for (String translation : translationssw) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---French---").append("\n");
            for (String translation : translationsfr) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---English---").append("\n");
            for (String translation : translationseng) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            myScrollpane.setContent(myLabel);
            myScrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            myScrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            System.out.println(sb.toString());
            myLabel.setText(sb.toString());
        }
        if (getLanguage().equals("Modern Greek"))
        {
            List<String> translationstr = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Turkish");
            List<String> translationsger = Dictionary.graph.getTranslations(getWord(),getLanguage(),"German");
            List<String> translationeng = Dictionary.graph.getTranslations(getWord(),getLanguage(),"English");
            List<String> translationssw = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Swedish");
            List<String> translationsfr = Dictionary.graph.getTranslations(getWord(),getLanguage(),"French");
            List<String> translationsita = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Italian");
            StringBuilder sb = new StringBuilder();

            sb.append("---Turkish---").append("\n");
            for (String translation : translationstr) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---German---").append("\n");
            for (String translation : translationsger) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---English---").append("\n");
            for (String translation : translationeng) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---Swedish---").append("\n");
            for (String translation : translationssw) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---French---").append("\n");
            for (String translation : translationsfr) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---Italian---").append("\n");
            for (String translation : translationsita) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            myScrollpane.setContent(myLabel);
            myScrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            myScrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            System.out.println(sb.toString());
            myLabel.setText(sb.toString());
        }
        if (getLanguage().equalsIgnoreCase("French"))
        {
            System.out.println(Dictionary.graph.getTranslations(getWord(),getLanguage(),"Turkish"));
            List<String> translationstr = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Turkish");
            List<String> translationsger = Dictionary.graph.getTranslations(getWord(),getLanguage(),"German");
            List<String> translationsmd = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Modern Greek");
            List<String> translationssw = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Swedish");
            List<String> translationseng = Dictionary.graph.getTranslations(getWord(),getLanguage(),"English");
            List<String> translationsita = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Italian");
            StringBuilder sb = new StringBuilder();

            sb.append("---Turkish---").append("\n");
            for (String translation : translationstr) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---German---").append("\n");
            for (String translation : translationsger) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---Modern Greek---").append("\n");
            for (String translation : translationsmd) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---Swedish---").append("\n");
            for (String translation : translationssw) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---English---").append("\n");
            for (String translation : translationseng) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---Italian---").append("\n");
            for (String translation : translationsita) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            myScrollpane.setContent(myLabel);
            myScrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            myScrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            System.out.println(sb.toString());
            myLabel.setText(sb.toString());
        }
        if (getLanguage().equalsIgnoreCase("German"))
        {
            List<String> translationstr = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Turkish");
            List<String> translationseng = Dictionary.graph.getTranslations(getWord(),getLanguage(),"English");
            List<String> translationsmd = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Modern Greek");
            List<String> translationssw = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Swedish");
            List<String> translationsfr = Dictionary.graph.getTranslations(getWord(),getLanguage(),"French");
            List<String> translationsita = Dictionary.graph.getTranslations(getWord(),getLanguage(),"Italian");
            StringBuilder sb = new StringBuilder();

            sb.append("---Turkish---").append("\n");
            for (String translation : translationstr) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---German---").append("\n");
            for (String translation : translationseng) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---Modern Greek---").append("\n");
            for (String translation : translationsmd) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---Swedish---").append("\n");
            for (String translation : translationssw) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---French---").append("\n");
            for (String translation : translationsfr) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            sb.append("---Italian---").append("\n");
            for (String translation : translationsita) {
                sb.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }


            myScrollpane.setContent(myLabel);
            myScrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            myScrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            System.out.println(sb.toString());
            myLabel.setText(sb.toString());
        }
    }

    public void displayAddWordForm(ActionEvent event)throws IOException
    {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("add.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void displayEditWordForm(ActionEvent event)throws Exception {
        //List<String> translationsger = Dictionary.graph.getTranslations(getWord(),getLanguage(),"German");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("edit.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setScene(scene);
        stage.show();
        System.out.print("Write source language:");



    }

    public void displayHelpMenu (ActionEvent event) throws Exception {

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("help.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setScene(scene);
        stage.show();



    }

    public static void displayDeleteWordConfirmation() {

    }

    public static void displaySynonyms() {

    }

    public static void createGUI() {

    }


}
