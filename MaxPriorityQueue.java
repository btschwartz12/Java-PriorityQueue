public interface MaxPriorityQueue
{
	boolean isEmpty();
	boolean add(Comparable x);
	Comparable removeMax();
	Comparable peekMax();
	
	String toString( );		
	boolean isFull( );
	int getCount();
 
}
