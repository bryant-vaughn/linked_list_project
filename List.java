
/**
 * This is a singly-linked, non-circular list with no tail reference of Integers. This 
 * class will build a list for a user of however many elements they want and allow them 
 * the ability to add nodes at the head, at the tail, or in order if the list is sorted. 
 * It will also allow the user to delete nodes by value or the whole list.
 *
 * @author Bryant Vaughn
 * @version 10/2017
 */
public class List
{
    private Node head;
    
    //This is the constructor for the list class
    public List()
    {
        head = null;
    }
    
    //This method will allow the user to build a list of any size they choose
    public void buildAList(Integer num)
    {
        if(head == null)
        {
            Node tempFirst = new Node(num);
        
            head = tempFirst;
        }
        else
        {
            Node current = head;
            
            while(current.next != null)
            {
                current = current.next;
            }
            
            Node temp = new Node(num);
            
            current.next = temp;
            current = temp;
        }
    }
    
    //This method will delete a node based on a value entered by user
    public void deleteByValue(Integer value)
    {
        Node current = head;
        boolean nodeDeleted = false;
        
        if(head == null)
        {
            System.out.println("The list is empty. There are no values to delete.");
        }
        else if(head.data == value)
        {
            head = head.next;
        }
        else
        {
            while(current.next != null && !nodeDeleted)
            {
                if(current.next.data == value && current.next != null)
                {
                    current.next = current.next.next;
                    nodeDeleted = true;
                }
                if(!nodeDeleted)
                {
                    current = current.next;
                }
            }
        }
        
        if(nodeDeleted == true)
        {
            System.out.println("The value was deleted successfully!");
        }
        else
        {
            System.out.println("The value was not deleted because it wasn't found.");
        }
    }
    
    //This method will delete the entire list
    public void deleteWholeList()
    {
        head = null;
    }
    
    //This method will insert a node at the head of the list
    public void insertAtHead(Integer num)
    {
        Node temp = new Node(num);
        temp.next = head;
        head = temp;
    }
    
    //This method will insert a node at the end of the list
    public void insertAtTail(Integer num)
    {
        Node temp = new Node(num);
        
        Node current = head;
        if(head == null)
        {
            head = temp;
            temp.next = null;
        }
        else
        {
            while(current.next != null)
            {
                current = current.next;
            }
        }
        
        current.next = temp;
    }
    
    //This method will insert an element in order if the list is sorted
    public void insertInOrder(Integer num)
    {
        boolean sort = checkSorting();
        Node temp = new Node(num);
        
        if(head == null)
        {
            head = temp;
        }
        else if(sort)
        {
            Node current = head;
            
            if(current.data >= num)
            {
                temp.next = head;
                head = temp;
            }
            
            while(current.next != null)
            {
                if(current.data <= num && current.next.data >= num)
                {
                    temp.next = current.next;
                    current.next = temp;
                    break;
                }
                
                current = current.next;
            }
            
            if(num > current.data)
            {
                current.next = temp;
            }
        }
    }
    
    //This method will print out the list to the user
    public void printList()
    {
        String str = "head > ";
        if(head == null)
        {
            str += "null";
        }
        else
        {
            Node current = head;
            while(current.next != null)
            {
                str += current.data + " > ";
                current = current.next;
            }
            
            str += current.data + " (singly-linked)";
        }
        
        System.out.println(str);
    }
    
    //This method will check if the list is sorted
    public boolean checkSorting()
    {
        Node current = head;
        
        if(head == null)
        {
            return true;
        }
        else
        {
            while(current.next != null)
            {
                if(current.data > current.next.data)
                {
                    return false;
                }
                
                current = current.next;
            }
        
            return true;
        }
    }
    private class Node
    {
        private Integer data;
        private Node next;
        
        public Node(Integer data)
        {
            this.data = data;
            next = null;
        }
    }
}