import java.util.*;

import FriendshipGraph.ListIterator;
import edu.princeton.cs.algs4.*;

//-----------------------------------------------------
// Title: Friendship Graph
// Author: Egemen OZDAG
// ID: 47755722122
// Section: 1
// Assignment: 1
// Description: This class is implementing friendshipGraph.
//-----------------------------------------------------

public class FriendshipGraph<Item> implements Iterable
{
	private int V;
	private int E;
	private static FriendshipGraph[][] adj;
	
	public static String[] oku(In read) {
		//-------------------------------------------------------- 
		// Summary: This method is taking file and reading it.
		// Precondition: read is the name of txt file and its given in FriendshipAnalyzerDemo class.
		//--------------------------------------------------------
		ArrayList<String> satir = new ArrayList<String>();
		//In read =new In("Macintosh HD⁩ ▸ ⁨Kullanıcılar⁩ ▸ ⁨egemenozdag⁩ ▸ ⁨Masaüstü⁩ ▸ tiny.txt");
		while(read.hasNextLine()) {satir.add(read.readLine());}
		return satir.toArray(new String[satir.size()]);
	}
	public FriendshipGraph(In in){
		//-------------------------------------------------------- 
		// Summary: This method making graph from the file but not working.
		//--------------------------------------------------------
		this.V = in.readInt();
		if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
		this.E = in.readInt();
		if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
		
		for (int v = 0; v < V; v++) {adj[v] = new Bag<Integer>();}
		
		load(in);
	}
	public void addFr(String kul1, String kul2){
		//-------------------------------------------------------- 
		// Summary: This method is adding new friends.
		// Precondition: kul1&kul2 are the name and surname of adding user(kullanici) and this user is coming from FriendshipAnalyzerDemo class.
		//--------------------------------------------------------
		String str1, str2;
		int in1 = 0, in2 = 0;
		for(int i = 0; i < this.V; i++){
			if(in1 != 0 && in2 != 0)	break;
			if(adj[i].equals(kul1)){str1 = kul1;in1 = i;}
			else if(adj[i].equals(kul2)){str2 = kul2;in2 = i;}
		}
		adj[in1].add(kul2);
		adj[in2].add(kul1);
	}
	public void load(In in){
		//-------------------------------------------------------- 
		// Summary: This method is loading the friends to the graph.
		// Precondition: in is the graph, arr is loading all the line in the txt file.
		//--------------------------------------------------------
		for (int i = 0; i < this.E; i++){
			String read = in.readString();
			String arr[] = read.split(",");
			addFr(arr[0], arr[1]);
		}
	}
	public boolean deleteFr(String kul1, String kul2){
		//-------------------------------------------------------- 
		// Summary: This method is deleting friend from the graph..
		// Precondition: kul1&kul2 are the name and surname of adding user(kullanici) and this user is coming from FriendshipAnalyzerDemo class.
		//--------------------------------------------------------
		
		String str1, str2;
		int in1 = 0, in2 = 0;
		for(int i = 0; i < this.V; i++){
			if(in1 != 0 && in2 != 0)	break;
			if(adj[i].equals(kul1)){str1 = kul1; in1 = i;}
			else if(adj[i].equals(kul2)){str2 = kul2;in2 = i;}
		}
		adj[in1].remove(kul2);
		adj[in2].remove(kul1);
		return true;
	}

	public Iterator findFriends(String user) {return (Iterator) new ListIterator(user); }
	
	private class ListIterator implements Iterable {
		int init = 0;
        public ListIterator(String node) {
        	int count = 0;
        	FriendshipGraph[] gg;
        	while(count < adj.length)
			{
        		gg = adj[count];
				if(gg.getItem() == node)
				{
					init = count;
					break;
				}
				count++;
			}
       }
	
	public int V() {
		// TODO Auto-generated method stub
		return V;
	}
	public int E() {
		// TODO Auto-generated method stub
		return E;
	}
	public FriendshipGraph[][] adj() {
		// TODO Auto-generated method stub
		return adj;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
