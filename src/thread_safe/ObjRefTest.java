package thread_safe;

import java.util.*;
import java.util.stream.Collectors;

public class ObjRefTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        List<List<Integer>> permute = permute(arr);

        for (List<Integer> integers : permute) {
            System.out.println(Arrays.toString(integers.toArray()));
        }

    }

    public static int jump(int[] nums) {
        int junmCount = 0;
        int curIdx = 0;
        while (curIdx < nums.length - 1) {
            curIdx = getNextMaxValIdx(nums[curIdx], nums, curIdx);
            System.out.println(curIdx);
            junmCount++;

        }
        return junmCount;
    }

    public static int getNextMaxValIdx(int curVal, int[] arr, int curIdx) {
        int maxIdx = curIdx + 1;
        int max = 0;
        for (int i = 1; i <= curVal && (curIdx + i) <= arr.length - 1; i++) {
            maxIdx = max > arr[curIdx + i] ? maxIdx : (curIdx + i);
            max = Math.max(arr[curIdx + i], max);

        }
        return maxIdx;
    }

    public static String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<String>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    private static String reverse(String top) {
        StringBuilder newStr = new StringBuilder();
        for (int i = top.length() - 1; i >= 0; i--) {
            newStr.append(top.charAt(i));
        }
        return newStr.toString();
    }

    private static List<String> getSplitStrs(String s) {
        List<String> list = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            char charStr = s.charAt(i);
            if ('(' == charStr || ')' == charStr) {
                if (!"".equals(temp)) {
                    list.add(temp);
                }
                list.add(String.valueOf(charStr));
                temp = "";
                continue;
            }
            temp = temp + charStr;
        }
        return list;
    }


    public static int numRabbits(int[] answers) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int answer : answers) {
            hash.put(answer, hash.getOrDefault(answer, 0) + 1);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            Integer sameRabbitsValue = entry.getKey();
            Integer rabbitCount = entry.getValue();

            count += rabbitCount / (sameRabbitsValue + 1) * (sameRabbitsValue + 1);

        }
        return count;
    }

    public static List<List<Integer>> permute(int[] nums) {
        // 输入：nums = [1,2,3]
        //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        List<List<Integer>> listlist = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            listlist.add(new ArrayList<>());
        }

        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int[] rest = getRestArr(nums, i);

            List<List<Integer>> permute = permute(rest);
            for (List<Integer> list : permute) {
                list.add(first);
                listlist.add(list);
            }
        }
        return listlist;

    }

    private static int[] getRestArr(int[] nums, int i) {
        int h = 0;
        int[] newArr = new int[nums.length - 1];
        for (int j = 0; j < nums.length; j++) {
            if (j != i) {
                newArr[h++] = nums[j];
            }
        }
        return newArr;
    }

    public int[] dailyTemperatures(int[] temperatures) {
//        输入: temperatures = [73,74,75,71,69,72,76,73]
//        输出: [1,1,4,2,1,1,0,0]

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < temperatures.length; i++) {

            boolean flag = false;
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    flag = true;
                    list.add(j - i);
                    break;
                }
            }
            if (!flag) {
                list.add(0);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();


    }

    public static int lengtnOfLongestSubString(String s) {
        // (a)bcabcbb 开始的最长字符串为 (abc)abcbb；
        // a(b)cabcbb 开始的最长字符串为 a(bca)bcbb；
        // ab(c)abcbb 开始的最长字符串为 ab(cab)cbb
        int ans = 0, rIdx = -1;
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {

                characterSet.remove(s.charAt(i - 1));
            }
            while (rIdx + 1 < s.length() && !characterSet.contains(s.charAt(rIdx + 1))) {
                characterSet.add(s.charAt(rIdx + 1));
                rIdx++;
            }
            ans = Math.max(ans, rIdx - i + 1);

        }
        return ans;


    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (s.charAt(i) == ')' && stack.pop() != '(') {
                return false;
            }
            if (s.charAt(i) == '}' && stack.pop() != '{') {
                return false;
            }
            if (s.charAt(i) == ']' && stack.pop() != '[') {
                return false;
            }
        }
        return true;

    }


//    public int findRadius(int[] houses, int[] heaters) {
//
//        //输入: houses = [1,2,3,4,5,6,7], heaters = [5,6]
//        //输出: 1
//        //解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
//        // 先排序 然后二分找到heaters上<=houses[i]的最大索引
//
//        Arrays.sort(heaters);
//
//        for (int i = 0; i < houses.length; i++) {
//            int leftIdx = binarySearch(heaters, houses[i]);
//        }
//
//    }

    private static int binarySearch(int[] heaters, int house) {
        if(heaters[0]>house){
            return -1;
        }
        int right = heaters.length - 1;
        int left = 0;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (heaters[mid] > house) {
                right = mid - 1;
            }
            if (heaters[mid] <= house) {
                left = mid;
            }

        }
        return left;
    }


}


