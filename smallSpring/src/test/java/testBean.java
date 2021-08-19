import com.test.yxm.junit.BeanDefinition;
import com.test.yxm.junit.BeanFactory;
import com.test.yxm.junit.UserService;
import org.junit.Test;

public class testBean {
    @Test
    public void m1(){
        //初始化BeanFactory（初始化bean工厂）
        BeanFactory beanFactory = new BeanFactory();
        //注入Bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        //获取Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.userData();
    }
}
