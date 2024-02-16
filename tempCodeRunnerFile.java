class stack{
    public int top = -1;
    public int default_size=10;
    public int[] array;
    public void push(int x){
        if (top == default_size-1) {System.out.println("Stack is Full"); return;}
        else {array[++top] =x ;}
    }
    public int pop(){
        if (top==-1) { System.out.println("Stack is Empty");return 0;}
        else {return array[top--];}
    }
    public boolean isEmpty() {if (top==-1) return true;else return false;}
    public boolean isFull() {if (top==default_size-1) return true;else return false;}
};
class Main{
    static stack s = new stack();
    public static void main(String[] args) {
       // s.push(5);
       // s.push(7);
        System.out.print("Top element of the Stack : "+s.pop());
        System.out.println("\nThe modified Stack after removing the Top Element: ");
        for(int i=0;i<=s.top;i++) System.out.print(s.array[i]+" ");
    }
}