
import java.util.Scanner;

public class Lab_7_43 {

    static class CustomStack {
        private int[][] stack;
        private int top;

        public CustomStack(int capacity) {
            stack = new int[capacity][2];
            top = -1;
        }

        public void push(int[] interval) {
            top++;
            stack[top] = interval;
        }

        public int[] pop() {
            return stack[top--];
        }

        public int[] peek() {
            return stack[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public int size() {
            return top + 1;
        }
    }

    public static void bubbleSort(int[][] intervals) {
        int n = intervals.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (intervals[j][0] > intervals[j + 1][0]) {
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }
            }
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        bubbleSort(intervals);

        CustomStack stack = new CustomStack(intervals.length);

        for (int i = 0; i < intervals.length; i++) {
            if (stack.isEmpty() || stack.peek()[1] < intervals[i][0]) {
                stack.push(intervals[i]);
            } else {
                stack.peek()[1] = Math.max(stack.peek()[1], intervals[i][1]);
            }
        }

        int[][] result = new int[stack.size()][2];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.print("{" + interval[0] + ", " + interval[1] + "} ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of intervals: ");
        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }

        int[][] mergedIntervals = merge(intervals);

        System.out.print("Merged Intervals: ");
        printIntervals(mergedIntervals);

        scanner.close();
    }
}
