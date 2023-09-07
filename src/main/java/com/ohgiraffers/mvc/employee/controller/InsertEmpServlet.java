package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/employee/insert")
public class InsertEmpServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //인코딩설정을 해주고 이러한부분을 filter로 작성해줘도 된다.
        request.setCharacterEncoding("UTF-8");

        String empName = request.getParameter("empName");

        String empNo = request.getParameter("empNo");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        String deptCode = request.getParameter("deptCode");

        String jobCode = request.getParameter("jobCode");

        String salLevel = request.getParameter("salLevel");

        int salary = Integer.parseInt(request.getParameter("salary"));

        double bonus =Double.parseDouble(request.getParameter("bonus"));

        String managerId = request.getParameter("managerId");

        Date hireDate = Date.valueOf(request.getParameter("hireDate"));

        EmployeeDTO emp = new EmployeeDTO();

        emp.setEmpName(empName);
        emp.setEmpNo(empNo);
        emp.setEmail(email);
        emp.setPhone(phone);
        emp.setDeptCode(deptCode);
        emp.setJobCode(jobCode);
        emp.setSalLevel(salLevel);
        emp.setSalary(salary);
        emp.setBonus(bonus);
        emp.setManagerId(managerId);
        emp.setHireDate(hireDate);

        System.out.println("insert request emp : " + emp);

        EmployeeService employeeService = new EmployeeService();
        int result = employeeService.insertEmp(emp);

        if(result > 0) {
            /*insert가 성공했을 경우 요청 url이 그대로 남아 있으면 새로고침시 다시 insert를 요청하게 되는 문제가 발생한다
            * 따라서 redirect 처리가 필요하다.*/

            /*request.getContextPath() :mvc 패키지*/
            response.sendRedirect(request.getContextPath() + "/employee/list");

        }else {
            //에러페이지는 새로고침했을때 다시 띄워도 관계없음.
            request.setAttribute("message", "신규 직원 등록에 실패하였습니다.");
            request.getRequestDispatcher("/WEB-INF/views.common/errorPage.jsp").forward(request, response);


        }
    }
}
