package demo.pattern.factory.abstractF;

import demo.pattern.factory.entity.Keyboard;
import demo.pattern.factory.entity.Mouse;

public interface AbstractFactory {
    Mouse createMouse();
    Keyboard createKeyboard();
}
