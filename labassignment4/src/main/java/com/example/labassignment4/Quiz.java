package com.example.labassignment4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet(name = "Quiz", value = "/quiz")
public class Quiz extends HttpServlet {
    private String[] questions = {
            "Question 1: What is the capital of France?",
            "Question 2: Which programming language is used for servlets?"
    };
    private String[][] choices = {
            {"A. Berlin", "B. London", "C. Paris", "D. Madrid"},
            {"A. Java", "B. Python", "C. C#", "D. Ruby"}
    };
    private int[] correctAnswers = {2, 1}; // Index of correct choices

    public void init() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Online Quiz</title></head><body>");
        out.println("<h2>Quiz Questions</h2>");
        out.println("<form action='quiz' method='POST'>");

        for (int i = 0; i < questions.length; i++) {
            out.println("<p>" + questions[i] + "</p>");

            for (int j = 0; j < choices[i].length; j++) {
                out.println("<input type='radio' name='answer" + i + "' value='" + j + "' required /> " + choices[i][j] + "<br>");
            }
        }

        out.println("<input type='submit' value='Submit'/>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            String userAnswer = request.getParameter("answer" + i);

            if (userAnswer != null && Integer.parseInt(userAnswer) == correctAnswers[i]) {
                score++;
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Quiz Result</title></head><body>");
        out.println("<h2>Quiz Result</h2>");
        out.println("<p>Your Score: " + score + "/" + questions.length + "</p>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
