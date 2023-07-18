package orders.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/plain; charset=utf-8");

		MainOrder test = new MainOrder();
		OrderService orderService = new OrderServiceImpl();

		String memberId = "M" + String.format("%09d", (int) Math.random() * 16 + 1);
		Integer totalAmount = (int) Math.random() * 10000000 +10000;
		Integer totalGrossProfit = (int) (totalAmount * 0.15) +1;
		Integer pointsDiscount = (int) Math.random() * 10000 +1;
		Integer couponDiscount = (int) Math.random() * 5000 +1;
		Integer paidAmount = totalAmount - pointsDiscount - couponDiscount;
		String paymentType = "1";
		String recipient = "王小明";
		String phoneNum = "0912-123-456";
		String deliveryAddress = "104 台北市 中山區 南京東路三段219號5樓";

		test.setMemberId(memberId);
		test.setTotalAmount(totalAmount);
		test.setTotalGrossProfit(totalGrossProfit);
		test.setPointsDiscount(pointsDiscount);
		test.setCouponDiscount(couponDiscount);
		test.setPaidAmount(paidAmount);
		test.setPaymentType(paymentType);
		test.setRecipient(recipient);
		test.setPhoneNum(phoneNum);
		test.setDeliveryAddress(deliveryAddress);
		
		boolean state = orderService.createOrder(test);

		if (state == true) {

			System.out.println("成功");
			PrintWriter out = resp.getWriter();
			out.print("訂單成立！！");
		}

	}

}
