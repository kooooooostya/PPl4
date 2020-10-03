package com.company;

import java.util.ArrayList;
import java.util.NoSuchElementException;

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
        if(!vertex.isNeighboringEmpty()){
            for (String vN : vertex.getNeighboringVertices()){
                this.getVertex(vN).addNeighboringVertex(vertex.getName());
            }
        }
        mGraph.add(vertex);
    }

    @Override
    public boolean deleteVertex(Vertex vertex) {
        if(!vertex.isNeighboringEmpty()){
            for (String vN : vertex.getNeighboringVertices()){
                this.getVertex(vN).removeNeighboringVertex(vertex.getName());
            }
        }
        return mGraph.remove(vertex);
    }

    //Возвращает вершину или выбросывает исключение если ее нет
    @Override
    public Vertex getVertex(String nameOfVertex) throws NoSuchElementException{
        for(Vertex vertex: this.mGraph){
            if(vertex.getName().equals(nameOfVertex)) return vertex;
        }
        throw new NoSuchElementException();
    }

    //Проверяет наличие верщины в графе
    @Override
    public boolean isContains(Vertex vertex) {
        return mGraph.contains(vertex);
    }

    //Проверяет наличие верщины в графе
    @Override
    public boolean isContains(String nameOfVertex) {
        for(Vertex vertex: this.mGraph){
            if(vertex.getName().equals(nameOfVertex)) return true;
        }
        return false;
    }

    //Проверяет наличие вершин в графе, если вершины присутствуют проверяет их на смежность
    @Override
    public boolean isNeighbors(Vertex vertex1, Vertex vertex2) {
        if (this.isContains(vertex1) && this.isContains(vertex2)){
            return vertex1.isNeighbors(vertex2);
        }
        return false;
    }

    @Override
    public int getAmountOfVertices() {
        return mGraph.size();
    }

    @Override
    public int getAmountOfEdges() {
        int edges = 0;
        for(int i = 0; i < this.getAmountOfVertices(); i++){
            for (int j = 0; j < this.getAmountOfVertices(); j++){
                if(this.getGraph().get(i).isNeighbors(this.getGraph().get(j))){
                    edges++;
                }
            }
        }
        edges /= 2; //делим результат на 2 т.к. мы каждое ребро считаем два раза
        return edges;
    }

    //Возврацает строку в которой список смежности
    public String createAdjacencyStructure(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < this.getAmountOfVertices(); i++){
            for (int j = 0; j < this.getAmountOfVertices(); j++){
                stringBuilder.append(this.getGraph().get(i).
                        isNeighbors(this.getGraph().get(j))?1:0);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    protected Object clone() {
        return new UndirectedGraph(this);
    }
}
