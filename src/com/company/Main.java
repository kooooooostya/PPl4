package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Vertex vertex1 = new Vertex("1", new ArrayList<>());
        Vertex vertex2 = new Vertex("2", new ArrayList<>());
        Vertex vertex3 = new Vertex("3", vertex2.getName());
        Vertex vertex4 = new Vertex("4", vertex1.getName(), vertex2.getName(), vertex3.getName());
        Vertex vertex5 = new Vertex("5", vertex2.getName());
        UndirectedGraph graph = new UndirectedGraph();
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);
        System.out.print(graph.createAdjacencyStructure());
    }
}
