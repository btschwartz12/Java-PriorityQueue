//HeapPriorityQueue.java
//ben schwartz
//yes

public class HeapPriorityQueue implements MaxPriorityQueue
{
	private Comparable[] piper;
	private int count;
	private int maxSize;
	
	public HeapPriorityQueue(int max)
	{
		piper = new Comparable[max+1];
		count = 0;
		maxSize = max;
	}
	public boolean add(Comparable val)
	{
		if(count == maxSize)
			return false;
		else if(count == 0)
		{
			piper[1] = val;
			count++;
			return true;
		}
		else
		{
			count++;
			piper[count] = val;
			addHelper(count);
			return true;
		}
	}
	private void addHelper(int index)
	{
		if(index == 1)
			return;
		if(piper[index].compareTo(piper[index/2]) <= 0)
			return;
		int newIndex = index/2;
		Comparable temp = piper[index];
		piper[index] = piper[newIndex];
		piper[newIndex] = temp;
		addHelper(newIndex);
	}
	public Comparable removeMax()
	{
		if(isEmpty())
		{
			System.out.println("ERROR: CANNOT REMOVE FROM EMPTY HEAP");
			return null;
		}
		Comparable temp = piper[1];
		piper[1] = piper[count];
		piper[count] = null;
		count--;
		removeHelper(1);
		return temp;
	}
	private void removeHelper(int index)
	{//look at kids and go to whichever one is greater
		Comparable kid1 = null;
		Comparable kid2 = null;
		if(index*2 <= count)
			kid1 = piper[index*2];
		if(index*2+1 <= count)
			kid2 = piper[index*2+1];
		if(kid1 == null && kid2 == null)
			return;
		if(index == 1 && kid2 == null)
		{
			if(piper[1].compareTo(piper[2]) >= 0)
				return;
			
				Comparable temp = piper[1];
				piper[1] = kid1;
				piper[2] = temp;
				return;
		}
		else if(kid2 == null)
		{
			if(piper[index].compareTo(piper[index*2]) >= 0)
				return;
		}
		else if(kid1.compareTo(piper[index]) <= 0 && kid2.compareTo(piper[index]) <= 0) 
			return;
		else 
		{
			if(kid1.compareTo(kid2) >= 0)
			{
				Comparable temp = piper[index];
				piper[index] = kid1;
				piper[index*2] = temp;
				removeHelper(index*2);
			}
			else
			{
				Comparable temp = piper[index];
				piper[index] = kid2;
				piper[index*2+1] = temp;
				removeHelper(index*2+1);
			}	
		}
	}
	public boolean isEmpty()
	{
		return count == 0;
	}
	public Comparable peekMax()
	{
		return count == 0 ? null : piper[1];
	}
	public String toString()
	{
		if(isEmpty())
			return "EMPTY";
		String toReturn = "";
		for(int i = 1; i <= count; i++)
			toReturn += piper[i]+", ";
		return "["+toReturn.substring(0, toReturn.length()-2)+"]";
	}
	public int getCount()
	{
		return count;
	}
	public boolean isFull()
	{
		return maxSize == count;
	}
}
