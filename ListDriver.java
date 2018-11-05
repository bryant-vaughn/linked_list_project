import java.util.Scanner;
/**
 * This is the driver class for the three list classes. It will interact with a user
 * to allow them to choose which list type they want to work with and what they want
 * to do with it. It contains the main method and is a two layer menu for the user.
 *
 * @author Bryant Vaughn
 * @version 10/2017
 */
public class ListDriver
{
    //Declaration of the three list types
    private static List typeOne;
    private static DoublyLinked typeTwo;
    private static SinglyLinkedCircular typeThree;
    
    //main method to run the program
    public static void main(String[] args)
    {
        //Scanner for input
        Scanner keyboard = new Scanner(System.in);
        
        //Initialization of the three list type objects
        typeOne = new List();
        typeTwo = new DoublyLinked();
        typeThree = new SinglyLinkedCircular();
        
        boolean notDone = true;
        
        //This is the menu for the list program
        do
        {
            System.out.println("Types of lists:");
            System.out.println(" 1) Singly-linked, no tail reference, non-circular, Integers");
            System.out.println(" 2) Doubly-linked, tail reference, non-circular, Doubles");
            System.out.println(" 3) Singly-linked, no tail reference, circular, Strings");
            System.out.println(" 4) Exit the program");
            System.out.println();
            
            System.out.print("Which list would you like to use?: ");
            int menu = keyboard.nextInt();
            keyboard.nextLine();
            System.out.println();
            
            //These are the menus for each type of list
            switch(menu)
            {
                case 1:
                    boolean typeOneNotDone = true;
                    do
                    {
                        System.out.println("-Type 1 operations-");
                        System.out.println("================================");
                        System.out.println(" 1) Build a list");
                        System.out.println(" 2) Clear the list");
                        System.out.println(" 3) Check if the list is sorted");
                        System.out.println(" 4) Insert at head");
                        System.out.println(" 5) Insert at tail");
                        System.out.println(" 6) Insert in order if the list is sorted");
                        System.out.println(" 7) Delete an element by value");
                        System.out.println(" 8) Go back to main menu");
                        System.out.println();
                        typeOne.printList();
                        System.out.println();
                    
                        System.out.println("What would you like to do?: ");
                        int typeOneMenu = keyboard.nextInt();
                        keyboard.nextLine();
                        System.out.println();
                        
                        //Switch case for type 1 operations
                        switch(typeOneMenu)
                        {
                            case 1:
                                System.out.print("Enter your list of numbers " + 
                                                 "(single space between each): ");
                                String inputIntegers = keyboard.nextLine();
                                String[] intNumbers = inputIntegers.split(" ");
                                
                                for(int i = 0; i < intNumbers.length; i++)
                                {
                                        Integer intItem = Integer.parseInt(intNumbers[i]);
                                        typeOne.buildAList(intItem);
                                }
                                
                                System.out.println();
                                break;
                            case 2:
                                typeOne.deleteWholeList();
                                break;
                            case 3:
                                boolean isSorted = typeOne.checkSorting();
                                
                                if(isSorted)
                                {
                                    System.out.println("The list is sorted!");
                                }
                                else
                                {
                                    System.out.println("The list is not sorted.");
                                }

                                System.out.println();
                                break;
                            case 4:
                                System.out.print("What value would you like to insert at the front?: ");
                                Integer headValue = keyboard.nextInt();
                                keyboard.nextLine();
                                typeOne.insertAtHead(headValue);

                                System.out.println();
                                break;
                            case 5:
                                System.out.print("What value would you like to insert at the end?: ");
                                Integer tailValue = keyboard.nextInt();
                                keyboard.nextLine();
                                typeOne.insertAtTail(tailValue);
                                
                                System.out.println();
                                break;
                            case 6:
                                boolean sorted = typeOne.checkSorting();
                                
                                if(sorted)
                                {
                                    System.out.print("The list is sorted! What would you like to insert?: ");
                                    Integer sortedValue = keyboard.nextInt();
                                    keyboard.nextLine();
                                    typeOne.insertInOrder(sortedValue);
                                }
                                else
                                {
                                    System.out.println("The list is not sorted. Nothing was inserted.");
                                }
                                
                                System.out.println();
                                break;
                            case 7:
                                System.out.print("What value would you like to delete?: ");
                                Integer deleteValue = keyboard.nextInt();
                                keyboard.nextLine();
                                typeOne.deleteByValue(deleteValue);
                                
                                System.out.println();
                                break;
                            case 8:
                                typeOneNotDone = false;
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    } while(typeOneNotDone);
                    break;
                case 2:
                    boolean typeTwoNotDone = true;
                    do
                    {
                        System.out.println("-Type 2 operations-");
                        System.out.println("================================");
                        System.out.println(" 1) Build a list");
                        System.out.println(" 2) Clear the list");
                        System.out.println(" 3) Check if the list is sorted");
                        System.out.println(" 4) Insert by position");
                        System.out.println(" 5) Insert in order if the list is sorted");
                        System.out.println(" 6) Delete from head");
                        System.out.println(" 7) Delete from tail");
                        System.out.println(" 8) Print the list in reverse");
                        System.out.println(" 9) Go back to main menu");
                        System.out.println();
                        typeTwo.printList();
                        System.out.println();
                    
                        System.out.println("What would you like to do?: ");
                        int typeTwoMenu = keyboard.nextInt();
                        keyboard.nextLine();
                        System.out.println();
                        
                        //Switch case for type 2 operations
                        switch(typeTwoMenu)
                        {
                            case 1:
                                System.out.print("Enter your list of numbers (single space between each): ");
                                String inputDoubles = keyboard.nextLine();
                                String[] doubleNumbers = inputDoubles.split(" ");
                                
                                for(int i = 0; i < doubleNumbers.length; i++)
                                {
                                    Double doubleItem = Double.parseDouble(doubleNumbers[i]);
                                    typeTwo.buildAList(doubleItem);
                                }
                                
                                System.out.println();
                                break;
                            case 2:
                                typeTwo.deleteWholeList();
                                break;
                            case 3:
                                boolean isSorted = typeTwo.checkSorting();
                                
                                if(isSorted)
                                {
                                    System.out.println("The list is sorted!");
                                }
                                else
                                {
                                    System.out.println("The list is not sorted.");
                                }
                                
                                System.out.println();
                                break;
                            case 4:
                                System.out.print("In what position do you want to insert?: ");
                                int position = keyboard.nextInt();
                                keyboard.nextLine();
                                System.out.println();
                                
                                System.out.print("What value do you want to insert?: ");
                                Double doubleInput = keyboard.nextDouble();
                                keyboard.nextLine();
                                typeTwo.insertByPosition(position, doubleInput);
                                
                                System.out.println();
                                break;
                            case 5:
                                boolean sorted = typeTwo.checkSorting();
                                
                                if(sorted)
                                {
                                    System.out.print("The list is sorted! What would you like to insert?: ");
                                    Double sortedInsert = keyboard.nextDouble();
                                    keyboard.nextLine();
                                    typeTwo.insertInOrder(sortedInsert);
                                    System.out.println();
                                }
                                else
                                {
                                    System.out.println("The list is not sorted. Nothing was inserted.");
                                    System.out.println();
                                }
                                
                                break;
                            case 6:
                                typeTwo.deleteHeadNode();
                                
                                System.out.println();
                                break;
                            case 7:
                                typeTwo.deleteTailNode();
                                
                                System.out.println();
                                break;
                            case 8:
                                System.out.println();
                                typeTwo.printInReverse();
                                System.out.println();
                                break;
                            case 9:
                                typeTwoNotDone = false;
                                break;
                        }
                    } while(typeTwoNotDone);
                    break;
                case 3:
                    boolean typeThreeNotDone = true;
                    do
                    {
                        System.out.println("-Type 3 operations-");
                        System.out.println("================================");
                        System.out.println(" 1) Build a list");
                        System.out.println(" 2) Clear the list");
                        System.out.println(" 3) Check if the list is sorted");
                        System.out.println(" 4) Insert at head");
                        System.out.println(" 5) Insert at tail");
                        System.out.println(" 6) Print all strings smaller than input");
                        System.out.println(" 7) Print the longest and shortest string(s)");
                        System.out.println(" 8) Go back to main menu");
                        System.out.println();
                        typeThree.printList();
                        System.out.println();
                    
                        System.out.println("What would you like to do?: ");
                        int typeThreeMenu = keyboard.nextInt();
                        keyboard.nextLine();
                        System.out.println();
                        
                        //Switch case for type 3 operations
                        switch(typeThreeMenu)
                        {
                            case 1:
                                System.out.print("Enter you list of strings (single space between each): ");
                                String inputString = keyboard.nextLine();
                                String[] stringWords = inputString.split(" ");
                                
                                for(int i = 0; i < stringWords.length; i++)
                                {
                                    typeThree.buildAList(stringWords[i]);
                                }
                                
                                System.out.println();
                                break;
                            case 2:
                                typeThree.deleteWholeList();
                                break;
                            case 3:
                                boolean isSorted = typeThree.checkSorting();
                                
                                if(isSorted)
                                {
                                    System.out.println("The list is sorted!");
                                }
                                else
                                {
                                    System.out.println("The list is not sorted.");
                                }
                                
                                System.out.println();
                                break;
                            case 4:
                                System.out.print("What string would you like to insert at the front?: ");
                                String headInput = keyboard.nextLine();
                                typeThree.insertAtHead(headInput);
                                
                                System.out.println();
                                break;
                            case 5:
                                System.out.print("What string would you like to insert at the end?: ");
                                String tailInput = keyboard.nextLine();
                                typeThree.insertAtTail(tailInput);
                                
                                System.out.println();
                                break;
                            case 6:
                                System.out.print("What's the max number of characters you want to print?: ");
                                int charMax = keyboard.nextInt();
                                keyboard.nextLine();
                                System.out.println();
                                typeThree.printSmallerStrings(charMax);
                                
                                System.out.println();
                                break;
                            case 7:
                                typeThree.printShortestAndLongest();
                                
                                System.out.println();
                                break;
                            case 8:
                                typeThreeNotDone = false;
                                break;
                        }
                    } while(typeThreeNotDone);
                    break;
                case 4:
                    notDone = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while(notDone);
    }
}