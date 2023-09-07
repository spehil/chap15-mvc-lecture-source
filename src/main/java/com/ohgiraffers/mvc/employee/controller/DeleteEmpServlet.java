package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteEmpServlet extends HttpServlet {

    /*Service로 deleteEmp 메소드 호출하여 결과 반환받고
    * 삭제 완료시 Employee 목록을 조회하는 화면으로 처리 */


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        request.setCharacterEncoding("UTF-8");

        String empNo= request.getParameter("empNo");


        EmployeeDTO emp = new EmployeeDTO();

        emp.setEmpName(empNo);

        System.out.println("delete request emp : " + emp);

        EmployeeService employeeService = new EmployeeService();
        int result = employeeService.deleteEmp(emp);

        if(result > 0) {

            /*request.getContextPath() :mvc 패키지*/
            response.sendRedirect(request.getContextPath() + "/employee/delete");

        }else {
            //에러페이지는 새로고침했을때 다시 띄워도 관계없음.
            request.setAttribute("message", "직원정보 삭제에 실패했습니다.");
            request.getRequestDispatcher("/WEB-INF/views.common/errorPage.jsp").forward(request, response);


        }

    }
    }

