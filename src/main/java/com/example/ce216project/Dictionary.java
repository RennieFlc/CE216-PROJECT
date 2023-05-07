package com.example.ce216project;

import java.io.*;
import java.nio.file.Files ;
import java.nio.file.Paths ;


import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary implements Serializable {

    public Language lang;
    public static Graph graph = new Graph();

    public void readDictFile()
    {


        //ENG
        {
            //ENG-TR
            try {

                File file = new File("src/main/resources/Dictionary/eng-tur.dict");
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("eng-tur.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in eng-tur.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("eng-tur.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph1 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from eng-tur.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }
            }

         catch (FileNotFoundException e) {
                System.out.println("File not found");
            }



            //ENG-ITA
            try {
                File file = new File("src/main/resources/Dictionary/eng-ita.dict");
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("eng-ita.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in eng-ita.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("eng-ita.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph2 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from eng-ita.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            //ENG-FRA
            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/eng-fra.dict")); // Open the text file for reading
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("eng-fra.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in eng-fra.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("eng-fra.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph3 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from eng-fra.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

        //Greek
        {
            //ELL-ITA
            try {
                File file = new File("src/main/resources/Dictionary/ell-ita.dict");
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("ell-ita.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in ell-ita.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("ell-ita.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph4 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from ell-ita.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            //ELL-SWE
            try {
                File file = new File("src/main/resources/Dictionary/ell-swe.dict");
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
                try {
                    FileOutputStream fileOut = new FileOutputStream("ell-swe.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in ell-swe.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }
                try {
                    FileInputStream fileIn = new FileInputStream("ell-swe.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph5 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from ell-swe.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            //ELL-ENG
            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/ell-eng.dict")); // Open the text file for reading
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("ell-eng.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in ell-eng.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("ell-eng.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph6 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from ell-eng.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            //ELL-FRA
            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/ell-fra.dict")); // Open the text file for reading
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("ell-fra.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in ell-fra.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("ell-fra.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph7 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from ell-fra.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }


        //ITA
        {
            //ITA-ENG
            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/ita-eng.dict")); // Open the text file for reading
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("ita-eng.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in ita-eng.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("ita-eng.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph8 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from ita-eng.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            //ITA-DEU
            try {
                File file = new File("src/main/resources/Dictionary/ita-deu.dict");
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("ita-deu.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in ita-deu.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("ita-deu.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph9 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from ita-deu.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            //ITA-TUR
            try {
                File file = new File("src/main/resources/Dictionary/ita-tur.dict");
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("ita-tur.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in ita-tur.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("ita-tur.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph10 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from ita-tur.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            //ITA-SWE
            try {
                File file = new File("src/main/resources/Dictionary/ita-swe.dict");
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("ita-swe.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in ita-swe.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("ita-swe.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph11 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from ita-swe.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            //ITA-ELL
            try {
                File file = new File("src/main/resources/Dictionary/ita-ell.dict");
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("ita-ell.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in ita-ell.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("ita-ell.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph12 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from ita-ell.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

        //GER
        {
            //GER-ITA
            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/deu-ita.dict")); // Open the text file for reading
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("deu-ita.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in deu-ita.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("deu-ita.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph13 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from deu-ita.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            //GER-SWE
            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/deu-swe.dict")); // Open the text file for reading
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("deu-swe.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in deu-swe.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("deu-swe.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph14 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from deu-swe.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            //GER-FRA
            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/deu-fra.dict")); // Open the text file for reading
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("deu-fra.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in deu-fra.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("deu-fra.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph15 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from deu-fra.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            //GER-ELL
            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/deu-ell.dict")); // Open the text file for reading
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("deu-ell.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in deu-ell.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("deu-ell.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph16 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from deu-ell.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            //GER-ENG
            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/deu-eng.dict")); // Open the text file for reading
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("deu-eng.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in deu-eng.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("deu-eng.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph17 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from deu-eng.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            //GER-TUR
            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/deu-tur.dict")); // Open the text file for reading
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("deu-tur.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in deu-tur.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("deu-tur.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph18 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from deu-tur.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

        //TUR
        {
            //TUR-GER
            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/tur-deu.dict")); // Open the text file for reading
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("tur-deu.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in tur-deu.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("tur-deu.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph19 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from tur-deu.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            //TUR-ENG
            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/tur-eng.dict")); // Open the text file for reading
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("tur-eng.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in tur-eng.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("tur-eng.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph20 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from tur-eng.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

        //FRA
        {
            //FRA-TUR
            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/fra-tur.dict")); // Open the text file for reading
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
                    scanner.close();

                    try {
                        FileOutputStream fileOut = new FileOutputStream("fra-tur.ser");
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        out.writeObject(graph);
                        out.close();
                        fileOut.close();
                        System.out.println("Serialized data is saved in fra-tur.ser");
                    } catch (IOException i) {
                        i.printStackTrace();
                    }

                    try {
                        FileInputStream fileIn = new FileInputStream("fra-tur.ser");
                        ObjectInputStream in = new ObjectInputStream(fileIn);
                        Graph graph21 = (Graph) in.readObject();
                        in.close();
                        fileIn.close();
                        System.out.println("Deserialized data is read from fra-tur.ser");
                    } catch (IOException i){
                        i.printStackTrace();
                    } catch (ClassNotFoundException c){
                        System.out.println("Graph class not found");
                        c.printStackTrace();
                    }


                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            //FRA-ENG
            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/fra-eng.dict")); // Open the text file for reading
                String word = "";
                ArrayList<String> translation = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    if (line.endsWith("/")) { //French word
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("fra-eng.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in fra-eng.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("fra-eng.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph22 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from fra-eng.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }



            //FRA-SWE
            String pathName = "src/main/resources/Dictionary/fra-swe.dict";
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("fra-swe.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in fra-swe.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("fra-swe.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph23 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from fra-swe.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }



            //FRA-ITA
            try {
                File file = new File("src/main/resources/Dictionary/fra-ita.dict");
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
                try {
                    FileOutputStream fileOut = new FileOutputStream("fra-ita.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in fra-ita.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("fra-ita.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph24 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from fra-ita.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            // French to German :
            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/fra-deu.dict")); // Open the text file for reading
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

                try {
                    FileOutputStream fileOut = new FileOutputStream("fra-deu.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in fra-deu.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("fra-deu.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph25 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from fra-deu.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            //FRENCH TO MODERN GREEK
            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/fra-ell.dict")); // Open the text file for reading
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
                try {
                    FileOutputStream fileOut = new FileOutputStream("fra-ell.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in fra-ell.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("fra-ell.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph26 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from fra-ell.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

        //SWE
        {
            //SWE TO GER
            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/swe-deu.dict")); // Open the text file for reading
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
                try {
                    FileOutputStream fileOut = new FileOutputStream("swe-deu.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in swe-deu.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("swe-deu.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph27 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from swe-deu.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            //SWE TO FRENCH
            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/swe-fra.dict")); // Open the text file for reading
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
                try {
                    FileOutputStream fileOut = new FileOutputStream("swe-fra.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in swe-fra.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("swe-fra.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph28 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from swe-fra.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            // SWE TO MODERN GREEK
            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/swe-ell.dict")); // Open the text file for reading
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
                try {
                    FileOutputStream fileOut = new FileOutputStream("swe-ell.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in swe-ell.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("swe-ell.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph29 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from swe-ell.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            // SWE TO ENGLISH
            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/swe-eng.dict")); // Open the text file for reading
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
                try {
                    FileOutputStream fileOut = new FileOutputStream("swe-eng.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in swe-eng.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("swe-eng.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph30 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from swe-eng.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            // SWEDISH TO TURKISH
            try {
                File file = new File("src/main/resources/Dictionary/swe-tur (2).dict");
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
                try {
                    FileOutputStream fileOut = new FileOutputStream("swe-tur (2).ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in swe-tur (2).ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("swe-tur (2).ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph31 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from swe-tur (2).ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }




            // SWEDISH TO ITALIAN

            try {
                Scanner scanner = new Scanner(new File("src/main/resources/Dictionary/swe-ita.dict")); // Open the text file for reading
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
                try {
                    FileOutputStream fileOut = new FileOutputStream("swe-ita.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(graph);
                    out.close();
                    fileOut.close();
                    System.out.println("Serialized data is saved in swe-ita.ser");
                } catch (IOException i) {
                    i.printStackTrace();
                }

                try {
                    FileInputStream fileIn = new FileInputStream("swe-ita.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Graph graph32 = (Graph) in.readObject();
                    in.close();
                    fileIn.close();
                    System.out.println("Deserialized data is read from swe-ita.ser");
                } catch (IOException i){
                    i.printStackTrace();
                } catch (ClassNotFoundException c){
                    System.out.println("Graph class not found");
                    c.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
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
