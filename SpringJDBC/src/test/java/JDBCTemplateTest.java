import com.yxm.spring.jdbc.Service.EmployeeService;
import com.yxm.spring.jdbc.dao.EmployeeDao;
import com.yxm.spring.jdbc.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JDBCTemplateTest {

    @Resource
    EmployeeDao employeeDao;

    @Resource
    EmployeeService employeeService;

    @Test
    public void testEmployeeById(){
        Employee byId = employeeDao.findById(3308);
        System.out.println(byId);
    }

    @Test
    public void testFindByDname(){
        List<Employee> bydname = employeeDao.findBydname("市场部");
        System.out.println(bydname);
    }

    @Test
    public void testFindByMap(){
        List s = employeeDao.findMapdname("市场部");
        System.out.println(s);
    }

    @Test
    public void testInsert(){
        Employee employee = new Employee();
        employee.setEno(8888);
        employee.setEname("赵六");
        employee.setSalary(6666f);
        employee.setDname("研发部");
        employee.setHiredate(new Date());
        employeeDao.insert(employee);
    }

    @Test
    public void testUpdate(){
        Employee byId = employeeDao.findById(8888);
        byId.setSalary(byId.getSalary()+1000);
        Integer update = employeeDao.update(byId);
        System.out.println(update);
    }

    @Test
    public void testDelete(){
        Integer delete = employeeDao.delete(8888);
        System.out.println("删除："+delete);
    }

    @Test
    public void batchImport(){
        employeeService.batchImport();
    }

}
