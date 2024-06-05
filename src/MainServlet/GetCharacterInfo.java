package MainServlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import DTO.DTO;
import DTO.enemy;
import battle_controller.hp_calc;
import test.CharacterInfo;
import test.Hero;
import test.meigen;
import test.test_Enemy;
import utils.DBUtils;

@WebServlet("/GetCharacterInfo")
public class GetCharacterInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    int id = 1;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String selectedValueStr = request.getParameter("hero_info");
        System.out.println(selectedValueStr);



        request.setAttribute("hero_info", id);

        EntityManager em = DBUtils.createEntityManager();

        DTO hero_dto = em.find(DTO.class, id);


        Hero hero = new Hero(hero_dto.getId(), hero_dto.getName(), hero_dto.getLevel(), hero_dto.getDefence(),
                hero_dto.getSpeed(), hero_dto.getFinish_word(), hero_dto.getAttack_value(), hero_dto.getHp(),
                hero_dto.getMax_hp());

        // response.getWriter().append("Served at: ").append(request.getContextPath());

        int hero_attack = hero.attack();
        int hero_speed = hero_dto.getSpeed();
        int hero_hp = hero_dto.getHp();
        int hero_level = hero_dto.getLevel();

        System.out.println(hero_attack);
        System.out.println(hero_speed);
        System.out.println(hero_hp);
        System.out.println(hero_level);

        request.setAttribute("hero_attack:", hero_attack);
        request.setAttribute("hero_speed:", hero_speed);
        request.setAttribute("hero_hp:", hero_hp);
        request.setAttribute("hero_level:", hero_level);

        RequestDispatcher rd = request.getRequestDispatcher("/hero_inf/hero_info.jsp");
        rd.forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String characterId = request.getParameter("id");
        CharacterInfo.Character character = CharacterInfo.getCharacter(characterId);

        if (character != null) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getWriter(), character);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "キャラクターが見つかりません");
        }
    }
}