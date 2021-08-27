//Java Progarm to add two linklists
/*=== Node.js, Vue.js===
1. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.*/
public class LinkedList

{
	class node
	{
		int val;
		node next;

		public node(int val)
		{
			this.val = val;
		}
	}
	
	// Function to print linked list
	void printlinkedlist(node head)
	{
		while (head != null)
		{
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	node head1, head2, result;
	int carry;

	// Function to add array to linked list
	void addtolist(int val, int list)
	{
		node newnode = new node(val);
		if (list == 1)
		{
			newnode.next = head1;
			head1 = newnode;
		}
		else if (list == 2)
		{
			newnode.next = head2;
			head2 = newnode;
		}
		else
		{
			newnode.next = result;
			result = newnode;
		}

	}
	// Function to add two same size linked list 
	
	void addsamesize(node n, node m)
	{
		// check any list's head pointer
		if (n == null)
			return;

		// Recursively add remaining nodes and get the carry
		addsamesize(n.next, m.next);

		// add digits of current nodes and propagated carry
		int sum = n.val + m.val + carry;
		carry = sum / 10;
		sum = sum % 10;

		// add to result list
		addtolist(sum, 3);

	}

	node current;

	// This function is called after the smaller list is
	// added to the bigger lists's sublist of same size.
	// Once the right sublist is added, the carry must be
	// added to the left side of larger list to get the
	// final result.
	void propogatecarry(node head1)
	{
		// If diff. number of nodes are not traversed, add carry
		if (head1 != current)
		{
			propogatecarry(head1.next);
			int sum = carry + head1.val;
			carry = sum / 10;
			sum %= 10;

			// add this node to the front of the result
			addtolist(sum, 3);
		}
	}

	int getsize(node head)
	{
		int count = 0;
		while (head != null)
		{
			count++;
			head = head.next;
		}
		return count;
	}
	
	// The main function that adds two linked lists
	// represented by head1 and head2. The sum of two
	// lists is stored in a list referred by result
	void additionlinklist()
	{
		int size1 = getsize(head1);
		int size2 = getsize(head2);

		// Add same size lists
		if (size1 == size2)
		{
			addsamesize(head1, head2);
		}
		else
		{
			// Swap head pointers if list 2 is bigger than list 1
			if (size1 < size2)
			{
				node temp = head1;
				head1 = head2;
				head2 = temp;
			}
			int diff = Math.abs(size1 - size2);

			// move diff. number of nodes in first list
			node temp = head1;
			while (diff-- >= 0)
			{
				current = temp;
				temp = temp.next;
			}

			// get addition of same size lists
			addsamesize(current, head2);

			// get addition of remaining first list and carry
			propogatecarry(head1);
		}
			// if some carry is still there, add a new node to
			// the front of the result list. e.g. 999 and 87
			if (carry > 0)
			addtolist(carry, 3);
		
	}

	//Main function

    public static void main(String args[])
	{
		LinkedList linklist = new LinkedList();
		linklist.head1 = null;
        linklist.head2 = null;
        linklist.result = null;
		linklist.carry = 0;
		int a1[] = { 2, 4, 3 };
		int a2[] = { 5, 6, 4 };
		int l1, l2;
		l1= a1.length;
		l2= a2.length;
		// First link list
		for (int i = 0; i <= l1 - 1; i++)
		linklist.addtolist(a1[i], 1);

		// Second link list
		for (int i = 0; i <= l2 - 1; i++)
        linklist.addtolist(a2[i], 2);
       

		linklist.additionlinklist();
        System.out.print("\n Input List 1 : ");
        linklist.printlinkedlist(linklist.head1);
        System.out.print("\n Input List 2 : ");
        linklist.printlinkedlist(linklist.head2);
        System.out.print("\n Result : ");
		linklist.printlinkedlist(linklist.result);
    }
    
    
}
