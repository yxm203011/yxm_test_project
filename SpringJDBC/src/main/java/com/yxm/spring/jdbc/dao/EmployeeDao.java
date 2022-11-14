package com.yxm.spring.jdbc.dao;

import com.yxm.spring.jdbc.entity.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public Employee findById(Integer eno){
        String sql = "select * from employee where eno = ?";
        Employee employee = jdbcTemplate.queryForObject(sql,new Object[]{eno},new BeanPropertyRowMapper<Employee>(Employee.class));
        return employee;
    }

    public List<Employee> findBydname(String dname){
        String sql = "select * from employee where dname = ?";
        List<Employee> query = jdbcTemplate.query(sql, new Object[]{dname}, new BeanPropertyRowMapper<>(Employee.class));
        return query;
    }
    public List findMapdname(String dname){
        String sql = "select eno as empno,salary as s from employee where dname = ?";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql, new Object[]{dname});
        return mapList;
    }

    public void insert(Employee employee){
        String sql = "insert employee(eno,ename,salary,dname,hiredate) values(?,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{employee.getEno(),employee.getEname(),employee.getSalary(),employee.getDname(),employee.getHiredate()});
    }

    public Integer update(Employee employee){
       String sql = "update employee set ename=?,salary=?,dname=?,hiredate=? where eno=?";
       Integer count = jdbcTemplate.update(sql,new Object[]{employee.getEname(),employee.getSalary(),employee.getDname(),employee.getHiredate(),employee.getEno()});
        return count;
    }

    public Integer delete(Integer eno){
        String sql="delete from employee where eno=?";
        return jdbcTemplate.update(sql,new Object[]{eno});
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
