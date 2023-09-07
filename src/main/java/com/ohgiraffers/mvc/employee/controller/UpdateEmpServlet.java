package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/employee/update")
public class UpdateEmpServlet extends HttpServlet {

    /*Service로 updateEmp 메소드 호출하여 결과 반환받고
    * 수정 완료시 Employee 목록을 조회하는 화면으로 처리*/


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String empId = request.getParameter("empId");
        String empName = request.getParameter("empName");


        EmployeeDTO emp = new EmployeeDTO();
        emp.setEmpId(empId);
        emp.setEmpName(empName);

        System.out.println("update request emp : " + emp);

        EmployeeService employeeService = new EmployeeService();
        int result = employeeService.updateEmp(emp);


        String path = "";
        if(result > 0) {
            /*insert가 성공했을 경우 요청 url이 그대로 남아 있으면 새로고침시 다시 insert를 요청하게 되는 문제가 발생한다
             * 따라서 redirect 처리가 필요하다.*/


            /*request.getContextPath() :mvc 패키지*/
            path = "/WEB-INF/views/employee/List.jsp";
            response.sendRedirect(request.getContextPath() + "/employee/update");

        }else {
            //에러페이지는 새로고침했을때 다시 띄워도 관계없음.
            path = "/WEB-INF/views/common/errorPage.jsp";
            request.setAttribute("message", "신규 직원 등록을 업데이트에 실패했습니다.");
            request.getRequestDispatcher("/WEB-INF/views.common/errorPage.jsp").forward(request, response);


        }

    }
}
