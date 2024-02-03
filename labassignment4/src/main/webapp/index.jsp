<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Quiz</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        h2 {
            color: #333;
        }
        form {
            max-width: 600px;
            margin: 0 auto;
        }
        p {
            color: #555;
        }
        input[type="radio"] {
            margin-bottom: 10px;
        }
        input[type="submit"] {
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<h2>Quiz Questions</h2>
<form action="${Quiz}/quiz" method="post">

    <%
        // Assume these are the same questions as in the Servlet. In a real
        // application, you might retrieve these from a shared resource or the servlet

        String[] questions = {"Question 1: What is the capital of France?", "Question 2: Which programming language is used for servlets?" };
        String[][] choices = {
                {"A. Berlin", "B. London", "C. Paris", "D. Madrid"},
                {"A. Java", "B. Python", "C. C#", "D. Ruby"}
        };

        for (int i = 0; i < questions.length; i++) {
    %>
    <p><%= questions[i] %></p>

    <%
        for (int j = 0; j < choices[i].length; j++) {
    %>
    <input type="radio" name="answer<%= i %>" value="<%= j %>" required /> <%= choices[i][j] %><br>
    <%
        }
    %>

    <%
        }
    %>
    <input type="submit" value="Submit">
</form>
</body>
</html>
