package order.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import order.dao.impl.SubOrderDAOImpl;
import com.google.gson.Gson;
/**
 * Servlet implementation class SubOrder
 */
@WebServlet("/SubOrder")
public class SubOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SubOrderDAOImpl dao = new SubOrderDAOImpl();   
    private static final Gson gson = new Gson();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Access-Control-Allow-Origin", "*"); // 允許來自所有網域的請求
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // 允許的 HTTP 方法
		response.setHeader("Access-Control-Allow-Headers", "Content-Type"); // 允許的請求Header
		response.setHeader("Access-Control-Allow-Credentials", "true"); // 是否允許帶有憑證的請求
		response.setContentType("application/json; charset=utf-8");		
		
		var out = response.getWriter(); // 這裡的var 是 PrintWrite類別的意思
		String getsubOrderId = request.getParameter("getsubOrderId");
		try {
			out.print(gson.toJson(dao.selectById(getsubOrderId)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
