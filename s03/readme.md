通过setter实现对象依赖注入

<bean id="name3" class="com.yxm.spring.ioc.entity.Chlid">
        <property name="name" value="张三"/>
        <property name="appleList">
                <list>
                    <ref bean="sweetApple"></ref>
                    <ref bean="sourApple"></ref>
                </list>
        </property>
    </bean>
使用这种方式添加list对象里的值