package event.jdk.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author ISJINHAO
 * @Date 2020/11/29 17:08
 */
public class JDKObserverDemo {

    public static void main(String[] args) {
        EventObservable observable = new EventObservable();
        // 添加观察者（监听者）
        observable.addObserver(new EventObserver());
        // 发布消息（事件）
        observable.notifyObservers("Hello,World");
    }

    static class EventObservable extends Observable {
        @Override
        public void notifyObservers(Object arg) {
            setChanged();
            super.notifyObservers(arg);
            clearChanged();
        }
    }

    static class EventObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            System.out.println("收到事件 ：" + arg);
        }
    }
}
