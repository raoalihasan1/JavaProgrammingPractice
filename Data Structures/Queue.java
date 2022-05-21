import java.util.*;

public class Queue 
{

    private ArrayList<String> myQueue = new ArrayList<>();

    public ArrayList getQueue()
    {
        return myQueue;
    }

    public void Add(String s)
    {
        myQueue.add(s);
    }

    public String Remove()
    {
        return myQueue.remove(0);
    }

    public String Peek()
    {
        return myQueue.get(0);
    }

    public static void main(String[] args)
    {
        Queue myQueue = new Queue();
        myQueue.Add("Red");
        myQueue.Add("Orange");
        myQueue.Add("Purple");
        myQueue.Add("Silver");
        myQueue.Add("Pink");
        myQueue.Add("Brown");
        myQueue.Add("Silver");
        System.out.println("================================");
        for(int i = 0; i < myQueue.getQueue().size(); i++)
        {
            System.out.println("Queue Item " + (i + 1) + ": " + myQueue.getQueue().get(i));
        }
        System.out.println("================================");
        System.out.println("Peek Item In Front Of Queue: " + myQueue.Peek());
        System.out.println("================================");
        System.out.println("Remove Item From Queue: " + myQueue.Remove());
        System.out.println("Remove Item From Queue: " + myQueue.Remove());
        System.out.println("Remove Item From Queue: " + myQueue.Remove());
        System.out.println("Remove Item From Queue: " + myQueue.Remove());
        System.out.println("================================");
    }

}