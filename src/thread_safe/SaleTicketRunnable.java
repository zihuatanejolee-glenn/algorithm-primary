package thread_safe;

public class SaleTicketRunnable implements Runnable {


    private Integer ticketLeft;

    private Station station;

    public SaleTicketRunnable(Integer ticketLeft, Station station) {
        this.ticketLeft = ticketLeft;
        this.station = station;
    }

    @Override
    public void run() {
        synchronized (station) {
            while (station.getCurrentSaleWindowsCounts() < station.getSumSaleWindowsCounts() - 1) {
                station.setCurrentSaleWindowsCounts(station.getCurrentSaleWindowsCounts() + 1);
                try {
                    station.wait();
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
            station.notifyAll();
        }
        while (ticketLeft > 0) {
            sale();
        }
    }

    private void sale() {

//        if(ticketLeft<=0){
//            return;
//        }
        System.out.println("windowsNo " + Thread.currentThread().getName() + " is selling seat number " + ticketLeft + " ticket");
        ticketLeft--;
    }
}
