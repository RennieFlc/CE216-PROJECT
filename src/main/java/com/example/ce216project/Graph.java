package com.example.ce216project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private HashMap<String, Node> nodes;

    public Graph() {
        this.nodes = new HashMap<>();
    }

    public void addWord(String word,String mainlanguage, String language, ArrayList<String> translations) {
        // create or retrieve the English node
        String key = word + "-" + mainlanguage;
        Node mainnode = nodes.getOrDefault(key, new Node(word, mainlanguage));
        nodes.put(key, mainnode);

        // create or retrieve the translation nodes and add them as neighbors of the English node
        for (String translation : translations) {
            key = translation + "-" + language;
            Node translationNode = nodes.getOrDefault(key, new Node(translation, language));
            nodes.put(key, translationNode);

            mainnode.addNeighbor(translationNode);
            translationNode.addNeighbor(mainnode);
        }
    }

    public ArrayList<String> getTranslations(String word, String mainlanguage, String language) {
        // find the main node and look for its neighbors in the specified language
        String key = word +"-"+mainlanguage;
        Node mainnode = nodes.get(key);
        if (mainnode == null) {
            return new ArrayList<String>();
        }

        ArrayList<String> translations = new ArrayList<String>();
        for (Node neighbor : mainnode.getNeighbors()) {
            if (neighbor.getLanguage().equals(language)) {
                translations.add(neighbor.getWord());
            } else if (neighbor.getLanguage().equals(mainlanguage)) {
                // check if the neighbor is in the same language as the main node
                // and add its translation as well
                String neighborKey = neighbor.getWord() + neighbor.getLanguage();
                Node neighborNode = nodes.get(neighborKey);
                for (Node neighborNeighbor : neighborNode.getNeighbors()) {
                    if (neighborNeighbor.getLanguage().equals(language)) {
                        translations.add(neighborNeighbor.getWord());
                    }
                }
            }
        }
        return translations;
    }
}
