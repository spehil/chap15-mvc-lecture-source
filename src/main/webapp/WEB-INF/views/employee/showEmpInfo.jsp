<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2023-09-07
  Time: 오전 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>사원정보</title>
</head>
<body>

    <h1>${param.empId}번 사원의 정보</h1>
    <h4>사원명 : ${selectedEmp.empName }</h4>
    <h4>부서 코드 : ${selectedEmp.deptCode }</h4>
    <h4>직급 코드 : ${selectedEmp.jobCode }</h4>
    <h4>월급 : ${selectedEmp.salary }</h4>


</body>
</html>
