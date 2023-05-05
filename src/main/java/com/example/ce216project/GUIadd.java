package com.example.ce216project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    @FXML
    public TextField addtext5;
    @FXML
    public TextField addtext6;
    @FXML
    public ImageView flagImage1;
    @FXML
    public ImageView flagImage2;
    @FXML
    public ImageView flagImage3;
    @FXML
    public ImageView flagImage4;
    @FXML
    public ImageView flagImage5;
    @FXML
    public ImageView flagImage6;

    @FXML
    public Button saveButton;

    public String[]language={"Turkish","English","French","Italian","Swedish","German","Modern Greek"};

    Image imageTurkish = new Image("com/example/ce216project/Flag_of_Turkey.svg.png");
    Image imageGerman = new Image("com/example/ce216project/Flag_of_Germany.svg.png");
    Image imageItalian = new Image("com/example/ce216project/Flag_of_Italy.svg.png");
    Image imageGreek = new Image("com/example/ce216project/Flag_of_Greece.svg.png");
    Image imageEnglish = new Image("com/example/ce216project/Flag_of_the_United_Kingdom_(3-5).svg.png");
    Image imageSwedish = new Image("com/example/ce216project/Flag_of_Sweden.svg.png");
    Image imageFrench = new Image("com/example/ce216project/Flag_of_France.svg.png");
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
    public void displayAddWordForm(ActionEvent event)throws IOException {
        if (getLanguage().equals("English")) {
            addtext1.setVisible(true);
            addtext2.setVisible(true);
            addtext3.setVisible(true);
            addtext4.setVisible(true);
            addtext5.setVisible(true);
            addtext6.setVisible(true);
            saveButton.setVisible(true);
            flagImage1.setImage(imageTurkish);
            flagImage2.setImage(imageGerman);
            flagImage3.setImage(imageGreek);
            flagImage4.setImage(imageSwedish);
            flagImage5.setImage(imageFrench);
            flagImage6.setImage(imageItalian);
        }
        if (getLanguage().equals("Turkish")) {
            addtext1.setVisible(true);
            addtext2.setVisible(true);
            addtext3.setVisible(true);
            addtext4.setVisible(true);
            addtext5.setVisible(true);
            addtext6.setVisible(true);
            saveButton.setVisible(true);
            flagImage1.setImage(imageEnglish);
            flagImage2.setImage(imageGerman);
            flagImage3.setImage(imageGreek);
            flagImage4.setImage(imageSwedish);
            flagImage5.setImage(imageFrench);
            flagImage6.setImage(imageItalian);
        }
        if (getLanguage().equals("Swedish")) {
            addtext1.setVisible(true);
            addtext2.setVisible(true);
            addtext3.setVisible(true);
            addtext4.setVisible(true);
            addtext5.setVisible(true);
            addtext6.setVisible(true);
            saveButton.setVisible(true);
            flagImage1.setImage(imageTurkish);
            flagImage2.setImage(imageGerman);
            flagImage3.setImage(imageGreek);
            flagImage4.setImage(imageEnglish);
            flagImage5.setImage(imageFrench);
            flagImage6.setImage(imageItalian);
        }
        if (getLanguage().equals("Italian")) {
            addtext1.setVisible(true);
            addtext2.setVisible(true);
            addtext3.setVisible(true);
            addtext4.setVisible(true);
            addtext5.setVisible(true);
            addtext6.setVisible(true);
            saveButton.setVisible(true);
            flagImage1.setImage(imageTurkish);
            flagImage2.setImage(imageGerman);
            flagImage3.setImage(imageGreek);
            flagImage4.setImage(imageSwedish);
            flagImage5.setImage(imageFrench);
            flagImage6.setImage(imageEnglish);
        }
        if (getLanguage().equals("Modern Greek")) {
            addtext1.setVisible(true);
            addtext2.setVisible(true);
            addtext3.setVisible(true);
            addtext4.setVisible(true);
            addtext5.setVisible(true);
            addtext6.setVisible(true);
            saveButton.setVisible(true);
            flagImage1.setImage(imageTurkish);
            flagImage2.setImage(imageGerman);
            flagImage3.setImage(imageEnglish);
            flagImage4.setImage(imageSwedish);
            flagImage5.setImage(imageFrench);
            flagImage6.setImage(imageItalian);
        }
        if (getLanguage().equals("French")) {
            addtext1.setVisible(true);
            addtext2.setVisible(true);
            addtext3.setVisible(true);
            addtext4.setVisible(true);
            addtext5.setVisible(true);
            addtext6.setVisible(true);
            saveButton.setVisible(true);
            flagImage1.setImage(imageTurkish);
            flagImage2.setImage(imageGerman);
            flagImage3.setImage(imageGreek);
            flagImage4.setImage(imageSwedish);
            flagImage5.setImage(imageEnglish);
            flagImage6.setImage(imageItalian);
        }
        if (getLanguage().equals("German")) {
            addtext1.setVisible(true);
            addtext2.setVisible(true);
            addtext3.setVisible(true);
            addtext4.setVisible(true);
            addtext5.setVisible(true);
            addtext6.setVisible(true);
            saveButton.setVisible(true);
            flagImage1.setImage(imageTurkish);
            flagImage2.setImage(imageEnglish);
            flagImage3.setImage(imageGreek);
            flagImage4.setImage(imageSwedish);
            flagImage5.setImage(imageFrench);
            flagImage6.setImage(imageItalian);
        }





    }

    public void enterAddWorForm(ActionEvent event) throws  IOException {
        if (getLanguage().equals("English")) {
            System.out.println(wordTextField.getText());
            ArrayList<String>turkishtranslate = new ArrayList<>();
            ArrayList<String>germantranslate = new ArrayList<>();
            ArrayList<String>moderngtranslate = new ArrayList<>();
            ArrayList<String>swedishtranslate = new ArrayList<>();
            ArrayList<String>frenchtranslate = new ArrayList<>();
            ArrayList<String>italiantranslate = new ArrayList<>();
            turkishtranslate.add(addtext1.getText());
            germantranslate.add(addtext2.getText());
            moderngtranslate.add(addtext3.getText());
            swedishtranslate.add(addtext4.getText());
            frenchtranslate.add(addtext5.getText());
            italiantranslate.add(addtext6.getText());

            if (saveButton.isDisabled() == false) {
                Dictionary.graph.addWord(wordTextField.getText(),"English","Turkish",turkishtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"English","German",germantranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"English","Modern Greek",moderngtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"English","Swedish",swedishtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"English","French",frenchtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"English","Italian",italiantranslate);
            }
        }
        if (getLanguage().equals("Turkish")) {
            System.out.println(wordTextField.getText());
            ArrayList<String>englishtranslate = new ArrayList<>();
            ArrayList<String>germantranslate = new ArrayList<>();
            ArrayList<String>moderngtranslate = new ArrayList<>();
            ArrayList<String>swedishtranslate = new ArrayList<>();
            ArrayList<String>frenchtranslate = new ArrayList<>();
            ArrayList<String>italiantranslate = new ArrayList<>();
            englishtranslate.add(addtext1.getText());
            germantranslate.add(addtext2.getText());
            moderngtranslate.add(addtext3.getText());
            swedishtranslate.add(addtext4.getText());
            frenchtranslate.add(addtext5.getText());
            italiantranslate.add(addtext6.getText());

            if (saveButton.isDisabled() == false) {
                Dictionary.graph.addWord(wordTextField.getText(),"Turkish","English",englishtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"Turkish","German",germantranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"Turkish","Modern Greek",moderngtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"Turkish","Swedish",swedishtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"Turkish","French",frenchtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"Turkish","Italian",italiantranslate);
            }
        }
        if (getLanguage().equals("Swedish")) {
            System.out.println(wordTextField.getText());
            ArrayList<String>turkishtranslate = new ArrayList<>();
            ArrayList<String>germantranslate = new ArrayList<>();
            ArrayList<String>moderngtranslate = new ArrayList<>();
            ArrayList<String>englishtranslate = new ArrayList<>();
            ArrayList<String>frenchtranslate = new ArrayList<>();
            ArrayList<String>italiantranslate = new ArrayList<>();
            turkishtranslate.add(addtext1.getText());
            germantranslate.add(addtext2.getText());
            moderngtranslate.add(addtext3.getText());
            englishtranslate.add(addtext4.getText());
            frenchtranslate.add(addtext5.getText());
            italiantranslate.add(addtext6.getText());

            if (saveButton.isDisabled() == false) {
                Dictionary.graph.addWord(wordTextField.getText(),"Swedish","Turkish",turkishtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"Swedish","German",germantranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"Swedish","Modern Greek",moderngtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"Swedish","English",englishtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"Swedish","French",frenchtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"Swedish","Italian",italiantranslate);
            }
        }
        if (getLanguage().equals("Italian")) {
            System.out.println(wordTextField.getText());
            ArrayList<String>turkishtranslate = new ArrayList<>();
            ArrayList<String>germantranslate = new ArrayList<>();
            ArrayList<String>moderngtranslate = new ArrayList<>();
            ArrayList<String>swedishtranslate = new ArrayList<>();
            ArrayList<String>frenchtranslate = new ArrayList<>();
            ArrayList<String>englishtranslate = new ArrayList<>();
            turkishtranslate.add(addtext1.getText());
            germantranslate.add(addtext2.getText());
            moderngtranslate.add(addtext3.getText());
            swedishtranslate.add(addtext4.getText());
            frenchtranslate.add(addtext5.getText());
            englishtranslate.add(addtext6.getText());

            if (saveButton.isDisabled() == false) {
                Dictionary.graph.addWord(wordTextField.getText(),"Italian","Turkish",turkishtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"Italian","German",germantranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"Italian","Modern Greek",moderngtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"Italian","Swedish",swedishtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"Italian","French",frenchtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"Italian","English",englishtranslate);
            }
        }
        if (getLanguage().equals("Modern Greek")) {
            System.out.println(wordTextField.getText());
            ArrayList<String>turkishtranslate = new ArrayList<>();
            ArrayList<String>germantranslate = new ArrayList<>();
            ArrayList<String>englishtranslate = new ArrayList<>();
            ArrayList<String>swedishtranslate = new ArrayList<>();
            ArrayList<String>frenchtranslate = new ArrayList<>();
            ArrayList<String>italiantranslate = new ArrayList<>();
            turkishtranslate.add(addtext1.getText());
            germantranslate.add(addtext2.getText());
            englishtranslate.add(addtext3.getText());
            swedishtranslate.add(addtext4.getText());
            frenchtranslate.add(addtext5.getText());
            italiantranslate.add(addtext6.getText());

            if (saveButton.isDisabled() == false) {
                Dictionary.graph.addWord(wordTextField.getText(),"Modern Greek","Turkish",turkishtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"Modern Greek","German",germantranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"Modern Greek","English",englishtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"Modern Greek","Swedish",swedishtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"Modern Greek","French",frenchtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"Modern Greek","Italian",italiantranslate);
            }
        }
        if (getLanguage().equals("French")) {
            System.out.println(wordTextField.getText());
            ArrayList<String>turkishtranslate = new ArrayList<>();
            ArrayList<String>germantranslate = new ArrayList<>();
            ArrayList<String>moderngtranslate = new ArrayList<>();
            ArrayList<String>swedishtranslate = new ArrayList<>();
            ArrayList<String>englishtranslate = new ArrayList<>();
            ArrayList<String>italiantranslate = new ArrayList<>();
            turkishtranslate.add(addtext1.getText());
            germantranslate.add(addtext2.getText());
            moderngtranslate.add(addtext3.getText());
            swedishtranslate.add(addtext4.getText());
            englishtranslate.add(addtext5.getText());
            italiantranslate.add(addtext6.getText());

            if (saveButton.isDisabled() == false) {
                Dictionary.graph.addWord(wordTextField.getText(),"French","Turkish",turkishtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"French","German",germantranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"French","Modern Greek",moderngtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"French","Swedish",swedishtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"French","English",englishtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"French","Italian",italiantranslate);
            }
        }
        if (getLanguage().equals("German")) {
            System.out.println(wordTextField.getText());
            ArrayList<String>turkishtranslate = new ArrayList<>();
            ArrayList<String>englishtranslate = new ArrayList<>();
            ArrayList<String>moderngtranslate = new ArrayList<>();
            ArrayList<String>swedishtranslate = new ArrayList<>();
            ArrayList<String>frenchtranslate = new ArrayList<>();
            ArrayList<String>italiantranslate = new ArrayList<>();
            turkishtranslate.add(addtext1.getText());
            englishtranslate.add(addtext2.getText());
            moderngtranslate.add(addtext3.getText());
            swedishtranslate.add(addtext4.getText());
            frenchtranslate.add(addtext5.getText());
            italiantranslate.add(addtext6.getText());

            if (saveButton.isDisabled() == false) {
                Dictionary.graph.addWord(wordTextField.getText(),"German","Turkish",turkishtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"German","English",englishtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"German","Modern Greek",moderngtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"German","Swedish",swedishtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"German","French",frenchtranslate);
                Dictionary.graph.addWord(wordTextField.getText(),"German","Italian",italiantranslate);
            }
        }

    }
}
