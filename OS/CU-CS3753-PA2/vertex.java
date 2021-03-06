import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

//implementing Vertex class
//This class is complete. You don't have to do anything!! just read it and understand it.
class Vertex implements Comparable<Vertex>
{
	//vertex name
    public final String name;    
    //minimum distance set to infinity 
    public double minDistance = Double.POSITIVE_INFINITY;
    
    public Vertex previous;
    public Edge[] adjacencies;
    
    //setting the vertex name
    public Vertex(String vertexName) {
    	name = vertexName;
    }
    
    public String toString() { return name; }
    
    //compare the minimum distance with the distance for other vertex
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
}

//Implementing Edge Class
//This class is complete. You don't have to do anything!! just read it and understand it.
class Edge
{
	//creating vertices (called destination as our example will work with destinations as cities)
    public final Vertex destination;
    
    // weight: distance between two vertices
    // example: Boulder to Golden: 15 miles
    public final double weight;
    
    /*setting the distance (weight) from the previous vertex to the next vertex
       Example: Edge(v, 10) means the size of edge (weight) between the current vertex (whatever it is)
       to vertex v is 10
    */
    public Edge(Vertex destinationParam, double weightParam){
    	destination = destinationParam; 
    	weight = weightParam;
    }
}

//implementing Dijkstra Algorithm
// You need to complete this class
public class Dijkstra
{
    //computePaths function
	public static void computePaths(Vertex source)
    {
		// 1. set source minimum Distance to 0.0
		// 2. Create a PriorityQueue for a set of vertices
		// 3. add the source to your PriorityQueue
       

      	//4. while your PriorityQueue is not empty do the followings:
      	//4a. remove vertex u from your PriorityQueue
      	//4b. Visit each edge exiting u. That is check all the adjacencies of u using a for loop
		
    }
	// Create a static function called getShortestPathTo 
	// return: List<Vertex>
	// input: Vertex destination
    public static List<Vertex> getShortestPathTo(Vertex destination)
    {
    	//5. Create a list of vertices and call it path     	
		new List<Vertex> path;
        
        //5a. for each vertex add the vertex to the path
        
        
        //5b. use Collections in Java to reverse the path (for correct display) 
        
        //5c. return the path instead of null
       return path;
    }
     
    // your implementation above must make the following main work correctly
    //You don't have to do anything here!! Just read and understand it to make your algorith work
    public static void main(String[] args)
    {
    	//set v0 to Boulder
        Vertex v0 = new Vertex("Boulder");
        //set v1 to Golden
		Vertex v1 = new Vertex("Golden");
		//set v2 to Longmont
		Vertex v2 = new Vertex("Longmont");
		//set v3 to Superior
		Vertex v3 = new Vertex("Superior");
		//set v4 to Denver
		Vertex v4 = new Vertex("Denver");
	
		//setting the Edges around Boulder (v0)
		// Boulder(v0) to Longmont(v1) = 15 miles
		// Boulder(v0) to Golden(v2) = 20 miles
		// Boulder(v0) to Superior(v3) = 8 miles
		v0.adjacencies = new Edge[]{ new Edge(v1, 15), new Edge(v2, 20), new Edge(v3, 8) };
		
		//setting the Edges around Longmont (v1)
		// Longmont(v1) to Boulder(v0) = 15 miles
		v1.adjacencies = new Edge[]{ new Edge(v0, 15)};
		
		//setting the Edges around Golden (v2)
		// Golden(v2) to Boulder(v0) = 20 miles
		// Golden(v2) to Superior(v3) = 16 miles
		// Golden(v2) to Superior(v4) = 15 miles
		v2.adjacencies = new Edge[]{ new Edge(v0, 20), new Edge(v3, 16), new Edge(v4, 15) };
		
		//setting the Edges around Superior (v2)
		// Superior(v3) to Boulder(v0) = 8 miles
		// Superior(v3) to Golden(v2) = 16 miles
		// Superior(v3) to Denver(v4) = 22 miles
		v3.adjacencies = new Edge[]{ new Edge(v0, 8), new Edge(v2, 16), new Edge(v4, 22) };
		
		// setting the Edges around Denver (v4)
		// Denver (v4) to Superior (v3) = 22 miles
		// Denver (v4) to Golden (v2) = 22 miles
		v4.adjacencies = new Edge[]{ new Edge(v3, 22), new Edge(v2, 15) };
		
		//place all vertices in an array called vertices.
		Vertex[] vertices = { v0, v1, v2, v3, v4 };
		
		//Starting from Boulder find the shortest to Boulder, Longmont, Golden, Superior and Denver 
		System.out.println("Starting from " + v0 + ": ");
	    computePaths(v0);
	    
	    //print all the shortest paths to difference cities
	    for (Vertex v : vertices)
		{
		    System.out.println("Distance to " + v + ": " + v.minDistance);
		    List<Vertex> path = getShortestPathTo(v);
		    System.out.println("Path is: " + path);
		}
    }
}
