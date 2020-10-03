package com.company;

public interface Graph{

    boolean isEmpty();

    void clear();

    void addVertex(Vertex vertex);

    boolean deleteVertex(Vertex vertex);

    Vertex getVertex(String nameOfVertex);

    //Проверяет наличие вершины в графе
    boolean isContains(Vertex vertex);
    boolean isContains(String nameOfVertex);

    // Проверяет являются ли вершины соседними в графе
    boolean isNeighbors(Vertex vertex1, Vertex vertex2);

    //Возвращает количество вершин
    int getAmountOfVertices();

    //Возвращает количество ребер
    int getAmountOfEdges();
}
