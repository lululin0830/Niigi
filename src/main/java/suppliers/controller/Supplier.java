package suppliers.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import orders.service.OrderService;
import suppliers.service.SupplierService;
import suppliers.service.impl.SupplierServiceImpl;

/**
 * Servlet implementation class Supplier
 */
@WebServlet("/Supplier")
public class Supplier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
		resp.setHeader("Access-Control-Allow-Credentials", "true");
		resp.setContentType("application/json; charset=utf-8");
		resp.setStatus(HttpServletResponse.SC_OK);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setContentType("application/json; charset=utf-8");
				
		SupplierService supplierService = new SupplierServiceImpl();				
		response.getWriter().print(supplierService.getAllInit());			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setContentType("application/json; charset=utf-8");
		
		Gson gson = new Gson();
		JsonElement req = gson.fromJson(request.getReader(),JsonElement.class);
		JsonObject searchCondition = req.getAsJsonObject();	

		SupplierService supplierService = new SupplierServiceImpl();
		
		response.getWriter().print(supplierService.getBySearch(searchCondition));
		System.out.println((supplierService.getBySearch(searchCondition)));
	}

}
