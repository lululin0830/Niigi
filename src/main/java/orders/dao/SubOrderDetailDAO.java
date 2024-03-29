package orders.dao;

import java.sql.Date;

import core.dao.CoreDAO;
import orders.entity.SubOrderDetail;


public interface SubOrderDetailDAO extends CoreDAO<SubOrderDetail, String>{
	
	//更新評價
	public void upadte_rate(SubOrderDetail SubOrderDetail); 	
	
	//更新退貨期限
	public void upadte_refundline(Date refundDeadline);	
	
	//更新退貨事件(退貨日期、退貨原因、備註)
	public void update_refund(SubOrderDetail SubOrderDetail);	
	
	//更新商品狀態
	public void item_status(String itemStatus);
		
	public void delete(SubOrderDetail SubOrderDetail);
	
	
}
