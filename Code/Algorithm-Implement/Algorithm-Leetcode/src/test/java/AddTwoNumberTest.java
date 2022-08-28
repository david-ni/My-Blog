import com.myblog.algorithm.leetcode.N2AddTwoNumber;

/**
 * @author David Wang <https://github.com/superTerrorist>
 */
public class AddTwoNumberTest{
    public static void main(String[] args){
        N2AddTwoNumber n2AddTwoNumber = new N2AddTwoNumber();

        N2AddTwoNumber.ListNode listNode1 = n2AddTwoNumber.new ListNode(2, n2AddTwoNumber.new ListNode(4, n2AddTwoNumber.new ListNode(9)));
        N2AddTwoNumber.ListNode listNode2 = n2AddTwoNumber.new ListNode(5, n2AddTwoNumber.new ListNode(6, n2AddTwoNumber.new ListNode(9)));

        N2AddTwoNumber.ListNode result = n2AddTwoNumber.addTwoNumbers(listNode1,listNode2);
        System.out.println(result);
    }
}
