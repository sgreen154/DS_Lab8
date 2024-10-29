public class Queue<T>
{
	public class Node
	{

	
		public T val;
		public Node next;
		public Node(T val, Node next)
		{
			this.val = val;
			this.next = next;
		}
	}
Node head;
Node back;
//be sure that your attributes are protected, so subclasses can use them


  public Queue()
  {
  this.head = null;
  this.back = null;
  }


   /**Adds val to the end of the queue
    */
  public void push(T val)
  {
  if(this.head == null)
  {
  this.head = new Node(val, null);
  this.back = this.head;
  }
  else
  {
  this.back.next = new Node(val, null);
  this.back = this.back.next;
  }
  }


   /**
      removes and returns the oldest value in the queue
      throws QueueUnderFlowException if the queue is empty
    */
  public T pop()
  {
      if(head == null)
      {
      throw new QueueUnderFlowException();
      }
      if(head.next == null)
      {
      T temp = this.head.val;
      this.head = null;
      this.back = null;
      return temp;
      }
      else
      {
      T temp = this.head.val;
      this.head = this.head.next;
      return temp;
      }
  }    


   /**
     returns true if the queue is empty
    */

  public boolean isEmpty()
  {
      if(head == null)
      {
      return true;
      }
      else
      {
      return false;
      }
  }




}
