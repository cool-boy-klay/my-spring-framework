package demo.pattern.factory.abstractF;

import demo.pattern.factory.entity.HpKeyboard;
import demo.pattern.factory.entity.HpMouse;
import demo.pattern.factory.entity.Keyboard;
import demo.pattern.factory.entity.Mouse;

public class HpKeyboardFactory implements AbstractFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new HpKeyboard();
    }
}
