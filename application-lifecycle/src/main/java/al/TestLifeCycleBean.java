package al;

import org.springframework.context.SmartLifecycle;

/**
 * @Author ISJINHAO
 * @Date 2020/12/28 19:10
 */
public class TestLifeCycleBean implements SmartLifecycle {

    private boolean running = false;

    @Override
    public void start() {
        System.out.println("bean start");
        running = true;
    }

    @Override
    public void stop() {
        System.out.println("bean stop");
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
