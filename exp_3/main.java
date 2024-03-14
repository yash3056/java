import animal.*;

public class main {
    public static void main(String[] args) {
        Animal dog = new Dog(); // Polymorphism: Dog object referred by Animal interface
        Animal cat = new Cat(); // Polymorphism: Cat object referred by Animal interface
        
        dog.makeSound(); // Output depends on the actual object type
        cat.makeSound(); // Output depends on the actual object type
    }
}
