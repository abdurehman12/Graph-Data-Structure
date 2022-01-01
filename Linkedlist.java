public class Linkedlist{
node head;
node tail;
    public void insert(vertex v) {
        node newnode= new node(v);
        if(head==null){
            head=newnode;
        }
        else {
            tail.next=newnode;
        }
        tail=newnode;

    }
public void delete(vertex v){
        if(head.v.name==v.name){
            head=head.next;
        }
        else
        {
            node temp=head,prev=head;
            while (temp!=null && temp.v.name!=v.name){
                prev=temp;
                temp=temp.next;
            }

            prev.next=temp.next;
        }
}
public vertex find(vertex v){
        node temp=head;
        while (temp!=null)
        {
         if(temp.v.name==v.name){
             return temp.v;
         }
        }
        return null;
}    public Boolean Find(vertex v){ // O(n)
        node temp = head;
        while(temp!=null){
            if(temp.v==v){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }



    public String toString() {
        String s=" ";
        node temp=head;
        while (temp!=null){
            s=s+temp.v.name;
            temp=temp.next;
        }
        return s;
}
}
