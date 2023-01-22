public class Reader implements Runnable {

    CommQueue readerQ;

    public Reader(CommQueue q){
        readerQ =  q;
    }

    public void run() {
        while (true){
            String s = readerQ.remove();
            System.out.println("Reader: " + s);
        }
    }

    public static void main (String args[]){
        CommQueue commQueue = new CommQueue();
        Thread feedFirst = new Thread(new Feed(commQueue));
        feedFirst.start();
        Thread readerFirst = new Thread(new Reader(commQueue));
        readerFirst.start();
    }
}
