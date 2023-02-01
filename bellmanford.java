public class bellmanford{
public static int max_val= 999;
public static int nv;
int distance[];
	bellmanford(int nv){
		this.nv = nv;
		distance = new int[nv+1];
	}
	public void bellman(int source,int adj[][]){
		for(int node=1;i<=nv;i++){
			distance[node] = max_val;
		}
		distance[source] = 0;
		for(int node=1;node<=n-1;node++){
			for(int sn=1;sn<=nv;sn++){
				for(int dn = 1;dn<=nv;dn++){
					if(adj[sn][dn]!=max_val)
						if(distance[dn]>distance[sn]+adj[sn][dn])
							distance[dn] = distance[sn]+adj[sn][dn];
				}
			}
		}
		for(int sn=1;sn<=nv;sn++){
				for(int dn = 1;dn<=nv;dn++){
					if(adj[sn][dn] != max_val)
						if(distance[dn]>distance[sn]+adj[sn][dn])
							System.out.println("contains negative edge cycle");
				}
		}
	for(int vertex=0;vertex<=nv;vertex++){
		System.out.println("distance from source:"+source+" to the vertex is"+distance[vertex]);
	}
		
}
	
	public static void main(){
		int source;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of vertices");
		nv = sc.nextInt();
		int adj[][] = new int[nv+1][nv+1];
		System.out.println("Enter the adjacency matrix");
		for(int sn=1;sn<=nv;sn++){
			for(int dn=1;dn<=nv;dn++){
				adj[sn][dn] = sc.nextInt();
				if(sn == dn){
					adj[sn][dn] = 0;
				}else{
					adj[sn][dn] = max_val;
				}
			}
		}
		System.out.println("Enter the source vertex");
		source = sc.nextInt();
		bellmanford f = new bellmanford(nv);
		f.bellman(source,adj);
	}
}
