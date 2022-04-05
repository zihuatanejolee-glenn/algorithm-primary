package class02study;

import class01study.BubbleSort;
import class01study.InsertSort;
import class01study.Selector;

import java.util.Arrays;

/**
 * 对数器:比较器 用来比较不同算法排序过的的数组是否相同
 */
public class Comparator {

    public static void main(String[] args) {
        int[] randomValArr = getFixLenAndRandomValArr(100000, 1000000);
        int[] copy01 = Arrays.copyOf(randomValArr, 100000);
        int[] copy02 = Arrays.copyOf(randomValArr, 100000);
        Selector.selector(randomValArr);
        BubbleSort.bubbleSort(copy01);
        InsertSort.insertSort(copy02);
        System.out.println(isSorted(randomValArr));
        System.out.println(isSorted(copy01));
        System.out.println(isSorted(copy02));
    }


    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }


    public static int[] getFixLenAndRandomValArr(int length, int maxVal) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * maxVal + 1);
        }
        return arr;
    }
}
