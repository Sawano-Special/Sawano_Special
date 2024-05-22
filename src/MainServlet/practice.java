package MainServlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.DTO;
import test.Hero;
import utils.DBUtils;

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

        //EntityManagerのオブジェクトを生成
        EntityManager em = DBUtils.createEntityManager();

        DTO dto = em.find(DTO.class, 1);

        Hero hero = new Hero(dto.getId(),dto.getName(),dto.getLevel(),dto.getAttack_value());
       // response.getWriter().append("Served at: ").append(request.getContextPath());



        int attack = hero.attack();

        String name = dto.getName();

        request.setAttribute("name",name);
        request.setAttribute("attack",attack);
        RequestDispatcher rd = request.getRequestDispatcher("/views1/battle1.jsp");
        System.out.println(name);
        rd.forward(request, response);

        request.setAttribute("attack",attack);
        System.out.println(attack);
    }

}
