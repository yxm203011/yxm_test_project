Spring IOC容器初体验，用于理解IOC容器用途
注解：
@Bean定义一个bean bean名字就是方法名字
@Value获取配置文件中的内容，@Value("${name}") 但是需要扫描配置文件使用<context:property-placeholder location=""/>扫描指定配置文件
@Scope表示当前bean对象什么时候创建  默认是单例（容器启动时实例就创建完成@Scope(value="singleton")全局公用一个bean ）可以通过设置value属性修改多例模式@Scope(value="prototype")在只是用的时候创建 每次请求都会产生一个bean
-------------下面这几个注解都是交由ioc管理 只是表示的作用域不同
@Controller表示当前类是controller并交由ioc管理
@Service表示当是service并交由ioc管理
@Repository表示当前是持久层比如dao 并交由ioc管理
@Component如果当前类不好归类的话 可以使用@Component 也是交由ioc管理
-------------
@Primary如果注入出现多个名字相同或者类型相同的话  需要使用这个注解来告诉ioc你想要注入的类
@AutoWired按照类型自动注入 比如我在Dao层中有一个接口  有两个DaoImpl都实现了这个接口 那我如果注入这两个DaoImpl时IOC无法判断我注入的是哪个Impl 就会报错可以使用@Primary注解来告诉ioc注入哪个
@Resource按照bean名称注入

@PostConstruct加在方法上面  表示当前bean加载成功之后会调用这个方法  可以理解为配置文件中的init-method
@Configuration表示当前类是配置类 ioc会自动扫描
@ComponentScan扫描指定路径文件@ComponentScan(basePackages="classpath:路径") 相当于配置文件中的<context:component-scan base-package="路径"/>

单元测试
@RunWith(SpringJUnit4ClassRunner.class)获取junit执行权交由ioc执行 会在测试用例执行前初始化ioc容器
@ContextConfiguration(locations = {"classpath:配置文件路径"})扫描哪个配置文件

Spring Aop：切面
pointcut:execution(public * com.yxm.spring..*Service.*(..))
                   public void com.yxm.spring xxxService.所有方法(所有参数)
JoinPoint： joinPoint.getTarget()获取当前ioc正在执行的类；
            joinPoint.getSignature()获取方法名称；
            joinPoint.getArgs()获取这个方法所有的参数；
通知的5种类型(S4中示例)
Before Advice：前置通知，目标方法执行前执行
After Returning Advice：返回后通知，目标方法返回数据后执行
After Throwing Advice：异常通知，目标方法抛异常时执行
After Advice：后置通知，目标方法执行完后执行
Around Advice：最强大的通知（环绕通知），自定义通知执行时机，可决定目标方法是否运行