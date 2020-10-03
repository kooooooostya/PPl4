package com.company;

import java.util.ArrayList;
import java.util.Arrays;

//Класс представлянт вершину графа
public class Vertex implements Comparable{
    private final String mName;
    private final ArrayList<String> mNeighboringVertices; //содержит имена соседних вершин

    public Vertex(String name, ArrayList<String> neighboringVertices) {
        mName = name;
        if(neighboringVertices != null)
            mNeighboringVertices = neighboringVertices;
        else mNeighboringVertices = new ArrayList<>();
    }

    public Vertex(String name, String...vertexNames) {
        mName = name;
        mNeighboringVertices = new ArrayList<>();
        mNeighboringVertices.addAll(Arrays.asList(vertexNames));
    }

    public boolean isNeighboringEmpty(){
        return this.mNeighboringVertices.isEmpty();
    }

    public String getName() {
        return mName;
    }

    public ArrayList<String> getNeighboringVertices() {
        return mNeighboringVertices;
    }

    public void addNeighboringVertex(String vertexName){
        this.mNeighboringVertices.add(vertexName);
    }

    public void removeNeighboringVertex(String vertexName){
        this.mNeighboringVertices.remove(vertexName);
    }

    //Проверяет являются ли вершины соседними
    public boolean isNeighbors(Vertex vertex2){
        for(String vertexName : this.getNeighboringVertices()){
            if(vertex2.getName().equals(vertexName)){
                return true;
            }
        }
        return false;
    }

    //Возвращает степень вершины
    public int getVertexDegree() {
        return this.mNeighboringVertices.size();
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Vertex){
            Vertex vertex = (Vertex)o;
            return this.mName.compareTo(vertex.mName);
        }
        return -1;
    }
}
