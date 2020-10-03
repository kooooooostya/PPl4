package com.company.Tests;

import com.company.Vertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VertexTest {

    Vertex mVertex;

    @BeforeEach
    void setUp() {
        mVertex = new Vertex("name", new ArrayList<>());
    }

    @Test
    void isNeighboringEmpty() {
        assertTrue(mVertex.isNeighboringEmpty());
        mVertex.addNeighboringVertex("kek");
        assertFalse(mVertex.isNeighboringEmpty());
    }

    @Test
    void addNeighboringVertex() {
        Vertex vertex = new Vertex("kek", mVertex.getName());
        mVertex.addNeighboringVertex(vertex.getName());
        assertTrue(mVertex.isNeighbors(vertex));
    }

    @Test
    void removeNeighboringVertex() {
        Vertex vertex = new Vertex("kek", mVertex.getName());
        mVertex.addNeighboringVertex(vertex.getName());
        assertTrue(mVertex.isNeighbors(vertex));
        mVertex.removeNeighboringVertex(vertex.getName());
        assertTrue(mVertex.isNeighboringEmpty());
    }

    @Test
    void isNeighbors() {
        Vertex vertex = new Vertex("kek", mVertex.getName());
        mVertex.addNeighboringVertex(vertex.getName());
        assertTrue(mVertex.isNeighbors(vertex));
    }

    @Test
    void getVertexDegree() {
        Vertex vertex = new Vertex("kek", mVertex.getName());
        mVertex.addNeighboringVertex(vertex.getName());
        assertEquals(mVertex.getVertexDegree(), 1);
        Vertex vertex1 = new Vertex("kek", mVertex.getName());
        mVertex.addNeighboringVertex(vertex1.getName());

        assertEquals(mVertex.getVertexDegree(), 2);
    }
}