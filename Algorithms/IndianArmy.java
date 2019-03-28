import java.util.*;

public class IndianArmy {
    
    //create a class to define a checkpoint
    static class CheckPoint {
    	long x; //position on x-axis
    	long p; //number of armed men assigned
    	long left;
    	long right;
    	public CheckPoint(long x, long p) {
    		this.x = x;
    		this.p = p;
    	}
    	
    	public long getLeft() {
    		return x-p;
    	}
    	
    	public long getRight() {
    		return x+p;
    	}
    }
    
    static CheckPoint c;
    
    //to calculate the total distance from start to end,that is not protected by the armed forces.
    static long totalDistance(PriorityQueue<CheckPoint> pq,long start,long end){
        long res = 0;
        while(!pq.isEmpty() && start < end) {
        	c = pq.poll();
        	long left = c.getLeft();
        	long right = c.getRight();
        	if(start < left) {
        		left = ((left > end) ? end : left); 
        		res = res + left - start;   //calculate the distance from start to beginning of the checkpoint
        	}
        	if(start < right)   
        		start = right;  //move on to the next checkpoint
        }
        if(start < end) //if all checkpoints are covered but didn't reach the end
        	res = res + end - start;
        return res;
    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();   //number of checkpoints
        long start = scan.nextLong();
        long end = scan.nextLong();
        
        //checkpoints are stored in a priority queue in ascending order
        PriorityQueue<CheckPoint> pq = new PriorityQueue<CheckPoint>((int) n, checkComparator); 
        for(int i=0;i<n;i++)
        {
        	long x = scan.nextLong();   //position on x-axis
        	long p = scan.nextLong();   //number of armed men assigned
        	c = new CheckPoint(x,p);
        	pq.add(c);
        }
        long distance = totalDistance(pq,start,end);
        System.out.println(distance);
    }
    
    public static Comparator<CheckPoint> checkComparator = new Comparator<CheckPoint>() {
    	public int compare(CheckPoint c1, CheckPoint c2) {
    		if(c1.getLeft() < c2.getLeft())
    			return -1;
    		else
    			return 1;
    	}
    };
}
