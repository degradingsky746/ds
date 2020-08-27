class Solution {
    ListNode sorted ;
    ListNode head = new ListNode();
    ListNode n = new ListNode();
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            head = null;
            return head;
        }
        head=n;
        n.val=0;
        n.next=null;
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null) n.next=lists[i];
                while(n.next!=null)n=n.next;
        }
        head = insSort(head.next);
        return head;  
        
    }
    ListNode insSort(ListNode head){
        sorted = null; 
        ListNode current = head;        
        while(current!=null){
            ListNode next = current.next;
            sortedInsert(current);
            current = next;
        }
        head = sorted;
        return head;
    }
    void sortedInsert(ListNode newnode){
        if(sorted==null||sorted.val >= newnode.val){
            newnode.next = sorted; 
            sorted = newnode;
        }
        else 
        { 
            ListNode current = sorted; 
            while (current.next != null && current.next.val < newnode.val)  
            { 
                current = current.next; 
            } 
            newnode.next = current.next; 
            current.next = newnode; 
        } 
}}