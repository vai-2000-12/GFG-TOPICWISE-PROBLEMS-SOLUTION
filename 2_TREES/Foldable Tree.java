class Tree
{
    //Function to check whether a binary tree is foldable or not.
    boolean IsFoldable(Node node) 
	{ 
	   
	   if(node == null){
	       return true;
	   }
	   
	   return isMirror(node.left , node.right);
	   
	} 
	
	public boolean isMirror(Node lroot , Node Rroot){
	      
	     if(lroot == null && Rroot == null){
	          return true;
	     } 
	     
	    if(lroot == null  || Rroot == null){
	         return false;
	    }
	     
	  return isMirror(lroot.left , Rroot.right) && isMirror(lroot.right, Rroot.left);
	}
}