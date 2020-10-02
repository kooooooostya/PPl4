package com.company;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;

//Класс представлянт вершину графа
public class Vertex implements Comparable{
    private final String mName;
    private final ArrayList<Vertex> mNeighboringVertices; //содержит имена соседних вершин

    public Vertex(String name, @Nullable ArrayList<Vertex> neighboringVertices) {
        mName = name;
        if(neighboringVertices != null)
            mNeighboringVertices = neighboringVertices;
        else mNeighboringVertices = new ArrayList<>();
    }

    public String getName() {
        return mName;
    }

    public ArrayList<Vertex> getNeighboringVertices() {
        return mNeighboringVertices;
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
