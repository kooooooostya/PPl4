package com.company;

import java.util.ArrayList;

public class UndirectedGraph implements Graph, Cloneable{

    private final ArrayList<Vertex> mGraph; // Содержит все ребра графа
    
    public UndirectedGraph(ArrayList<Vertex> graph) {
        mGraph = graph;
    }

    public UndirectedGraph() {
        mGraph = new ArrayList<>();
    }

    private UndirectedGraph(UndirectedGraph graph) {
      mGraph = (ArrayList<Vertex>) graph.mGraph.clone();
    }

    public ArrayList<Vertex> getGraph() {
        return mGraph;
    }

    @Override
    public boolean isEmpty() {
        return mGraph.isEmpty();
    }

    @Override
    public void clear() {
        mGraph.clear();
    }

    @Override
    public void addVertex(Vertex vertex) {
        mGraph.add(vertex);
    }

    @Override
    public boolean deleteVertex(Vertex vertex) {
        return mGraph.remove(vertex);
    }

    @Override
    public Vertex getVertex(String nameOfVertex) {
        return null;
    }

    @Override
    public boolean isContains(Vertex vertex) {
        return mGraph.contains(vertex);
    }

    @Override
    public boolean isContains(String nameOfVertex) {
        for(Vertex vertex: this.mGraph){
            if(vertex.getName().equals(nameOfVertex)) return true;
        }
        return false;
    }

    public String createAdjacencyStructure(){
        String ans = "";
        StringBuilder stringBuilder;
        //TODO дописать


        return ans;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new UndirectedGraph(this);
    }
}
