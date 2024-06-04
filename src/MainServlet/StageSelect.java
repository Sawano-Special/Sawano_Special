package MainServlet;

import java.io.IOException;
import test.meigen;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DTO.DTO;
import test.Hero;
import utils.DBUtils;

/**
 * Servlet implementation class StageSelect
 */
@WebServlet("/StageSelect")
public class StageSelect extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StageSelect() {
        super();
        // TODO Auto-generated constructor stub
    }
    int i=1;
    String message2 = "やぁ";

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/layout/app.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // フォームから送信されたhero_infoの値を取得
        String heroInfo = request.getParameter("hero_info");

        // 取得したheroInfoの値をコンソールに出力（デバッグ用）
        System.out.println("選択されたID: " + heroInfo);

        // 取得したheroInfoの値をリクエスト属性に設定
        request.setAttribute("selectedHero", heroInfo);
        request.setAttribute("selectedHero2", heroInfo);
        request.setAttribute("selectedHero3", heroInfo);
        request.setAttribute("selectedHero4", heroInfo);
        request.setAttribute("selectedHero5", heroInfo);

        // stageselect1()メソッドの結果（例）をリクエスト属性に設定
        String[] message = meigen.stageselect1();
        request.setAttribute("message", message);

        // app.jspにフォワード
        RequestDispatcher rd = request.getRequestDispatcher("/layout/app.jsp");
        rd.forward(request, response);

        // 送信完了のメッセージをコンソールに出力
        System.out.println("送りました！！");
    }
}
