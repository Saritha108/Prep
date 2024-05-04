package com.July;

class Node
{
	int data;
	Node next;
	Node(int d) {data = d;
				next = null;}
}
	
class Main
{
    Node head;
    public void addToTheLast(Node node)
    {
    	if (head == null)
    	{
    		head = node;
    	}
    	else
    	{
    		Node temp = head;
    		while (temp.next != null)
    			temp = temp.next;
    		temp.next = node;
    	}
    }
    void printList()
    {
    	Node temp = head;
    	while (temp != null)
    	{
    		System.out.println(temp.data);
    		temp = temp.next;
    	}
    	
    }
    public static void main(String args[])
    {
    	Main list1 = new Main();
    	Main list2 = new Main();
    	
    	list1.addToTheLast(new Node(1));
    	list1.addToTheLast(new Node(2));
    	list1.addToTheLast(new Node(4));
    	list1.addToTheLast(new Node(6));
    	list1.addToTheLast(new Node(9));
    	
    	
        
    	list2.addToTheLast(new Node(3));
    	list2.addToTheLast(new Node(4));
    	list2.addToTheLast(new Node(7));
    	list2.addToTheLast(new Node(8));
    	
    	
    	list1.head = new Mergesortedlists().MergeSortedLists(list1.head, list2.head);
    	list1.printList();	
    	
    }
}


class Mergesortedlists 
{
    public Node MergeSortedLists(Node list1, Node list2) 
    {
      
        if(list1 == null) return list2;
        if(list2 == null) return list1;
          
        if(list1.data < list2.data) 
        {
        	
        	list1.next = MergeSortedLists(list1.next, list2);
        	System.out.println("list1.data"+list1.data +"  "+ "list2.data" +list2.data);
            return list1;
        }
        else 
        {
            list2.next = MergeSortedLists(list1, list2.next);
			System.out.println("list1.data"+list1.data +"  "+ "list2.data" +list2.data);

            return list2;
        }
          
    }
}  

//https://www.scaler.com/topics/merge-two-sorted-linked-lists/
