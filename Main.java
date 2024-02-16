class stack{
    public int top = -1;
    public int default_size=10;
    public int[] array = new int[default_size];
    public void push(int x){
        if (top == default_size-1) {System.out.println("Stack is Full"); return;}
        else {array[++top] =x ;}
    }
    public int pop(){
        if (top==-1) { System.out.println("Stack is Empty");return 0;}
        else {return array[top--];}
    }
    public int peek(){
        return array[this.top];
    }
    public boolean isEmpty() {if (top==-1) return true;else return false;}
    public boolean isFull() {if (top==default_size-1) return true;else return false;}
};
public class Main{
    static stack s = new stack();
    public static void main(String[] args) {
        s.push(5);
        s.push(7);
        s.push(8);
        s.push(9);
        s.push(3);
        s.peek();
        System.out.print("The elements in the Stack are : ");
        for (int i=0;i<=s.top;i++) {System.out.print(s.array[i]+" ");}
        System.out.print("\nThe element pushed is "+s.pop());
        System.out.print("\nThe elements in the Stack are : ");
        for (int i=0;i<=s.top;i++) {System.out.print(s.array[i]+" ");}
    }
}