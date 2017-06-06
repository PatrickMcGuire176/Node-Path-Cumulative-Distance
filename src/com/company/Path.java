package com.company;

/**
 * Created by McGuirePC on 6/4/2017.
 */
public class Path {

    Node beginningNode;
    Node endingNode;
    int distance;

    public Path(Node beginningNode, Node endingNode, int distance) {
        this.beginningNode = beginningNode;
        this.endingNode = endingNode;
        this.distance = distance;
    }
}
