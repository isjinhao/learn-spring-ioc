package ab.livebeansview;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.LiveBeansView;

/**
 * @Author ISJINHAO
 * @Date 2021/1/2 21:21
 */
public class LiveBeansViewDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(LiveBeansViewDemo.class);
        context.refresh();

        LiveBeansView liveBeansView = new LiveBeansView();
        liveBeansView.setApplicationContext(context);
        String snapshotAsJson = liveBeansView.getSnapshotAsJson();
        System.out.println(snapshotAsJson);

        context.close();
    }

}
