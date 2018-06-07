package dream.free.sideproject.cowork.gchat.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dream.free.sideproject.cowork.gchat.config.BaseConfigurations;

/**
 * @author George-Chou
 * @since  2018/06/07
 * 
 * 程式進入點，會啟動Spring的生命週期。
 */
public class MasterApplicationStartup {
    public static void main(String[] args) {
        //設定Profile為dev
        System.setProperty("spring.profiles.active", "dev");
        
        //初始化Spring的ApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(BaseConfigurations.class);
        ((AnnotationConfigApplicationContext) context).close();
    }
}
