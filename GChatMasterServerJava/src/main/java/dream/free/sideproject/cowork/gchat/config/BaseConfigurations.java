package dream.free.sideproject.cowork.gchat.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"dream.free.sideproject.cowork.gchat"})
@Import({ PersistenceJPAConfiguration.class, UnitTestConfigurations.class })
public class BaseConfigurations {
    
}
