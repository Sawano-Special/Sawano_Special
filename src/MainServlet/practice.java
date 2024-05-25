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
import DTO.enemy;
import test.Enemy_damage;

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

        DTO hero_dto = em.find(DTO.class, 1);
        enemy enemy_dto = em.find(enemy.class, 1);

        Hero hero = new Hero(hero_dto.getId(),hero_dto.getName(),hero_dto.getLevel(),hero_dto.getDefence(),hero_dto.getSpeed(),hero_dto.getFinish_ward(),hero_dto.getAttack_value(),hero_dto.getHp());
       // response.getWriter().append("Served at: ").append(request.getContextPath());


        int hero_hp = hero_dto.getHp();
        System.out.println(hero_hp);
        request.setAttribute("hero_hp",hero_hp);

        int enemy_hp = enemy_dto.getHp();
        int enmey_damage_max = enemy_dto.getHp();
       // System.out.println(enemy_hp);

        Enemy_damage enemy_damage = new Enemy_damage(enmey_damage_max);



        //リクエストパラメータを受け取る

        String attack_action = request.getParameter("attack");


        if(attack_action == null) {
            attack_action = "aaa";
            request.setAttribute("enemy_hp",enemy_hp);
            System.out.println(enemy_hp);
        }

        if(attack_action.equals("攻撃")) {
            String name = hero_dto.getName();
            int attack = hero.attack();

            //HP減少
            //enemy_damage.setDamage(enmey_damage_max) = enemy_damage.setDamage(enmey_damage_max) - attack;
            request.setAttribute("enemy_hp",enemy_hp);


            System.out.println(name);
            System.out.println(attack);
            System.out.println(enemy_hp);


            request.setAttribute("name",name);
            request.setAttribute("attack",attack);


            RequestDispatcher rd = request.getRequestDispatcher("/views1/battle1.jsp");
            rd.forward(request, response);
        }
        else  {
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
