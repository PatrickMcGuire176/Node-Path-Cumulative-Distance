package com.company;

import java.lang.reflect.Field;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int shortestValue = 9999999;
        int comparingValue = 0;
        int cumulativeDistance = 0;
        int beginningNode = 0;

        Node Node1 = new Node(1, false, false );
        Node Node2 = new Node(2, false, false);
        Node Node3 = new Node(3, false, false);
        Node Node4 = new Node(4, false, true);

        Path Path1 = new Path(Node1, Node2, 10);
        Path Path2 = new Path(Node1, Node3, 12);
        Path Path3 = new Path(Node2, Node4, 9);
        Path Path4 = new Path(Node3, Node4, 3);

        //for node number 1 and 2 calculate distance, for node number 2 and 3, calculate distance

        HashMap<String, Node> nodeHashMap = new HashMap<String, Node>();
        nodeHashMap.put("Node1", Node1);
        nodeHashMap.put("Node2", Node2);
        nodeHashMap.put("Node3", Node3);
        nodeHashMap.put("Node4", Node4);

        HashMap<String, Path> pathHashMap = new HashMap<String, Path>();
        pathHashMap.put("Path1", Path1);
        pathHashMap.put("Path2", Path2);
        pathHashMap.put("Path3", Path3);
        pathHashMap.put("Path4", Path4);

        /*
        Find Hashmap where node number == 1
        For each pathHashMap, find path where beginning node == 1.  Add path to shortestValue.
        Loop through all nodes.  Add shortest value by comparing current shortest value
         */

        ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> singleList = new ArrayList<Integer>();
        singleList.add(1);
        singleList.add(2);
        singleList.add(3);
        listOfLists.add(new ArrayList(singleList));
        System.out.println(listOfLists);
        singleList.clear();
        singleList.add(4);
        listOfLists.add(new ArrayList(singleList));
        System.out.println(listOfLists);

        //I HAVE NO IDEA WHAT THE FUCK IS HAPPENING BELOW
        //At a high level, I'm trying to get each unique route's distance(combination of paths)
        //for loop to loop through all nodes where node number == i
        for (int i = 1; i <= 4; i++) {
            //for each Node
            for (Map.Entry<String, Node> nodeEntry : nodeHashMap.entrySet()) {
                System.out.println("Node Number is " + nodeEntry.getValue().nodeNumber);
                System.out.println("Iterator number is " + i);
                if ((nodeEntry.getValue().nodeNumber == i) && nodeEntry.getValue().endingNode == false) {
                    //Loop through all Paths with beginning Node number == 1
                    for (Map.Entry<String, Path> pathEntry : pathHashMap.entrySet()) {
                        //Check if the found Path's shortest value is shortest.  If it is, set shortestvalue = new shortestvalue
                        System.out.println("Path Beginning Node is " + pathEntry.getValue().beginningNode.nodeNumber);
                        System.out.println("Node Entry number is " + nodeEntry.getValue().nodeNumber);
                        if (pathEntry.getValue().beginningNode.nodeNumber == nodeEntry.getValue().nodeNumber) {
                            comparingValue = pathEntry.getValue().distance;
                            cumulativeDistance = comparingValue + cumulativeDistance;
                            if (comparingValue < shortestValue) {
                                System.out.println("path distance " +pathEntry.getValue().distance);
                                System.out.println("Shortest Value " + shortestValue);
                                shortestValue = pathEntry.getValue().distance;
                            }
                                singleList.add(i);
                        }
                    }
                    //nodeEntry.setValue(nodeEntry.getValue()).touched = 1;
                    //break;
                }
            }
        }
        System.out.println("Cumulative Distance is " +cumulativeDistance + "!");

       /*
        for(int i = 0; i<=4; i++){
            try
            {
                nodeHashMap.getClass().getField("nodeNumber");
                System.out.println(nodeHashMap.getClass().getField("nodeNumber"));
            } catch(NoSuchFieldException e) {
                System.out.println("FIELD NOT FOUND YO");
            }
        }

        for (Map.Entry<String, Node> entry : nodeHashMap.entrySet()) {
            if (entry.getValue().nodeNumber == 1) {
                for (Map.Entry<String, Path> entry2 : pathHashMap.entrySet()){

                }
            }
        }
        */

           // getPath(Node1, Node4, pathHashMap);
        }

    public static int calculateDistance(Path firstPath, Path secondPath) {
        int distance;
        distance = firstPath.distance + secondPath.distance;
        return distance;

    }

    public static Path getPath(Node firstNode, Node secondNode, HashMap<String, Path> pathHashMap) {
        Path test;
        for (Map.Entry<String, Path> entry : pathHashMap.entrySet()) {
            if (entry.getValue().beginningNode.equals(firstNode) && (entry.getValue().endingNode.equals((secondNode)))) {
                System.out.println(entry.getKey());
                test = entry.getValue();
                return test;
            } else {
                //  System.out.println("It didn't work, boys, pack it up");
            }
        }
        return null;
    }
}





