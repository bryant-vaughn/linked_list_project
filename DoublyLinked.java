
/**
 * This is a doubly-linked, tail referenced list class of Doubles. This class will build a 
 * list of any size, add nodes based on position and add nodes in order if the list is 
 * sorted. It will also delete nodes from the head, tail or even clear the entire list. 
 * This class will also check to see if a list is sorted in ascending order. Finally, 
 * it can print a list forward and in reverse without changing the data structure.
 *
 * @author Bryant Vaughn
 * @version 10/2017
 */
public class DoublyLinked
{
    private Node head;
    private Node tail;

    //This is the constructor for the doubly-linked class
    public DoublyLinked()
    {
        head = null;
        tail = null;
    }

    //This method will allow the user to build a list of whatever size they choose
    public void buildAList(Double num)
    {
        if(head == null)
        {
            Node tempFirst = new Node(num);
        
            head = tempFirst;
            tail = tempFirst;
        }
        else
        {
            Node current = head;
            
            while(current.next != null)
            {
                current = current.next;
            }
            
            Node temp = new Node(num);
            
            temp.previous = current;
            current.next = temp;
            current = temp;
            tail = current;
        }
    }

    //This method will print the list to the screen for the user
    public void printList()
    {
        String str = "head > ";

        if(head == null)
        {
            str += "null < tail";
        }
        else
        {
            Node current = head;

            while(current.next != null)
            {
                str += current.data + " > ";
                current = current.next;
            }

            str += current.data + " < tail (doubly-linked)";
        }
        
        System.out.println(str);
    }

    //This method will report if the list is sorted
    public boolean checkSorting()
    {
        if(head == null)
        {
            return true;
        }
        else
        {
            Node current = head;

            while(current.next != null)
            {
                if(current.data > current.next.data)
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

    //This method will insert a node based on the position a user chooses
    public void insertByPosition(int pos, Double num)
    {
        Node temp = new Node(num);

        if(head == null)
        {
            head = temp;
            tail = temp;
        }
        else if(pos == 1)
        {
            temp.next = head;
            head.previous = temp;
            head = temp;
        }
        else
        {
            Node currentTrail = head;
            Node currentLead;

            for(int i = 1; i < pos; i++)
            {
                if(i == (pos - 1) && currentTrail.next != null)
                {
                    currentLead = currentTrail.next;
                    temp.next = currentLead;
                    currentTrail.next = temp;
                    temp.previous = currentTrail;
                    currentLead.previous = temp;
                }
                else if(i == (pos - 1) && currentTrail.next == null)
                {
                    currentTrail.next = temp;
                    temp.previous = currentTrail;
                    tail = temp;
                }

                currentTrail = currentTrail.next;
            }
        }
    }

    //This method will insert a node in order if the list is sorted
    public void insertInOrder(Double num)
    {
        boolean sorted = checkSorting();

        Node temp = new Node(num);

        if(head == null)
        {
            head = temp;
            tail = temp;
        }
        else if(sorted)
        {
            Node current = head;

            if(current.data >= num)
            {
                temp.next = head;
                head.previous = temp;
                head = temp;
            }

            while(current.next != null)
            {
                if(current.data <= num && current.next.data >= num)
                {
                    temp.next = current.next;
                    temp.previous = current;
                    current.next.previous = temp;
                    current.next = temp;
                    break;
                }

                current = current.next;
            }
            
            if(num > current.data)
            {
                current.next = temp;
                temp.previous = current;
                tail = temp;
            }
        }
    }

    //This method will delete the head node from the list
    public void deleteHeadNode()
    {
        head = head.next;
        head.previous = null;
    }

    //This method will delete the tail node from the list
    public void deleteTailNode()
    {
            Node current = head;
            while(current.next != tail)
            {
                current = current.next;
            }

            current.next = null;
            tail.previous = null;
            tail = current;
    }

    //This method will print the linked list in reverse
    public void printInReverse()
    {
        String str = "tail > ";

        if(head == null)
        {
            str += "null < head";
        }
        else
        {
            Node current = tail;

            while(current.previous != null)
            {
                str += current.data + " > ";

                current = current.previous;
            }

            str += current.data + " < head (doubly-linked)";
        }
        
        System.out.println(str);
    }

    private class Node
    {
        private Double data;
        private Node next, previous;

        public Node(Double data)
        {
            this.data = data;
            next = null;
            previous = null;
        }
    }
}