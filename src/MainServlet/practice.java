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
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      //EntityManagerのオブジェクトを生成
        EntityManager em = DBUtils.createEntityManager();

        DTO dto = em.find(DTO.class, 1);

        Hero hero = new Hero(dto.getId(),dto.getName(),dto.getLevel(),dto.getDefence(),dto.getSpeed(),dto.getFinish_ward(),dto.getAttack_value(),dto.getHp());
       // response.getWriter().append("Served at: ").append(request.getContextPath());


        //リクエストパラメータを受け取る

        String attack_action = request.getParameter("attack");

        if(attack_action.equals("攻撃")) {
            String name = dto.getName();
            int attack = hero.attack();

            System.out.println(name);
            System.out.println(attack);


            request.setAttribute("name",name);
            request.setAttribute("attack",attack);


            RequestDispatcher rd = request.getRequestDispatcher("/views1/battle1.jsp");
            rd.forward(request, response);
        }else {
            String name = "葉山";
            int attack = 1000;

            System.out.println(name);
            System.out.println(attack);


            request.setAttribute("name",name);
            request.setAttribute("attack",attack);


            RequestDispatcher rd = request.getRequestDispatcher("/views1/battle1.jsp");
            rd.forward(request, response);
        }
        System.out.println(attack_action);


//        System.out.println(name);
//        System.out.println(attack);




    }

}
