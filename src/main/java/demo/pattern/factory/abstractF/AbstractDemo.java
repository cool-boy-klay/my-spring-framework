package demo.pattern.factory.abstractF;

public class AbstractDemo {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new DellKeyBoardFactory();
        abstractFactory.createKeyboard().sayHi();
        abstractFactory.createMouse().sayHi();
    }
}
