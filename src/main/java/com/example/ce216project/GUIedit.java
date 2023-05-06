package com.example.ce216project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GUIedit implements Initializable {
    @FXML
    public ChoiceBox<String> myChoiceBox;
    @FXML
    public Button editButton;
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
    public void displayEditWordForm(ActionEvent event)throws IOException {
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
            List<String> translationstr = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Turkish");
            List<String> translationsger = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"German");
            List<String> translationsmd = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Modern Greek");
            List<String> translationssw = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Swedish");
            List<String> translationsfr = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"French");
            List<String> translationsita = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Italian");
            StringBuilder sbtr = new StringBuilder();
            for (String translation : translationstr) {
                sbtr.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext1.setText(sbtr.toString());

            StringBuilder sbger = new StringBuilder();
            for (String translation : translationsger) {
                sbger.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext2.setText(sbger.toString());

            StringBuilder sbsmd = new StringBuilder();
            for (String translation : translationsmd) {
                sbsmd.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext3.setText(sbsmd.toString());

            StringBuilder sbssw= new StringBuilder();
            for (String translation : translationssw) {
                sbssw.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext4.setText(sbssw.toString());

            StringBuilder sbsfr= new StringBuilder();
            for (String translation : translationsfr) {
                sbsfr.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext5.setText(sbsfr.toString());

            StringBuilder sbsita= new StringBuilder();
            for (String translation : translationsita) {
                sbsita.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext6.setText(sbsita.toString());



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

            List<String> translationseng = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"English");
            List<String> translationsger = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"German");
            List<String> translationsmd = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Modern Greek");
            List<String> translationssw = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Swedish");
            List<String> translationsfr = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"French");
            List<String> translationsita = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Italian");
            StringBuilder sbeng = new StringBuilder();
            for (String translation : translationseng) {
                sbeng.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext1.setText(sbeng.toString());

            StringBuilder sbeger = new StringBuilder();
            for (String translation : translationsger) {
                sbeger.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext2.setText(sbeger.toString());

            StringBuilder sbesmd = new StringBuilder();
            for (String translation : translationsmd) {
                sbesmd.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext3.setText(sbesmd.toString());

            StringBuilder sbessw = new StringBuilder();
            for (String translation : translationssw) {
                sbessw.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext4.setText(sbessw.toString());

            StringBuilder sbefr = new StringBuilder();
            for (String translation : translationsfr) {
                sbefr.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext5.setText(sbefr.toString());

            for (String translation : translationsita) {
                sbefr.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext6.setText(sbefr.toString());

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

            List<String> translationsturk = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Turkish");
            List<String> translationsger = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"German");
            List<String> translationsmd = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Modern Greek");
            List<String> translationseng = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"English");
            List<String> translationsfr = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"French");
            List<String> translationsita = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Italian");
            StringBuilder sbtur = new StringBuilder();
            for (String translation : translationsturk) {
                sbtur.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext1.setText(sbtur.toString());

            StringBuilder sbger = new StringBuilder();
            for (String translation : translationsger) {
                sbger.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext2.setText(sbger.toString());

            StringBuilder sbsmd = new StringBuilder();
            for (String translation : translationsmd) {
                sbsmd.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext3.setText(sbsmd.toString());

            StringBuilder sbseng = new StringBuilder();
            for (String translation : translationseng) {
                sbseng.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext4.setText(sbseng.toString());

            StringBuilder sbsfr = new StringBuilder();
            for (String translation : translationsfr) {
                sbsfr.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext5.setText(sbsfr.toString());

            StringBuilder sbsita = new StringBuilder();
            for (String translation : translationsita) {
                sbsita.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext6.setText(sbsita.toString());





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

            List<String> translationsturk = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Turkish");
            List<String> translationsger = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"German");
            List<String> translationsmd = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Modern Greek");
            List<String> translationsswe = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"English");
            List<String> translationsfr = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"French");
            List<String> translationseng = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Italian");
            StringBuilder sbtur = new StringBuilder();
            for (String translation : translationsturk) {
                sbtur.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext1.setText(sbtur.toString());
            for (String translation : translationsger) {
                sbtur.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext2.setText(sbtur.toString());

            StringBuilder sbsmd = new StringBuilder();
            for (String translation : translationsmd) {
                sbsmd.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext3.setText(sbsmd.toString());

            StringBuilder sbsswe = new StringBuilder();
            for (String translation : translationsswe) {
                sbsswe.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext4.setText(sbsswe.toString());

            StringBuilder sbsfr = new StringBuilder();
            for (String translation : translationsfr) {
                sbsfr.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext5.setText(sbsfr.toString());

            StringBuilder sbseng = new StringBuilder();
            for (String translation : translationseng) {
                sbseng.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext6.setText(sbseng.toString());


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

            List<String> translationsturk = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Turkish");
            List<String> translationsger = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"German");
            List<String> translationeng = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Modern Greek");
            List<String> translationsswe = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"English");
            List<String> translationsfr = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"French");
            List<String> translationsita = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Italian");
            StringBuilder sbtur = new StringBuilder();
            for (String translation : translationsturk) {
                sbtur.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext1.setText(sbtur.toString());

            StringBuilder sbger = new StringBuilder();
            for (String translation : translationsger) {
                sbger.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext2.setText(sbger.toString());

            StringBuilder sbeng = new StringBuilder();
            for (String translation : translationeng) {
                sbeng.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext3.setText(sbeng.toString());

            StringBuilder sbeswe = new StringBuilder();
            for (String translation : translationsswe) {
                sbeswe.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext4.setText(sbeswe.toString());

            StringBuilder sbefr = new StringBuilder();
            for (String translation : translationsfr) {
                sbefr.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext5.setText(sbefr.toString());

            StringBuilder sbeita = new StringBuilder();
            for (String translation : translationsita) {
                sbeita.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext6.setText(sbeita.toString());

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

            List<String> translationsturk = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Turkish");
            List<String> translationsger = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"German");
            List<String> translationmg = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Modern Greek");
            List<String> translationsswe = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"English");
            List<String> translationseng = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"French");
            List<String> translationsita = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Italian");
            StringBuilder sbtur = new StringBuilder();
            for (String translation : translationsturk) {
                sbtur.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext1.setText(sbtur.toString());

            StringBuilder sbger = new StringBuilder();
            for (String translation : translationsger) {
                sbger.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext2.setText(sbger.toString());

            StringBuilder sbmg = new StringBuilder();
            for (String translation : translationmg) {
                sbmg.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext3.setText(sbmg.toString());

            StringBuilder sbswe = new StringBuilder();
            for (String translation : translationsswe) {
                sbswe.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext4.setText(sbswe.toString());

            StringBuilder sbseng = new StringBuilder();
            for (String translation : translationseng) {
                sbseng.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext5.setText(sbseng.toString());

            StringBuilder sbsita = new StringBuilder();
            for (String translation : translationsita) {
                sbsita.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext6.setText(sbsita.toString());
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

            List<String> translationsturk = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Turkish");
            List<String> translationseng = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"German");
            List<String> translationmg = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Modern Greek");
            List<String> translationsswe = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"English");
            List<String> translationsfr = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"French");
            List<String> translationsita = Dictionary.graph.getTranslations(wordTextField.getText(),getLanguage(),"Italian");
            StringBuilder sbtur = new StringBuilder();
            for (String translation : translationsturk) {
                sbtur.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext1.setText(sbtur.toString());

            StringBuilder sbseng = new StringBuilder();
            for (String translation : translationseng) {
                sbseng.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext2.setText(sbseng.toString());

            StringBuilder sbsemg = new StringBuilder();
            for (String translation : translationmg) {
                sbsemg.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext3.setText(sbsemg.toString());

            StringBuilder sbsswe = new StringBuilder();
            for (String translation : translationsswe) {
                sbsswe.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext4.setText(sbsswe.toString());

            StringBuilder sbsfr = new StringBuilder();
            for (String translation : translationsfr) {
                sbsfr.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext5.setText(sbsfr.toString());

            StringBuilder sbsita = new StringBuilder();
            for (String translation : translationsita) {
                sbsita.append(translation).append("\n"); // Add each translation to the StringBuilder with a line break
            }
            addtext6.setText(sbsita.toString());

        }





    }
    public void enterEditWorForm(ActionEvent event) throws  IOException {
        if (getLanguage().equals("English")) {
            System.out.println(wordTextField.getText());
            ArrayList<String> turkishtranslate = new ArrayList<>();
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
