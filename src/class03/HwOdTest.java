package class03;

public class HwOdTest {

    // 求一串01010101010的信号中 最长的010101010交替的信号最长串 必须0开头 0结尾

    public static void main(String[] args) {
        String signalStr = "00101010101100001010010";


        int leftIdx = 0;
        int length = signalStr.length();
        int max = 0;
        while (leftIdx < length - 1) {

            int tempLen = 0;

            for (int i = leftIdx; i < length && leftIdx+1<length; i++) {
                if (signalStr.charAt(leftIdx) == '0' && signalStr.charAt(leftIdx) == signalStr.charAt(leftIdx + 1)) {
                    leftIdx++;
                    break;
                } else {
                    leftIdx++;
                    tempLen++;
                }
            }
            max = Math.max(tempLen, max);
        }
        if(max == 0){
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < max; i++) {
            System.out.print((i % 2 == 0) ? '0' : '1');
        }
    }
}
