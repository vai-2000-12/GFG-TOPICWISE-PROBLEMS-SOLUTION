

//User function Template for Java

class Solution
{
    public static Long findMaxScore(Node root)
    {
        
      //Step 1:- Boundary  Condition to check whether root is null or not..
      
      if(root == null){
          return (long)1;
      }
      
      // Step 2:- recusively call for its left and right subtree and multiply
      // with root value for both left and right.. 
    
      Long leftS = root.data*findMaxScore(root.left);
      Long rightS = root.data*findMaxScore(root.right);
     
     
     // step 3 :- find the Maximmum value from Both the Nodes..
      return Math.max(leftS ,rightS);
    }
}