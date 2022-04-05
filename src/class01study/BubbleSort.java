package class01study;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 4, 2, 3, 5, 6, 78, 834, 35, 45, 4365, 76, 5, 43, 545, 46, 54, 34, 3};
        printArray(array);
        bubbleSort(array);
        System.out.println();
        printArray(array);

        // {2, 3, 1, 4}

    }

    public static void bubbleSort(int[] array) {
        if (array == null || array.length == 1) {
            return;
        }

        // {7,1,4,3}
        // l-1 l-2 3 2 1

        //

        int l = array.length;


        for (int times = l - 1;l >= 1; l--) {

            for (int first = 0; first < times; first++) {
                if (array[first] > array[first + 1]) {
                    swap(array, first, first + 1);
//                }
                }

            }
//        for (int i = 0; i < length - 1; i++) {
//
//            for (int j = 0; j < length - i - 1; j++) {
//                if(array[j] > array[j+1]){
//                    swap(array,j ,j+1);
//                }
//            }
//        }
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
