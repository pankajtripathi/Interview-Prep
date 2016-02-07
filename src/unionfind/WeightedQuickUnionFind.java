package unionfind;
import java.util.Scanner;

/**
 * Created by pankajtripathi on 2/1/16.
 */
public class WeightedQuickUnionFind {

	private int size[];
	private int parent[];
	private int count;

	/*
	 * @param the number of sites
	 * */
	public WeightedQuickUnionFind(int N) {
		count=N;
		parent=new int[count];
		size=new int[count];
		for (int i = 0; i < count; i++) {
			parent[i]=i;
			size[i]=1;
		}
	}

	/*
	 * @param a integer representing a site
	 * purpose: return the root of the given site
	 * */
	public int root(int a){
		while(a != parent[a]){
			parent[a]=parent[parent[a]];
			a = parent[a];
		}
		return a;
	}

	/*
	 * @param p and q integer representing two sites
	 * purpose: returns true is two sites are connected
	 * */
	public boolean connected(int p,int q){
		return root(p) == root(q);
	}

	/*
	 * @param p integer representing one site
	 * @param q integer representing other site
	 * purpose: it establishes union between two sites
	 * */
	public void union(int p, int q){
		int rootP=root(p);
		int rootQ=root(q);
		if(rootP==rootQ) return;
		if(size[rootP] < size[rootQ]){
			parent[rootP] =rootQ;
			size[rootQ] += size[rootP];
		}
		else{
			parent[rootQ] =rootP;
			size[rootP] += size[rootQ];
		}
	}

	/*
	 * displays the contents of parent array
	 * */
	public void display(){
		for (int i = 0; i < parent.length; i++) {
			System.out.print(parent[i]+" ");
		}
	}

	/*
	 * Reads the number of connections user is going to provide
	 * The format for the connections between two points is
	 * p-q example 4-3
	 * Makes the connections as stated by the user and then displays the final array
	 * */
	public static void main(String[] args) {
		String points[], paths[];
		int P,Q;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number of sites");
		int N = scanner.nextInt();
		WeightedQuickUnionFind wuf=new WeightedQuickUnionFind(N);
		System.out.println("Enter the number of connections you want to make");
		int num=scanner.nextInt();
		paths=new String[num];
		System.out.println("Enter connection in format p-q, that is p will be connected to q");
		for (int i = 0; i < num; i++) {
			paths[i]=scanner.next();
			points = paths[i].split("-");
			P=Integer.parseInt(points[0]);
			Q=Integer.parseInt(points[1]);
			if(!wuf.connected(P,Q)){
				wuf.union(P,Q);
				System.out.print(P+" "+Q+"--->");
				wuf.display();
				System.out.println();
			}
		}
		System.out.println("Final parent array after the connections:");
		wuf.display();
	}
}
