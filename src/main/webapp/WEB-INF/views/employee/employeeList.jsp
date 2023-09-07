
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>직원 목록 전체 조회</title>

</head>
<body>
<h1>직원 목록 전체 조회</h1>
<table>
    <tr>
        <th>사원번호</th>
        <th>직원명</th>
        <th>주민등록번호</th>
        <th>이메일</th>
        <th>전화번호</th>
        <th>부서코드</th>
        <th>직급코드</th>
        <th>급여등급</th>
        <th>급여</th>
        <th>보너스율</th>
        <th>관리자 사번</th>
        <th>입사일</th>
        <th>퇴사일</th>
        <th>퇴직 여부</th>
    </tr>

    <c:forEach items="${empList}" var="emp"> <!--set.Attribute값에 이름과 같게 empList라고 써준다.-->
        <tr><th>${emp.empId}</th>
            <th>${emp.empNo}</th>
            <th>${emp.empName}</th>
            <th>${emp.empNo}</th>
            <th>${emp.email}</th>
            <th>${emp.phone}</th>
            <th>${emp.deptCode}</th>
            <th>${emp.jobCode}</th>
            <th>${emp.salLevel}</th>
            <th>${emp.salary}</th>
            <th>${emp.bonus}</th>
            <th>${emp.managerId}</th>
            <th>${emp.hireDate}</th>
            <th>${emp.entDate}</th>
            <th>${emp.entYn} </th></tr>

    </c:forEach>

</table>

</body>
</html>
