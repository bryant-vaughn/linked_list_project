
/**
 * This is a singly-linked, circularly- linked list class of Strings. It will allow the user 
 * to build a list of any size, add new nodes to the beginning as long as the data doesn't 
 * already exist, and also enter a node at the end of the list. It can also print all strings 
 * that are shorter than a length of user input, and print the shortest and longest string(s) 
 * in the list. Finally, it also includes methods to print out the list and delete the entire 
 * list.
 *
 * @author Bryant Vaughn
 * @version 10/2017
 */
public class SinglyLinkedCircular
{
    private Node head;
    
    //This is the constructor for the singly-linked circular class
    public SinglyLinkedCircular()
    {
        head = null;
    }
    
    //This method will build a list of any size
    public void buildAList(String s)
    {
        if(head == null)
        {
            Node tempFirst = new Node(s);
        
            head = tempFirst;
            tempFirst.next = head;
        }
        else
        {
            Node current = head;
            
            while(current.next != head)
            {
                current = current.next;
            }
            
            Node temp = new Node(s);
            
            current.next = temp;
            current = temp;
            temp.next = head;
        }
    }
    
    //This method will print the list for the user
    public void printList()
    {
        String str = "head > ";
        
        if(head == null)
        {
            str += "null";
        }
        else if(head.next == head)
        {
            str += head.data + " (singly-linked, circular)";
        }
        else
        {
            Node current = head;
            
            //While loop to create the string of all nodes besides the last one
            while(current.next != head)
            {
                str += current.data + " > ";
                
                current = current.next;
            }
            
            str += current.data + " (singly-linked, circular)";
        }
        
        System.out.println(str);
    }
    
    //This method will check if the list is sorted
    public boolean checkSorting()
    {
        if(head == null)
        {
            return true;
        }
        else
        {
            Node current = head;
            
            while(current.next != head)
            {
                if(current.data.compareTo(current.next.data) > 0)
                {
                    return false;
                }
                
                current = current.next;
            }
        }
        
        return true;
    }
    
    //This method will delete the entire list
    public void deleteWholeList()
    {
        head = null;
    }
    
    //This method will add a node to the end of the list
    public void insertAtTail(String s)
    {
        Node temp = new Node(s);
        
        if(head == null)
        {
            head = temp;
            temp.next = head;
        }
        else
        {
            Node current = head;
            
            while(current.next != head)
            {
                current = current.next;
            }
            
            current.next = temp;
            temp.next = head;
        }
    }
    
    //This method will print all strings smaller than user size choice
    public void printSmallerStrings(int length)
    {
        int stringLength = 0;
        String str = "";
        
        if(head == null)
        {
            System.out.println("The list is empty. There is nothing to print.");
        }
        else
        {
            Node current = head;
            
            while(current.next != head)
            {
                stringLength = current.data.length();
                
                if(stringLength < length)
                {
                    str += current.data + ", ";
                }
                
                current = current.next;
            }
            
            stringLength = current.data.length();
            
            if(stringLength < length)
            {
                str += current.data;
            }
        }
        
        if(str == null)
        {
            System.out.println("There were no strings shorter than " + length + 
                               " characters.");
        }
        else
        {
            str += " <- these are all strings shorter than " + length + " characters.";
            
            System.out.println(str);
        }
    }
    
    //This method will find and print the shortest and longest strings in the list
    public void printShortestAndLongest()
    {
        int shortest;
        String shortList = null;
        
        int longest;
        String longList = null;
        
        if(head == null)
        {
            System.out.println("The list is empty. There is nothing to print.");
        }
        else
        {
            Node current = head;
            
            shortest = current.data.length();
            shortList = current.data + " ";
            
            longest = current.data.length();
            longList = current.data + " ";
            
            current = current.next;
            
            while(current != head)
            {
                if(current.data.length() < shortest)
                {
                    shortList = current.data + " ";
                    shortest = current.data.length();
                }
                else if(current.data.length() == shortest)
                {
                    shortList += current.data + " ";
                }
                else if(current.data.length() > longest)
                {
                    longList = current.data + " ";
                    longest = current.data.length();
                }
                else if(current.data.length() == longest)
                {
                    longList += current.data + " ";
                }
                
                current = current.next;
            }
            
            System.out.println("The shortest string(s) in the list: " + shortList);
            
            System.out.println("The longest string(s) in the list: " + longList);
        }
    }
    
    //This method will insert at the head if the String is not already in the list
    public void insertAtHead(String s)
    {
        Node temp = new Node(s);
        boolean isDuplicate = false;
        
        if(head == null)
        {
            head = temp;
            temp.next = head;
        }
        else
        {
            Node current = head;
            
            while(current.next != head && isDuplicate == false)
            {
                if(current.data.equals(s))
                {
                    isDuplicate = true;
                }
                current = current.next;
            }
            
            if(isDuplicate == false)
            {
                temp.next = head;
                current.next = temp;
                head = temp;
            }
        }
    }
    
    private class Node
    {
        private String data;
        private Node next;
        
        public Node(String data)
        {
            this.data = data;
            next = null;
        }
    }
}