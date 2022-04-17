package thread_safe;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

public class ObjReference {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Map<String, Integer> ticket = new HashMap<>();
        ticket.put("counts", 100);
        OneRunnable oneRunnable = new OneRunnable(ticket);
        Thread one = new Thread(oneRunnable,"thread_1");
        Thread two = new Thread(oneRunnable,"thread_2");
        Thread three = new Thread(oneRunnable,"thread_3");


        one.start();
        two.start();
        three.start();

//        int sumWindowsCount = 100;
//        Station station = new Station();
//        station.setSumSaleWindowsCounts(sumWindowsCount);
//
//        SaleTicketRunnable runnable = new SaleTicketRunnable(100, station);
//
//        for (int i = 0; i < sumWindowsCount; i++) {
//            Thread thread = new Thread(runnable, "window_" + (i + 1));
//            thread.start();
//        }

    }
}

