import java.util.*;

// Back-end Complete function Template for JAVA

class Solution
{
    //Function to check if cell indexes are within bounds.
    boolean isValid(int x, int y, int N){
		return (x >=0 && x < N && y >=0 && y < N);
	}
	
	//Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        KnightPos[0]--;
		KnightPos[1]--;
		TargetPos[0]--;
		TargetPos[1]--;
		
        int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
        
        //using boolean list to mark visited cells and currently 
        //marking all the cells as false.
		boolean vis[][] = new boolean[N][N];
		
		//queue for storing visited cells by knight in board and steps taken.
		Queue<ArrayList<Integer>> q = new LinkedList<>(); 
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(KnightPos[0]);
		temp.add(KnightPos[1]);
		temp.add(0);
		
		//pushing starting position of knight with 0 distance.
		q.add(temp);
		//marking starting cell as visited.
		vis[KnightPos[0]][KnightPos[1]] = true;
		
		while(!q.isEmpty())
		{
		    //storing cell indexes and steps of front element and popping them.
		    ArrayList<Integer> temp2 = q.poll();
			int x = temp2.get(0);
			int y = temp2.get(1);
			int steps = temp2.get(2);
			
			//if we reach the required cell, we return true.
			if(x == TargetPos[0] && y == TargetPos[1])
				return steps;
			
			//using loop to reach all the cells that can be reached by knight.
			for(int i=0; i<8; i++)
			{
				int n_x = x + dx[i];
				int n_y = y + dy[i];
				
				//if cell indexes are valid and cell is not visited, we push  
				//the indexes in queue with steps and mark cell as visited.
				if(isValid(n_x, n_y, N) && !vis[n_x][n_y])
				{
				    ArrayList<Integer> temp1 = new ArrayList<>();
            		temp1.add(n_x);
            		temp1.add(n_y);
            		temp1.add(steps+1);
					q.add(temp1);
					vis[n_x][n_y] = true;
				}
			}
		}
		return -1;
    }
}