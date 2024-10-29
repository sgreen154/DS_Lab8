import java.util.Comparator;

public class PriorityQueue<T> extends Queue<T>
{

   Comparator<T> compare;

   public PriorityQueue(Comparator<T> comp)
   {
      compare = comp;
   }


    //@Override
   public void push(T val)
   {
	   if(head == null)
	   {
		   head = new Node(val, null);
	   }
	   else if(compare.compare(val, head.val) > 0)
	   {
		   Node temp = new Node(val, head);
		   head = temp;
	   }
	   else
	   {
		   push(val, head, head.next);
	   }
   }
	   
   private void push(T val, Node former, Node next)
   {
	   if(next == null || compare.compare(val, next.val) > 0)
	   {
		   Node temp = new Node(val, next);
		   former.next = temp;
	   }
	   else
	   {
		   push(val, next, next.next);
	   }
   }
}
