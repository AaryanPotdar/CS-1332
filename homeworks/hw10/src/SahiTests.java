import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SahiTests {

    private Graph<Integer> oneNodeGraph;
    private Graph<Integer> noEdgesGraph;
    private Graph<Integer> sameBFSAndDFS;

    // MAIN GRAPHS
    private Graph<Integer> directedGraph1;
    private Graph<Character> directedGraph2;

    private Graph<Integer> connectedDirectedGraph1;
    private Graph<Integer> undirectedGraph1;

    private Graph<Integer> disconnectedDirectedGraph1;
    private Graph<Integer> disconnectedUndirectedGraph1;

    // SPECIAL GRAPHS
    private Graph<Integer> completeGraph1;
    private Graph<Integer> multiGraph1;
    private Graph<Integer> selfLoopGraph;
    private Graph<Integer> selfLoopAndParallelEdgesGraph1;
    private Graph<Integer> eulerianGraph;
    private Graph<Integer> hamiltonianGraph;
    private Graph<Integer> petersonGraph;
    private Graph<Integer> tree;

    // DIJKSTRAS
    private Graph<Character> dijkstraGraph1;
    private Graph<Character> dijkstraGraph2;
    // PRIMS
    private Graph<Character> primsGraph1;
    private Graph<Character> primsGraph2;
    private Graph<Character> disconnectedPrimsGraph1;

    public static final int TIMEOUT = 200;

    @Before
    public void init() {
        oneNodeGraph = createOneNodeGraph();
        directedGraph1 = createDirectedGraph1();
        connectedDirectedGraph1 = createConnectedDirectedGraph1();
        undirectedGraph1 = createUndirectedGraph1();
        disconnectedDirectedGraph1 = createDisconnectedDirectedGraph1();
        disconnectedUndirectedGraph1 = createDisconnectedUndirectedGraph1();
        completeGraph1 = createCompleteGraph1();
        directedGraph2 = createDirectedGraph2();
        selfLoopAndParallelEdgesGraph1 = createSelfLoopAndParallelEdgesGraph1();
        petersonGraph = createPetersonGraph();
        noEdgesGraph = createNoEdgesGraph();
        multiGraph1 = createMultiGraph1();
        selfLoopGraph = createSelfloopGraph();
        eulerianGraph = createEulerianGraph();
        hamiltonianGraph = createHamiltonianGraph();
        sameBFSAndDFS = createSameBFSAndDFS();
        tree = createTree();
        dijkstraGraph1 = createDijkstraGraph1();
        dijkstraGraph2 = createDijkstraGraph2();
        primsGraph1 = createPrimsGraph1();
        primsGraph2 = createPrimsGraph2();
        disconnectedPrimsGraph1 = createDisconnectedPrimsGraph1();
    }

    private Graph<Integer> createOneNodeGraph() {
        Set<Vertex<Integer>> vertices = new HashSet<Vertex<Integer>>();
        Set<Edge<Integer>> edges = new LinkedHashSet<Edge<Integer>>();
        vertices.add(new Vertex<Integer>(1));
        return new Graph<Integer>(vertices, edges);
    }

    private Graph<Integer> createNoEdgesGraph() {
        Set<Vertex<Integer>> vertices = new HashSet<Vertex<Integer>>();
        Set<Edge<Integer>> edges = new LinkedHashSet<Edge<Integer>>();
        for (int i = 1; i <= 6; i++) {
            vertices.add(new Vertex<Integer>(i));
        }
        return new Graph<Integer>(vertices, edges);
    }

    private Graph<Integer> createSameBFSAndDFS() {
        Set<Vertex<Integer>> vertices = new HashSet<Vertex<Integer>>();
        for (int i = 1; i <= 7; i++) {
            vertices.add(new Vertex<Integer>(i));
        }

        Set<Edge<Integer>> edges = new LinkedHashSet<Edge<Integer>>();
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(6), 0));

        return new Graph<Integer>(vertices, edges);
    }

    private Graph<Integer> createDirectedGraph1() {
        Set<Vertex<Integer>> vertices = new HashSet<Vertex<Integer>>();
        for (int i = 1; i <= 13; i++) {
            vertices.add(new Vertex<Integer>(i));
        }

        Set<Edge<Integer>> edges = new LinkedHashSet<Edge<Integer>>();
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(8), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(10), 0));
        edges.add(new Edge<>(new Vertex<>(8), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(10), 0));
        edges.add(new Edge<>(new Vertex<>(10), new Vertex<>(11), 0));
        edges.add(new Edge<>(new Vertex<>(10), new Vertex<>(12), 0));
        edges.add(new Edge<>(new Vertex<>(11), new Vertex<>(13), 0));
        edges.add(new Edge<>(new Vertex<>(12), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(12), new Vertex<>(13), 0));
        edges.add(new Edge<>(new Vertex<>(13), new Vertex<>(10), 0));

        return new Graph<Integer>(vertices, edges);
    }

    private Graph<Integer> createConnectedDirectedGraph1() {
        Set<Vertex<Integer>> vertices = new HashSet<Vertex<Integer>>();
        for (int i = 1; i <= 9; i++) {
            vertices.add(new Vertex<Integer>(i));
        }

        Set<Edge<Integer>> edges = new LinkedHashSet<Edge<Integer>>();
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(8), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(9), 0));
        edges.add(new Edge<>(new Vertex<>(8), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(8), new Vertex<>(9), 0));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(8), 0));

        return new Graph<Integer>(vertices, edges);
    }

    private Graph<Integer> createUndirectedGraph1() {
        Set<Vertex<Integer>> vertices = new HashSet<Vertex<Integer>>();
        for (int i = 1; i <= 9; i++) {
            vertices.add(new Vertex<Integer>(i));
        }

        Set<Edge<Integer>> edges = new LinkedHashSet<Edge<Integer>>();
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(2), 4));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(1), 4));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(8), 8));
        edges.add(new Edge<>(new Vertex<>(8), new Vertex<>(1), 8));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(3), 8));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(2), 8));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(8), 11));
        edges.add(new Edge<>(new Vertex<>(8), new Vertex<>(2), 11));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(4), 7));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(3), 7));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(6), 4));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(3), 4));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(9), 2));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(3), 2));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(5), 9));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(4), 9));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(6), 14));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(4), 14));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(6), 10));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(5), 10));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(7), 2));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(6), 2));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(8), 1));
        edges.add(new Edge<>(new Vertex<>(8), new Vertex<>(7), 1));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(9), 6));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(7), 6));
        edges.add(new Edge<>(new Vertex<>(8), new Vertex<>(9), 7));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(8), 7));
        return new Graph<Integer>(vertices, edges);

    }

    private Graph<Integer> createDisconnectedDirectedGraph1() {
        Set<Vertex<Integer>> vertices = new HashSet<Vertex<Integer>>();
        for (int i = 1; i <= 10; i++) {
            vertices.add(new Vertex<Integer>(i));
        }

        Set<Edge<Integer>> edges = new LinkedHashSet<Edge<Integer>>();
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(3), 8));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(3), 6));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(4), 8));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(1), 6));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(2), 12));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(6), 1));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(7), 2));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(8), 6));
        edges.add(new Edge<>(new Vertex<>(8), new Vertex<>(9), 2));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(7), 10));

        return new Graph<Integer>(vertices, edges);
    }

    private Graph<Integer> createDisconnectedUndirectedGraph1() {
        Set<Vertex<Integer>> vertices = new HashSet<Vertex<Integer>>();
        for (int i = 1; i <= 9; i++) {
            vertices.add(new Vertex<Integer>(i));
        }

        Set<Edge<Integer>> edges = new LinkedHashSet<Edge<Integer>>();
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(8), 0));
        edges.add(new Edge<>(new Vertex<>(8), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(9), 0));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(8), new Vertex<>(9), 0));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(8), 0));

        return new Graph<Integer>(vertices, edges);
    }

    private Graph<Integer> createCompleteGraph1() {
        Set<Vertex<Integer>> vertices = new HashSet<Vertex<Integer>>();
        for (int i = 1; i <= 7; i++) {
            vertices.add(new Vertex<Integer>(i));
        }

        Set<Edge<Integer>> edges = new LinkedHashSet<Edge<Integer>>();
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(6), 0));

        return new Graph<Integer>(vertices, edges);
    }

    private Graph<Character> createDirectedGraph2() {
        Set<Vertex<Character>> vertices = new HashSet<>();
        for (int i = 65; i <= 82; i++) {
            vertices.add(new Vertex<Character>((char) i));
        }

        Set<Edge<Character>> edges = new LinkedHashSet<>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('E'), 0));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('H'), 0));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('A'), 0));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('C'), 0));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('G'), 0));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('C'), 0));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('G'), 0));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('R'), 0));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('F'), 0));
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('B'), 0));
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('C'), 0));
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('E'), 0));
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('J'), 0));
        edges.add(new Edge<>(new Vertex<>('G'), new Vertex<>('D'), 0));
        edges.add(new Edge<>(new Vertex<>('G'), new Vertex<>('F'), 0));
        edges.add(new Edge<>(new Vertex<>('G'), new Vertex<>('K'), 0));
        edges.add(new Edge<>(new Vertex<>('H'), new Vertex<>('A'), 0));
        edges.add(new Edge<>(new Vertex<>('I'), new Vertex<>('J'), 0));
        edges.add(new Edge<>(new Vertex<>('I'), new Vertex<>('M'), 0));
        edges.add(new Edge<>(new Vertex<>('J'), new Vertex<>('M'), 0));
        edges.add(new Edge<>(new Vertex<>('K'), new Vertex<>('D'), 0));
        edges.add(new Edge<>(new Vertex<>('K'), new Vertex<>('R'), 0));
        edges.add(new Edge<>(new Vertex<>('L'), new Vertex<>('H'), 0));
        edges.add(new Edge<>(new Vertex<>('M'), new Vertex<>('I'), 0));
        edges.add(new Edge<>(new Vertex<>('M'), new Vertex<>('N'), 0));
        edges.add(new Edge<>(new Vertex<>('M'), new Vertex<>('Q'), 0));
        edges.add(new Edge<>(new Vertex<>('N'), new Vertex<>('J'), 0));
        edges.add(new Edge<>(new Vertex<>('N'), new Vertex<>('K'), 0));
        edges.add(new Edge<>(new Vertex<>('N'), new Vertex<>('Q'), 0));
        edges.add(new Edge<>(new Vertex<>('O'), new Vertex<>('H'), 0));
        edges.add(new Edge<>(new Vertex<>('R'), new Vertex<>('K'), 0));
        edges.add(new Edge<>(new Vertex<>('R'), new Vertex<>('Q'), 0));

        return new Graph<Character>(vertices, edges);
    }

    private Graph<Integer> createSelfLoopAndParallelEdgesGraph1() {
        Set<Vertex<Integer>> vertices = new HashSet<Vertex<Integer>>();
        for (int i = 1; i <= 4; i++) {
            vertices.add(new Vertex<Integer>(i));
        }

        Set<Edge<Integer>> edges = new LinkedHashSet<Edge<Integer>>();
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(2), 5));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(4), 1));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(4), 8));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(4), 2));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(1), 5));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(2), 3));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(3), 1));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(2), 1));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(3), 23));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(2), 23));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(1), 1));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(1), 8));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(1), 2));

        return new Graph<Integer>(vertices, edges);
    }

    private Graph<Integer> createPetersonGraph() {
        Set<Vertex<Integer>> vertices = new HashSet<Vertex<Integer>>();
        for (int i = 1; i <= 10; i++) {
            vertices.add(new Vertex<Integer>(i));
        }

        Set<Edge<Integer>> edges = new LinkedHashSet<Edge<Integer>>();
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(8), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(9), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(10), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(10), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(9), 0));
        edges.add(new Edge<>(new Vertex<>(8), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(8), new Vertex<>(9), 0));
        edges.add(new Edge<>(new Vertex<>(8), new Vertex<>(10), 0));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(8), 0));
        edges.add(new Edge<>(new Vertex<>(10), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(10), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(10), new Vertex<>(8), 0));

        return new Graph<Integer>(vertices, edges);

    }

    private Graph<Integer> createMultiGraph1() {
        Set<Vertex<Integer>> vertices = new HashSet<Vertex<Integer>>();
        for (int i = 1; i <= 3; i++) {
            vertices.add(new Vertex<Integer>(i));
        }

        Set<Edge<Integer>> edges = new LinkedHashSet<Edge<Integer>>();
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(2), 0));

        return new Graph<Integer>(vertices, edges);
    }

    private Graph<Integer> createSelfloopGraph() {
        Set<Vertex<Integer>> vertices = new HashSet<Vertex<Integer>>();
        for (int i = 1; i <= 3; i++) {
            vertices.add(new Vertex<Integer>(i));
        }

        Set<Edge<Integer>> edges = new LinkedHashSet<Edge<Integer>>();
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(3), 0));

        return new Graph<Integer>(vertices, edges);

    }

    private Graph<Integer> createEulerianGraph() {
        Set<Vertex<Integer>> vertices = new HashSet<Vertex<Integer>>();
        for (int i = 1; i <= 10; i++) {
            vertices.add(new Vertex<Integer>(i));
        }

        Set<Edge<Integer>> edges = new LinkedHashSet<Edge<Integer>>();
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(8), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(10), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(10), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(10), 0));
        edges.add(new Edge<>(new Vertex<>(8), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(8), new Vertex<>(9), 0));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(8), 0));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(10), 0));
        edges.add(new Edge<>(new Vertex<>(10), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(10), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(10), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(10), new Vertex<>(9), 0));

        return new Graph<Integer>(vertices, edges);
    }

    private Graph<Integer> createHamiltonianGraph() {
        Set<Vertex<Integer>> vertices = new HashSet<Vertex<Integer>>();
        for (int i = 1; i <= 10; i++) {
            vertices.add(new Vertex<Integer>(i));
        }

        Set<Edge<Integer>> edges = new LinkedHashSet<Edge<Integer>>();
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(8), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(10), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(10), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(8), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(8), new Vertex<>(9), 0));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(8), 0));
        edges.add(new Edge<>(new Vertex<>(9), new Vertex<>(10), 0));
        edges.add(new Edge<>(new Vertex<>(10), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(10), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(10), new Vertex<>(9), 0));

        return new Graph<Integer>(vertices, edges);
    }

    private Graph<Integer> createTree() {
        Set<Vertex<Integer>> vertices = new HashSet<Vertex<Integer>>();
        for (int i = 1; i <= 7; i++) {
            vertices.add(new Vertex<Integer>(i));
        }

        Set<Edge<Integer>> edges = new LinkedHashSet<Edge<Integer>>();
        edges.add(new Edge<>(new Vertex<>(1), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(1), 0));
        edges.add(new Edge<>(new Vertex<>(2), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(2), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(4), 0));
        edges.add(new Edge<>(new Vertex<>(3), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(4), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(3), 0));
        edges.add(new Edge<>(new Vertex<>(5), new Vertex<>(6), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(5), 0));
        edges.add(new Edge<>(new Vertex<>(6), new Vertex<>(7), 0));
        edges.add(new Edge<>(new Vertex<>(7), new Vertex<>(6), 0));

        return new Graph<Integer>(vertices, edges);
    }

    private Graph<Character> createDijkstraGraph1() {
        Set<Vertex<Character>> vertices = new HashSet<Vertex<Character>>();
        for (int i = 97; i <= 104; i++) {
            vertices.add(new Vertex<Character>((char) i));
        }

        Set<Edge<Character>> edges = new LinkedHashSet<Edge<Character>>();
        edges.add(new Edge<>(new Vertex<>('a'), new Vertex<>('b'), 1));
        edges.add(new Edge<>(new Vertex<>('a'), new Vertex<>('g'), 6));
        edges.add(new Edge<>(new Vertex<>('a'), new Vertex<>('h'), 10));
        edges.add(new Edge<>(new Vertex<>('b'), new Vertex<>('d'), 1));
        edges.add(new Edge<>(new Vertex<>('b'), new Vertex<>('h'), 2));
        edges.add(new Edge<>(new Vertex<>('c'), new Vertex<>('d'), 4));
        edges.add(new Edge<>(new Vertex<>('c'), new Vertex<>('e'), 1));
        edges.add(new Edge<>(new Vertex<>('d'), new Vertex<>('e'), 3));
        edges.add(new Edge<>(new Vertex<>('d'), new Vertex<>('f'), 4));
        edges.add(new Edge<>(new Vertex<>('e'), new Vertex<>('f'), 5));
        edges.add(new Edge<>(new Vertex<>('g'), new Vertex<>('b'), 2));
        edges.add(new Edge<>(new Vertex<>('g'), new Vertex<>('d'), 8));
        edges.add(new Edge<>(new Vertex<>('g'), new Vertex<>('c'), 2));
        edges.add(new Edge<>(new Vertex<>('h'), new Vertex<>('f'), 5));

        return new Graph<Character>(vertices, edges);
    }

    private Graph<Character> createDijkstraGraph2() {
        Set<Vertex<Character>> vertices = new HashSet<Vertex<Character>>();
        for (int i = 65; i <= 82; i++) {
            vertices.add(new Vertex<Character>((char) i));
        }

        Set<Edge<Character>> edges = new LinkedHashSet<Edge<Character>>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 1));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('A'), 1));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('C'), 9));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('A'), 9));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('E'), 5));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('A'), 5));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('H'), 5));
        edges.add(new Edge<>(new Vertex<>('H'), new Vertex<>('A'), 5));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('O'), 1));
        edges.add(new Edge<>(new Vertex<>('O'), new Vertex<>('A'), 1));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('E'), 2));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('B'), 2));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('F'), 4));
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('B'), 4));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 7));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('C'), 7));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('F'), 7));
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('C'), 7));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('G'), 9));
        edges.add(new Edge<>(new Vertex<>('G'), new Vertex<>('D'), 9));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('K'), 7));
        edges.add(new Edge<>(new Vertex<>('K'), new Vertex<>('D'), 7));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('R'), 2));
        edges.add(new Edge<>(new Vertex<>('R'), new Vertex<>('D'), 2));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('F'), 8));
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('E'), 8));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('H'), 6));
        edges.add(new Edge<>(new Vertex<>('H'), new Vertex<>('E'), 6));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('I'), 6));
        edges.add(new Edge<>(new Vertex<>('I'), new Vertex<>('E'), 6));
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('G'), 2));
        edges.add(new Edge<>(new Vertex<>('G'), new Vertex<>('F'), 2));
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('I'), 5));
        edges.add(new Edge<>(new Vertex<>('I'), new Vertex<>('F'), 5));
        edges.add(new Edge<>(new Vertex<>('G'), new Vertex<>('K'), 5));
        edges.add(new Edge<>(new Vertex<>('K'), new Vertex<>('G'), 5));
        edges.add(new Edge<>(new Vertex<>('H'), new Vertex<>('L'), 7));
        edges.add(new Edge<>(new Vertex<>('L'), new Vertex<>('H'), 7));
        edges.add(new Edge<>(new Vertex<>('I'), new Vertex<>('L'), 4));
        edges.add(new Edge<>(new Vertex<>('L'), new Vertex<>('I'), 4));
        edges.add(new Edge<>(new Vertex<>('I'), new Vertex<>('M'), 2));
        edges.add(new Edge<>(new Vertex<>('M'), new Vertex<>('I'), 2));
        edges.add(new Edge<>(new Vertex<>('J'), new Vertex<>('M'), 6));
        edges.add(new Edge<>(new Vertex<>('M'), new Vertex<>('J'), 6));
        edges.add(new Edge<>(new Vertex<>('J'), new Vertex<>('N'), 3));
        edges.add(new Edge<>(new Vertex<>('N'), new Vertex<>('J'), 3));
        edges.add(new Edge<>(new Vertex<>('K'), new Vertex<>('R'), 1));
        edges.add(new Edge<>(new Vertex<>('R'), new Vertex<>('K'), 1));
        edges.add(new Edge<>(new Vertex<>('L'), new Vertex<>('O'), 9));
        edges.add(new Edge<>(new Vertex<>('O'), new Vertex<>('L'), 9));
        edges.add(new Edge<>(new Vertex<>('L'), new Vertex<>('P'), 3));
        edges.add(new Edge<>(new Vertex<>('P'), new Vertex<>('L'), 3));
        edges.add(new Edge<>(new Vertex<>('M'), new Vertex<>('P'), 2));
        edges.add(new Edge<>(new Vertex<>('P'), new Vertex<>('M'), 2));
        edges.add(new Edge<>(new Vertex<>('N'), new Vertex<>('Q'), 2));
        edges.add(new Edge<>(new Vertex<>('Q'), new Vertex<>('N'), 2));
        edges.add(new Edge<>(new Vertex<>('N'), new Vertex<>('R'), 8));
        edges.add(new Edge<>(new Vertex<>('R'), new Vertex<>('N'), 8));
        edges.add(new Edge<>(new Vertex<>('P'), new Vertex<>('Q'), 9));
        edges.add(new Edge<>(new Vertex<>('Q'), new Vertex<>('P'), 9));
        edges.add(new Edge<>(new Vertex<>('Q'), new Vertex<>('R'), 6));
        edges.add(new Edge<>(new Vertex<>('Q'), new Vertex<>('R'), 6));
        edges.add(new Edge<>(new Vertex<>('R'), new Vertex<>('Q'), 6));

        return new Graph<Character>(vertices, edges);
    }

    private Graph<Character> createPrimsGraph1() {
        Set<Vertex<Character>> vertices = new HashSet<Vertex<Character>>();
        for (int i = 97; i <= 108; i++) {
            vertices.add(new Vertex<Character>((char) i));
        }

        Set<Edge<Character>> edges = new LinkedHashSet<Edge<Character>>();
        edges.add(new Edge<>(new Vertex<>('a'), new Vertex<>('c'), 8));
        edges.add(new Edge<>(new Vertex<>('c'), new Vertex<>('a'), 8));
        edges.add(new Edge<>(new Vertex<>('a'), new Vertex<>('f'), 5));
        edges.add(new Edge<>(new Vertex<>('f'), new Vertex<>('a'), 5));
        edges.add(new Edge<>(new Vertex<>('a'), new Vertex<>('l'), 14));
        edges.add(new Edge<>(new Vertex<>('l'), new Vertex<>('a'), 14));
        edges.add(new Edge<>(new Vertex<>('b'), new Vertex<>('d'), 8));
        edges.add(new Edge<>(new Vertex<>('d'), new Vertex<>('b'), 8));
        edges.add(new Edge<>(new Vertex<>('b'), new Vertex<>('f'), 20));
        edges.add(new Edge<>(new Vertex<>('f'), new Vertex<>('b'), 20));
        edges.add(new Edge<>(new Vertex<>('b'), new Vertex<>('h'), 12));
        edges.add(new Edge<>(new Vertex<>('h'), new Vertex<>('b'), 12));
        edges.add(new Edge<>(new Vertex<>('b'), new Vertex<>('k'), 47));
        edges.add(new Edge<>(new Vertex<>('k'), new Vertex<>('b'), 47));
        edges.add(new Edge<>(new Vertex<>('c'), new Vertex<>('g'), 12));
        edges.add(new Edge<>(new Vertex<>('g'), new Vertex<>('c'), 12));
        edges.add(new Edge<>(new Vertex<>('c'), new Vertex<>('i'), 10));
        edges.add(new Edge<>(new Vertex<>('i'), new Vertex<>('c'), 10));
        edges.add(new Edge<>(new Vertex<>('c'), new Vertex<>('l'), 8));
        edges.add(new Edge<>(new Vertex<>('l'), new Vertex<>('c'), 8));
        edges.add(new Edge<>(new Vertex<>('d'), new Vertex<>('f'), 94));
        edges.add(new Edge<>(new Vertex<>('f'), new Vertex<>('d'), 94));
        edges.add(new Edge<>(new Vertex<>('d'), new Vertex<>('g'), 22));
        edges.add(new Edge<>(new Vertex<>('g'), new Vertex<>('d'), 22));
        edges.add(new Edge<>(new Vertex<>('e'), new Vertex<>('h'), 8));
        edges.add(new Edge<>(new Vertex<>('h'), new Vertex<>('e'), 8));
        edges.add(new Edge<>(new Vertex<>('e'), new Vertex<>('i'), 16));
        edges.add(new Edge<>(new Vertex<>('i'), new Vertex<>('e'), 16));
        edges.add(new Edge<>(new Vertex<>('e'), new Vertex<>('l'), 15));
        edges.add(new Edge<>(new Vertex<>('l'), new Vertex<>('e'), 15));
        edges.add(new Edge<>(new Vertex<>('f'), new Vertex<>('i'), 8));
        edges.add(new Edge<>(new Vertex<>('i'), new Vertex<>('f'), 8));
        edges.add(new Edge<>(new Vertex<>('f'), new Vertex<>('k'), 16));
        edges.add(new Edge<>(new Vertex<>('k'), new Vertex<>('f'), 16));
        edges.add(new Edge<>(new Vertex<>('g'), new Vertex<>('j'), 5));
        edges.add(new Edge<>(new Vertex<>('j'), new Vertex<>('g'), 5));
        edges.add(new Edge<>(new Vertex<>('g'), new Vertex<>('l'), 13));
        edges.add(new Edge<>(new Vertex<>('l'), new Vertex<>('g'), 13));
        edges.add(new Edge<>(new Vertex<>('h'), new Vertex<>('j'), 16));
        edges.add(new Edge<>(new Vertex<>('j'), new Vertex<>('h'), 16));
        edges.add(new Edge<>(new Vertex<>('h'), new Vertex<>('l'), 14));
        edges.add(new Edge<>(new Vertex<>('l'), new Vertex<>('h'), 14));
        edges.add(new Edge<>(new Vertex<>('j'), new Vertex<>('k'), 5));
        edges.add(new Edge<>(new Vertex<>('k'), new Vertex<>('j'), 5));

        return new Graph<Character>(vertices, edges);
    }

    private Graph<Character> createPrimsGraph2() {
        Set<Vertex<Character>> vertices = new HashSet<Vertex<Character>>();
        for (int i = 65; i <= 70; i++) {
            vertices.add(new Vertex<Character>((char) i));
        }

        Set<Edge<Character>> edges = new LinkedHashSet<Edge<Character>>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 9));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('A'), 9));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 6));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('A'), 6));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('C'), 3));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('A'), 3));
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('E'), 7));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('A'), 7));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('C'), 4));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('B'), 4));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('D'), 2));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('B'), 2));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('F'), 5));
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('B'), 5));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('C'), 1));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 3));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('C'), 3));
        edges.add(new Edge<>(new Vertex<>('C'), new Vertex<>('E'), 8));
        edges.add(new Edge<>(new Vertex<>('E'), new Vertex<>('C'), 8));
        edges.add(new Edge<>(new Vertex<>('D'), new Vertex<>('F'), 2));
        edges.add(new Edge<>(new Vertex<>('F'), new Vertex<>('D'), 2));

        return new Graph<Character>(vertices, edges);
    }

    private Graph<Character> createDisconnectedPrimsGraph1() {
        Set<Vertex<Character>> vertices = new HashSet<Vertex<Character>>();
        for (int i = 65; i <= 67; i++) {
            vertices.add(new Vertex<Character>((char) i));
        }

        Set<Edge<Character>> edges = new LinkedHashSet<Edge<Character>>();
        edges.add(new Edge<>(new Vertex<>('A'), new Vertex<>('B'), 23));
        edges.add(new Edge<>(new Vertex<>('B'), new Vertex<>('A'), 23));
        return new Graph<Character>(vertices, edges);
    }

    // BFS TESTS
    @Test(timeout = TIMEOUT)
    public void testBFSOneNodeGraph() {
        List<Vertex<Integer>> bfsActual1 = GraphAlgorithms.bfs(new Vertex<Integer>(1), oneNodeGraph);
        List<Vertex<Integer>> bfsExpected1 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(1)));

        assertEquals(bfsExpected1, bfsActual1);
    }

    @Test(timeout = TIMEOUT)
    public void testBFSDirectedGraph1() {
        // start vertex 2
        List<Vertex<Integer>> bfsActual2 = GraphAlgorithms.bfs(new Vertex<Integer>(2), directedGraph1);
        List<Vertex<Integer>> bfsExpected2 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(2)));

        assertEquals(bfsExpected2, bfsActual2);

        // start vertex 10
        List<Vertex<Integer>> bfsActual10 = GraphAlgorithms.bfs(new Vertex<Integer>(10), directedGraph1);
        List<Vertex<Integer>> bfsExpected10 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(10),
                new Vertex<Integer>(11), new Vertex<Integer>(12), new Vertex<Integer>(13), new Vertex<Integer>(5),
                new Vertex<Integer>(3), new Vertex<Integer>(4), new Vertex<Integer>(6)));

        assertEquals(bfsExpected10, bfsActual10);

        // start vertex 6
        List<Vertex<Integer>> bfsActual6 = GraphAlgorithms.bfs(new Vertex<Integer>(6), directedGraph1);
        List<Vertex<Integer>> bfsExpected6 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(6),
                new Vertex<Integer>(5), new Vertex<Integer>(3), new Vertex<Integer>(4)));

        assertEquals(bfsExpected6, bfsActual6);

        // start vertex 9
        List<Vertex<Integer>> bfsActual9 = GraphAlgorithms.bfs(new Vertex<Integer>(9), directedGraph1);
        List<Vertex<Integer>> bfsExpected9 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(9),
                new Vertex<Integer>(7), new Vertex<Integer>(10), new Vertex<Integer>(1), new Vertex<Integer>(5),
                new Vertex<Integer>(8), new Vertex<Integer>(11), new Vertex<Integer>(12), new Vertex<Integer>(2),
                new Vertex<Integer>(3), new Vertex<Integer>(6), new Vertex<Integer>(4), new Vertex<Integer>(13)));

        assertEquals(bfsExpected9, bfsActual9);

    }

    @Test(timeout = TIMEOUT)
    public void testBFSConnectedDirectedGraph1() {
        // start vertex 1
        List<Vertex<Integer>> bfsActual1 = GraphAlgorithms.bfs(new Vertex<Integer>(1), connectedDirectedGraph1);
        List<Vertex<Integer>> bfsExpected1 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(1),
                new Vertex<Integer>(2), new Vertex<Integer>(3), new Vertex<Integer>(4), new Vertex<Integer>(5),
                new Vertex<Integer>(6), new Vertex<Integer>(7), new Vertex<Integer>(8), new Vertex<Integer>(9)));

        assertEquals(bfsExpected1, bfsActual1);

        // start vertex 4
        List<Vertex<Integer>> bfsActual4 = GraphAlgorithms.bfs(new Vertex<Integer>(4), connectedDirectedGraph1);
        List<Vertex<Integer>> bfsExpected4 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(4),
                new Vertex<Integer>(2), new Vertex<Integer>(5), new Vertex<Integer>(6), new Vertex<Integer>(1),
                new Vertex<Integer>(3), new Vertex<Integer>(7), new Vertex<Integer>(8), new Vertex<Integer>(9)));

        assertEquals(bfsExpected4, bfsActual4);

        // start vertex 6
        List<Vertex<Integer>> bfsActual6 = GraphAlgorithms.bfs(new Vertex<Integer>(6), connectedDirectedGraph1);
        List<Vertex<Integer>> bfsExpected6 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(6),
                new Vertex<Integer>(4), new Vertex<Integer>(7), new Vertex<Integer>(8), new Vertex<Integer>(2),
                new Vertex<Integer>(5), new Vertex<Integer>(9), new Vertex<Integer>(1), new Vertex<Integer>(3)));

        assertEquals(bfsExpected6, bfsActual6);

        // start vertex 9
        List<Vertex<Integer>> bfsActual9 = GraphAlgorithms.bfs(new Vertex<Integer>(9), connectedDirectedGraph1);
        List<Vertex<Integer>> bfsExpected9 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(9),
                new Vertex<Integer>(7), new Vertex<Integer>(8), new Vertex<Integer>(5), new Vertex<Integer>(6),
                new Vertex<Integer>(3), new Vertex<Integer>(4), new Vertex<Integer>(2), new Vertex<Integer>(1)));

        assertEquals(bfsExpected9, bfsActual9);

    }

    @Test(timeout = TIMEOUT)
    public void testBFSUndirectedGraph1() {
        // start vertex 1
        List<Vertex<Integer>> bfsActual1 = GraphAlgorithms.bfs(new Vertex<Integer>(1), undirectedGraph1);
        List<Vertex<Integer>> bfsExpected1 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(1),
                new Vertex<Integer>(2), new Vertex<Integer>(8), new Vertex<Integer>(3), new Vertex<Integer>(7),
                new Vertex<Integer>(9), new Vertex<Integer>(4), new Vertex<Integer>(6), new Vertex<Integer>(5)));

        assertEquals(bfsExpected1, bfsActual1);

        // start vertex 9
        List<Vertex<Integer>> bfsActual9 = GraphAlgorithms.bfs(new Vertex<Integer>(9), undirectedGraph1);
        List<Vertex<Integer>> bfsExpected9 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(9),
                new Vertex<Integer>(3), new Vertex<Integer>(7), new Vertex<Integer>(8), new Vertex<Integer>(2),
                new Vertex<Integer>(4), new Vertex<Integer>(6), new Vertex<Integer>(1), new Vertex<Integer>(5)));
        assertEquals(bfsExpected9, bfsActual9);

        // start vertex 3
        List<Vertex<Integer>> bfsActual3 = GraphAlgorithms.bfs(new Vertex<Integer>(3), undirectedGraph1);
        List<Vertex<Integer>> bfsExpected3 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(3),
                new Vertex<Integer>(2), new Vertex<Integer>(4), new Vertex<Integer>(6), new Vertex<Integer>(9),
                new Vertex<Integer>(1), new Vertex<Integer>(8), new Vertex<Integer>(5), new Vertex<Integer>(7)));
        assertEquals(bfsExpected3, bfsActual3);

        // start vertex 8
        List<Vertex<Integer>> bfsActual8 = GraphAlgorithms.bfs(new Vertex<Integer>(8), undirectedGraph1);
        List<Vertex<Integer>> bfsExpected8 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(8),
                new Vertex<Integer>(1), new Vertex<Integer>(2), new Vertex<Integer>(7), new Vertex<Integer>(9),
                new Vertex<Integer>(3), new Vertex<Integer>(6), new Vertex<Integer>(4), new Vertex<Integer>(5)));
        assertEquals(bfsExpected8, bfsActual8);

    }

    @Test(timeout = TIMEOUT)
    public void testBFSDisconnectedDirectedGraph1() {
        // start vertex 10
        List<Vertex<Integer>> bfsActual10 = GraphAlgorithms.bfs(new Vertex<Integer>(10), disconnectedDirectedGraph1);
        List<Vertex<Integer>> bfsExpected10 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(10)));

        assertEquals(bfsExpected10, bfsActual10);

        // start vertex 7
        List<Vertex<Integer>> bfsActual7 = GraphAlgorithms.bfs(new Vertex<Integer>(7), disconnectedDirectedGraph1);
        List<Vertex<Integer>> bfsExpected7 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(7), new Vertex<Integer>(8), new Vertex<Integer>(9)));

        assertEquals(bfsExpected7, bfsActual7);

        // start vertex 5
        List<Vertex<Integer>> bfsActual5 = GraphAlgorithms.bfs(new Vertex<Integer>(5), disconnectedDirectedGraph1);
        List<Vertex<Integer>> bfsExpected5 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(5),
                new Vertex<Integer>(6), new Vertex<Integer>(7), new Vertex<Integer>(8), new Vertex<Integer>(9)));

        assertEquals(bfsExpected5, bfsActual5);

        // start vertex 2
        List<Vertex<Integer>> bfsActual2 = GraphAlgorithms.bfs(new Vertex<Integer>(2), disconnectedDirectedGraph1);
        List<Vertex<Integer>> bfsExpected2 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(2),
                new Vertex<Integer>(3), new Vertex<Integer>(4), new Vertex<Integer>(1)));

        assertEquals(bfsExpected2, bfsActual2);

        // start vertex 4
        List<Vertex<Integer>> bfsActual4 = GraphAlgorithms.bfs(new Vertex<Integer>(4), disconnectedDirectedGraph1);
        List<Vertex<Integer>> bfsExpected4 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(4),
                new Vertex<Integer>(1), new Vertex<Integer>(2), new Vertex<Integer>(3)));

        assertEquals(bfsExpected4, bfsActual4);

    }

    @Test(timeout = TIMEOUT)
    public void testBFSDisconnectedUndirectedGraph1() {
        // start vertex 5
        List<Vertex<Integer>> bfsActual5 = GraphAlgorithms.bfs(new Vertex<Integer>(5), disconnectedUndirectedGraph1);
        List<Vertex<Integer>> bfsExpected5 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(5), new Vertex<Integer>(1), new Vertex<Integer>(2),
                        new Vertex<Integer>(3), new Vertex<Integer>(4), new Vertex<Integer>(6)));

        assertEquals(bfsExpected5, bfsActual5);

        // start vertex 1
        List<Vertex<Integer>> bfsActual1 = GraphAlgorithms.bfs(new Vertex<Integer>(1), disconnectedUndirectedGraph1);
        List<Vertex<Integer>> bfsExpected1 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(1), new Vertex<Integer>(2), new Vertex<Integer>(5),
                        new Vertex<Integer>(3), new Vertex<Integer>(4), new Vertex<Integer>(6)));

        assertEquals(bfsExpected1, bfsActual1);

        // start vertex 6
        List<Vertex<Integer>> bfsActual6 = GraphAlgorithms.bfs(new Vertex<Integer>(6), disconnectedUndirectedGraph1);
        List<Vertex<Integer>> bfsExpected6 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(6), new Vertex<Integer>(3), new Vertex<Integer>(4),
                        new Vertex<Integer>(5), new Vertex<Integer>(1), new Vertex<Integer>(2)));

        assertEquals(bfsExpected6, bfsActual6);

        // start vertex 4
        List<Vertex<Integer>> bfsActual4 = GraphAlgorithms.bfs(new Vertex<Integer>(4), disconnectedUndirectedGraph1);
        List<Vertex<Integer>> bfsExpected4 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(4), new Vertex<Integer>(3), new Vertex<Integer>(5),
                        new Vertex<Integer>(6), new Vertex<Integer>(1), new Vertex<Integer>(2)));

        assertEquals(bfsExpected4, bfsActual4);
    }

    @Test(timeout = TIMEOUT)
    public void testBFSCompleteGraph1() {
        // start vertex 2
        List<Vertex<Integer>> bfsActual2 = GraphAlgorithms.bfs(new Vertex<Integer>(2), completeGraph1);
        List<Vertex<Integer>> bfsExpected2 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(2),
                new Vertex<Integer>(1), new Vertex<Integer>(3), new Vertex<Integer>(4), new Vertex<Integer>(5),
                new Vertex<Integer>(6), new Vertex<Integer>(7)));

        assertEquals(bfsExpected2, bfsActual2);

        // start vertex 4
        List<Vertex<Integer>> bfsActual4 = GraphAlgorithms.bfs(new Vertex<Integer>(4), completeGraph1);
        List<Vertex<Integer>> bfsExpected4 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(4),
                new Vertex<Integer>(1), new Vertex<Integer>(2), new Vertex<Integer>(3), new Vertex<Integer>(5),
                new Vertex<Integer>(6), new Vertex<Integer>(7)));

        assertEquals(bfsExpected4, bfsActual4);

        // start vertex 7
        List<Vertex<Integer>> bfsActual7 = GraphAlgorithms.bfs(new Vertex<Integer>(7), completeGraph1);
        List<Vertex<Integer>> bfsExpected7 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(7),
                new Vertex<Integer>(1), new Vertex<Integer>(2), new Vertex<Integer>(3), new Vertex<Integer>(4),
                new Vertex<Integer>(5), new Vertex<Integer>(6)));

        assertEquals(bfsExpected7, bfsActual7);

    }

    @Test(timeout = TIMEOUT)
    public void testDirectedGraph2() {
        // start vertex F
        List<Vertex<Character>> bfsActualF = GraphAlgorithms.bfs(new Vertex<Character>('F'), directedGraph2);
        List<Vertex<Character>> bfsExpectedF = new LinkedList<Vertex<Character>>(
                Arrays.asList(new Vertex<Character>('F'), new Vertex<Character>('B'), new Vertex<Character>('C'),
                        new Vertex<Character>('E'), new Vertex<Character>('J'), new Vertex<Character>('A'),
                        new Vertex<Character>('G'), new Vertex<Character>('M'), new Vertex<Character>('H'),
                        new Vertex<Character>('D'), new Vertex<Character>('K'), new Vertex<Character>('I'),
                        new Vertex<Character>('N'), new Vertex<Character>('Q'), new Vertex<Character>('R')));

        assertEquals(bfsExpectedF, bfsActualF);

        // start vertex O
        List<Vertex<Character>> bfsActualO = GraphAlgorithms.bfs(new Vertex<Character>('O'), directedGraph2);
        List<Vertex<Character>> bfsExpectedO = new LinkedList<Vertex<Character>>(
                Arrays.asList(new Vertex<Character>('O'), new Vertex<Character>('H'), new Vertex<Character>('A'),
                        new Vertex<Character>('E'), new Vertex<Character>('F'), new Vertex<Character>('B'),
                        new Vertex<Character>('C'), new Vertex<Character>('J'), new Vertex<Character>('G'),
                        new Vertex<Character>('M'), new Vertex<Character>('D'), new Vertex<Character>('K'),
                        new Vertex<Character>('I'), new Vertex<Character>('N'), new Vertex<Character>('Q'),
                        new Vertex<Character>('R')));

        assertEquals(bfsExpectedO, bfsActualO);

        // start vertex R
        List<Vertex<Character>> bfsActualR = GraphAlgorithms.bfs(new Vertex<Character>('R'), directedGraph2);
        List<Vertex<Character>> bfsExpectedR = new LinkedList<Vertex<Character>>(
                Arrays.asList(new Vertex<Character>('R'), new Vertex<Character>('K'), new Vertex<Character>('Q'),
                        new Vertex<Character>('D'), new Vertex<Character>('C'), new Vertex<Character>('G'),
                        new Vertex<Character>('F'), new Vertex<Character>('B'), new Vertex<Character>('E'),
                        new Vertex<Character>('J'), new Vertex<Character>('A'), new Vertex<Character>('M'),
                        new Vertex<Character>('H'), new Vertex<Character>('I'), new Vertex<Character>('N')));

        assertEquals(bfsExpectedR, bfsActualR);

        // start vertex D
        List<Vertex<Character>> bfsActualD = GraphAlgorithms.bfs(new Vertex<Character>('D'), directedGraph2);
        List<Vertex<Character>> bfsExpectedD = new LinkedList<Vertex<Character>>(
                Arrays.asList(new Vertex<Character>('D'), new Vertex<Character>('C'), new Vertex<Character>('G'),
                        new Vertex<Character>('R'), new Vertex<Character>('F'), new Vertex<Character>('K'),
                        new Vertex<Character>('Q'), new Vertex<Character>('B'), new Vertex<Character>('E'),
                        new Vertex<Character>('J'), new Vertex<Character>('A'), new Vertex<Character>('M'),
                        new Vertex<Character>('H'), new Vertex<Character>('I'), new Vertex<Character>('N')));

        assertEquals(bfsExpectedD, bfsActualD);
    }

    @Test(timeout = TIMEOUT)
    public void testBFSSelfLoopAndParallelEdgesGraph1() {

        // start vertex 2
        List<Vertex<Integer>> bfsActual2 = GraphAlgorithms.bfs(new Vertex<Integer>(2), selfLoopAndParallelEdgesGraph1);
        List<Vertex<Integer>> bfsExpected2 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(2),
                new Vertex<Integer>(1), new Vertex<Integer>(3), new Vertex<Integer>(4)));

        assertEquals(bfsExpected2, bfsActual2);

        // start vertex 1
        List<Vertex<Integer>> bfsActual1 = GraphAlgorithms.bfs(new Vertex<Integer>(1), selfLoopAndParallelEdgesGraph1);
        List<Vertex<Integer>> bfsExpected1 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(1),
                new Vertex<Integer>(2), new Vertex<Integer>(4), new Vertex<Integer>(3)));

        assertEquals(bfsExpected1, bfsActual1);

        // start vertex 4
        List<Vertex<Integer>> bfsActual4 = GraphAlgorithms.bfs(new Vertex<Integer>(4), selfLoopAndParallelEdgesGraph1);
        List<Vertex<Integer>> bfsExpected4 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(4),
                new Vertex<Integer>(1), new Vertex<Integer>(2), new Vertex<Integer>(3)));

        assertEquals(bfsExpected4, bfsActual4);

        // start vertex 3
        List<Vertex<Integer>> bfsActual3 = GraphAlgorithms.bfs(new Vertex<Integer>(3), selfLoopAndParallelEdgesGraph1);
        List<Vertex<Integer>> bfsExpected3 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(3),
                new Vertex<Integer>(2), new Vertex<Integer>(1), new Vertex<Integer>(4)));

        assertEquals(bfsExpected3, bfsActual3);
    }

    @Test(timeout = TIMEOUT)
    public void testBFSPetersonGraph() {
        // start vertex 8
        List<Vertex<Integer>> bfsActual8 = GraphAlgorithms.bfs(new Vertex<Integer>(8), petersonGraph);
        List<Vertex<Integer>> bfsExpected8 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(8), new Vertex<Integer>(2), new Vertex<Integer>(9),
                        new Vertex<Integer>(10), new Vertex<Integer>(1), new Vertex<Integer>(4), new Vertex<Integer>(3),
                        new Vertex<Integer>(7), new Vertex<Integer>(5), new Vertex<Integer>(6)));

        assertEquals(bfsExpected8, bfsActual8);

        // start vertex 5
        List<Vertex<Integer>> bfsActual5 = GraphAlgorithms.bfs(new Vertex<Integer>(5), petersonGraph);
        List<Vertex<Integer>> bfsExpected5 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(5), new Vertex<Integer>(3), new Vertex<Integer>(4),
                        new Vertex<Integer>(10), new Vertex<Integer>(1), new Vertex<Integer>(9), new Vertex<Integer>(2),
                        new Vertex<Integer>(7), new Vertex<Integer>(6), new Vertex<Integer>(8)));

        assertEquals(bfsExpected5, bfsActual5);

        // start vertex 6
        List<Vertex<Integer>> bfsActual6 = GraphAlgorithms.bfs(new Vertex<Integer>(6), petersonGraph);
        List<Vertex<Integer>> bfsExpected6 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(6), new Vertex<Integer>(1), new Vertex<Integer>(7),
                        new Vertex<Integer>(10), new Vertex<Integer>(2), new Vertex<Integer>(3), new Vertex<Integer>(4),
                        new Vertex<Integer>(9), new Vertex<Integer>(5), new Vertex<Integer>(8)));

        assertEquals(bfsExpected6, bfsActual6);

        // start vertex 2
        List<Vertex<Integer>> bfsActual2 = GraphAlgorithms.bfs(new Vertex<Integer>(2), petersonGraph);
        List<Vertex<Integer>> bfsExpected2 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(2), new Vertex<Integer>(1), new Vertex<Integer>(4),
                        new Vertex<Integer>(8), new Vertex<Integer>(3), new Vertex<Integer>(6), new Vertex<Integer>(5),
                        new Vertex<Integer>(7), new Vertex<Integer>(9), new Vertex<Integer>(10)));

        assertEquals(bfsExpected2, bfsActual2);
    }

    @Test(timeout = TIMEOUT)
    public void testBFSNoEdgesGraph() {
        // start vertex 1
        List<Vertex<Integer>> bfsActual1 = GraphAlgorithms.bfs(new Vertex<Integer>(1), noEdgesGraph);
        List<Vertex<Integer>> bfsExpected1 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(1)));

        assertEquals(bfsExpected1, bfsActual1);

        // start vertex 6
        List<Vertex<Integer>> bfsActual6 = GraphAlgorithms.bfs(new Vertex<Integer>(6), noEdgesGraph);
        List<Vertex<Integer>> bfsExpected6 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(6)));

        assertEquals(bfsExpected6, bfsActual6);
    }

    @Test(timeout = TIMEOUT)
    public void testBFSMultiGraph1() {
        // start vertex 1
        List<Vertex<Integer>> bfsActual1 = GraphAlgorithms.bfs(new Vertex<Integer>(1), multiGraph1);
        List<Vertex<Integer>> bfsExpected1 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(1), new Vertex<Integer>(2), new Vertex<Integer>(3)));

        assertEquals(bfsExpected1, bfsActual1);

        // start vertex 2
        List<Vertex<Integer>> bfsActual2 = GraphAlgorithms.bfs(new Vertex<Integer>(2), multiGraph1);
        List<Vertex<Integer>> bfsExpected2 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(2), new Vertex<Integer>(1), new Vertex<Integer>(3)));

        assertEquals(bfsExpected2, bfsActual2);

        // start vertex 3
        List<Vertex<Integer>> bfsActual3 = GraphAlgorithms.bfs(new Vertex<Integer>(3), multiGraph1);
        List<Vertex<Integer>> bfsExpected3 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(3), new Vertex<Integer>(1), new Vertex<Integer>(2)));

        assertEquals(bfsExpected3, bfsActual3);

    }

    @Test(timeout = TIMEOUT)
    public void testBFSSelfLoopGraph() {
        // start vertex 1
        List<Vertex<Integer>> bfsActual1 = GraphAlgorithms.bfs(new Vertex<Integer>(1), selfLoopGraph);
        List<Vertex<Integer>> bfsExpected1 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(1), new Vertex<Integer>(3)));

        assertEquals(bfsExpected1, bfsActual1);

        // start vertex 2
        List<Vertex<Integer>> bfsActual2 = GraphAlgorithms.bfs(new Vertex<Integer>(2), selfLoopGraph);
        List<Vertex<Integer>> bfsExpected2 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(2)));

        assertEquals(bfsExpected2, bfsActual2);

        // start vertex 3
        List<Vertex<Integer>> bfsActual3 = GraphAlgorithms.bfs(new Vertex<Integer>(3), selfLoopGraph);
        List<Vertex<Integer>> bfsExpected3 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(3)));

        assertEquals(bfsExpected3, bfsActual3);
    }

    @Test(timeout = TIMEOUT)
    public void testBFSEulerianGraph() {
        // start vertex 4
        List<Vertex<Integer>> bfsActual4 = GraphAlgorithms.bfs(new Vertex<Integer>(4), eulerianGraph);
        List<Vertex<Integer>> bfsExpected4 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(4), new Vertex<Integer>(7), new Vertex<Integer>(10),
                        new Vertex<Integer>(1), new Vertex<Integer>(2), new Vertex<Integer>(3), new Vertex<Integer>(9),
                        new Vertex<Integer>(5), new Vertex<Integer>(6), new Vertex<Integer>(8)));

        assertEquals(bfsExpected4, bfsActual4);

        // start vertex 8
        List<Vertex<Integer>> bfsActual8 = GraphAlgorithms.bfs(new Vertex<Integer>(8), eulerianGraph);
        List<Vertex<Integer>> bfsExpected8 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(8), new Vertex<Integer>(3), new Vertex<Integer>(9),
                        new Vertex<Integer>(2), new Vertex<Integer>(5), new Vertex<Integer>(10), new Vertex<Integer>(6),
                        new Vertex<Integer>(7), new Vertex<Integer>(1), new Vertex<Integer>(4)));

        assertEquals(bfsExpected8, bfsActual8);

        // start vertex 7
        List<Vertex<Integer>> bfsActual7 = GraphAlgorithms.bfs(new Vertex<Integer>(7), eulerianGraph);
        List<Vertex<Integer>> bfsExpected7 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(7), new Vertex<Integer>(1), new Vertex<Integer>(2),
                        new Vertex<Integer>(4), new Vertex<Integer>(10), new Vertex<Integer>(5), new Vertex<Integer>(3),
                        new Vertex<Integer>(6), new Vertex<Integer>(9), new Vertex<Integer>(8)));

        assertEquals(bfsExpected7, bfsActual7);

        // start vertex 6
        List<Vertex<Integer>> bfsActual6 = GraphAlgorithms.bfs(new Vertex<Integer>(6), eulerianGraph);
        List<Vertex<Integer>> bfsExpected6 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(6), new Vertex<Integer>(2), new Vertex<Integer>(5),
                        new Vertex<Integer>(3), new Vertex<Integer>(7), new Vertex<Integer>(1), new Vertex<Integer>(8),
                        new Vertex<Integer>(10), new Vertex<Integer>(4), new Vertex<Integer>(9)));

        assertEquals(bfsExpected6, bfsActual6);

    }

    @Test(timeout = TIMEOUT)
    public void testBFSHamiltonianGraph() {
        // start vertex 3
        List<Vertex<Integer>> bfsActual3 = GraphAlgorithms.bfs(new Vertex<Integer>(3), hamiltonianGraph);
        List<Vertex<Integer>> bfsExpected3 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(3), new Vertex<Integer>(2), new Vertex<Integer>(8),
                        new Vertex<Integer>(10), new Vertex<Integer>(5), new Vertex<Integer>(6), new Vertex<Integer>(7),
                        new Vertex<Integer>(9), new Vertex<Integer>(4), new Vertex<Integer>(1)));

        assertEquals(bfsExpected3, bfsActual3);

        // start vertex 5
        List<Vertex<Integer>> bfsActual5 = GraphAlgorithms.bfs(new Vertex<Integer>(5), hamiltonianGraph);
        List<Vertex<Integer>> bfsExpected5 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(5), new Vertex<Integer>(1), new Vertex<Integer>(2),
                        new Vertex<Integer>(6), new Vertex<Integer>(7), new Vertex<Integer>(3), new Vertex<Integer>(4),
                        new Vertex<Integer>(8), new Vertex<Integer>(10), new Vertex<Integer>(9)));

        assertEquals(bfsExpected5, bfsActual5);

        // start vertex 2
        List<Vertex<Integer>> bfsActual2 = GraphAlgorithms.bfs(new Vertex<Integer>(2), hamiltonianGraph);
        List<Vertex<Integer>> bfsExpected2 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(2), new Vertex<Integer>(3), new Vertex<Integer>(5),
                        new Vertex<Integer>(6), new Vertex<Integer>(7), new Vertex<Integer>(8), new Vertex<Integer>(10),
                        new Vertex<Integer>(1), new Vertex<Integer>(4), new Vertex<Integer>(9)));

        assertEquals(bfsExpected2, bfsActual2);

        // start vertex 9
        List<Vertex<Integer>> bfsActual9 = GraphAlgorithms.bfs(new Vertex<Integer>(9), hamiltonianGraph);
        List<Vertex<Integer>> bfsExpected9 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(9), new Vertex<Integer>(8), new Vertex<Integer>(10),
                        new Vertex<Integer>(3), new Vertex<Integer>(4), new Vertex<Integer>(2), new Vertex<Integer>(7),
                        new Vertex<Integer>(5), new Vertex<Integer>(6), new Vertex<Integer>(1)));

        assertEquals(bfsExpected9, bfsActual9);

    }

    @Test(timeout = TIMEOUT)
    public void testSameBFS() {
        // start vertex 2
        List<Vertex<Integer>> bfsActual2 = GraphAlgorithms.bfs(new Vertex<Integer>(2), sameBFSAndDFS);
        List<Vertex<Integer>> bfsExpected2 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(2),
                new Vertex<Integer>(1), new Vertex<Integer>(3), new Vertex<Integer>(4), new Vertex<Integer>(5),
                new Vertex<Integer>(6), new Vertex<Integer>(7)));

        assertEquals(bfsExpected2, bfsActual2);

        // start vertex 5
        List<Vertex<Integer>> bfsActual5 = GraphAlgorithms.bfs(new Vertex<Integer>(5), sameBFSAndDFS);
        List<Vertex<Integer>> bfsExpected5 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(5),
                new Vertex<Integer>(3), new Vertex<Integer>(4), new Vertex<Integer>(6), new Vertex<Integer>(7),
                new Vertex<Integer>(1), new Vertex<Integer>(2)));

        assertEquals(bfsExpected5, bfsActual5);

        // start vertex 7
        List<Vertex<Integer>> bfsActual7 = GraphAlgorithms.bfs(new Vertex<Integer>(7), sameBFSAndDFS);
        List<Vertex<Integer>> bfsExpected7 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(7),
                new Vertex<Integer>(5), new Vertex<Integer>(6), new Vertex<Integer>(3), new Vertex<Integer>(4),
                new Vertex<Integer>(1), new Vertex<Integer>(2)));

        assertEquals(bfsExpected7, bfsActual7);

        // start vertex 4
        List<Vertex<Integer>> bfsActual4 = GraphAlgorithms.bfs(new Vertex<Integer>(4), sameBFSAndDFS);
        List<Vertex<Integer>> bfsExpected4 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(4),
                new Vertex<Integer>(3), new Vertex<Integer>(5), new Vertex<Integer>(1), new Vertex<Integer>(2),
                new Vertex<Integer>(6), new Vertex<Integer>(7)));

        assertEquals(bfsExpected4, bfsActual4);

    }

    @Test(timeout = TIMEOUT)
    public void testBFSTree() {
        // start vertex 3
        List<Vertex<Integer>> bfsActual3 = GraphAlgorithms.bfs(new Vertex<Integer>(3), tree);
        List<Vertex<Integer>> bfsExpected3 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(3),
                new Vertex<Integer>(2), new Vertex<Integer>(4), new Vertex<Integer>(5), new Vertex<Integer>(1),
                new Vertex<Integer>(6), new Vertex<Integer>(7)));

        assertEquals(bfsExpected3, bfsActual3);

        // start vertex 4
        List<Vertex<Integer>> bfsActual4 = GraphAlgorithms.bfs(new Vertex<Integer>(4), tree);
        List<Vertex<Integer>> bfsExpected4 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(4),
                new Vertex<Integer>(3), new Vertex<Integer>(2), new Vertex<Integer>(5), new Vertex<Integer>(1),
                new Vertex<Integer>(6), new Vertex<Integer>(7)));

        assertEquals(bfsExpected4, bfsActual4);

    }

    @Test(timeout = TIMEOUT)
    public void testDFSSelfLoopAndParallelEdgesGraph1() {
        // start vertex 2
        List<Vertex<Integer>> dfsActual2 = GraphAlgorithms.dfs(new Vertex<Integer>(2), selfLoopAndParallelEdgesGraph1);
        List<Vertex<Integer>> dfsExpected2 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(2),
                new Vertex<Integer>(1), new Vertex<Integer>(4), new Vertex<Integer>(3)));

        assertEquals(dfsExpected2, dfsActual2);

        // start vertex 4
        List<Vertex<Integer>> dfsActual4 = GraphAlgorithms.dfs(new Vertex<Integer>(4), selfLoopAndParallelEdgesGraph1);
        List<Vertex<Integer>> dfsExpected4 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(4),
                new Vertex<Integer>(1), new Vertex<Integer>(2), new Vertex<Integer>(3)));

        assertEquals(dfsExpected4, dfsActual4);

    }

    // DFS TESTS
    @Test(timeout = TIMEOUT)
    public void testDFSDirectedGraph1() {
        // start vertex 1
        List<Vertex<Integer>> dfsActual1 = GraphAlgorithms.dfs(new Vertex<Integer>(1), directedGraph1);
        List<Vertex<Integer>> dfsExpected1 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(1), new Vertex<Integer>(2), new Vertex<Integer>(3),
                        new Vertex<Integer>(4), new Vertex<Integer>(6), new Vertex<Integer>(5)));

        assertEquals(dfsExpected1, dfsActual1);

        // start vertex 10
        List<Vertex<Integer>> dfsActual10 = GraphAlgorithms.dfs(new Vertex<Integer>(10), directedGraph1);
        List<Vertex<Integer>> dfsExpected10 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(10),
                new Vertex<Integer>(11), new Vertex<Integer>(13), new Vertex<Integer>(12), new Vertex<Integer>(5),
                new Vertex<Integer>(3), new Vertex<Integer>(4), new Vertex<Integer>(6)));

        assertEquals(dfsExpected10, dfsActual10);

        // start vertex 5
        List<Vertex<Integer>> dfsActual5 = GraphAlgorithms.dfs(new Vertex<Integer>(5), directedGraph1);
        List<Vertex<Integer>> dfsExpected5 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(5),
                new Vertex<Integer>(3), new Vertex<Integer>(4), new Vertex<Integer>(6)));

        assertEquals(dfsExpected5, dfsActual5);

        // start vertex 8
        List<Vertex<Integer>> dfsActual8 = GraphAlgorithms.dfs(new Vertex<Integer>(8), directedGraph1);
        List<Vertex<Integer>> dfsExpected8 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(8),
                new Vertex<Integer>(7), new Vertex<Integer>(1), new Vertex<Integer>(2), new Vertex<Integer>(3),
                new Vertex<Integer>(4), new Vertex<Integer>(6), new Vertex<Integer>(5), new Vertex<Integer>(10),
                new Vertex<Integer>(11), new Vertex<Integer>(13), new Vertex<Integer>(12)));

        assertEquals(dfsExpected8, dfsActual8);
    }

    @Test(timeout = TIMEOUT)
    public void testDFSConnectedDirectedGraph1() {
        // start vertex 4
        List<Vertex<Integer>> dfsActual4 = GraphAlgorithms.dfs(new Vertex<Integer>(4), connectedDirectedGraph1);
        List<Vertex<Integer>> dfsExpected4 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(4),
                new Vertex<Integer>(2), new Vertex<Integer>(1), new Vertex<Integer>(3), new Vertex<Integer>(5),
                new Vertex<Integer>(7), new Vertex<Integer>(9), new Vertex<Integer>(8), new Vertex<Integer>(6)));

        assertEquals(dfsExpected4, dfsActual4);

        // start vertex 7
        List<Vertex<Integer>> dfsActual7 = GraphAlgorithms.dfs(new Vertex<Integer>(7), connectedDirectedGraph1);
        List<Vertex<Integer>> dfsExpected7 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(7),
                new Vertex<Integer>(5), new Vertex<Integer>(3), new Vertex<Integer>(2), new Vertex<Integer>(1),
                new Vertex<Integer>(4), new Vertex<Integer>(6), new Vertex<Integer>(8), new Vertex<Integer>(9)));

        assertEquals(dfsExpected7, dfsActual7);

        // start vertex 9
        List<Vertex<Integer>> dfsActual9 = GraphAlgorithms.dfs(new Vertex<Integer>(9), connectedDirectedGraph1);
        List<Vertex<Integer>> dfsExpected9 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(9),
                new Vertex<Integer>(7), new Vertex<Integer>(5), new Vertex<Integer>(3), new Vertex<Integer>(2),
                new Vertex<Integer>(1), new Vertex<Integer>(4), new Vertex<Integer>(6), new Vertex<Integer>(8)));

        assertEquals(dfsExpected9, dfsActual9);

        // start vertex 6
        List<Vertex<Integer>> dfsActual6 = GraphAlgorithms.dfs(new Vertex<Integer>(6), connectedDirectedGraph1);
        List<Vertex<Integer>> dfsExpected6 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(6),
                new Vertex<Integer>(4), new Vertex<Integer>(2), new Vertex<Integer>(1), new Vertex<Integer>(3),
                new Vertex<Integer>(5), new Vertex<Integer>(7), new Vertex<Integer>(9), new Vertex<Integer>(8)));

        assertEquals(dfsExpected6, dfsActual6);
    }

    @Test(timeout = TIMEOUT)
    public void testDFSUndirectedGraph1() {
        // start vertex 9
        List<Vertex<Integer>> dfsActual9 = GraphAlgorithms.dfs(new Vertex<Integer>(9), undirectedGraph1);
        List<Vertex<Integer>> dfsExpected9 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(9),
                new Vertex<Integer>(3), new Vertex<Integer>(2), new Vertex<Integer>(1), new Vertex<Integer>(8),
                new Vertex<Integer>(7), new Vertex<Integer>(6), new Vertex<Integer>(4), new Vertex<Integer>(5)));

        assertEquals(dfsExpected9, dfsActual9);

        // start vertex 6
        List<Vertex<Integer>> dfsActual6 = GraphAlgorithms.dfs(new Vertex<Integer>(6), undirectedGraph1);
        List<Vertex<Integer>> dfsExpected6 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(6),
                new Vertex<Integer>(3), new Vertex<Integer>(2), new Vertex<Integer>(1), new Vertex<Integer>(8),
                new Vertex<Integer>(7), new Vertex<Integer>(9), new Vertex<Integer>(4), new Vertex<Integer>(5)));

        assertEquals(dfsExpected6, dfsActual6);

        // start vertex 5
        List<Vertex<Integer>> dfsActual5 = GraphAlgorithms.dfs(new Vertex<Integer>(5), undirectedGraph1);
        List<Vertex<Integer>> dfsExpected5 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(5),
                new Vertex<Integer>(4), new Vertex<Integer>(3), new Vertex<Integer>(2), new Vertex<Integer>(1),
                new Vertex<Integer>(8), new Vertex<Integer>(7), new Vertex<Integer>(6), new Vertex<Integer>(9)));

        assertEquals(dfsExpected5, dfsActual5);

        // start vertex 2
        List<Vertex<Integer>> dfsActual2 = GraphAlgorithms.dfs(new Vertex<Integer>(2), undirectedGraph1);
        List<Vertex<Integer>> dfsExpected2 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(2),
                new Vertex<Integer>(1), new Vertex<Integer>(8), new Vertex<Integer>(7), new Vertex<Integer>(6),
                new Vertex<Integer>(3), new Vertex<Integer>(4), new Vertex<Integer>(5), new Vertex<Integer>(9)));

        assertEquals(dfsExpected2, dfsActual2);

    }

    @Test(timeout = TIMEOUT)
    public void testDFSDisconnectedDirectedGraph1() {
        // start vertex 2
        List<Vertex<Integer>> dfsActual2 = GraphAlgorithms.dfs(new Vertex<Integer>(2), disconnectedDirectedGraph1);
        List<Vertex<Integer>> dfsExpected2 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(2),
                new Vertex<Integer>(3), new Vertex<Integer>(4), new Vertex<Integer>(1)));

        assertEquals(dfsExpected2, dfsActual2);

        // start vertex 9
        List<Vertex<Integer>> dfsActual9 = GraphAlgorithms.dfs(new Vertex<Integer>(9), disconnectedDirectedGraph1);
        List<Vertex<Integer>> dfsExpected9 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(9), new Vertex<Integer>(7), new Vertex<Integer>(8)));

        assertEquals(dfsExpected9, dfsActual9);

        // start vertex 5
        List<Vertex<Integer>> dfsActual5 = GraphAlgorithms.dfs(new Vertex<Integer>(5), disconnectedDirectedGraph1);
        List<Vertex<Integer>> dfsExpected5 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(5),
                new Vertex<Integer>(6), new Vertex<Integer>(7), new Vertex<Integer>(8), new Vertex<Integer>(9)));

        assertEquals(dfsExpected5, dfsActual5);

    }

    @Test(timeout = TIMEOUT)
    public void testDFSDisconnectedUndirectedGraph1() {
        // start vertex 5
        List<Vertex<Integer>> dfsActual5 = GraphAlgorithms.dfs(new Vertex<Integer>(5), disconnectedUndirectedGraph1);
        List<Vertex<Integer>> dfsExpected5 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(5), new Vertex<Integer>(1), new Vertex<Integer>(2),
                        new Vertex<Integer>(3), new Vertex<Integer>(4), new Vertex<Integer>(6)));

        assertEquals(dfsExpected5, dfsActual5);

        // start vertex 4
        List<Vertex<Integer>> dfsActual4 = GraphAlgorithms.dfs(new Vertex<Integer>(4), disconnectedUndirectedGraph1);
        List<Vertex<Integer>> dfsExpected4 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(4), new Vertex<Integer>(3), new Vertex<Integer>(5),
                        new Vertex<Integer>(1), new Vertex<Integer>(2), new Vertex<Integer>(6)));

        assertEquals(dfsExpected4, dfsActual4);

        // start vertex 1
        List<Vertex<Integer>> dfsActual1 = GraphAlgorithms.dfs(new Vertex<Integer>(1), disconnectedUndirectedGraph1);
        List<Vertex<Integer>> dfsExpected1 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(1), new Vertex<Integer>(2), new Vertex<Integer>(5),
                        new Vertex<Integer>(3), new Vertex<Integer>(4), new Vertex<Integer>(6)));

        assertEquals(dfsExpected1, dfsActual1);

        // start vertex 6
        List<Vertex<Integer>> dfsActual6 = GraphAlgorithms.dfs(new Vertex<Integer>(6), disconnectedUndirectedGraph1);
        List<Vertex<Integer>> dfsExpected6 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(6), new Vertex<Integer>(3), new Vertex<Integer>(4),
                        new Vertex<Integer>(5), new Vertex<Integer>(1), new Vertex<Integer>(2)));

        assertEquals(dfsExpected6, dfsActual6);
    }

    @Test(timeout = TIMEOUT)
    public void testDFSdirectedGraph2() {
        // start vertex F
        List<Vertex<Character>> dfsActualF = GraphAlgorithms.dfs(new Vertex<Character>('F'), directedGraph2);
        List<Vertex<Character>> dfsExpectedF = new LinkedList<Vertex<Character>>(
                Arrays.asList(new Vertex<Character>('F'), new Vertex<Character>('B'), new Vertex<Character>('A'),
                        new Vertex<Character>('E'), new Vertex<Character>('H'), new Vertex<Character>('C'),
                        new Vertex<Character>('G'), new Vertex<Character>('D'), new Vertex<Character>('R'),
                        new Vertex<Character>('K'), new Vertex<Character>('Q'), new Vertex<Character>('J'),
                        new Vertex<Character>('M'), new Vertex<Character>('I'), new Vertex<Character>('N')));

        assertEquals(dfsExpectedF, dfsActualF);

        // start vertex L
        List<Vertex<Character>> dfsActualL = GraphAlgorithms.dfs(new Vertex<Character>('L'), directedGraph2);
        List<Vertex<Character>> dfsExpectedL = new LinkedList<Vertex<Character>>(
                Arrays.asList(new Vertex<Character>('L'), new Vertex<Character>('H'), new Vertex<Character>('A'),
                        new Vertex<Character>('E'), new Vertex<Character>('F'), new Vertex<Character>('B'),
                        new Vertex<Character>('C'), new Vertex<Character>('G'), new Vertex<Character>('D'),
                        new Vertex<Character>('R'), new Vertex<Character>('K'), new Vertex<Character>('Q'),
                        new Vertex<Character>('J'), new Vertex<Character>('M'), new Vertex<Character>('I'),
                        new Vertex<Character>('N')));

        assertEquals(dfsExpectedL, dfsActualL);

        // start vertex D
        List<Vertex<Character>> dfsActualD = GraphAlgorithms.dfs(new Vertex<Character>('D'), directedGraph2);
        List<Vertex<Character>> dfsExpectedD = new LinkedList<Vertex<Character>>(
                Arrays.asList(new Vertex<Character>('D'), new Vertex<Character>('C'), new Vertex<Character>('G'),
                        new Vertex<Character>('F'), new Vertex<Character>('B'), new Vertex<Character>('A'),
                        new Vertex<Character>('E'), new Vertex<Character>('H'), new Vertex<Character>('J'),
                        new Vertex<Character>('M'), new Vertex<Character>('I'), new Vertex<Character>('N'),
                        new Vertex<Character>('K'), new Vertex<Character>('R'), new Vertex<Character>('Q')));

        assertEquals(dfsExpectedD, dfsActualD);

    }

    @Test(timeout = TIMEOUT)
    public void testDFSCompleteGraph() {
        // start vertex 3
        List<Vertex<Integer>> dfsActual3 = GraphAlgorithms.dfs(new Vertex<Integer>(3), completeGraph1);
        List<Vertex<Integer>> dfsExpected3 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(3),
                new Vertex<Integer>(1), new Vertex<Integer>(2), new Vertex<Integer>(4), new Vertex<Integer>(5),
                new Vertex<Integer>(6), new Vertex<Integer>(7)));

        assertEquals(dfsExpected3, dfsActual3);

        // start vertex 6
        List<Vertex<Integer>> dfsActual6 = GraphAlgorithms.dfs(new Vertex<Integer>(6), completeGraph1);
        List<Vertex<Integer>> dfsExpected6 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(6),
                new Vertex<Integer>(1), new Vertex<Integer>(2), new Vertex<Integer>(3), new Vertex<Integer>(4),
                new Vertex<Integer>(5), new Vertex<Integer>(7)));

        assertEquals(dfsExpected6, dfsActual6);

    }

    @Test(timeout = TIMEOUT)
    public void testDFSEulerianGraph() {
        // start vertex 5
        List<Vertex<Integer>> dfsActual5 = GraphAlgorithms.dfs(new Vertex<Integer>(5), eulerianGraph);
        List<Vertex<Integer>> dfsExpected5 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(5), new Vertex<Integer>(1), new Vertex<Integer>(7),
                        new Vertex<Integer>(2), new Vertex<Integer>(3), new Vertex<Integer>(8), new Vertex<Integer>(9),
                        new Vertex<Integer>(10), new Vertex<Integer>(4), new Vertex<Integer>(6)));

        assertEquals(dfsExpected5, dfsActual5);

        // start vertex 8
        List<Vertex<Integer>> dfsActual8 = GraphAlgorithms.dfs(new Vertex<Integer>(8), eulerianGraph);
        List<Vertex<Integer>> dfsExpected8 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(8), new Vertex<Integer>(3), new Vertex<Integer>(2),
                        new Vertex<Integer>(5), new Vertex<Integer>(1), new Vertex<Integer>(7), new Vertex<Integer>(4),
                        new Vertex<Integer>(10), new Vertex<Integer>(9), new Vertex<Integer>(6)));

        assertEquals(dfsExpected8, dfsActual8);

        // start vertex 7
        List<Vertex<Integer>> dfsActual7 = GraphAlgorithms.dfs(new Vertex<Integer>(7), eulerianGraph);
        List<Vertex<Integer>> dfsExpected7 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(7), new Vertex<Integer>(1), new Vertex<Integer>(5),
                        new Vertex<Integer>(2), new Vertex<Integer>(3), new Vertex<Integer>(8), new Vertex<Integer>(9),
                        new Vertex<Integer>(10), new Vertex<Integer>(4), new Vertex<Integer>(6)));

        assertEquals(dfsExpected7, dfsActual7);

        // start vertex 10
        List<Vertex<Integer>> dfsActual10 = GraphAlgorithms.dfs(new Vertex<Integer>(10), eulerianGraph);
        List<Vertex<Integer>> dfsExpected10 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(10), new Vertex<Integer>(3), new Vertex<Integer>(2),
                        new Vertex<Integer>(5), new Vertex<Integer>(1), new Vertex<Integer>(7), new Vertex<Integer>(4),
                        new Vertex<Integer>(6), new Vertex<Integer>(8), new Vertex<Integer>(9)));

        assertEquals(dfsExpected10, dfsActual10);
    }

    @Test(timeout = TIMEOUT)
    public void testDFSHamiltonianGraph() {
        // start vertex 5
        List<Vertex<Integer>> dfsActual5 = GraphAlgorithms.dfs(new Vertex<Integer>(5), hamiltonianGraph);
        List<Vertex<Integer>> dfsExpected5 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(5), new Vertex<Integer>(1), new Vertex<Integer>(7),
                        new Vertex<Integer>(2), new Vertex<Integer>(3), new Vertex<Integer>(8), new Vertex<Integer>(9),
                        new Vertex<Integer>(10), new Vertex<Integer>(4), new Vertex<Integer>(6)));

        assertEquals(dfsExpected5, dfsActual5);

        // start vertex 10
        List<Vertex<Integer>> dfsActual10 = GraphAlgorithms.dfs(new Vertex<Integer>(10), hamiltonianGraph);
        List<Vertex<Integer>> dfsExpected10 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(10), new Vertex<Integer>(3), new Vertex<Integer>(2),
                        new Vertex<Integer>(5), new Vertex<Integer>(1), new Vertex<Integer>(7), new Vertex<Integer>(4),
                        new Vertex<Integer>(6), new Vertex<Integer>(8), new Vertex<Integer>(9)));

        assertEquals(dfsExpected10, dfsActual10);

        // start vertex 7
        List<Vertex<Integer>> dfsActual7 = GraphAlgorithms.dfs(new Vertex<Integer>(7), hamiltonianGraph);
        List<Vertex<Integer>> dfsExpected7 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(7), new Vertex<Integer>(1), new Vertex<Integer>(5),
                        new Vertex<Integer>(2), new Vertex<Integer>(3), new Vertex<Integer>(8), new Vertex<Integer>(9),
                        new Vertex<Integer>(10), new Vertex<Integer>(4), new Vertex<Integer>(6)));

        assertEquals(dfsExpected7, dfsActual7);

        // start vertex 1
        List<Vertex<Integer>> dfsActual1 = GraphAlgorithms.dfs(new Vertex<Integer>(1), hamiltonianGraph);
        List<Vertex<Integer>> dfsExpected1 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(1), new Vertex<Integer>(5), new Vertex<Integer>(2),
                        new Vertex<Integer>(3), new Vertex<Integer>(8), new Vertex<Integer>(9), new Vertex<Integer>(10),
                        new Vertex<Integer>(4), new Vertex<Integer>(7), new Vertex<Integer>(6)));

        assertEquals(dfsExpected1, dfsActual1);

    }

    @Test(timeout = TIMEOUT)
    public void testSameDFS() {
        // start vertex 2
        List<Vertex<Integer>> bfsActual2 = GraphAlgorithms.dfs(new Vertex<Integer>(2), sameBFSAndDFS);
        List<Vertex<Integer>> bfsExpected2 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(2),
                new Vertex<Integer>(1), new Vertex<Integer>(3), new Vertex<Integer>(4), new Vertex<Integer>(5),
                new Vertex<Integer>(6), new Vertex<Integer>(7)));

        assertEquals(bfsExpected2, bfsActual2);

        // start vertex 5
        List<Vertex<Integer>> bfsActual5 = GraphAlgorithms.dfs(new Vertex<Integer>(5), sameBFSAndDFS);
        List<Vertex<Integer>> bfsExpected5 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(5),
                new Vertex<Integer>(3), new Vertex<Integer>(1), new Vertex<Integer>(2), new Vertex<Integer>(4),
                new Vertex<Integer>(6), new Vertex<Integer>(7)));

        assertEquals(bfsExpected5, bfsActual5);

        // start vertex 7
        List<Vertex<Integer>> bfsActual7 = GraphAlgorithms.dfs(new Vertex<Integer>(7), sameBFSAndDFS);
        List<Vertex<Integer>> bfsExpected7 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(7),
                new Vertex<Integer>(5), new Vertex<Integer>(3), new Vertex<Integer>(1), new Vertex<Integer>(2),
                new Vertex<Integer>(4), new Vertex<Integer>(6)));

        assertEquals(bfsExpected7, bfsActual7);

        // start vertex 4
        List<Vertex<Integer>> bfsActual4 = GraphAlgorithms.dfs(new Vertex<Integer>(4), sameBFSAndDFS);
        List<Vertex<Integer>> bfsExpected4 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(4),
                new Vertex<Integer>(3), new Vertex<Integer>(1), new Vertex<Integer>(2), new Vertex<Integer>(5),
                new Vertex<Integer>(6), new Vertex<Integer>(7)));

        assertEquals(bfsExpected4, bfsActual4);

    }

    @Test(timeout = TIMEOUT)
    public void testDFSTree() {
        // start vertex 7
        List<Vertex<Integer>> dfsActual7 = GraphAlgorithms.dfs(new Vertex<Integer>(7), tree);
        List<Vertex<Integer>> dfsExpected7 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(7),
                new Vertex<Integer>(6), new Vertex<Integer>(5), new Vertex<Integer>(3), new Vertex<Integer>(2),
                new Vertex<Integer>(1), new Vertex<Integer>(4)));

        assertEquals(dfsExpected7, dfsActual7);

        // start vertex 2
        List<Vertex<Integer>> dfsActual2 = GraphAlgorithms.dfs(new Vertex<Integer>(2), tree);
        List<Vertex<Integer>> dfsExpected2 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(2),
                new Vertex<Integer>(1), new Vertex<Integer>(3), new Vertex<Integer>(4), new Vertex<Integer>(5),
                new Vertex<Integer>(6), new Vertex<Integer>(7)));

        assertEquals(dfsExpected2, dfsActual2);

    }

    @Test(timeout = TIMEOUT)
    public void testDFSPetersonGraph() {
        // start vertex 10
        List<Vertex<Integer>> dfsActual10 = GraphAlgorithms.dfs(new Vertex<Integer>(10), petersonGraph);
        List<Vertex<Integer>> dfsExpected10 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(10), new Vertex<Integer>(5), new Vertex<Integer>(3),
                        new Vertex<Integer>(1), new Vertex<Integer>(2), new Vertex<Integer>(4), new Vertex<Integer>(7),
                        new Vertex<Integer>(6), new Vertex<Integer>(9), new Vertex<Integer>(8)));

        assertEquals(dfsExpected10, dfsActual10);

        // start vertex 2
        List<Vertex<Integer>> dfsActual2 = GraphAlgorithms.dfs(new Vertex<Integer>(2), petersonGraph);
        List<Vertex<Integer>> dfsExpected2 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(2), new Vertex<Integer>(1), new Vertex<Integer>(3),
                        new Vertex<Integer>(5), new Vertex<Integer>(4), new Vertex<Integer>(7), new Vertex<Integer>(6),
                        new Vertex<Integer>(10), new Vertex<Integer>(8), new Vertex<Integer>(9)));

        assertEquals(dfsExpected2, dfsActual2);

        // start vertex 6
        List<Vertex<Integer>> dfsActual6 = GraphAlgorithms.dfs(new Vertex<Integer>(6), petersonGraph);
        List<Vertex<Integer>> dfsExpected6 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(6), new Vertex<Integer>(1), new Vertex<Integer>(2),
                        new Vertex<Integer>(4), new Vertex<Integer>(5), new Vertex<Integer>(3), new Vertex<Integer>(9),
                        new Vertex<Integer>(7), new Vertex<Integer>(8), new Vertex<Integer>(10)));

        assertEquals(dfsExpected6, dfsActual6);

        // start vertex 9
        List<Vertex<Integer>> dfsActual9 = GraphAlgorithms.dfs(new Vertex<Integer>(9), petersonGraph);
        List<Vertex<Integer>> dfsExpected9 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(9), new Vertex<Integer>(3), new Vertex<Integer>(1),
                        new Vertex<Integer>(2), new Vertex<Integer>(4), new Vertex<Integer>(5), new Vertex<Integer>(10),
                        new Vertex<Integer>(6), new Vertex<Integer>(7), new Vertex<Integer>(8)));

        assertEquals(dfsExpected9, dfsActual9);
    }

    @Test(timeout = TIMEOUT)
    public void testDFSNoEdgesGraph() {
        // start vertex 5
        List<Vertex<Integer>> dfsActual5 = GraphAlgorithms.dfs(new Vertex<Integer>(5), noEdgesGraph);
        List<Vertex<Integer>> dfsExpected5 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(5)));

        assertEquals(dfsExpected5, dfsActual5);

        // start vertex 2
        List<Vertex<Integer>> dfsActual2 = GraphAlgorithms.dfs(new Vertex<Integer>(2), noEdgesGraph);
        List<Vertex<Integer>> dfsExpected2 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(2)));

        assertEquals(dfsExpected2, dfsActual2);
    }

    @Test(timeout = TIMEOUT)
    public void testDFSMultiGraph1() {
        // start vertex 1
        List<Vertex<Integer>> dfsActual1 = GraphAlgorithms.dfs(new Vertex<Integer>(1), multiGraph1);
        List<Vertex<Integer>> dfsExpected1 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(1), new Vertex<Integer>(2), new Vertex<Integer>(3)));

        assertEquals(dfsExpected1, dfsActual1);

        // start vertex 2
        List<Vertex<Integer>> dfsActual2 = GraphAlgorithms.dfs(new Vertex<Integer>(2), multiGraph1);
        List<Vertex<Integer>> dfsExpected2 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(2), new Vertex<Integer>(1), new Vertex<Integer>(3)));

        assertEquals(dfsExpected2, dfsActual2);

    }

    @Test(timeout = TIMEOUT)
    public void testDFSSelfLoopGraph() {
        // start vertex 1
        List<Vertex<Integer>> dfsActual1 = GraphAlgorithms.dfs(new Vertex<Integer>(1), selfLoopGraph);
        List<Vertex<Integer>> dfsExpected1 = new LinkedList<Vertex<Integer>>(
                Arrays.asList(new Vertex<Integer>(1), new Vertex<Integer>(3)));

        assertEquals(dfsExpected1, dfsActual1);

        // start vertex 2
        List<Vertex<Integer>> dfsActual2 = GraphAlgorithms.dfs(new Vertex<Integer>(2), selfLoopGraph);
        List<Vertex<Integer>> dfsExpected2 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(2)));

        assertEquals(dfsExpected2, dfsActual2);

        // start vertex 3
        List<Vertex<Integer>> dfsActual3 = GraphAlgorithms.dfs(new Vertex<Integer>(3), selfLoopGraph);
        List<Vertex<Integer>> dfsExpected3 = new LinkedList<Vertex<Integer>>(Arrays.asList(new Vertex<Integer>(3)));

        assertEquals(dfsExpected3, dfsActual3);
    }

    // DIJKSTRAS TESTS
    @Test(timeout = TIMEOUT)
    public void testDijkstraGraph1() {
        // start vertex a
        Map<Vertex<Character>, Integer> dijkActualA = GraphAlgorithms.dijkstras(new Vertex<Character>('a'),
                dijkstraGraph1);
        Map<Vertex<Character>, Integer> dijkExpectedA = new HashMap<>();
        dijkExpectedA.put(new Vertex<>('a'), 0);
        dijkExpectedA.put(new Vertex<>('b'), 1);
        dijkExpectedA.put(new Vertex<>('c'), 8);
        dijkExpectedA.put(new Vertex<>('d'), 2);
        dijkExpectedA.put(new Vertex<>('e'), 5);
        dijkExpectedA.put(new Vertex<>('f'), 6);
        dijkExpectedA.put(new Vertex<>('g'), 6);
        dijkExpectedA.put(new Vertex<>('h'), 3);

        assertEquals(dijkExpectedA, dijkActualA);

        // start vertex d
        Map<Vertex<Character>, Integer> dijkActualD = GraphAlgorithms.dijkstras(new Vertex<Character>('d'),
                dijkstraGraph1);
        Map<Vertex<Character>, Integer> dijkExpectedD = new HashMap<>();
        dijkExpectedD.put(new Vertex<>('a'), Integer.MAX_VALUE);
        dijkExpectedD.put(new Vertex<>('b'), Integer.MAX_VALUE);
        dijkExpectedD.put(new Vertex<>('c'), Integer.MAX_VALUE);
        dijkExpectedD.put(new Vertex<>('d'), 0);
        dijkExpectedD.put(new Vertex<>('e'), 3);
        dijkExpectedD.put(new Vertex<>('f'), 4);
        dijkExpectedD.put(new Vertex<>('g'), Integer.MAX_VALUE);
        dijkExpectedD.put(new Vertex<>('h'), Integer.MAX_VALUE);

        assertEquals(dijkExpectedD, dijkActualD);

        // start vertex g
        Map<Vertex<Character>, Integer> dijkActualG = GraphAlgorithms.dijkstras(new Vertex<Character>('g'),
                dijkstraGraph1);
        Map<Vertex<Character>, Integer> dijkExpectedG = new HashMap<>();
        dijkExpectedG.put(new Vertex<>('a'), Integer.MAX_VALUE);
        dijkExpectedG.put(new Vertex<>('b'), 2);
        dijkExpectedG.put(new Vertex<>('c'), 2);
        dijkExpectedG.put(new Vertex<>('d'), 3);
        dijkExpectedG.put(new Vertex<>('e'), 3);
        dijkExpectedG.put(new Vertex<>('f'), 7);
        dijkExpectedG.put(new Vertex<>('g'), 0);
        dijkExpectedG.put(new Vertex<>('h'), 4);

        assertEquals(dijkExpectedG, dijkActualG);

    }

    @Test(timeout = TIMEOUT)
    public void testDijkstraGraph2() {
        // start vertex J
        Map<Vertex<Character>, Integer> dijkActualJ = GraphAlgorithms.dijkstras(new Vertex<Character>('J'),
                dijkstraGraph2);
        Map<Vertex<Character>, Integer> dijkExpectedJ = new HashMap<>();
        dijkExpectedJ.put(new Vertex<>('A'), 17);
        dijkExpectedJ.put(new Vertex<>('B'), 16);
        dijkExpectedJ.put(new Vertex<>('C'), 20);
        dijkExpectedJ.put(new Vertex<>('D'), 13);
        dijkExpectedJ.put(new Vertex<>('E'), 14);
        dijkExpectedJ.put(new Vertex<>('F'), 13);
        dijkExpectedJ.put(new Vertex<>('G'), 15);
        dijkExpectedJ.put(new Vertex<>('H'), 18);
        dijkExpectedJ.put(new Vertex<>('I'), 8);
        dijkExpectedJ.put(new Vertex<>('J'), 0);
        dijkExpectedJ.put(new Vertex<>('K'), 12);
        dijkExpectedJ.put(new Vertex<>('L'), 11);
        dijkExpectedJ.put(new Vertex<>('M'), 6);
        dijkExpectedJ.put(new Vertex<>('N'), 3);
        dijkExpectedJ.put(new Vertex<>('O'), 18);
        dijkExpectedJ.put(new Vertex<>('P'), 8);
        dijkExpectedJ.put(new Vertex<>('Q'), 5);
        dijkExpectedJ.put(new Vertex<>('R'), 11);
        assertEquals(dijkExpectedJ, dijkActualJ);

        // start vertex D
        Map<Vertex<Character>, Integer> dijkActualD = GraphAlgorithms.dijkstras(new Vertex<Character>('D'),
                dijkstraGraph2);
        Map<Vertex<Character>, Integer> dijkExpectedD = new HashMap<>();
        dijkExpectedD.put(new Vertex<>('A'), 15);
        dijkExpectedD.put(new Vertex<>('B'), 14);
        dijkExpectedD.put(new Vertex<>('C'), 7);
        dijkExpectedD.put(new Vertex<>('D'), 0);
        dijkExpectedD.put(new Vertex<>('E'), 16);
        dijkExpectedD.put(new Vertex<>('F'), 10);
        dijkExpectedD.put(new Vertex<>('G'), 8);
        dijkExpectedD.put(new Vertex<>('H'), 20);
        dijkExpectedD.put(new Vertex<>('I'), 15);
        dijkExpectedD.put(new Vertex<>('J'), 13);
        dijkExpectedD.put(new Vertex<>('K'), 3);
        dijkExpectedD.put(new Vertex<>('L'), 19);
        dijkExpectedD.put(new Vertex<>('M'), 17);
        dijkExpectedD.put(new Vertex<>('N'), 10);
        dijkExpectedD.put(new Vertex<>('O'), 16);
        dijkExpectedD.put(new Vertex<>('P'), 17);
        dijkExpectedD.put(new Vertex<>('Q'), 8);
        dijkExpectedD.put(new Vertex<>('R'), 2);

        assertEquals(dijkExpectedD, dijkActualD);

        // start vertex P
        Map<Vertex<Character>, Integer> dijkActualP = GraphAlgorithms.dijkstras(new Vertex<Character>('P'),
                dijkstraGraph2);
        Map<Vertex<Character>, Integer> dijkExpectedP = new HashMap<>();
        dijkExpectedP.put(new Vertex<>('A'), 13);
        dijkExpectedP.put(new Vertex<>('B'), 12);
        dijkExpectedP.put(new Vertex<>('C'), 16);
        dijkExpectedP.put(new Vertex<>('D'), 17);
        dijkExpectedP.put(new Vertex<>('E'), 10);
        dijkExpectedP.put(new Vertex<>('F'), 9);
        dijkExpectedP.put(new Vertex<>('G'), 11);
        dijkExpectedP.put(new Vertex<>('H'), 10);
        dijkExpectedP.put(new Vertex<>('I'), 4);
        dijkExpectedP.put(new Vertex<>('J'), 8);
        dijkExpectedP.put(new Vertex<>('K'), 16);
        dijkExpectedP.put(new Vertex<>('L'), 3);
        dijkExpectedP.put(new Vertex<>('M'), 2);
        dijkExpectedP.put(new Vertex<>('N'), 11);
        dijkExpectedP.put(new Vertex<>('O'), 12);
        dijkExpectedP.put(new Vertex<>('P'), 0);
        dijkExpectedP.put(new Vertex<>('Q'), 9);
        dijkExpectedP.put(new Vertex<>('R'), 15);

        assertEquals(dijkExpectedP, dijkActualP);

    }

    @Test(timeout = TIMEOUT)
    public void testDijkstraSelfLoopAndParallelEdgesGraph1() {
        // start vertex 1
        Map<Vertex<Integer>, Integer> dijkActual1 = GraphAlgorithms.dijkstras(new Vertex<Integer>(1),
                selfLoopAndParallelEdgesGraph1);
        Map<Vertex<Integer>, Integer> dijkExpected1 = new HashMap<>();
        dijkExpected1.put(new Vertex<>(1), 0);
        dijkExpected1.put(new Vertex<>(2), 5);
        dijkExpected1.put(new Vertex<>(3), 6);
        dijkExpected1.put(new Vertex<>(4), 1);

        assertEquals(dijkExpected1, dijkActual1);

        // start vertex 2
        Map<Vertex<Integer>, Integer> dijkActual2 = GraphAlgorithms.dijkstras(new Vertex<Integer>(2),
                selfLoopAndParallelEdgesGraph1);
        Map<Vertex<Integer>, Integer> dijkExpected2 = new HashMap<>();
        dijkExpected2.put(new Vertex<>(1), 5);
        dijkExpected2.put(new Vertex<>(2), 0);
        dijkExpected2.put(new Vertex<>(3), 1);
        dijkExpected2.put(new Vertex<>(4), 6);

        assertEquals(dijkExpected2, dijkActual2);

        // start vertex 3
        Map<Vertex<Integer>, Integer> dijkActual3 = GraphAlgorithms.dijkstras(new Vertex<Integer>(3),
                selfLoopAndParallelEdgesGraph1);
        Map<Vertex<Integer>, Integer> dijkExpected3 = new HashMap<>();
        dijkExpected3.put(new Vertex<>(1), 6);
        dijkExpected3.put(new Vertex<>(2), 1);
        dijkExpected3.put(new Vertex<>(3), 0);
        dijkExpected3.put(new Vertex<>(4), 7);

        assertEquals(dijkExpected3, dijkActual3);

        // start vertex 4
        Map<Vertex<Integer>, Integer> dijkActual4 = GraphAlgorithms.dijkstras(new Vertex<Integer>(4),
                selfLoopAndParallelEdgesGraph1);
        Map<Vertex<Integer>, Integer> dijkExpected4 = new HashMap<>();
        dijkExpected4.put(new Vertex<>(1), 1);
        dijkExpected4.put(new Vertex<>(2), 6);
        dijkExpected4.put(new Vertex<>(3), 7);
        dijkExpected4.put(new Vertex<>(4), 0);

        assertEquals(dijkExpected4, dijkActual4);

    }

    @Test(timeout = TIMEOUT)
    public void testDijkstraOneNode() {
        // start vertex 1
        Map<Vertex<Integer>, Integer> dijkActual1 = GraphAlgorithms.dijkstras(new Vertex<Integer>(1), oneNodeGraph);
        Map<Vertex<Integer>, Integer> dijkExpected1 = new HashMap<>();
        dijkExpected1.put(new Vertex<>(1), 0);

        assertEquals(dijkExpected1, dijkActual1);

    }

    // PRIMS TESTS

    @Test(timeout = TIMEOUT)
    public void testPrimsGraph1() {
        // start vertex a
        Set<Edge<Character>> mstActualA = GraphAlgorithms.prims(new Vertex<>('a'), primsGraph1);
        Set<Edge<Character>> edgesA = new HashSet<>();
        edgesA.add(new Edge<>(new Vertex<>('a'), new Vertex<>('c'), 8));
        edgesA.add(new Edge<>(new Vertex<>('c'), new Vertex<>('a'), 8));
        edgesA.add(new Edge<>(new Vertex<>('a'), new Vertex<>('f'), 5));
        edgesA.add(new Edge<>(new Vertex<>('f'), new Vertex<>('a'), 5));
        edgesA.add(new Edge<>(new Vertex<>('b'), new Vertex<>('d'), 8));
        edgesA.add(new Edge<>(new Vertex<>('d'), new Vertex<>('b'), 8));
        edgesA.add(new Edge<>(new Vertex<>('h'), new Vertex<>('b'), 12));
        edgesA.add(new Edge<>(new Vertex<>('b'), new Vertex<>('h'), 12));
        edgesA.add(new Edge<>(new Vertex<>('c'), new Vertex<>('g'), 12));
        edgesA.add(new Edge<>(new Vertex<>('g'), new Vertex<>('c'), 12));
        edgesA.add(new Edge<>(new Vertex<>('f'), new Vertex<>('i'), 8));
        edgesA.add(new Edge<>(new Vertex<>('i'), new Vertex<>('f'), 8));
        edgesA.add(new Edge<>(new Vertex<>('c'), new Vertex<>('l'), 8));
        edgesA.add(new Edge<>(new Vertex<>('l'), new Vertex<>('c'), 8));
        edgesA.add(new Edge<>(new Vertex<>('l'), new Vertex<>('h'), 14));
        edgesA.add(new Edge<>(new Vertex<>('h'), new Vertex<>('l'), 14));
        edgesA.add(new Edge<>(new Vertex<>('h'), new Vertex<>('e'), 8));
        edgesA.add(new Edge<>(new Vertex<>('e'), new Vertex<>('h'), 8));
        edgesA.add(new Edge<>(new Vertex<>('g'), new Vertex<>('j'), 5));
        edgesA.add(new Edge<>(new Vertex<>('j'), new Vertex<>('g'), 5));
        edgesA.add(new Edge<>(new Vertex<>('j'), new Vertex<>('k'), 5));
        edgesA.add(new Edge<>(new Vertex<>('k'), new Vertex<>('j'), 5));

        assertEquals(edgesA, mstActualA);

    }

    @Test(timeout = TIMEOUT)
    public void testPrimsGraph2() {
        // start vertex E
        Set<Edge<Character>> mstActualE = GraphAlgorithms.prims(new Vertex<>('E'), primsGraph2);
        Set<Edge<Character>> edgesE = new HashSet<>();
        edgesE.add(new Edge<>(new Vertex<>('D'), new Vertex<>('F'), 2));
        edgesE.add(new Edge<>(new Vertex<>('F'), new Vertex<>('D'), 2));
        edgesE.add(new Edge<>(new Vertex<>('A'), new Vertex<>('C'), 3));
        edgesE.add(new Edge<>(new Vertex<>('C'), new Vertex<>('A'), 3));
        edgesE.add(new Edge<>(new Vertex<>('E'), new Vertex<>('A'), 7));
        edgesE.add(new Edge<>(new Vertex<>('A'), new Vertex<>('E'), 7));
        edgesE.add(new Edge<>(new Vertex<>('C'), new Vertex<>('D'), 3));
        edgesE.add(new Edge<>(new Vertex<>('D'), new Vertex<>('C'), 3));
        edgesE.add(new Edge<>(new Vertex<>('D'), new Vertex<>('B'), 2));
        edgesE.add(new Edge<>(new Vertex<>('B'), new Vertex<>('D'), 2));

        assertEquals(edgesE, mstActualE);
    }

    @Test(timeout = TIMEOUT)
    public void testPrimsNoEdgesGraph() {
        // start vertex 1
        Set<Edge<Integer>> mstActual1 = GraphAlgorithms.prims(new Vertex<>(1), noEdgesGraph);
        Set<Edge<Character>> edgesA = new HashSet<>();

        assertNull(mstActual1);

    }

    @Test(timeout = TIMEOUT)
    public void testDisconnectedPrimsGraph() {
        // start vertex a
        Set<Edge<Character>> mstActualA = GraphAlgorithms.prims(new Vertex<>('A'), disconnectedPrimsGraph1);
        Set<Edge<Character>> edgesA = new HashSet<>();

        assertNull(mstActualA);

    }

    // ALL EXCEPTIONS TESTING

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testBFSExceptionNullStart() {
        List<Vertex<Integer>> bfsActual = GraphAlgorithms.bfs(null, directedGraph1);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testBFSExceptionNullGraph() {
        List<Vertex<Integer>> bfsActual = GraphAlgorithms.bfs(new Vertex<Integer>(5), null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testBFSExceptionStartNotInVertexSet() {
        List<Vertex<Integer>> bfsActual = GraphAlgorithms.bfs(new Vertex<Integer>(20), directedGraph1);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testDFSExceptionNullStart() {
        List<Vertex<Integer>> dfsActual = GraphAlgorithms.dfs(null, directedGraph1);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testDFSExceptionNullGraph() {
        List<Vertex<Integer>> dfsActual = GraphAlgorithms.dfs(new Vertex<Integer>(5), null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testDFSExceptionStartNotInVertexSet() {
        List<Vertex<Integer>> dfsActual = GraphAlgorithms.dfs(new Vertex<Integer>(20), directedGraph1);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testDijkstrasExceptionNullStart() {
        Map<Vertex<Character>, Integer> dijkActual = GraphAlgorithms.dijkstras(null, dijkstraGraph1);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testDijkstrasExceptionNullGraph() {
        Map<Vertex<Character>, Integer> dijkActual = GraphAlgorithms.dijkstras(new Vertex<Character>('g'), null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testDijkstraExceptionStartNotInVertexSet() {
        Map<Vertex<Character>, Integer> dijkActual = GraphAlgorithms.dijkstras(new Vertex<Character>('k'),
                dijkstraGraph1);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testPrimsExceptionNullStart() {
        Set<Edge<Character>> primsActual = GraphAlgorithms.prims(null, primsGraph1);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testPrimsExceptionNullGraph() {
        Set<Edge<Character>> primsActual = GraphAlgorithms.prims(new Vertex<Character>('a'), null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testPrimsExceptionStartNotInVertexSet() {
        Set<Edge<Character>> primsActual = GraphAlgorithms.prims(new Vertex<Character>('o'), primsGraph1);
    }

}