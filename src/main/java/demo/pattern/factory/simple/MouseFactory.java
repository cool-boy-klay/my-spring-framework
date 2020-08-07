package demo.pattern.factory.simple;

import demo.pattern.factory.entity.DellMouse;
import demo.pattern.factory.entity.HpMouse;
import demo.pattern.factory.entity.Mouse;

/**
 * 简单工厂
 * 优点：
 * 可以对创建的对象进行加工，对客户端隐藏细节
 * 缺点：
 * 如果创建逻辑复杂或者创建对象过会造成代码臃肿
 * 新增添加子类会违反开闭原则（一个软件应该通过扩展实现变化而不是通过修改已有代码）
 */


public class MouseFactory {
    public static Mouse createMouse(int type){
        switch (type){
            case 0:
                return new HpMouse();
            case 1:
                return new DellMouse();
            default:
                return null;
        }
    }

    public static void main(String[] args) {

        MouseFactory.createMouse(0).sayHi();
    }
}
