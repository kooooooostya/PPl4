package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        mUndirectedGraph.addVertex(new Vertex("first", null));
        assertFalse(mUndirectedGraph.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        mUndirectedGraph.addVertex(new Vertex("first", null));
        mUndirectedGraph.addVertex(new Vertex("second", null));
        mUndirectedGraph.addVertex(new Vertex("third", null));
        assertFalse(mUndirectedGraph.isEmpty());
        mUndirectedGraph.clear();
        assertTrue(mUndirectedGraph.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void addVertex() {
        Vertex vertex = new Vertex("first", null);
        mUndirectedGraph.addVertex(vertex);
        assertTrue(mUndirectedGraph.isContains(vertex));
    }

    @org.junit.jupiter.api.Test
    void deleteVertex() {
        Vertex vertex = new Vertex("first", null);
        mUndirectedGraph.addVertex(vertex);
        assertTrue(mUndirectedGraph.isContains(vertex));
        assertTrue(mUndirectedGraph.deleteVertex(vertex));
        assertFalse(mUndirectedGraph.isContains(vertex));
    }

    @Test
    void isContains() {
        Vertex vertex = new Vertex("first", null);
        mUndirectedGraph.addVertex(vertex);
        assertTrue(mUndirectedGraph.isContains(vertex));
        assertTrue(mUndirectedGraph.isContains(vertex.getName()));
    }
}