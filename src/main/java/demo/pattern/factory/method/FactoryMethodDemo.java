package demo.pattern.factory.method;

import demo.pattern.factory.entity.Mouse;

/**
 * 工厂方法模式
 * 优点：
 * 遵循开闭模式
 * 隐藏客户端创建对象的细节
 * 遵循单一职责
 * 缺点：
 * 只支持同一类产品创建
 * 创建子类麻烦
 */
public class FactoryMethodDemo {
    public static void main(String[] args) {
        MouseFactory mouseFactory = new HpMouseFactory();
        mouseFactory.createMouse().sayHi();
    }
}
