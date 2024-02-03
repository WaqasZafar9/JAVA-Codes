<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="com.example.studentsystem.Student" %>
<%@ page import="jakarta.servlet.ServletException" %>
<%@ page import="jakarta.servlet.annotation.WebServlet" %>
<%@ page import="jakarta.servlet.http.HttpServlet" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="jakarta.servlet.http.HttpServletResponse" %>
<%@ page import="java.io.IOException" %>

<%
    // Student class definition
    class Student {
        private String rollNumber;
        private String name;

        public Student(String rollNumber, String name) {
            this.rollNumber = rollNumber;
            this.name = name;
        }

        public String getRollNumber() {
            return rollNumber;
        }

        public void setRollNumber(String rollNumber) {
            this.rollNumber = rollNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    // Servlet class definition
    @WebServlet(name = "StudentSystemServlet", value = "/students")
    class StudentSystemServlet extends HttpServlet {
        private List<Student> students = new ArrayList<>();

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("students", students);
            request.getRequestDispatcher("/students.jsp").forward(request, response);
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String rollNumber = request.getParameter("rollNumber");
            String name = request.getParameter("name");

            Student newStudent = new Student(rollNumber, name);
            students.add(newStudent);

            response.sendRedirect(request.getContextPath() + "/students");
        }
    }
%>

<html>
<head>
    <title>Student Information System</title>

</head>
<body>
<h2>Student List</h2>
<table border="1">
    <thead>
    <tr>
        <th>Roll Number</th>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.rollNumber}</td>
            <td>${student.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h2>Add New Student</h2>
<form action="${pageContext.request.contextPath}/students" method="post">
    Roll Number: <input type="text" name="rollNumber" required/><br>
    Name: <input type="text" name="name" required/><br>
    <input type="submit" value="Add Student">
</form>
</body>
</html>
