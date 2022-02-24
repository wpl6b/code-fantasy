import javax.swing.text.TabableView;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        evalRPN(new String[]{"4", "13", "5", "/", "+"});
    }


    class MyQueue {
        Deque s1;
        Deque s2;

        public MyQueue() {
            s1 = new LinkedList<>();
            s2 = new LinkedList<>();
        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            int res = 0;
            if (!s1.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                res = (int) s2.pop();

                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }

            if (!s2.isEmpty()) {
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
                res = (int) s1.pop();

                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }

            return res;
        }

        public int peek() {
            int res = 0;
            if (!s1.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                res = (int) s2.peek();

                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }

            if (!s2.isEmpty()) {
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
                res = (int) s1.peek();

                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }

            return res;
        }

        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

    class MyStack {
        Deque<Integer> q1;
        Deque<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<Integer>();
            q2 = new LinkedList<Integer>();
        }

        public void push(int x) {
            if (!q1.isEmpty()) q1.offer(x);
            else if (!q2.isEmpty()) q2.offer(x);
            else q1.offer(x);
        }

        public int pop() {
            int res = 0;
            if (!q1.isEmpty()) {
                while (q1.size() != 1) q2.offer(q1.poll());
                res = q1.poll();
            } else if (!q2.isEmpty()) {
                while (q2.size() != 1) q1.offer(q2.poll());
                res = q2.poll();
            }
            return res;
        }

        public int top() {
            int res = 0;
            if (!q1.isEmpty()) {
                while (q1.size() != 1) q2.offer(q1.poll());
                res = q1.peek();
                q2.offer(q1.poll());
            } else if (!q2.isEmpty()) {
                while (q2.size() != 1) q1.offer(q2.poll());
                res = q2.peek();
                q1.offer(q2.poll());
            }
            return res;
        }

        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') stack.push(ch);
            else {
                if (ch == ')' && stack.peek() != null && stack.peek() == '(') stack.pop();
                else if (ch == ']' && stack.peek() != null && stack.peek() == '[') stack.pop();
                else if (ch == '}' && stack.peek() != null && stack.peek() == '{') stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }

    public String removeDuplicates(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != ch) stack.push(ch);
            else if (stack.peek() == ch) stack.pop();
        }

        StringBuffer res = new StringBuffer();
        while (!stack.isEmpty()) res.insert(0, stack.pop());
        return res.toString();
    }

    public static int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                if (str.equals("+")) stack.push(a + b);
                if (str.equals("-")) stack.push(a - b);
                if (str.equals("*")) stack.push(a * b);
                if (str.equals("/")) stack.push(a / b);
            } else stack.push(Integer.valueOf(str));
        }

        return stack.pop();
    }

//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int i = 0, j = k - 1;
//        ArrayList<Integer> res = new ArrayList<>();
//        while (j < nums.length){
//            int max = Integer.MIN_VALUE;
//            for (int l = 0; l < k; l++) {
//                max = Math.max(nums[i + l], max);
//            }
//            res.add(max);
//            i ++;
//            j ++;
//        }
//
//        return res.stream().mapToInt(Integer::intValue).toArray();
//
//    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        //优先队列
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                (pair1, pair2) -> pair1[1] != pair2[1] ? pair2[1] - pair1[1] : pair2[0] - pair1[0]
        );

        for (int i = 0; i < k; i++) {
            heap.add(new int[]{i, nums[i]});
        }
        res.add(heap.peek()[1]);
        int l = 1, r = k;
        while (r < nums.length) {

            heap.offer(new int[]{r, nums[r]});
            while (heap.peek()[0] < l) heap.poll();
            res.add(heap.peek()[1]);
            l++;
            r++;
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        //单调队列
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (deque.isEmpty()) deque.offerLast(i);
            else {
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])         deque.pollLast();

                deque.offerLast(i);
            }
        }
        res.add(nums[deque.peekFirst()]);

        int l = 1, r = k;
        while (r < nums.length) {

            while (nums[deque.peekLast()] < nums[r])         deque.pollLast();

            deque.offerLast(r);

            while (!deque.isEmpty() && deque.peekFirst() < l) deque.pollFirst();
            res.add(nums[deque.peekFirst()]);

            l++;
            r++;
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
