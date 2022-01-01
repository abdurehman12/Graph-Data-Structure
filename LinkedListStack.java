
public class LinkedListStack<T> {
    StackNode top;
    public void PUSH(T c) {
       StackNode temp= new StackNode(c);
       if (this.isEmpty()){
           top=temp;
       }
       else{
           temp.next=top;
           top=temp;
       }
    }
     public T POP(){
       if(this.isEmpty()){
           return null;
       }
       else{
           StackNode temp = top;
           top=top.next;
           return (T)temp.info;
       }
     }
     public T PEEK(){
         if(this.isEmpty()){
             System.out.println("Stack is empty");
             return null;
         }
         else{
             return (T)top.info;
         }
     }
     public Boolean isEmpty() {
         return top==null;
     }
    @Override
     public String toString(){
         String s ="";
         StackNode temp = top;
         while(temp!=null){
             s+= temp.info+"\n";
             temp=temp.next;
         }
         return s;
     }
}




