package MainServlet;

import java.io.IOException;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.DTO;
import test.Hero;
import test.exp;
import test.test_Enemy;
import utils.DBUtils;
import DTO.enemy;
import test.Enemy_damage;
import battle_controller.hp_calc;
import sql_setting.exp_table;
import test.meigen;

/**
* Servlet implementation class practice
*/
@WebServlet("/practice4")
public class practice4 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public practice4() {
        super();
        // TODO Auto-generated constructor stub
    }
    int id = 1;
    int stage = 4;
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      //EntityManagerのオブジェクトを生成
        EntityManager em = DBUtils.createEntityManager();

        DTO hero_dto = em.find(DTO.class, 1);
        enemy enemy_dto = em.find(enemy.class, 4);

        Hero hero = new Hero(hero_dto.getId(),hero_dto.getName(),hero_dto.getLevel(),hero_dto.getDefence(),hero_dto.getSpeed(),hero_dto.getFinish_word(),hero_dto.getAttack_value(),hero_dto.getHp(),hero_dto.getMax_hp());
        test_Enemy test_enemy = new test_Enemy(enemy_dto.getId(),enemy_dto.getName(),enemy_dto.getLevel(),enemy_dto.getSpeed(),enemy_dto.getFinish_word(),enemy_dto.getAttack_value(),enemy_dto.getHp(),hero_dto.getMax_hp());
        meigen meigen = new meigen();


        hp_calc hp_calc = new hp_calc();

       // response.getWriter().append("Served at: ").append(request.getContextPath());

        String hero_name = hero_dto.getName();
        int hero_attack = hero.attack();
        int hero_speed = hero_dto.getSpeed();


        String message = "";
        String message2 = "";

        String enemy_name = enemy_dto.getName();
        int enemy_attack = test_enemy.attack();
        int enemy_speed = enemy_dto.getSpeed();

        request.setAttribute("hero_name:",hero_name);
        request.setAttribute("hero_attack:",hero_attack);
        request.setAttribute("enemy_name:",enemy_name);
        request.setAttribute("enemy_attack:",enemy_attack);


        int hero_hp = hero_dto.getHp();
        System.out.println("IF前："+hero_hp);
        request.setAttribute("hero_hp",hero_hp);

        int enemy_hp = enemy_dto.getHp();
        //int enemy_damage = enemy_dto.getHp();
        System.out.println("IF前："+enemy_hp);
        request.setAttribute("enemy_hp",enemy_hp);

        //Enemy_damage enemy_damage = new Enemy_damage(enmey_damage_max);


        //リクエストパラメータを受け取る

        String attack_action = request.getParameter("attack");

        String battle4_start = request.getParameter("battle4_start");

        String recovery = request.getParameter("recovery");

        Integer enemy_current_hp = (Integer) request.getSession().getAttribute("enemy_current_hp");
        Integer hero_current_hp = (Integer) request.getSession().getAttribute("hero_current_hp");

        System.out.println("IF前："+enemy_current_hp);
        System.out.println("IF前："+hero_current_hp);


        if(attack_action == null) {
            attack_action = "aaa";
            //request.setAttribute("enemy_hp",enemy_hp);
            System.out.println("Attack_ActionがNULL："+attack_action);
        }

        if(enemy_current_hp == null) {
            enemy_current_hp = enemy_dto.getHp();
            System.out.println("えねみーNULL表示されています!！" + enemy_current_hp);
        }

        if(hero_current_hp == null) {
            hero_current_hp = hero_dto.getHp();
            System.out.println("ヒーローNULL表示されています" + hero_current_hp);
        }

        if(battle4_start == null) {
            battle4_start = "開始中";
            System.out.println("battle開始中です。");
        }

        if(recovery == null) {
            recovery = "aa";
            System.out.println("回復はしません");
        }

        if(attack_action.equals("攻撃")) {

            if(enemy_current_hp > 0 && hero_current_hp > 0) {

                if(hero_speed > enemy_speed) {

                    System.out.println("ヒーローが先に攻撃");
                    //ヒーロー先に攻撃
                    enemy_current_hp = hp_calc.enemy_hp_calc(hero_attack,enemy_current_hp);
                    if(enemy_current_hp <=0) {
                        enemy_current_hp = 0;
                        //message = hero_name+"は"+ enemy_name +"とのバトルに勝利しました!!!";
                        message = meigen.meigen_battle_finish(hero_name, enemy_name);
                        message2 = exp_table.exp_update(id, stage,hero_name);
                        exp.exp(id);
                        System.out.println(message+":"+message2);
                        request.setAttribute("message",message);
                        request.setAttribute("message2",message2);
                        request.getSession().setAttribute("stage5_unlocked", true);


                    }else if(hero_current_hp <= 0) {
                        hero_current_hp = 0;
                        //message = hero_name+"は"+ enemy_name +"とのバトルに敗れました!";
                        message = meigen.meigen_battle_finish2(enemy_name, hero_name);
                        System.out.println(message);
                        request.setAttribute("message",message);
                        request.setAttribute("message2",message2);
                    }
                    else {
                        hero_current_hp = hp_calc.hero_hp_calc(enemy_attack, hero_current_hp);
                        message = meigen.meigen_hero_damage(hero_name, hero_attack);
                        message2 = meigen.meigen_enemy_damage(enemy_name, enemy_attack);
                        System.out.println(message);
                        System.out.println(message2);
                        request.setAttribute("message",message);
                        request.setAttribute("message2",message2);

                    }

                }else if(hero_speed < enemy_speed){
                  //エネミー先に攻撃
                    System.out.println("エネミーが先に攻撃");
                    hero_current_hp = hp_calc.hero_hp_calc(enemy_attack, hero_current_hp);
                    if(enemy_current_hp <=0) {
                        enemy_current_hp = 0;
                        //message = hero_name+"は"+ enemy_name +"とのバトルに勝利しました!!!";
                        message = meigen.meigen_battle_finish(hero_name, enemy_name);
                        message2 = exp_table.exp_update(id, stage,hero_name);
                        exp.exp(id);                        System.out.println(message+":"+message2);
                        request.setAttribute("message",message);
                        request.setAttribute("message2",message2);
                        request.getSession().setAttribute("stage5_unlocked", true);


                    }else if(hero_current_hp <= 0) {
                        hero_current_hp = 0;
                        //message = hero_name+"は"+ enemy_name +"とのバトルに敗れました!";
                        message = meigen.meigen_battle_finish2(enemy_name, hero_name);
                        System.out.println(message);
                        request.setAttribute("message",message);
                        request.setAttribute("message2",message2);
                    }
                    else {
                        enemy_current_hp = hp_calc.enemy_hp_calc(hero_attack,enemy_current_hp);
                        message = meigen.meigen_hero_damage(hero_name, hero_attack);
                        message2 = meigen.meigen_enemy_damage(enemy_name, enemy_attack);
                        System.out.println(message);
                        System.out.println(message2);
                        request.setAttribute("message",message);
                        request.setAttribute("message2",message2);
                    }

                }else {
                    //スピードが同じのため、ランダムで5以下の場合ヒーローが先に攻撃。6以上の場合エネミーが先に攻撃。
                    Random rand = new Random();
                    int speed_ave = rand.nextInt(10)+1;

                    if(speed_ave <= 5) {
                      //ヒーロー先に攻撃
                        System.out.println("ヒーローが先に攻撃");
                        enemy_current_hp = hp_calc.enemy_hp_calc(hero_attack,enemy_current_hp);
                        if(enemy_current_hp <=0) {
                            enemy_current_hp = 0;
                            //message = hero_name+"は"+ enemy_name +"とのバトルに勝利しました!!!";
                            message = meigen.meigen_battle_finish(hero_name, enemy_name);
                            message2 = exp_table.exp_update(id, stage,hero_name);
                            exp.exp(id);
                            System.out.println(message+":"+message2);
                            request.setAttribute("message",message);
                            request.setAttribute("message2",message2);
                            request.getSession().setAttribute("stage5_unlocked", true);


                        }else if(hero_current_hp <= 0) {
                            hero_current_hp = 0;
                            //message = hero_name+"は"+ enemy_name +"とのバトルに敗れました!";
                            message = meigen.meigen_battle_finish2(enemy_name, hero_name);
                            System.out.println(message);
                            request.setAttribute("message",message);
                            request.setAttribute("message2",message2);
                        }
                        else {
                            hero_current_hp = hp_calc.hero_hp_calc(enemy_attack, hero_current_hp);
                            message = meigen.meigen_hero_damage(hero_name, hero_attack);
                            message2 = meigen.meigen_enemy_damage(enemy_name, enemy_attack);
                            System.out.println(message);
                            System.out.println(message2);
                            request.setAttribute("message",message);
                            request.setAttribute("message2",message2);

                        }
                    }else {
                      //エネミー先に攻撃
                        System.out.println("エネミーが先に攻撃");
                        hero_current_hp = hp_calc.hero_hp_calc(enemy_attack, hero_current_hp);
                        if(enemy_current_hp <=0) {
                            enemy_current_hp = 0;
                            //message = hero_name+"は"+ enemy_name +"とのバトルに勝利しました!!!";
                            message = meigen.meigen_battle_finish(hero_name, enemy_name);
                            message2 = exp_table.exp_update(id, stage,hero_name);
                            exp.exp(id);
                            System.out.println(message+":"+message2);
                            request.setAttribute("message",message);
                            request.setAttribute("message2",message2);


                        }else if(hero_current_hp <= 0) {
                            hero_current_hp = 0;
                            //message = hero_name+"は"+ enemy_name +"とのバトルに敗れました!";
                            message = meigen.meigen_battle_finish2(enemy_name, hero_name);
                            System.out.println(message);
                            request.setAttribute("message",message);
                            request.setAttribute("message2",message2);
                        }
                        else {
                            enemy_current_hp = hp_calc.enemy_hp_calc(hero_attack,enemy_current_hp);
                            message = meigen.meigen_hero_damage(hero_name, hero_attack);
                            message2 = meigen.meigen_enemy_damage(enemy_name, enemy_attack);
                            System.out.println(message);
                            System.out.println(message2);
                            request.setAttribute("message",message);
                            request.setAttribute("message2",message2);
                        }

                    }

                }


                //HP減少
//                enemy_current_hp = hp_calc.enemy_hp_calc(hero_attack,enemy_current_hp);
//
//                hero_current_hp = hp_calc.hero_hp_calc(enemy_attack, hero_current_hp);

                //enemy_current_hp = enemy_current_hp  - attack;


                System.out.println(hero_name);
                System.out.println(hero_attack);
                System.out.println(enemy_hp);

                System.out.println(hero_hp);

                request.getSession().setAttribute("enemy_current_hp",enemy_current_hp);
                request.getSession().setAttribute("hero_current_hp",hero_current_hp);

            }else {
              //HP減少


                if(enemy_current_hp <= 0 && hero_current_hp > 0) {
                    enemy_current_hp = 0;
                    //message = hero_name+"は"+ enemy_name +"とのバトルに勝利しました!!";
                    message = meigen.meigen_battle_finish(hero_name, enemy_name);
                    System.out.println(message);
                    message2 = exp_table.exp_update(id, stage,hero_name);
                    exp.exp(id);
                    request.setAttribute("message",message);
                    request.setAttribute("message2", message2);
                }else {
                    hero_current_hp = 0;
                    //message = hero_name+"は"+ enemy_name +"とのバトルに敗れました!";
                    message = meigen.meigen_battle_finish2(enemy_name, hero_name);
                    System.out.println(message);
                    request.setAttribute("message",message);
                    request.setAttribute("message2", message2);
                }

                request.getSession().setAttribute("hero_current_hp",hero_current_hp);
                request.getSession().setAttribute("enemy_current_hp",enemy_current_hp);


                request.setAttribute("message",message);
                request.setAttribute("message2",message2);
                //System.out.println(message);

            }


        }
        //回復処理
        else if(recovery.equals("回復")) {
            hero_current_hp = hero.recovery(hero_current_hp);
            System.out.println("回復しました");
            System.out.println("回復後HP：" +hero_current_hp);
            //エネミーの攻撃
            hero_current_hp = hp_calc.hero_hp_calc(enemy_attack, hero_current_hp);
            System.out.println("ダメージ後HP:"+hero_current_hp);
            if(enemy_current_hp <=0) {
                enemy_current_hp = 0;
                //message = hero_name+"は"+ enemy_name +"とのバトルに勝利しました!!!";
                message = meigen.meigen_battle_finish(hero_name, enemy_name);
                message2 = exp_table.exp_update(id, stage,hero_name);
                exp.exp(id);
                System.out.println(message);
                request.setAttribute("message",message);
                request.setAttribute("message2",message2);


            }else if(hero_current_hp <= 0) {
                hero_current_hp = 0;
                //message = hero_name+"は"+ enemy_name +"とのバトルに敗れました!";
                message = meigen.meigen_battle_finish2(enemy_name, hero_name);
                System.out.println(message);
                request.setAttribute("message",message);
                request.setAttribute("message2",message2);
            }
            else {
                message =  "ヒーローのHPが30回復しました。";
                message2 = meigen.meigen_enemy_damage(enemy_name, enemy_attack);
                System.out.println(message);
                System.out.println(message2);
                request.setAttribute("message",message);
                request.setAttribute("message2",message2);
            }
            request.getSession().setAttribute("enemy_current_hp",enemy_current_hp);
            request.getSession().setAttribute("hero_current_hp",hero_current_hp);

        }

        else  {
            if(battle4_start.equals("battle4")) {
                enemy_current_hp = enemy_dto.getHp();
                hero_current_hp = hero_dto.getHp();
                //request.getSession().setAttribute("enemy_current_hp",enemy_current_hp);
                System.out.println("バトル1が開始されました(初期状態2)");
            }

            enemy_current_hp = enemy_dto.getHp();
            hero_current_hp = hero_dto.getHp();
            System.out.println("Enemy_enemy_current_hp:" +enemy_current_hp);
            System.out.println("Hero_current_hp:" +hero_current_hp);


            request.getSession().setAttribute("enemy_current_hp",enemy_current_hp);
            request.getSession().setAttribute("hero_current_hp",hero_current_hp);


            //message ="野生の"+enemy_dto.getName()+"が現れました!!";
            message = meigen.meigen_battle_start(enemy_name, 4);

            request.setAttribute("message",message);
            request.setAttribute("message2", message2);
            System.out.println(message);

        }

        RequestDispatcher rd = request.getRequestDispatcher("/views4/battle4.jsp");
        rd.forward(request, response);

    }

}