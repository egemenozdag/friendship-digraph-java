import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;

//-----------------------------------------------------
//Title: FriendshipGraph Analyzer
//Author: Egemen OZDAG
//ID: 47755722122
//Section: 1
//Assignment: 1
//Description: This class is analyzer of the friendshipGraph class.
//-----------------------------------------------------
public class FriendshipAnalyzer {
	private int E;
    private final int V;
    private FriendshipGraph[][] adj;
    private boolean[] marked;
	private int[] id;
    private int[] edgeTo;
    private int[] distTo;
    private int count;
    
	public FriendshipAnalyzer(FriendshipGraph graph){
		//---------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
		// Summary: This method is introducing the FriendshipGraph class to FrienshipAnalyzer class.
		// Precondition: graph is the graph.
		//----------------------------------------------------------------------------------------------------------------------------------------------------------------------
		V = graph.V();
		E = graph.E();
		adj = graph.adj();
	}
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
	// Summary: This method is finding the average number of friends.
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public double avgNumOfFr(){return ((double)this.E / (2 * (double)adj.length));}
	
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
	// Summary: This method is finding the connected components.
	// Precondition: marked is looking is the verticles(V) marked, and id is like serial number of V, count is taking total connection number per verticles.
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public int connectedComp(){
		marked = new boolean[V];
		id = new int[V];
		for (int v = 0; v < V; v++){
			if (!marked[v]){
				depthFirstSearch(G, v); 
				count++; 
			}
		} 
		return 1;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
	// Summary: This method is finding the distance.
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public int findDist(String kul1, String kul2){return Integer.MAX_VALUE;}
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
	// Summary: This method is depth first search method, G is the graph and s is the verticles.
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private void depthFirstSearch(FriendshipGraph G, String v){
		marked[V] = true;
		id[V] = count;
		for (int w : G.adj())if (!marked[w])depthFirstSearch(G, w);
	} 

	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
	// Summary: This method is breath first search method, G is the graph and s is the verticles.
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private void breadthFirstSearch(Graph G, int s){
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(s);
		marked[s] = true;
		distTo[s] = 0;

		while (!q.isEmpty()) { int v = q.dequeue();
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					q.enqueue(w);
					marked[w] = true;
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
				}
			}
		}
	}
	
	
	
}
