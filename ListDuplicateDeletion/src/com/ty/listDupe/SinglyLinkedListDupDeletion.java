package com.ty.listDupe;

public class SinglyLinkedListDupDeletion {
	class Node
	{
		int data;
		Node next;
	
	public Node(int data)
	{
		this.data=data;
		this.next=null;
	}
	}
	public Node head;
	public Node tail;
	
	
	
	public void addNode(int data)
	{
		Node newnode= new Node(data);
		if(head==null)
		{
			head=newnode;
			tail=newnode;
		}
		else
		{
			tail.next=newnode;
			tail=newnode;
		}
	}
	
	public void deleteNode(int key){
		Node temp=head;
		Node prev=null;
		if(temp == null){
            System.out.println("Can't delete Linked List empty");
            return;
        }
		 if(temp.data==key)
	        {
	            head = temp.next; 
	            System.out.println("Deleted: " + key);
	            return;
	        }
		 while (temp != null && temp.data != key)
	        {
	            prev = temp;
	            temp = temp.next;
	        }
		 if(temp==null)
	        {
	            System.out.println("Value not found");
	            return;
	        }
		 prev.next = temp.next;
	     System.out.println("Deleted: " + key);
		
	}
	
	public void Display()
	{
		Node current;
		current=head;
		if(head==null)
		{
			System.out.println("empty list");
		}
		else
		{
			while(current!=null)
			{
				System.out.print(current.data+" ");
				current=current.next;
			}
		}
	}
	
    
    public void removeDuplicates() 
    {
        Node current = head; 
        Node index = null;
        Node temp = null;

        if(head == null) 
        {
            return;
        } 
        else 
        {
            while(current != null) 
            {
                temp = current;
                index = current.next;

                while(index != null) 
                {
                    if(current.data == index.data) 
                    {
                        temp.next = index.next;
                    } 
                    else 
                    {
                        temp = index;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }
	
	
	public static void main(String[] args) {
		SinglyLinkedListDupDeletion nlist=new SinglyLinkedListDupDeletion();
		nlist.addNode(1);
		nlist.addNode(1);
		nlist.addNode(2);
		nlist.addNode(2);
		nlist.addNode(1);
		nlist.addNode(1);
		nlist.addNode(1);
		nlist.addNode(1);
		nlist.deleteNode(1);
		
		System.out.println("before deleting duplicates");
		nlist.Display();
		
		nlist.removeDuplicates();
		System.out.println("\n"+"after deleting duplicates");
		nlist.Display();
	}
	
	

}
