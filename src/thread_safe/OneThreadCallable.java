package thread_safe;

import java.util.concurrent.Callable;

public class OneThreadCallable implements Callable<Integer> {
    private Integer res;

    public OneThreadCallable(Integer res) {
        this.res = res;
    }

    /**
     * 一个线程先sleep 1 秒等另外一个线程先打印map.get(key=1) 然后去拿共享变量Map里面的key为1的value对象 然后修改
     *
     * @return
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {


        return res;
    }
}
