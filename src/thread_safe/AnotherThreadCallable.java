package thread_safe;

import java.util.Map;
import java.util.concurrent.Callable;

public class AnotherThreadCallable implements Callable<String> {


    private Map<String,ObjOne> map;

    public AnotherThreadCallable(Map<String, ObjOne> map) {
        this.map = map;
    }

    /**
     * 另一个线程先拿到这个对象打印 随后sleep 2 秒 再拿到再打印
     * @return
     * @throws Exception
     */
    @Override
    public String call() throws Exception {
        ObjOne objOne = map.get("111");
        System.out.println("thread one start print"+objOne);
        Thread.sleep(5000);
        System.out.println("thread one start again print"+objOne);
        return "two";
    }
}
