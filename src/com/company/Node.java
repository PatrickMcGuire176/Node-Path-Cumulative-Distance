package com.company;

/**
 * Created by McGuirePC on 6/4/2017.
 */
public class Node {
    int nodeNumber;
    boolean touched;
    boolean endingNode;

    public Node(int nodeNumber, boolean touched, boolean endingNode){
        this.nodeNumber = nodeNumber;
        this.touched = touched;
        this.endingNode = endingNode;
    }
}
