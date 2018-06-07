package dream.free.sideproject.cowork.gchat.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"dream.free.sideproject.cowork.gchat"})
@Import({ 
    PersistenceJPAConfigurationForDevelopment.class, 
    UnitTestConfigurations.class,
    PersistenceJPAConfigurationForProduction.class
})
@PropertySource(value="classpath:application.properties")
public class BaseConfigurations {
    
}
