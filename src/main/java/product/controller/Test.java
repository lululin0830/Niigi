package product.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.dao.ProductDAO;
import product.dao.ProductSpecDAO;
import product.dao.impl.ProductDAOImpl;
import product.dao.impl.ProductSpecDAOImpl;
import product.entity.Product;
import product.entity.ProductSpec;
import product.service.ProductService;
import product.service.impl.ProductServiceImpl;

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
