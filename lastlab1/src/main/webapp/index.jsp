import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();

out.println("<html><head><title>Online Quiz</title></head><body>");
out.println("<h1>Online Quiz</h1>");

// Display quiz questions with multiple-choice answers
out.println("<form method='post' action='QuizServlet'>");
out.println("1. What is the capital of France?<br>");
out.println("<input type='radio' name='q1' value='Paris'>Paris<br>");
out.println("<input type='radio' name='q1' value='Berlin'>Berlin<br>");
out.println("<input type='radio' name='q1' value='London'>London<br><br>");

out.println("2. Which programming language is used for servlets?<br>");
out.println("<input type='radio' name='q2' value='Java'>Java<br>");
out.println("<input type='radio' name='q2' value='Python'>Python<br>");
out.println("<input type='radio' name='q2' value='C#'>C#<br><br>");

out.println("<input type='submit' value='Submit'></form>");
out.println("</body></html>");
}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();

int score = 0;

// Check answers and calculate score
String answer1 = request.getParameter("q1");
String answer2 = request.getParameter("q2");

if (answer1 != null && answer1.equals("Paris")) {
score++;
}
if (answer2 != null && answer2.equals("Java")) {
score++;
}

// Display the score
out.println("<html><head><title>Quiz Result</title></head><body>");
out.println("<h1>Quiz Result</h1>");
out.println("<p>Your score is: " + score + "/2</p>");
out.println("</body></html>");
}
}
