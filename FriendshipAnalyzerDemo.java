import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

//-----------------------------------------------------
// Title: Level tester class
//Author: Egemen OZDAG
//ID: 47755722122
//Section: 1
//Assignment: 1
//Description: This class is testing the other two classes.
//-----------------------------------------------------
public class FriendshipAnalyzerDemo {
	public static void main(String[] args) {
		double res;
		In inputFile = new In("tiny.txt");
		FriendshipGraph.oku(inputFile);
		StdOut.println("Loading.. ");
		FriendshipGraph.addFr("ali", "veli");
		FriendshipGraph.deleteFr("a","aahed");
		FriendshipGraph graph = new FriendshipGraph(inputFile);
		FriendshipAnalyzer analyze = new FriendshipAnalyzer(graph);
		res = analyze.avgNumOfFr();
		StdOut.println(res);
	}
}
