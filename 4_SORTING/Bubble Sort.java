//User function Template for Java
class Solution
{
    //Function to sort the array using bubble sort algorithm.
	public static void bubbleSort(int arr[], int n){
        
        int m = arr.length;
 
        for( int i = 0; i < m  ; i++){
            for( int j = 0; j < m-1-i ; j++){
                if(arr[j] > arr[j+1]){
                    //swap the elements of the arrray :
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                     arr[j+1] = temp;
                }
            }
        }
    }
}
