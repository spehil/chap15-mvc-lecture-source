package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/employee/list")
public class SelectAllEmpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //파라미터를 꺼내서 검증할 필요는 없는 작업이므로 ..!
        EmployeeService employeeService = new EmployeeService();
        List<EmployeeDTO> empList = employeeService.selectAllEmp();


        String path = "";
        if(empList != null && !empList.isEmpty()){//null이나 비어있지 않을때 보여줄거임.
            path = "/WEB-INF/views/employee/employeeList.jsp";
            request.setAttribute("empList", empList);


        }else{

            path= "/WEB-INF/views/common/errorPage.jsp";
            request.setAttribute("message","직원전체 목록이 조회되지 않았습니다.");
        }
        request.getRequestDispatcher(path).forward(request,response);//넘겨줄데이터를 path에 저장된곳으로 forward해준다.(forward 코드)
    }


}
