import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }

    public int removeElement(int[] nums, int val) {
        int s = -1;
        int f = 0;
        while (f < nums.length) {
            if (nums[f] != val) nums[++s] = nums[f++];
            else f++;
        }

        return s + 1;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode s = dummy;
        ListNode f = dummy;
        while (n >= 0){
            f = f.next;
            n --;
        }
        while (f != null){
            s = s.next;
            f = f.next;
        }

        s.next = s.next.next;

        return dummy.next;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb){
            if(pa.next == null)  pa = headB;
            else pa = pa.next;

            if(pb.next == null) pb = headA;
            else pb = pb.next;
        }

        return pa;
    }

    public static List<List<Integer>> threeSum(int[] nums){
         Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k){
                if(nums[i] + nums[j] + nums[k] > 0) k--;
                else if(nums[i] + nums[j] + nums[k] < 0)    j++;
                else    {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }

            }


        }

        return res;
    }


}
