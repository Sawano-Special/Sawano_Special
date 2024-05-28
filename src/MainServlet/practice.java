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
import test.test_Enemy;
import utils.DBUtils;
import DTO.enemy;
import test.Enemy_damage;
import battle_controller.hp_calc;

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

        Hero hero = new Hero(hero_dto.getId(),hero_dto.getName(),hero_dto.getLevel(),hero_dto.getDefence(),hero_dto.getSpeed(),hero_dto.getFinish_ward(),hero_dto.getAttack_value(),hero_dto.getHp(),hero_dto.getMax_hp());
        test_Enemy test_enemy = new test_Enemy(enemy_dto.getId(),enemy_dto.getName(),enemy_dto.getLevel(),enemy_dto.getSpeed(),enemy_dto.getFinish_ward(),enemy_dto.getAttack_value(),enemy_dto.getHp(),hero_dto.getMax_hp());

        hp_calc hp_calc = new hp_calc();

       // response.getWriter().append("Served at: ").append(request.getContextPath());


        int hero_hp = hero_dto.getHp();
        System.out.println(hero_hp);
        //request.setAttribute("hero_hp",hero_hp);

        int enemy_hp = enemy_dto.getHp();
        //int enemy_damage = enemy_dto.getHp();
        System.out.println(enemy_hp);

        //Enemy_damage enemy_damage = new Enemy_damage(enmey_damage_max);



        //リクエストパラメータを受け取る

        String attack_action = request.getParameter("attack");

        String battle1_start = request.getParameter("battle1_start");

        Integer enemy_current_hp = (Integer) request.getSession().getAttribute("enemy_current_hp");
        Integer hero_enemy_current_hp = (Integer) request.getSession().getAttribute("hero_enemy_current_hp");

        System.out.println(enemy_current_hp);
        System.out.println(hero_enemy_current_hp);



        if(attack_action == null) {
            attack_action = "aaa";
            request.setAttribute("enemy_hp",enemy_hp);
            System.out.println(enemy_hp);
        }

        if(enemy_current_hp == null) {
            enemy_current_hp = enemy_dto.getHp();
            System.out.println("ENEMY表示されています" + enemy_current_hp);
        }

        if(hero_enemy_current_hp == null) {
            hero_enemy_current_hp = hero_dto.getHp();
            System.out.println("HERO表示されています" + hero_enemy_current_hp);


        if(battle1_start == null) {
            battle1_start = "開始中";
            System.out.println("開始中です！");
        }



        if(attack_action.equals("攻撃")) {

            if(enemy_current_hp > 0 && hero_enemy_current_hp > 0) {
                String hero_name = hero_dto.getName();
                int hero_attack = hero.attack();

                String enemy_name = enemy_dto.getName();
                int enemy_attack = test_enemy.attack();

                //HP減少
                enemy_current_hp = hp_calc.enemy_hp_calc(hero_attack,enemy_current_hp);

                hero_enemy_current_hp = hp_calc.hero_hp_calc(enemy_attack, hero_enemy_current_hp);

                //enemy_current_hp = enemy_current_hp  - attack;


                request.setAttribute("enemy_hp",enemy_hp);
                request.setAttribute("hero_hp",hero_hp);


                System.out.println(hero_name);
                System.out.println(hero_attack);
                System.out.println(enemy_hp);

                System.out.println(hero_hp);

                //request.setAttribute("name",hero_name);
                //request.setAttribute("attack",hero_attack);

                //request.setAttribute("enemy_name",enemy_name);
                //request.setAttribute("emnemy_attack",enemy_attack);




                String message = "";
                String message2 = "";

                if(enemy_current_hp <= 0 && hero_enemy_current_hp > 0) {
                    enemy_current_hp = 0;
                    System.out.println("呼び出されてるよ");
                    message = hero_name+"は"+ enemy_name +"とのバトルに勝利しました!!";
                    request.setAttribute("message",message);
                }else if(enemy_current_hp > 0 && hero_enemy_current_hp <= 0) {
                    hero_enemy_current_hp = 0;
                    System.out.println("呼び出されてるよhero");
                    message = hero_name+"は"+ enemy_name +"とのバトルに敗れました!";
                    request.setAttribute("message",message);
                }
                else {
                    message = hero_name +"は"+enemy_name +"に"+hero_attack+"ダメージを与えた";
                    message2 = enemy_name +"は"+hero_name +"に"+enemy_attack+"ダメージを与えた";
                    System.out.println(message);
                    System.out.println(message2);
                    request.setAttribute("message",message);
                    request.setAttribute("message2",message2);
                }

                request.getSession().setAttribute("enemy_current_hp",enemy_current_hp);


                RequestDispatcher rd = request.getRequestDispatcher("/views1/battle1.jsp");
                rd.forward(request, response);

            }else {
                if(battle1_start.equals("battle1")) {
                    enemy_current_hp = enemy_dto.getHp();
                    request.getSession().setAttribute("enemy_current_hp",enemy_current_hp);
                    System.out.println("バトル1が開始されました(初期状態１)" + enemy_current_hp);
                }
                String message = "";
                String message2 = "";
                String hero_name = hero_dto.getName();
                int hero_attack = hero.attack();

                String enemy_name = enemy_dto.getName();
                int enemy_attack = test_enemy.attack();

                if(enemy_current_hp <= 0 && hero_enemy_current_hp > 0) {
                    enemy_current_hp = 0;
                    System.out.println("呼び出されてるよ");
                    message = hero_name+"は"+ enemy_name +"とのバトルに勝利しました!!";
                    request.setAttribute("message",message);
                    request.setAttribute("message2", message2);
                }else if(enemy_current_hp > 0 && hero_enemy_current_hp <= 0) {
                    hero_enemy_current_hp = 0;
                    System.out.println("呼び出されてるよhero");
                    message = hero_name+"は"+ enemy_name +"とのバトルに敗れました!";
                    request.setAttribute("message",message);
                    request.setAttribute("message2", message2);
                }
                else {
                    message = hero_name +"は"+enemy_name +"に"+hero_attack+"ダメージを与えた";
                    message2 = enemy_name +"は"+hero_name +"に"+enemy_attack+"ダメージを与えた";
                    System.out.println(message);
                    System.out.println(message2);
                    request.setAttribute("message",message);
                    request.setAttribute("message2",message2);
                }
                request.getSession().setAttribute("enemy_current_hp",enemy_current_hp);



                request.setAttribute("message",message);
                System.out.println(message);


                RequestDispatcher rd = request.getRequestDispatcher("/views1/battle1.jsp");
                rd.forward(request, response);
            }


        }else  {
            if(battle1_start.equals("battle1")) {
                enemy_current_hp = enemy_dto.getHp();
                hero_enemy_current_hp = hero_dto.getHp();
                //request.getSession().setAttribute("enemy_current_hp",enemy_current_hp);
                System.out.println("バトル1が開始されました(初期状態2)");
            }

            System.out.println("Enemy_enemy_current_hp:" +enemy_current_hp);
            System.out.println("Hero_enemy_current_hp:" +hero_enemy_current_hp);


            request.getSession().setAttribute("enemy_current_hp",enemy_current_hp);
            request.getSession().setAttribute("hero_enemy_current_hp",hero_enemy_current_hp);


            String message ="野生の"+enemy_dto.getName()+"が現れました!!";
            String message2 ="";

            request.setAttribute("message",message);
            request.setAttribute("message2", message2);
            System.out.println(message);




            RequestDispatcher rd = request.getRequestDispatcher("/views1/battle1.jsp");
            rd.forward(request, response);

            //enemy_current_hp = 0;
        }



                System.out.println(attack_action);


        //        System.out.println(name);
        //        System.out.println(attack);

    }
    }
}
