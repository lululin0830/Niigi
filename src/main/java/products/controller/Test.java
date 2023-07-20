package products.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import products.dao.ProductDAO;
import products.dao.ProductSpecDAO;
import products.dao.impl.ProductDAOImpl;
import products.dao.impl.ProductSpecDAOImpl;
import products.entity.Product;
import products.entity.ProductSpec;
import products.service.ProductService;
import products.service.impl.ProductServiceImpl;

@WebServlet("/Test01")
public class Test extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8199356609082890875L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		ProductService service = new ProductServiceImpl();
		
		ProductDAO dao1 = new ProductDAOImpl();
		ProductSpecDAO dao2 = new ProductSpecDAOImpl();
		
		try {
			
			service.beginTransaction();
			
			Product product = dao1.selectById(10000001);
			ProductSpec productSpec = dao2.selectById("10000001001");
			
			System.out.println(product);
			System.out.println(productSpec);
			
			
			service.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
