package com.yxm.spring.jdbc.Service;

import com.yxm.spring.jdbc.dao.EmployeeDao;
import com.yxm.spring.jdbc.entity.Employee;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Date;

public class EmployeeService {

    private EmployeeDao employeeDao;

    //private DataSourceTransactionManager transactionManager;

    public void batchImport(){
        /*TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(transactionDefinition);
        try{*/
            for (int i = 1; i <= 10; i++) {
                /*if(i == 3){
                    throw new RuntimeException("意料之外的异常");
                }*/
                Employee employee = new Employee();
                employee.setEno(8000+i);
                employee.setEname("员工"+i);
                employee.setSalary(4000f);
                employee.setDname("市场部");
                employee.setHiredate(new Date());
                employeeDao.insert(employee);
            }
          /*  transactionManager.commit(status);
        }catch(Exception e){
            transactionManager.rollback(status);
            e.printStackTrace();
        }*/
        System.out.println("导入成功");
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    /*public DataSourceTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(DataSourceTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }*/
}