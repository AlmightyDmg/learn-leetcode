package cn.com.dmg.learnleetcode.easy;

/**
 * @ClassName AddTwoNumbers 2. 两数相加 https://leetcode-cn.com/problems/add-two-numbers/
 * @Description
 * @author zhum
 * @date 2022/3/11 14:00
 */
public class AddTwoNumbers {
    public static void main(String[] args) {


        ListNode l1 = new ListNode();
        l1.val = 2;
        ListNode l1Next = new ListNode(4);
        l1.next = l1Next;
        l1Next.next = new ListNode(3);

        ListNode l2 = new ListNode();
        l2.val = 5;
        ListNode l2Next = new ListNode(6);
        l2.next = l2Next;
        l2Next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers2(l1, l2);
        System.out.println(listNode);

        System.out.println(Integer.MAX_VALUE);


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder s1 = new StringBuilder();
        for (;;){
            s1.append(l1.val);
            if(l1.next == null){
                break;
            }
            l1 = l1.next;
        }


        StringBuilder s2 = new StringBuilder();

        for (;;){
            s2.append(l2.val);
            if(l2.next == null){
                break;
            }
            l2 = l2.next;
        }

        int i1 = Integer.parseInt(s1.reverse().toString());
        int i2 = Integer.parseInt(s2.reverse().toString());

        int result = i1 + i2;

        StringBuilder sb = new StringBuilder(String.valueOf(result));
        String[] strings = sb.toString().split("");

        //根节点
        ListNode listNode = new ListNode();
        //子节点
        ListNode tempNode = listNode;

        for (int i = strings.length-1; i>=0; i--) {
            //处理根节点
            if(tempNode.next == null){
                tempNode.val = Integer.parseInt(strings[i]);
            }
            if(i > 0){
                ListNode nextNode = new ListNode(Integer.parseInt(strings[i-1]));
                tempNode.next = nextNode;
                tempNode = nextNode;
            }

        }
        return listNode;
    }


    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode resultListNode = null;
        ListNode nextNode = null;
        //进位值
        int carry = 0;

        //对两个链表进行遍历
        while (l1 != null || l2 != null){
            int i1 = l1 == null ? 0 : l1.val;
            int i2 = l2 == null ? 0 : l2.val;
            //和
            int sum = i1 + i2 + carry;
            if(resultListNode == null){
                resultListNode = nextNode = new ListNode(sum % 10);
            } else {
                nextNode.next = new ListNode(sum % 10);
                nextNode = nextNode.next;
            }
            //计算新的 carry
            carry = sum / 10;
            //获得新的l1 和 l2
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        //最后如果carry>0也要加上
        if(carry > 0){
            nextNode.next = new ListNode(carry);
        }
        return resultListNode;
    }





}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

