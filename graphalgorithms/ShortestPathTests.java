package cs311.hw8.graphalgorithms;

import cs311.hw7.graph.Graph;

import static cs311.hw8.graphalgorithms.GraphAlgorithms.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
/**
 * Created by Erica on 11/25/2016.
 */
public class ShortestPathTests {

    private static double EPSILON = .0000007;

    @Test public void SimplestTest(){
        Graph<Integer, IWeight> g = new Graph();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");

        g.addEdge("A", "B", new Weight(5));
        g.addEdge("A", "C", new Weight(2));
        g.addEdge("C", "B", new  Weight(2));

        List<cs311.hw7.graph.IGraph.Edge<IWeight>> expected= new ArrayList<>();
        expected.add(g.getEdge("A","C"));
        expected.add(g.getEdge("C","B"));

        assertEquals(expected,ShortestPath(g,"A","B"));

        g.addVertex("D");
        g.addEdge("A", "D", new Weight(20));
        g.addEdge("B", "D", new Weight(2));

        expected.add(g.getEdge("B","D"));
        assertEquals(expected,ShortestPath(g,"A","D"));
    }

    @Test public void AnotherSimpleTest(){
        //graph src - https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Shortest_path_with_direct_weights.svg/250px-Shortest_path_with_direct_weights.svg.png

        Graph<Integer, IWeight> g = new Graph();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");

        g.addEdge("A", "B", new Weight(4));
        g.addEdge("A", "C", new Weight(2));
        g.addEdge("B", "D", new  Weight(10));
        g.addEdge("B", "C", new  Weight(5));
        g.addEdge("C", "E", new  Weight(3));
        g.addEdge("E", "D", new  Weight(4));
        g.addEdge("D", "F", new  Weight(11));

        List<cs311.hw7.graph.IGraph.Edge<IWeight>> expected= new ArrayList<>();
        expected.add(g.getEdge("A","C"));
        expected.add(g.getEdge("C","E"));
        expected.add(g.getEdge("E","D"));
        expected.add(g.getEdge("D","F"));


        assertEquals(expected,ShortestPath(g,"A","F"));
    }


    @Test public void MediumGraphTest(){
        //graph src - https://i.stack.imgur.com/tyTz7.png (except t-z changed to weight 1)

        Graph<Integer, IWeight> g = new Graph();
        g.setUndirectedGraph();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");
        g.addVertex("G");
        g.addVertex("H");
        g.addVertex("I");
        g.addVertex("J");
        g.addVertex("K");
        g.addVertex("L");
        g.addVertex("M");
        g.addVertex("N");
        g.addVertex("O");
        g.addVertex("P");
        g.addVertex("Q");
        g.addVertex("R");
        g.addVertex("S");
        g.addVertex("T");
        g.addVertex("Z");

        g.addEdge("A", "B", new Weight(2));
        g.addEdge("A", "C", new Weight(4));
        g.addEdge("A", "D", new  Weight(1));
        g.addEdge("B", "C", new  Weight(3));
        g.addEdge("B", "E", new  Weight(1));
        g.addEdge("C", "E", new  Weight(2));
        g.addEdge("C", "F", new  Weight(2));
        g.addEdge("D", "F", new  Weight(5));
        g.addEdge("D", "G", new  Weight(4));
        g.addEdge("E", "H", new  Weight(3));
        g.addEdge("F", "H", new  Weight(3));
        g.addEdge("F", "I", new  Weight(2));
        g.addEdge("F", "J", new  Weight(4));
        g.addEdge("F", "G", new  Weight(3));
        g.addEdge("G", "K", new  Weight(2));
        g.addEdge("H", "O", new  Weight(8));
        g.addEdge("H", "L", new  Weight(1));
        g.addEdge("I", "L", new  Weight(3));
        g.addEdge("I", "M", new  Weight(2));
        g.addEdge("I", "J", new  Weight(3));
        g.addEdge("J", "M", new  Weight(6));
        g.addEdge("J", "N", new  Weight(3));
        g.addEdge("J", "K", new  Weight(6));
        g.addEdge("K", "N", new  Weight(4));
        g.addEdge("K", "R", new  Weight(2));
        g.addEdge("L", "O", new  Weight(6));
        g.addEdge("L", "M", new  Weight(3));
        g.addEdge("M", "O", new  Weight(4));
        g.addEdge("M", "P", new  Weight(2));
        g.addEdge("M", "N", new  Weight(5));
        g.addEdge("N", "Q", new  Weight(2));
        g.addEdge("N", "R", new  Weight(1));
        g.addEdge("O", "S", new  Weight(6));
        g.addEdge("O", "P", new  Weight(2));
        g.addEdge("P", "S", new  Weight(2));
        g.addEdge("P", "T", new  Weight(1));
        g.addEdge("P", "Q", new  Weight(1));
        g.addEdge("Q", "T", new  Weight(3));
        g.addEdge("S", "Z", new  Weight(2));
        g.addEdge("T", "Z", new  Weight(1));

//        List<cs311.hw7.graph.IGraph.Edge<IWeight>> expected= new ArrayList<>();
//        expected.add(g.getEdge("A","D"));
//        expected.add(g.getEdge("D","G"));
//        expected.add(g.getEdge("G","K"));
//        expected.add(g.getEdge("K","R"));
//        expected.add(g.getEdge("R","N"));
//        expected.add(g.getEdge("N","Q"));
//        expected.add(g.getEdge("Q","P"));
//        expected.add(g.getEdge("P","T"));
//        expected.add(g.getEdge("T","Z"));

        List<cs311.hw7.graph.IGraph.Edge<IWeight>> actual = ShortestPath(g,"A","Z");
        //printLists(15.0, actual);
        assertEquals(15.0,findPathSum(actual), EPSILON);
    }

    private static double findPathSum(List<cs311.hw7.graph.IGraph.Edge<IWeight>> list){
        double sum = 0.0;
        for(cs311.hw7.graph.IGraph.Edge<IWeight> edge : list){
            sum += edge.getEdgeData().getWeight();
        }
        return sum;
    }

    private static void printLists(List<cs311.hw7.graph.IGraph.Edge<IWeight>> list1,List<cs311.hw7.graph.IGraph.Edge<IWeight>> list2 ){
        double sum = 0;
        for(cs311.hw7.graph.IGraph.Edge<IWeight> edge : list1){
            System.out.println(edge.getVertexName1() + " " + edge.getVertexName2() + " " + edge.getEdgeData());
                sum += edge.getEdgeData().getWeight();
            }
        System.out.println(sum);
        System.out.println();
        sum = 0;
        for(cs311.hw7.graph.IGraph.Edge<IWeight> edge : list2){
            System.out.println(edge.getVertexName1() + " " + edge.getVertexName2() + " " + edge.getEdgeData());
            sum += edge.getEdgeData().getWeight();
        }
        System.out.println(sum);
    }

}
