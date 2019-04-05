import java.util.*;

public class MiddleElement {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList l = new LinkedList();
        int size = scan.nextInt();
        int s = size;
        while(size-- > 0)
        {
            l.enqueue(scan.nextInt());
        }
        int middle_element = l.findElementByPosition(s / 2 + 1);
        System.out.println(middle_element);
    }
    
    static class LinkedList{
        
        static class Node{
            
            int data;
            Node next;
            Node(int d){
                data = d;
            }
        }
        
        Node head;
        void enqueue(int x){
            Node n = new Node(x);
            if(head == null)
            {
                head = n;
                head.next = null;
            }
            else
            {   Node curr = head;
                while(curr.next!=null)
                    curr = curr.next;
                curr.next = n;
            }
        }
        
        int findElementByPosition(int p){
            if(p == 1)
                return head.data;
            else
            {   
                int count = 2;
                Node curr = head.next;
                while(curr.next != null)
                {   
                    if(p == count)
                        return curr.data;
                    else
                    {
                        curr = curr.next;
                        count++;
                    }
                }
                System.out.println("Enter correct position");
                return -1;
            }
        }
    }
}
