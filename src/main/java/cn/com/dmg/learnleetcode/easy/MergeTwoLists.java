package cn.com.dmg.learnleetcode.easy;

public class MergeTwoLists {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 != null){
            return list2;
        }
        if(list1 != null && list2 == null){
            return list1;
        }
        if(list1 == null && list2 == null){
            return null;
        }

        //设置头节点 和 临时节点
        ListNode head = new ListNode(0);
        ListNode temp = head;
        //遍历两个链表
        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        //当有任意一个为空的时候，直接拼接上另一个链表
        if(list1 == null){
            temp.next = list2;
        } else {
            temp.next = list1;
        }
        return head.next;
    }
}


