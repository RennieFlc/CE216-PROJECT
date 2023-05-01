package com.example.ce216project;

import java.util.ArrayList;

public class Node {
    private String word;
    private String language;
    private ArrayList<Node> neighbors;

    public Node(String word, String language) {
        this.word = word;
        this.language = language;
        this.neighbors = new ArrayList<>();
    }

    public String getWord() {
        return word;
    }

    public String getLanguage() {
        return language;
    }

    public ArrayList<Node> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }
}

