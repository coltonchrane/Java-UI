public class BinarySearchTree
{
   
	private Node root; 
	public BinarySearchTree() 
	{
		root = null;
	} 
	public void add(Comparable obj)

	{
	   Node newNode = new Node();
	   newNode.data = obj;
	   newNode.left = null;
	   newNode.right = null;
	   if (root == null) { root = newNode; }
	   else { root.addNode(newNode); }
	}
	private class Node 
	{
		public Comparable data; 
		public Node left; 
		public Node right; 
		public void addNode(Node newNode)
		   {
		      int comp = newNode.data.compareTo(data);
		      if (comp < 0)
		      {
		         if (left == null) { left = newNode; }
		         else { left.addNode(newNode); }
		      }
		      else if (comp > 0)
		      {
		         if (right == null) { right = newNode; }
		         else { right.addNode(newNode); }
		      }
		   }
   
}
}