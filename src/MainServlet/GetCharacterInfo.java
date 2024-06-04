package MainServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import test.CharacterInfo;

@WebServlet("/GetCharacterInfo")
public class GetCharacterInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;

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