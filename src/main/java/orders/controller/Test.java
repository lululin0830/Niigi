package orders.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import orders.dao.MainOrderDAO;
import orders.dao.impl.MainOrderDAOImpl;
import orders.dao.impl.SubOrderDAOImpl;
import orders.entity.MainOrder;
import orders.service.OrderService;
import orders.service.impl.OrderServiceImpl;

@WebServlet("/Test")
public class Test extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		MainOrderDAO dao = new MainOrderDAOImpl();
		OrderService service = new OrderServiceImpl();
		
		try {
			
			service.beginTransaction();
			
			MainOrder test = dao.selectById("20230715000000001");
			System.out.println(test);
			
			service.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
