package class01study;

public class Selector {


    public static void main(String[] args) {
        int[] array = {2, 3, 1, 4, 2, 3, 5, 6, 78, 834, 35, 45, 4365, 76, 5, 43, 545, 46, 54, 34, 3};
        printArray(array);
        selector(array);
        System.out.println();
        printArray(array);
    }

    public static void selector(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int maxValIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                maxValIndex = array[maxValIndex] < array[j] ? maxValIndex : j;
            }
            swap(maxValIndex, i, array);
        }
    }

    private static void swap(int maxValIndex, int i, int[] array) {
        int temp;
        temp = array[i];
        array[i] = array[maxValIndex];
        array[maxValIndex] = temp;
    }

    private static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
