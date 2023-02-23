//HeapRunner.java
//ben schwartz
//yes
import java.util.Scanner;
public class HeapRunner
{
	public static void main(String[] args)
	{
		int pip = 0;

		
		
		MaxPriorityQueue piper = null;
		Scanner reader = new Scanner(System.in);
		//KeyboardReader reader = new KeyboardReader();
		int choice = -1;
		System.out.println("WELCOME TO MY HEAP RUNNER ASSIGNMENT! SELECT FROM THE FOLLOWING...");
		while(choice != 0)
		{
			System.out.print("\n 1. create a new queue"
								   +"\n 2.  add a value"
								   +"\n 3.  delete a value"
								   +"\n 4.  check if empty"
								   +"\n 5.  peek max"
								   +"\n 6.  print"
								   +"\n 7.  check if full"
								   +"\n 8.  get count"
								   + "\n9.  count down tactic" 
								   +"\n 0.	 Exit \n"

								   +"\nWhat is your selection?   ");
			choice = reader.nextInt();

		
		if(choice == 1)
		{
			System.out.println("Enter the size of your queue : ");
			int size = reader.nextInt();
			pip = size;
			piper = new HeapPriorityQueue(size);
			System.out.println("A heap was made with size "+size+"\n");
		}
		else if(choice == 2)
		{
			System.out.println("do you want to enter a String(0) or a number(1) : ");
			int p = reader.nextInt();
			if(p == 0)
			{
				System.out.println("Enter a String to add : ");
				String s = reader.next();
				if(piper.add(s))
					System.out.println(s+" was successfully added");
				else
					System.out.println(s+" was NOT successfully added");
			}
			else if(p == 1)
			{
				System.out.print("Enter a number to add : ");
				int s = reader.nextInt();
				if(piper.add(s))
					System.out.println(s+" was successfully added");
				else
					System.out.println(s+" was NOT successfully added");
			}
			else
				System.out.println("ERROR");
		}
		else if(choice == 3)
		{
			Comparable pip1 = piper.removeMax();
			if(pip1 != null)
				System.out.println(pip1+" was deleted.");
			else
				System.out.println("deletion failed.");
		}
		else if(choice == 4)
			System.out.println("EMPTY = "+piper.isEmpty());
		else if(choice == 5)
			System.out.println("MAX = "+piper.peekMax());
		else if(choice == 6)
			System.out.println(piper);
		else if(choice == 7)
			System.out.println("IS FULL = "+piper.isFull());
		else if(choice == 8)
			System.out.println("COUNT = "+piper.getCount());
		else if(choice == 9)
		{
			piper = new HeapPriorityQueue(pip);
			for(int i = 1; i <= pip; i++)
				piper.add(new Integer(i));
			while(!piper.isEmpty())
				System.out.print(piper.removeMax()+", ");
		}
		else
			break;
		}
	}
}