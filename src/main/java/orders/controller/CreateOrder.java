package orders.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import lombok.experimental.var;
import orders.dao.MainOrderDAO;
import orders.dao.impl.MainOrderDAOImpl;
import orders.entity.MainOrder;
import orders.service.OrderService;
import orders.service.impl.OrderServiceImpl;

@WebServlet("/CreateOrder")
public class CreateOrder extends HttpServlet {

	/**
	 * 成立訂單(2023-07-15 v1)
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
		resp.setHeader("Access-Control-Allow-Credentials", "true");
		resp.setContentType("application/json; charset=utf-8");
		resp.setStatus(HttpServletResponse.SC_OK);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "POST");
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
		resp.setHeader("Access-Control-Allow-Credentials", "true");
		resp.setContentType("application/json; charset=utf-8");

		Gson gson = new Gson();
		JsonObject orderData = gson.fromJson(req.getReader(), JsonObject.class);

		OrderService orderService = new OrderServiceImpl();

		boolean state = orderService.createOrder(orderData);

		PrintWriter out = resp.getWriter();
		if (state == true) {
			System.out.println("成功");
			out.print("訂單成立！！");
		} else {
			System.out.println("失敗");
			out.print("系統忙碌中");
		}

	}

}
