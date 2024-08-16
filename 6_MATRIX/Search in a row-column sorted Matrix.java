class Solution 
{ 
    //Function to search a given number in row-column sorted matrix.
	static boolean search(int matrix[][], int n, int m, int x) 
	{  
	    for( int i = 0 ; i < n ; i++){
	        for(int j = 0 ; j < m ; j++){
	            if(matrix[i][j] == x){
	                return true;
	            }
	        }     
	    } 
	    return false;
	} 
} 
