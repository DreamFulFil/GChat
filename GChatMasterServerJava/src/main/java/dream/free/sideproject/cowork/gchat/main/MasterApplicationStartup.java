package dream.free.sideproject.cowork.gchat.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dream.free.sideproject.cowork.gchat.config.BaseConfigurations;

public class MasterApplicationStartup {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "dev");
        ApplicationContext context = new AnnotationConfigApplicationContext(BaseConfigurations.class);
        ((AnnotationConfigApplicationContext)context).close();
    }
}
