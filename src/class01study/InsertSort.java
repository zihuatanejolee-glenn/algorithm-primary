package class01study;

public class InsertSort {

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 4, 2, 3, 5, 6, 78, 834, 35, 45, 4365, 76, 5, 43, 545, 46, 54, 34, 3};
//        printArray(array);
//        insertSort(array);
//        System.out.println();
//        printArray(array);
    }

    public static void insertSort(int[] array) {
        if (array == null || array.length == 1) {
            return;
        }

        // {2,3,1,6,5}
        int l = array.length;
        for (int times = 1; times < l; times++) {
            for (int needMoveToLeftInx = times; needMoveToLeftInx > 0 && array[needMoveToLeftInx] < array[needMoveToLeftInx - 1]; needMoveToLeftInx--) {
                swap(array, needMoveToLeftInx, needMoveToLeftInx - 1);
            }
        }
        

    }

    private static void swap(int[] array, int j, int i) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }


    private static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
