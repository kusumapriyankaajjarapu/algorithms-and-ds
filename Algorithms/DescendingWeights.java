import java.util.*;

public class DescendingWeights {
    
    //method for performing bucketsort
    public static void bucketSort(int[] arr,int k){
        
        ArrayList<Integer> bucket[] = new ArrayList[k];
        for(int i = 0;i < k;i ++)
        {
            bucket[i] = new ArrayList<Integer>();   //An arrayList is created to hold all the elements within a bucket
        }
        for(int i = 0;i < arr.length;i ++)
        {
            int weight = arr[i] % k;
            bucket[weight].add(arr[i]);     //placing the elements in the buckets that correspond to their weight
        }
        for(int i = k-1;i >= 0;i --)
        {
            Collections.sort(bucket[i]);    //sorting the elements within a bucket
            for(int j = 0;j < bucket[i].size();j ++)
            {
                System.out.print(bucket[i].get(j)+" ");     //printing the elements in descending order
            }
        }
    }
    
    public static void main(String[] args) {
	
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=scan.nextInt();
        }
        bucketSort(arr,k);
        scan.close();
    }
}
