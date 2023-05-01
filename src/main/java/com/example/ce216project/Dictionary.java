package com.example.ce216project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {

    public Language lang; // Not so sure if a language has a dictionary or dictionary has a language
    public static Graph graph = new Graph();
    public void readDictFile()
    {
        //ENG
        {
            //ENG-TR
            try {
                File file = new File("src/Dictionary/eng-tur.dict");
                Scanner scanner = new Scanner(file);
                String word = null;
                while (scanner.hasNextLine()) {
                    ArrayList<String> translation = new ArrayList<>();
                    String meaning;
                    String line = scanner.nextLine();
                    if (!Character.isDigit(line.charAt(0))) {
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else if (Character.isDigit(line.charAt(0))) {
                        String[] parts = line.split("/");
                        meaning = parts[0].replaceAll("\\d+\\.", "").trim();
                        String[] meanings = meaning.split(",");
                        for (String m : meanings) {
                            translation.add(m.trim());
                        }
                    }
                    graph.addWord(word, "English", "Turkish", translation);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
            //ENG-TR VOCABULARY TEST
            System.out.println(graph.getTranslations("death", "English", "Turkish"));
            System.out.println(graph.getTranslations("öIüm", "Turkish", "English"));
            //ENG-ITA
            try {
                File file = new File("src/Dictionary/eng-ita.dict");
                Scanner scanner = new Scanner(file);
                String word = "";
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.endsWith("/")) {
                        if (!word.isEmpty()) {
                            String[] parts = line.split("/");
                            word = parts[0].trim();
                            String[] engWords = parts[1].split(",");
                            ArrayList<String> translation = new ArrayList<>();
                            for (String engWord : engWords) {
                                translation.add(engWord.trim());
                            }
                            graph.addWord(word, "English", "Italian", translation);
                        } else {
                            String[] parts = line.split("/");
                            word = parts[0].trim();
                        }
                    } else {
                        String[] parts = line.split("\\s+");
                        StringBuilder italianWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {
                            italianWord.insert(0, parts[i] + " ");
                        }
                        ArrayList<String> translation = new ArrayList<>();
                        translation.add(italianWord.toString().trim());
                        graph.addWord(word, "English", "Italian", translation);
                        word = "";
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //ENG-ITA Test
            System.out.println(graph.getTranslations("abandonment", "English", "Italian"));
            //ENG-FRA
            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/eng-fra.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith("/")) { //Italian word
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "English", "French", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder frenchWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            frenchWord.insert(0, parts[i] + " ");
                        }
                        translation.add(frenchWord.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "English", "French", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //ENG-FRA VOCABULARY TEST
            System.out.println(graph.getTranslations("drug", "English", "French"));
            System.out.println(graph.getTranslations("1. remède", "French", "English"));
        }

        //Greek
        {
            //ELL-ITA
            try {
                File file = new File("src/Dictionary/ell-ita.dict");
                Scanner scanner = new Scanner(file);
                String word = "";
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.endsWith(">")) {
                        if (!word.isEmpty()) {
                            String[] parts = line.split("/");
                            word = parts[0].trim();
                            String[] italianWords = parts[1].split(",");
                            ArrayList<String> translation = new ArrayList<>();
                            for (String italianWord : italianWords) {
                                translation.add(italianWord.trim());
                            }
                            graph.addWord(word, "Modern Greek", "Italian", translation);
                        } else {
                            String[] parts = line.split("/");
                            word = parts[0].trim();
                        }
                    } else {
                        String[] parts = line.split("\\s+");
                        StringBuilder italianWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {
                            italianWord.insert(0, parts[i] + " ");
                        }
                        ArrayList<String> translation = new ArrayList<>();
                        translation.add(italianWord.toString().trim()); // Add the Italian translation to the ArrayList
                        graph.addWord(word, "Modern Greek", "Italian", translation); // Add the Italian translation to the existing word in the graph
                        word = "";
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //ELL-ITA VOCABULARY TEST
            System.out.println(graph.getTranslations("Αράλη", "Modern Greek", "Italian"));
            System.out.println(graph.getTranslations("Aral", "Italian", "Modern Greek"));
            //ELL-SWE
            try {
                File file = new File("src/Dictionary/ell-swe.dict");
                Scanner scanner = new Scanner(file);
                String word = "";
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.endsWith(">")) {
                        if (!word.isEmpty()) {
                            String[] parts = line.split("/");
                            word = parts[0].trim();
                            String[] swedWords = parts[1].split(",");
                            ArrayList<String> translation = new ArrayList<>();
                            for (String swedWord : swedWords) {
                                translation.add(swedWord.trim());
                            }
                            graph.addWord(word, "Modern Greek", "Swedish", translation);
                        } else {
                            String[] parts = line.split("/");
                            word = parts[0].trim();
                        }
                    } else {
                        String[] parts = line.split("\\s+");
                        StringBuilder swedWords = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {
                            swedWords.insert(0, parts[i] + " ");
                        }
                        ArrayList<String> translation = new ArrayList<>();
                        translation.add(swedWords.toString().trim());
                        graph.addWord(word, "Modern Greek", "Swedish", translation);
                        word = "";
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("Όφις", "Modern Greek", "Swedish"));
            //ELL-ENG
            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/ell-eng.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith(">")) { //Modern Greek word - English
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "Modern Greek", "English", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder englishWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            englishWord.insert(0, parts[i] + " ");
                        }
                        translation.add(englishWord.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "Modern Greek", "English", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("Άδης", "Modern Greek", "English"));
            //ELL-FRA
            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/ell-fra.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith(">")) { //French word - Modern Greek
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "Modern Greek", "French", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder frenchWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            frenchWord.insert(0, parts[i] + " ");
                        }
                        translation.add(frenchWord.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "Modern Greek", "French", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("Μπουρκίνα Φάσο", "Modern Greek", "French"));
        }


        //ITA
        {
            //ITA-ENG
            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/ita-eng.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith("/")) { //italian word
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "Italian", "English", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder englishWorld = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            englishWorld.insert(0, parts[i] + " ");
                        }
                        translation.add(englishWorld.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "Italian", "English", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //ITA-DEU
            try {
                File file = new File("src/Dictionary/ita-deu.dict");
                Scanner scanner = new Scanner(file);
                String word = "";
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.endsWith("/")) {
                        if (!word.isEmpty()) {
                            String[] parts = line.split("/");
                            word = parts[0].trim();
                            String[] italianWords = parts[1].split(",");
                            ArrayList<String> translation = new ArrayList<>();
                            for (String italianWord : italianWords) {
                                translation.add(italianWord.trim());
                            }
                            graph.addWord(word, "Italian", "German", translation);
                        } else {
                            String[] parts = line.split("/");
                            word = parts[0].trim();
                        }
                    } else {
                        String[] parts = line.split("\\s+");
                        StringBuilder germanWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {
                            germanWord.insert(0, parts[i] + " ");
                        }
                        ArrayList<String> translation = new ArrayList<>();
                        translation.add(germanWord.toString().trim());
                        graph.addWord(word, "Italian", "German", translation);
                        word = "";
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("Amburgo", "Italian", "German"));
            //ITA-TUR
            try {
                File file = new File("src/Dictionary/ita-tur.dict");
                Scanner scanner = new Scanner(file);
                String word = "";
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.endsWith(">")) {
                        if (!word.isEmpty()) {
                            String[] parts = line.split("/");
                            word = parts[0].trim();
                            String[] italianWords = parts[1].split(",");
                            ArrayList<String> translation = new ArrayList<>();
                            for (String italianWord : italianWords) {
                                translation.add(italianWord.trim());
                            }
                            graph.addWord(word, "Italian", "Turkish", translation);
                        } else {
                            String[] parts = line.split("/");
                            word = parts[0].trim();
                        }
                    } else {
                        String[] parts = line.split("\\s+");
                        StringBuilder turkishWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {
                            turkishWord.insert(0, parts[i] + " ");
                        }
                        ArrayList<String> translation = new ArrayList<>();
                        translation.add(turkishWord.toString().trim());
                        graph.addWord(word, "Italian", "Turkish", translation);
                        word = "";
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("entusiasmare", "Italian", "Turkish"));
            //ITA-SWE
            try {
                File file = new File("src/Dictionary/ita-swe.dict");
                Scanner scanner = new Scanner(file);
                String word = "";
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.endsWith(">")) {
                        if (!word.isEmpty()) {
                            String[] parts = line.split("/");
                            word = parts[0].trim();
                            String[] italianWords = parts[1].split(",");
                            ArrayList<String> translation = new ArrayList<>();
                            for (String italianWord : italianWords) {
                                translation.add(italianWord.trim());
                            }
                            graph.addWord(word, "Italian", "Swedish", translation);
                        } else {
                            String[] parts = line.split("/");
                            word = parts[0].trim();
                        }
                    } else {
                        String[] parts = line.split("\\s+");
                        StringBuilder swedishWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {
                            swedishWord.insert(0, parts[i] + " ");
                        }
                        ArrayList<String> translation = new ArrayList<>();
                        translation.add(swedishWord.toString().trim());
                        graph.addWord(word, "Italian", "Swedish", translation);
                        word = "";
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("intimidire", "Italian", "Swedish"));
            //ITA-ELL
            try {
                File file = new File("src/Dictionary/ita-ell.dict");
                Scanner scanner = new Scanner(file);
                String word = "";
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.endsWith(">")) {
                        if (!word.isEmpty()) {
                            String[] parts = line.split("/");
                            word = parts[0].trim();
                            String[] italianWords = parts[1].split(",");
                            ArrayList<String> translation = new ArrayList<>();
                            for (String italianWord : italianWords) {
                                translation.add(italianWord.trim());
                            }
                            graph.addWord(word, "Italian", "Modern Greek", translation);
                        } else {
                            String[] parts = line.split("/");
                            word = parts[0].trim();
                        }
                    } else {
                        String[] parts = line.split("\\s+");
                        StringBuilder modernGreekWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {
                            modernGreekWord.insert(0, parts[i] + " ");
                        }
                        ArrayList<String> translation = new ArrayList<>();
                        translation.add(modernGreekWord.toString().trim());
                        graph.addWord(word, "Italian", "Modern Greek", translation);
                        word = "";
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("intimidire", "Italian", "Modern Greek"));
        }

        //GER
        {
            //GER-ITA
            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/deu-ita.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith("/")) { //German word
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "German", "Italian", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder italianWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            italianWord.insert(0, parts[i] + " ");
                        }
                        translation.add(italianWord.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "German", "Italian", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("eins", "German", "Italian"));
            //GER-SWE
            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/deu-swe.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith(">")) { //German word
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "German", "Swedish", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder swedishWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            swedishWord.insert(0, parts[i] + " ");
                        }
                        translation.add(swedishWord.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "German", "Swedish", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("Mädchenschule", "German", "Swedish"));
            //GER-FRA
            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/deu-fra.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith(">")) { //German word
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "German", "French", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder frenchWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            frenchWord.insert(0, parts[i] + " ");
                        }
                        translation.add(frenchWord.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "German", "French", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("Alpendohle", "German", "French"));
            //GER-ELL
            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/deu-ell.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith(">")) { //German word
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "German", "Modern Greek", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder modernGreekWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            modernGreekWord.insert(0, parts[i] + " ");
                        }
                        translation.add(modernGreekWord.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "German", "Modern Greek", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("Einsamkeit", "German", "Modern Greek"));
            //GER-ENG
            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/deu-eng.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith(">")) { //German word
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "German", "English", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder englishWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            englishWord.insert(0, parts[i] + " ");
                        }
                        translation.add(englishWord.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "German", "English", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("Aalpässe", "German", "English"));
            //GER-TUR
            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/deu-tur.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith(">")) { //German word
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "German", "Turkish", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder turkishWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            turkishWord.insert(0, parts[i] + " ");
                        }
                        translation.add(turkishWord.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "German", "Turkish", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("Traum", "German", "Turkish"));
        }

        //TUR
        {
            //TUR-GER
            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/tur-deu.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith("/")) { //German word
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "Turkish", "German", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder germanWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            germanWord.insert(0, parts[i] + " ");
                        }
                        translation.add(germanWord.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "Turkish", "German", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("deve", "Turkish", "German"));

            //TUR-ENG
            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/tur-eng.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith("/")) { //German word
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "Turkish", "English", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder englishWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            englishWord.insert(0, parts[i] + " ");
                        }
                        translation.add(englishWord.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "Turkish", "English", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("amatör", "Turkish", "English"));
        }

        //FRA
        {
            //FRA-TUR
            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/fra-tur.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith(">")) { //french word
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph
                            graph.addWord(word, "French", "Turkish", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\\s");
                        StringBuilder turkishWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {
                            if (parts[i].startsWith("]") || parts[i].startsWith("[")) {
                                break;
                            }
                            turkishWord.insert(0, parts[i] + " ");
                        }
                        translation.add(turkishWord.toString().trim());
                    }


                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //FRA-ENG
            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/fra-eng.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith("/")) { //German word
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "English", "French", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder frenchWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            frenchWord.insert(0, parts[i] + " ");
                        }
                        translation.add(frenchWord.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "English", "French", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("vert", "French", "English"));
            //FRA-SWE
            String pathName = "src/Dictionary/fra-swe.dict";
            try {
                Scanner scanner = new Scanner(new File(pathName)); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith(">")) { //French word - Swedish
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "French", "Swedish", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder frenchWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            frenchWord.insert(0, parts[i] + " ");
                        }
                        translation.add(frenchWord.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "French", "Swedish", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("Basse-Bavière", "French", "Swedish"));
            //FRA-ITA
            try {
                File file = new File("src/Dictionary/fra-ita.dict");
                Scanner scanner = new Scanner(file);
                String word = "";
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.endsWith(">")) {
                        if (!word.isEmpty()) {
                            String[] parts = line.split("/");
                            word = parts[0].trim();
                            String[] frenchWords = parts[1].split(",");
                            ArrayList<String> translation = new ArrayList<>();
                            for (String frenchWord : frenchWords) {
                                translation.add(frenchWord.trim());
                            }
                            graph.addWord(word, "French", "Italian", translation);
                        } else {
                            String[] parts = line.split("/");
                            word = parts[0].trim();
                        }
                    } else {
                        String[] parts = line.split("\\s+");
                        StringBuilder italianWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {
                            italianWord.insert(0, parts[i] + " ");
                        }
                        ArrayList<String> translation = new ArrayList<>();
                        translation.add(italianWord.toString().trim());
                        graph.addWord(word, "French", "Italian", translation);
                        word = "";
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("Ain", "French", "Italian"));
            // French to German :
            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/fra-deu.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith(">")) { //French word - German
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "French", "German", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder germanWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            germanWord.insert(0, parts[i] + " ");
                        }
                        translation.add(germanWord.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "French", "German", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("chignole", "French", "German"));
            //FRENCH TO MODERN GREEK
            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/fra-ell.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith(">")) { //French word - Modern Greek
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "French", "Modern Greek", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder modernGreekWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            modernGreekWord.insert(0, parts[i] + " ");
                        }
                        translation.add(modernGreekWord.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "French", "Modern Greek", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("Belle au bois dormant", "French", "Modern Greek"));
        }

        //SWE
        {
            //SWE TO GER
            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/swe-deu.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith(">")) { //Swedish word - German
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "Swedish", "German", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder germanWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            germanWord.insert(0, parts[i] + " ");
                        }
                        translation.add(germanWord.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "Swedish", "German", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("Blod är tjockare än vatten.", "Swedish", "German"));
            //SWE TO FRENCH
            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/swe-fra.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith(">")) { //French word - Swedish
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "Swedish", "French", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder frenchWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            frenchWord.insert(0, parts[i] + " ");
                        }
                        translation.add(frenchWord.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "Swedish", "French", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("Köln", "Swedish", "French"));
            // SWE TO MODERN GREEK
            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/swe-ell.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith(">")) { //French word - Swedish
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "Swedish", "Modern Greek", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder frenchWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            frenchWord.insert(0, parts[i] + " ");
                        }
                        translation.add(frenchWord.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "Swedish", "Modern Greek", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("Köln", "Swedish", "Modern Greek"));
            // SWE TO ENGLISH
            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/swe-eng.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith("/")) { //Swedish word - English
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "Swedish", "English", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder englishWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            englishWord.insert(0, parts[i] + " ");
                        }
                        translation.add(englishWord.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "Swedish", "English", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("Sverige", "Swedish", "English"));
            // SWEDISH TO TURKISH
            try {
                File file = new File("src/Dictionary/swe-tur (2).dict");
                Scanner scanner = new Scanner(file);
                String word = "";
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.endsWith(">")) {
                        if (!word.isEmpty()) {
                            String[] parts = line.split("/");
                            word = parts[0].trim();
                            String[] swedWords = parts[1].split(",");
                            ArrayList<String> translation = new ArrayList<>();
                            for (String swedWord : swedWords) {
                                translation.add(swedWord.trim());
                            }
                            graph.addWord(word, "Swedish", "Turkish", translation);
                        } else {
                            String[] parts = line.split("/");
                            word = parts[0].trim();
                        }
                    } else {
                        String[] parts = line.split("\\s+");
                        StringBuilder turkishWords = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {
                            turkishWords.insert(0, parts[i] + " ");
                        }
                        ArrayList<String> translation = new ArrayList<>();
                        translation.add(turkishWords.toString().trim());
                        graph.addWord(word, "Swedish", "Turkish", translation);
                        word = "";
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println(graph.getTranslations("tyst", "Swedish", "Turkish"));


            // SWEDISH TO ITALIAN

            try {
                Scanner scanner = new Scanner(new File("src/Dictionary/swe-ita.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith(">")) { //French word - Swedish
                        if (!word.isEmpty()) {
                            // If word is not empty, add the previous word and translation to the graph

                            graph.addWord(word, "Swedish", "Italian", translation);
                            word = "";
                            translation = new ArrayList<>();
                        }
                        String[] parts = line.split("/");
                        word = parts[0].trim();
                    } else {
                        String[] parts = line.split("\s");
                        StringBuilder frenchWord = new StringBuilder();
                        for (int i = parts.length - 1; i >= 0; i--) {

                            frenchWord.insert(0, parts[i] + " ");
                        }
                        translation.add(frenchWord.toString().trim());
                    }


                }
                if (!word.isEmpty()) {
                    // Add the last word and translation to the graph after reading the file
                    graph.addWord(word, "Swedish", "Italian", translation);
                }

                scanner.close(); // Close the scanner after reading the file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(graph.getTranslations("Köln", "Swedish", "Italian"));
        }
    } // Let's add more details
    public static void writeDictFile(){} //when we get how to read files from the website.

    public static String searchWord(String word, Language lang){
        return word;
    }

    public static String addWord(String word,Language lang){
        return word;
    }

    public static String editWord(String word,Language lang){
        return word;
    }

    public static String deleteWord(String word,Language lang){
        return word;
    }

}
