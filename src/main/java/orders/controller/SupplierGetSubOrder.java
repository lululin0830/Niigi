package orders.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import orders.dao.impl.SubOrderDAOImpl;
import orders.service.OrderService;
import orders.service.impl.OrderServiceImpl;
/**
 * Servlet implementation class SubOrder
 */
@WebServlet("/SubOrder")
public class SupplierGetSubOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Access-Control-Allow-Origin", "*"); // 允許來自所有網域的請求
		response.setHeader("Access-Control-Allow-Methods", "GET"); // 允許的 HTTP 方法
		response.setHeader("Access-Control-Allow-Headers", "Content-Type"); // 允許的請求Header
		response.setHeader("Access-Control-Allow-Credentials", "true"); // 是否允許帶有憑證的請求
		response.setContentType("application/json; charset=utf-8");		
		
		OrderService orderService = new OrderServiceImpl();
		response.getWriter().print(orderService.getSupplierSubOrderInit(""));
		
	}

}
