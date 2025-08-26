/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution 
{
    public ListNode sumoflists(ListNode l1,ListNode l2)
    {
        ListNode sumhead=null;
        ListNode last=null;
        int carry=0;
        int sum=0;
        while(l1!=null || l2!=null)
        {
            sum=0;
            if(l1==null)
            {
                sum=l2.val + carry;
                if(sum>=10)
                {
                    carry=sum/10;
                    sum=sum%10;
                    
                }
                else
                {
                    carry=0;
                }  
                ListNode temp=new ListNode(sum,null);
                if(sumhead==null)
                {
                    sumhead=temp;
                    last=temp;
                }
                else
                {
                    last.next=temp;
                    last=temp;
                }
                if(l2.next==null && carry>0)
                {
                    temp=new ListNode(carry,null);
                    last.next=temp;
                    last=temp;
                }
                l2=l2.next;
            }
            else if(l2==null)
            {
                sum=l1.val + carry;           
                if(sum>=10)
                {
                    carry=sum/10;
                    sum=sum%10;
                }
                else
                {
                    carry=0;
                }
                ListNode temp=new ListNode(sum,null);
                if(sumhead==null)
                {
                    sumhead=temp;
                    last=temp;
                }
                else
                {
                    last.next=temp;
                    last=temp;
                }
                if(l1.next==null && carry>0)
                {
                    temp=new ListNode(carry,null);
                    last.next=temp;
                    last=temp;
                }
                l1=l1.next;
            }
            else
            {
                sum=l1.val+l2.val + carry;
                if(sum>=10)
                {
                    carry=sum/10;
                    sum=sum%10; 
                }
                else
                {
                    carry=0;
                }
                
                ListNode temp=new ListNode(sum,null);
                if(sumhead==null)
                {
                    sumhead=temp;
                    last=temp;
                }
                else
                {
                    last.next=temp;
                    last=temp;
                }
                if(l1.next==null && l2.next==null && carry>0)
                {
                   temp=new ListNode(carry,null);
                    last.next=temp;
                    last=temp;
                }
                l1=l1.next;
                l2=l2.next;
            }
        }
        return sumhead;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
      
       
       ListNode sumhead2=sumoflists(l1,l2);
       return sumhead2;
        
    }
}