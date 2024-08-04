class Solution
{
  static void insert(int arr[],int i)
  {
       int m = arr.length;
     
     for( int k = 1 ; k < m ;k++){
        int j = k;
        while(j> 0 && arr[j] < arr[j-1]){
          // swap the arr[j] with arr[j-1];
          int temp = arr[j];
          arr[j] = arr[j-1];
          arr[j-1] = temp;
          j--;
        }
     }
  }
  //Function to sort the array using insertion sort algorithm.
  public void insertionSort(int arr[], int n)
  {
      int m = arr.length;
     for( int i =1 ; i < m ; i++){
         insert(arr, m);
     }
  }
}