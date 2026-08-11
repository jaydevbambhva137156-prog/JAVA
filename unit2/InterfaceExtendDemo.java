interface Animal
{
    void sound();
}

interface Pet extends Animal
{
    void play();
}

class Dog implements Pet
{
    public void sound()
    {
        System.out.println("Dog barks");
    }

    public void play()
    {
        System.out.println("Dog plays with a ball");
    }
}

public class InterfaceExtendDemo
{
    public static void main(String args[])
    {
        Dog d = new Dog();

        d.sound();
        d.play();
    }
}