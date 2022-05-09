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

        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
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





}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

