package com.company.Tests;

import com.company.UndirectedGraph;
import com.company.Vertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class UndirectedGraphTest {

    UndirectedGraph mUndirectedGraph;
    @BeforeEach
    void setUp() {
        mUndirectedGraph = new UndirectedGraph();
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(mUndirectedGraph.isEmpty());
        mUndirectedGraph.addVertex(new Vertex("first", new ArrayList<>()));
        assertFalse(mUndirectedGraph.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        mUndirectedGraph.addVertex(new Vertex("first", new ArrayList<>()));
        mUndirectedGraph.addVertex(new Vertex("second", new ArrayList<>()));
        mUndirectedGraph.addVertex(new Vertex("third", new ArrayList<>()));
        assertFalse(mUndirectedGraph.isEmpty());
        mUndirectedGraph.clear();
        assertTrue(mUndirectedGraph.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void addVertex() {
        Vertex vertex = new Vertex("first", new ArrayList<>());
        mUndirectedGraph.addVertex(vertex);
        assertTrue(mUndirectedGraph.isContains(vertex));
    }

    @org.junit.jupiter.api.Test
    void deleteVertex() {
        Vertex vertex = new Vertex("first", new ArrayList<>());
        mUndirectedGraph.addVertex(vertex);
        assertTrue(mUndirectedGraph.isContains(vertex));
        assertTrue(mUndirectedGraph.deleteVertex(vertex));
        assertFalse(mUndirectedGraph.isContains(vertex));
    }

    @Test
    void isContains() {
        Vertex vertex = new Vertex("first", new ArrayList<>());
        mUndirectedGraph.addVertex(vertex);
        assertTrue(mUndirectedGraph.isContains(vertex));
        assertTrue(mUndirectedGraph.isContains(vertex.getName()));
    }

    @Test
    void getVertex() {
        Vertex vertex1 = new Vertex("1", new ArrayList<>());
        Vertex vertex2 = new Vertex("2", new ArrayList<>());
        mUndirectedGraph.addVertex(vertex1);
        mUndirectedGraph.addVertex(vertex2);

        assertEquals(mUndirectedGraph.getVertex(vertex1.getName()).getName(), vertex1.getName());
        assertEquals(mUndirectedGraph.getVertex(vertex2.getName()).getName(), vertex2.getName());
        assertThrows(NoSuchElementException.class,
                () -> mUndirectedGraph.getVertex("кек чебурек"));
    }

    @Test
    void getAmountOfVertices() {
        Vertex vertex1 = new Vertex("1", new ArrayList<>());
        Vertex vertex2 = new Vertex("2", new ArrayList<>());
        Vertex vertex3 = new Vertex("3", vertex2.getName());
        Vertex vertex4 = new Vertex("4", vertex1.getName(), vertex2.getName(), vertex3.getName());
        mUndirectedGraph.addVertex(vertex1);
        mUndirectedGraph.addVertex(vertex2);
        mUndirectedGraph.addVertex(vertex3);
        mUndirectedGraph.addVertex(vertex4);

        assertEquals(4, mUndirectedGraph.getAmountOfVertices());
    }

    @Test
    void getAmountOfEdges() {
        Vertex vertex1 = new Vertex("1", new ArrayList<>());
        Vertex vertex2 = new Vertex("2", new ArrayList<>());
        Vertex vertex3 = new Vertex("3", vertex2.getName());
        Vertex vertex4 = new Vertex("4", vertex1.getName(), vertex2.getName(), vertex3.getName());
        mUndirectedGraph.addVertex(vertex1);
        mUndirectedGraph.addVertex(vertex2);
        mUndirectedGraph.addVertex(vertex3);
        mUndirectedGraph.addVertex(vertex4);

        assertEquals(4, mUndirectedGraph.getAmountOfEdges());
    }

    @Test
    void createAdjacencyStructure() {
        Vertex vertex1 = new Vertex("1", new ArrayList<>());
        Vertex vertex2 = new Vertex("2", new ArrayList<>());
        Vertex vertex3 = new Vertex("3", vertex2.getName());
        Vertex vertex4 = new Vertex("4", vertex1.getName(), vertex2.getName(), vertex3.getName());
        Vertex vertex5 = new Vertex("5", vertex2.getName());
        mUndirectedGraph.addVertex(vertex1);
        mUndirectedGraph.addVertex(vertex2);
        mUndirectedGraph.addVertex(vertex3);
        mUndirectedGraph.addVertex(vertex4);
        mUndirectedGraph.addVertex(vertex5);

        String expected = " 12345\n" +
                "100010\n" +
                "200111\n" +
                "301010\n" +
                "411100\n" +
                "501000\n";
        assertEquals(expected, mUndirectedGraph.createAdjacencyStructure());
    }
}