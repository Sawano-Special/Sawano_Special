package MainServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.Hero;

/**
 * Servlet implementation class practice
 */
@WebServlet("/practice")
public class practice extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public practice() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Hero hero = new Hero(1,"立浪",150,100);
       // response.getWriter().append("Served at: ").append(request.getContextPath());

        //EntityManager a = DBUtils.createEntityManager();


        int result = hero.attack(100);

        request.setAttribute("result", result);
        RequestDispatcher rd = request.getRequestDispatcher("/views1/battle1.jsp");
        System.out.println(result);
        rd.forward(request, response);
    }

}
