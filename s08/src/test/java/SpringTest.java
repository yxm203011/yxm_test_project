import com.yxm.spring.ioc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

//将Junit4的执行权交由spring test 在测试用例执行前自动初始化ioc容器
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
public class SpringTest {
    @Resource
    private UserService userService;

    @Test
    public void test1(){
        userService.createUser();
    }
}
