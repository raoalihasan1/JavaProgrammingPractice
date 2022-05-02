public class Feed implements Runnable {

    CommQueue readerQ;

    public Feed(CommQueue q){
        readerQ =  q;
    }

    public void run(){
        String Headlines[] =
        { "First Headline",
          "Second Headline",
          "Third Headline",
          "Fourth Headline",
          "Fifth Headline",
          "Sixth Headline",
          "Seventh Headline",

        };

        for (String hl : Headlines){
            readerQ.add(hl);
            System.out.println("Feed: " + hl +" Into Queue");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e){
                System.out.println(e);
            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            System.out.println(e);
        } finally {
          System.exit(0);
        }

    }
}
