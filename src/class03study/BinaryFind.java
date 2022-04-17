package class03study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryFind {


    public static void main(String[] args) {

//        testFindByBinary();

    }

    private static void testFindByBinary() {
        int length = 100000000;
        int[] testArr = new int[length];

        int temp = 0;
        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * 10);
            temp += random == 0 ? 1 : random;
            testArr[i] = temp;
        }

        for (int i = 0; i < length; i++) {
            if (findByBinary(testArr, testArr[i]) != i) {
                System.out.println("算法有错误 " + i);
            }
        }
        System.out.println("----end------");
    }

    /**
     * 从一个升序的数组里面找出大于等于值为target的最左索引 不一定存在这个值  数组有可能有多个相同的值
     *
     * @param arr
     * @param target
     * @return
     */
    public static int findByBinary4(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        // [0,2,3,5,6,8,9,10,12,13,15]
        // 已知从左到右有2数索引为leftIdx和rightIdx 则中间数(左中)index为(leftIdx + rightIdx) / 2

        int leftIdx = 0;
        // arr中不存在target
        int temp = -1;
        // arr中存在target
        int rightIdx = arr.length - 1;
        while (leftIdx <= rightIdx) {
            int leftMidIdx = (leftIdx + rightIdx) / 2;
            if (target <= arr[leftMidIdx]) {
                rightIdx = leftMidIdx - 1;
                temp = leftMidIdx;

            } else if (target > arr[leftMidIdx]) {
                leftIdx = leftMidIdx + 1;
            }
        }
        return temp;
    }


    /**
     * 从一个升序的数组里面找出值为target的索引 必定存在这个值 也有可能不存在数组不可能有多个相同的值
     * <p>
     * 如果这个值不存在的话 这个方法会死循环
     *
     * @param arr
     * @param target
     * @return
     */
    public static int findByBinary(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        // [0,2,3,5,6,8,9,10,12,13,15]
        // 已知从左到右有2数索引为leftIdx和rightIdx 则中间数(左中)index为(leftIdx + rightIdx) / 2

        int leftIdx = 0;
        int rightIdx = arr.length - 1;

        int LeftMidIdx = (arr.length - 1) / 2;

        while (arr[LeftMidIdx] != target) {
            if (arr[LeftMidIdx] > target) {
                rightIdx = LeftMidIdx - 1;
            } else {
                leftIdx = LeftMidIdx + 1;
            }
            // 指针移动
            LeftMidIdx = (leftIdx + rightIdx) / 2;
        }
        return LeftMidIdx;
    }

    /**
     * 从一个升序的数组里面找出值为target的索引 不一定存在这个值 找不到时返回-1 数组不可能有多个相同的值
     *
     * @param arr
     * @param target
     * @return
     */
    public static int findByBinary3(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        // [0,2,3,5,6,8,9,10,12,13,15]
        // 已知从左到右有2数索引为leftIdx和rightIdx 则中间数(左中)index为(leftIdx + rightIdx) / 2

        int leftIdx = 0;
        int rightIdx = arr.length - 1;

        int leftMidIdx = (arr.length - 1) / 2;
        while (leftIdx <= rightIdx) {
            if (target < arr[leftMidIdx]) {
                rightIdx = leftMidIdx - 1;

            } else if (target > arr[leftMidIdx]) {
                leftIdx = leftMidIdx + 1;
            } else {
                return leftMidIdx;
            }
        }
        return -1;
    }

    /**
     * 从一个升序的数组里面找出值为target的所有索引 数组可能有多个相同的值
     *
     * @param arr
     * @param target
     * @return
     */
    public static List<Integer> findByBinary2(int[] arr, int target) {
        if (arr.length == 0) {
            return Collections.emptyList();
        }
        List<Integer> indexes = new ArrayList<>();
        // [0,2,3,5,6,8,9,10,12,13,15]
        // 已知从左到右有2数索引为leftIdx和rightIdx 则中间数(左中)index为(leftIdx + rightIdx) / 2
        int leftIdx = 0;
        int rightIdx = arr.length - 1;

        while (leftIdx <= rightIdx) {
            int mid = (leftIdx + rightIdx) / 2;
            if (arr[mid] > target) {
                rightIdx = mid - 1;
            } else if (arr[mid] < target) {
                leftIdx = mid + 1;
            } else {
                indexes.add(mid);
                int tempPlus = mid + 1;
                int tempMinus = mid - 1;
                while (arr[tempPlus] == target) {
                    indexes.add(tempPlus);
                    tempPlus++;
                }
                while (arr[tempMinus] == target) {
                    indexes.add(tempMinus);
                    tempMinus--;
                }
            }
        }
        return indexes;

    }
}
