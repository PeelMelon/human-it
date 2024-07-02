package practice07;

public class SoundExample{

    public interface Soundable {
        String sound();
    }

    public static class Cat implements Soundable {
        @Override
        public String sound() {
            return "야옹";
        }
    }

    public static class Dog implements Soundable {
        @Override
        public String sound() {
            return "멍멍";
        }
    }

    public static void main(String[] args) {
        Soundable cat = new Cat();
        Soundable dog = new Dog();
        
        System.out.println("Cat: " + cat.sound());
        System.out.println("Dog: " + dog.sound());
    }
}


