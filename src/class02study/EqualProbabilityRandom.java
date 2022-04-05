package class02study;

import java.util.Arrays;

/**
 * Math.random()生成[0,1)的double 概率是相同的
 * 题目1.已知一个函数x可以生成一个[a,b]的int 概率相同 求生成[c,d]的int 概率相同的函数y
 * 题目2.已知一个函数x1可以生成一个[0,1]的int 概率不同 生成0概率为p  生成1概率为1-p 求一个函数生成[0,1]概率相同的函数y1
 *  题2解:可以使用2次函数x2 第一次生成0第二次生成1返回 第一次生成0第二次生成1返回
 */
public class EqualProbabilityRandom {
    public static void main(String[] args) {
        // 题目1 test 定义一个数组 表示(index+1)这个数出现了arr[index+1]次
        int[] arr = new int[7];
        for (int i = 0; i < 1000000; i++) {
            int res = y();
            if (res > 7 || res < 1) {
                System.out.println("算法有问题 res is " + res);
            }
            arr[res-1]++;
        }

        int[] arr2 = new int[2];

        for (int i = 0; i < 100000000; i++) {
            int res = y2();
            arr2[res]++;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * 0 0 概率为0.8 * 0.8
     * 1 1 概率为0.2 * 0.2
     * 0 1 概率为0.8 * 0.2
     * 1 0 概率为0.2 * 0.8
     * @return 生成[0,1]概率相同的函数y1
     */
    public static int y2(){
        RandomBox randomBox = new RandomBox(0.8);
        int num;
        do{
            num = randomBox.x2();
        }while (num == randomBox.x2());
        return num;
    }

    /**
     * 已知一个函数x可以生成一个[1,5]的int 概率相同 求生成[1,7]的int 概率相同的函数
     * 生成一个[1,7]的int值等概率函数
     *
     * @return 生成一个[1, 7]的int值且等概率
     */
    public static int y() {
        // 根据x函数写一个生成0和1的等概率函数
        // 根据二进制000(0)和111(7)
        int first;
        int second;
        int third;
        // first位不能为0 为0
        do {
            // 000 这种情况不返回 因为每位上出现0或1的概率相同 所有生成[0,7]的概率相同 生成000(1)时忽略重新生成 总的生成概率还是一样
            third = get0Or1WithSameProbability() << 2;
            second = get0Or1WithSameProbability() << 1;
            first = get0Or1WithSameProbability();
        } while (first == 0 && second == 0 && third == 0);
        return third + second + first;
    }


    /**
     * 生成0和1的等概率函数
     *
     * @return 生成0和1的int且等概率
     */
    public static int get0Or1WithSameProbability() {
        while (true) {
            int res = x();
            if (res != 3) {
                return res <= 2 ? 0 : 1;
            }
        }
    }

    /**
     * 模拟x函数
     *
     * @return 生成一个[1, 5]的int 概率相同
     */
    public static int x() {
        return (int) (Math.random() * 5 + 1);
    }


}
    class RandomBox{
        private final double p;
        public RandomBox(double p){
            this.p=p;
        }
        public int x2(){
            return Math.random()<p?0:1;
        }


        }
