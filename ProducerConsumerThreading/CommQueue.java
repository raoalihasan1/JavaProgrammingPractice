import java.util.*;

public class CommQueue {

  protected Queue<String> rssQueue = new LinkedList<>();
  private int maxQueueSize;

  public synchronized void add(String s){
    if(rssQueue.size() > maxQueueSize){
      try {
        wait();
      }
      catch(InterruptedException e){
        System.out.println(e);
      }
      maxQueueSize = rssQueue.size();
    }
    notifyAll();
    rssQueue.add(s);
  }

  public synchronized String remove(){
    while(rssQueue.isEmpty()){
      try {
        wait();
      }
      catch(InterruptedException e){
        System.out.println(e);
      }
    }
    return rssQueue.remove();
  }

}
