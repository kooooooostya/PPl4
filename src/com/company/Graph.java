package com.company;

public interface Graph{

    boolean isEmpty();

    void clear();

    void addVertex(Vertex vertex);

    boolean deleteVertex(Vertex vertex);

    Vertex getVertex(String nameOfVertex);

    boolean isContains(Vertex vertex);
    boolean isContains(String nameOfVertex);
}
