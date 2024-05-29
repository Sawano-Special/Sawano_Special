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
//    	for(int i=1;i<=meigen.stageselect1().length;i++) {
//      	  String stage = meigen.stageselect1()[i-1];
//      	  System.out.println(stage);
//
//        }
//        System.out.println("aaaaaaaaa");
//        String[] message = meigen.stageselect1();
//        //request.setAttribute("message",message);
//        Gson gson = new Gson();
//        String jsonArray = gson.toJson(message);
//        response.setContentType("application/json");
//        response.getWriter().write(jsonArray);
    	String[] message = meigen.stageselect1();
    	//String message = "やぁ！";
      //request.setAttribute("message",message);
      String attack_action = request.getParameter("attack");
      System.out.println("attack_action:");
      System.out.print(attack_action);
      if(attack_action==null){
    	  System.out.println("ボタンif文前");
    	  if(i<=message.length) {
    		  System.out.println("ボタンif文中");
    	  message2 = message[i];
    	  System.out.println("message2"+message2);
    	  request.setAttribute("message2",message2);
    	  i++;
    	  System.out.println(i);
    	  }

      }else{
    	  message2 = "よぁ";
      }
        RequestDispatcher rd = request.getRequestDispatcher("/layout/app.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String[] message = meigen.stageselect1();
    	//String message = "やぁ！";
      //request.setAttribute("message",message);
      String attack_action = request.getParameter("attack");
      System.out.println("attack_action:");
      System.out.print(attack_action);
      if(attack_action==null){
    	  System.out.println("ボタンif文前");
    	  if(i<=message.length) {
    		  System.out.println("ボタンif文中");
    	  message2 = message[i];
    	  System.out.println("message2"+message2);
    	  request.setAttribute("message2",message2);
    	  i++;
    	  System.out.println(i);
    	  }

      }else{
    	  message2 = "よぁ";
      }
      RequestDispatcher rd = request.getRequestDispatcher("/layout/app.jsp");
      rd.forward(request, response);
//      Gson gson = new Gson();
//      String jsonArray = gson.toJson(message);
//      response.setContentType("application/json");
//      response.getWriter().write(jsonArray);



      }



}
