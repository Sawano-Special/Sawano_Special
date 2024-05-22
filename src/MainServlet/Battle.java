package MainServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Battle
 */
@WebServlet("/Battle")
public class Battle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Battle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String[] results = {"大吉","吉","中吉","小吉","末吉","凶"};
        request.setAttribute("results",results[(int)(Math.random()*6)]);

        String action = request.getParameter("action");

        List<String> errors = new ArrayList<String>();

        


        // JSPに値を送る
//        request.setAttribute("username", username);

        // ビューとなるJSPを指定して表示する
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/omikuji_result.jsp");
        rd.forward(request, response);


    }

}
