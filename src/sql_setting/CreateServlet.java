package sql_setting;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.DTO;
import utils.DBUtils;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtils.createEntityManager();
            em.getTransaction().begin();

            DTO d = new DTO();

            String content = request.getParameter("content");
            d.setName(content);

            int Level = 0;
            d.setLevel(Level);
            int attack =0;
            d.setAttack_value(attack);

            em.persist(d);
            em.getTransaction().commit();
            request.getSession().setAttribute("flush", "登録が完了しました。");       // ここを追記
            em.close();

            response.sendRedirect(request.getContextPath() + "/main");
        }
    }

}