package order.dao;

import java.sql.Date;

import order.entity.SubOrderDetail;

public interface SubOrderDetailDAO {
	
	public void insert(SubOrderDetail SubOrderDetail);
	
	//更新評價
	public void upadte_rate(SubOrderDetail SubOrderDetail); 	
	
	//更新退貨期限
	public void upadte_refundline(Date refundDeadline);	
	
	//更新退貨事件(退貨日期、退貨原因、備註)
	public void update_refund(SubOrderDetail SubOrderDetail);	
	
	//更新商品狀態
	public void item_status(String itemStatus);
		
	public void delete(SubOrderDetail SubOrderDetail);
	
	public void getAll(SubOrderDetail SubOrderDetail);
	
	//以PK查詢(PK:訂單明細編號)
	public void getByPrimaryKey(String orderDetailId);
}
