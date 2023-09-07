package com.ohgiraffers.mvc.employee.model.service;

import com.ohgiraffers.mvc.employee.model.dao.EmployeeMapper;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.mvc.common.mybatis.Template.getSqlSession;

public class EmployeeService {

    private  EmployeeMapper employeeMapper;
    public EmployeeDTO selectOneEmpById(String empId) {


        /*SqlSession객체 생성 -> Template템플릿에서 작성해서 호출 */

        SqlSession sqlSession = getSqlSession();
        System.out.println("sqlSession : " +sqlSession);

       employeeMapper =  sqlSession.getMapper(EmployeeMapper.class);

       EmployeeDTO selectEmp = employeeMapper.selectOneEmpById(empId);

       sqlSession.close();




        return  selectEmp;


    }

    public List<EmployeeDTO> selectAllEmp() {
        SqlSession sqlSession = getSqlSession();
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        List<EmployeeDTO> empList = employeeMapper.selectAllEmp();

        sqlSession.close();
        return empList;




    }

    public int insertEmp(EmployeeDTO emp) {

        SqlSession sqlSession = getSqlSession();
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        int result = employeeMapper.insertEmp(emp);//insert된 행의 수를 result로 받아온다.

        if(result > 0) {

            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }


        sqlSession.close();

        return result; //값을 반환한다!
    }

    public  int updateEmp(EmployeeDTO emp){

        SqlSession sqlSession = getSqlSession();
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        int result = employeeMapper.updateEmp(emp);

        if(result > 0) {

            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }


        sqlSession.close();

        return result; //값을 반환한다!



    }

    public int deleteEmp(EmployeeDTO emp) {

        SqlSession sqlSession = getSqlSession();
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        int result = employeeMapper.deleteEmp(emp);//insert된 행의 수를 result로 받아온다.

        if(result > 0) {

            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }


        sqlSession.close();

        return result; //값을 반환한다!

    }
}
