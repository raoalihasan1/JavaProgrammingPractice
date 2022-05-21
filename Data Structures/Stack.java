import java.util.*;

public class Stack
{

    private ArrayList<String> myStack = new ArrayList<>();

    public ArrayList getStack()
    {
        return myStack;
    }

    public void Push(String s)
    {
        myStack.add(s);
    }

    public String Pop()
    {
        return myStack.remove(myStack.size()-1);
    }

    public String Peek()
    {
        return myStack.get(myStack.size()-1);
    }

    public int Search(String s)
    {
        int x = 0;
        for (int i = myStack.size()-1; i >= 0; i--)
        {
            if (myStack.get(i).equals(s))
            {
                break;
            }
            x++;
        }
        if(x == myStack.size())
        {
            return -1;
        }
        return x;
    }

    public static void main(String[] args)
    {
        Stack myStack = new Stack();
        myStack.Push("Bread");
        myStack.Push("Milk");
        myStack.Push("Biscuit");
        myStack.Push("Chicken");
        myStack.Push("Chocolate");
        System.out.println("================================");
        for(int i = 0; i < myStack.getStack().size(); i++)
        {
            System.out.println("Pushed Item " + (i + 1) + ": " + myStack.getStack().get(i));
        }
        System.out.println("================================");
        System.out.println("Pop Item 1: " + myStack.Pop());
        System.out.println("Pop Item 2: " + myStack.Pop());
        System.out.println("Pop Item 3: " + myStack.Pop());
        myStack.Push("Biscuit");
        myStack.Push("Chicken");
        System.out.println("================================");
        for(int i = 0; i < myStack.getStack().size(); i++)
        {
            System.out.println("Pushed Item " + (i + 1) + ": " + myStack.getStack().get(i));
        }
        System.out.println("================================");
        System.out.println("Number Of Searches To Biscuit: " + myStack.Search("Biscuit"));
        System.out.println("Number Of Searches To Bread: " + myStack.Search("Bread"));
        System.out.println("Number Of Searches To Beef: " + myStack.Search("Beef"));
        System.out.println("================================");
    }

}