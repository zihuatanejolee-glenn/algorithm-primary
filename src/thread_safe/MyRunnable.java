package thread_safe;

public class MyRunnable implements Runnable {
    int counts = 100;

    @Override
    public void run() {
        while (counts > 0) {
            synchronized (this) {
                if (counts <= 0) {
                    return;
                }
                System.out.println("nodeName " + Thread.currentThread().getName() + " is selling number " + counts + " ticket");
                counts--;
            }
        }
    }


}
