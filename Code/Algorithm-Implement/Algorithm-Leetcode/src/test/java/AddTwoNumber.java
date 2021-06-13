/**
 * @author David Wang <https://github.com/superTerrorist>
 */
public class AddTwoNumber{
    public static void main(String[] args){
        com.myblog.algorithm.leetcode.AddTwoNumber addTwoNumber = new com.myblog.algorithm.leetcode.AddTwoNumber();

        com.myblog.algorithm.leetcode.AddTwoNumber.ListNode listNode1 = addTwoNumber.new ListNode(2,addTwoNumber.new ListNode(4, addTwoNumber.new ListNode(9)));
        com.myblog.algorithm.leetcode.AddTwoNumber.ListNode listNode2 = addTwoNumber.new ListNode(5,addTwoNumber.new ListNode(6, addTwoNumber.new ListNode(9)));

        com.myblog.algorithm.leetcode.AddTwoNumber.ListNode result = addTwoNumber.addTwoNumbers(listNode1,listNode2);
        System.out.println(result);
    }
}
