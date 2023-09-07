package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/employee/select")
public class SelectOneEmpByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String empId = request.getParameter("empId");
        System.out.println("empId : " + empId);

        EmployeeService employeeService = new EmployeeService();

        EmployeeDTO selectedEmp = employeeService.selectOneEmpById(empId);

        System.out.println("selectedEmp : " + selectedEmp);

        String path = "";
        if(selectedEmp != null) {

            path = "/WEB-INF/views/employee/showEmpInfo.jsp";
            request.setAttribute("selectedEmp", selectedEmp);

        }else {
            path="/WEB-INF/views/common/errorPage.jsp";
            request.setAttribute("message","해당사번을 가진 직원이 없습니다.");
        }

        //위임해주는코드
        request.getRequestDispatcher(path).forward(request, response);

    }


}
