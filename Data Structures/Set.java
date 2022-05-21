import java.util.*;

public class Set 
{

    private ArrayList<String> mySet = new ArrayList<>();

    public ArrayList getSet()
    {
        return mySet;
    }

    public boolean Add(String s)
    {
        for(String i: mySet)
        {
            if(i.equals(s))
            {
                return false;
            }
        }
        mySet.add(s);
        return true;
    }

    public boolean Clear(){
        int setSize = mySet.size();
        for(int i = 0; i < setSize; i++)
        {
            mySet.remove(0);
        }
        if(mySet.size() == setSize)
        {
            return false;
        }
        return true;
    }

    public boolean Remove(String s)
    {
        for(int i = 0; i < mySet.size(); i++)
        {
            if(mySet.get(i).equals(s))
            {
                mySet.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean Contains(String s)
    {
        for(int i = 0; i < mySet.size(); i++)
        {
            if(mySet.get(i).equals(s))
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        Set mySet = new Set();
        mySet.Add("Red");
        mySet.Add("Orange");
        mySet.Add("Purple");
        mySet.Add("Silver");
        System.out.println("================================");
        for(int i = 0; i < mySet.getSet().size(); i++)
        {
            System.out.println("Set Item " + (i + 1) + ": " + mySet.getSet().get(i));
        }
        System.out.println("================================");
        if(mySet.Contains("Silver"))
        {
            System.out.println("Silver Is In The Set");
        }
        else
        {
            System.out.println("Silver Is Not In The Set");
        }
        System.out.println("================================");
        if(mySet.Remove("Orange"))
        {
            System.out.println("Orange Removed From The Set");
        }
        else 
        {
            System.out.println("Orange Not Removed From The Set");   
        }
        System.out.println("================================");
        if(mySet.Remove("Brown"))
        {
            System.out.println("Brown Removed From The Set");
        }
        else 
        {
            System.out.println("Brown Not Removed From The Set");   
        }
        System.out.println("================================");
        for(int i = 0; i < mySet.getSet().size(); i++)
        {
            System.out.println("Set Item " + (i + 1) + ": " + mySet.getSet().get(i));
        }
        System.out.println("================================");
        if(mySet.Clear())
        {
            System.out.println("The Set Has Been Cleared");
        }
        else
        {
            System.out.println("Failed To Clear The Set");
        }
        System.out.println("================================");
    }

}