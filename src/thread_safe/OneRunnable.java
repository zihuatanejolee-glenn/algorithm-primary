package thread_safe;

import java.util.Map;

public class OneRunnable implements Runnable {

    private Map<String, Integer> ticket;

    public OneRunnable(Map<String, Integer> ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
        Integer counts;
        do {
//            try {
//                Thread.sleep((int)(Math.random()*100)+1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (this) {
                counts = ticket.get("counts");
                if (counts <= 0) {
                    return;
                }
                System.out.println("nodeName " + Thread.currentThread().getName() + " is selling number " + counts + " ticket");
                ticket.put("counts", --counts);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        } while (counts > 0);

    }
}
