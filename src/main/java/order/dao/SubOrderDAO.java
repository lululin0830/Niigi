package order.dao;

import java.sql.Timestamp;
import java.util.List;

import order.entity.SubOrder;

public interface SubOrderDAO {
	public void insert(SubOrder SubOrder);
    public void updateOrderCloseTime(SubOrder SubOrder);
    public void updateSubOrderStatus(SubOrder SubOrder);
    public void updateGrantStatus(SubOrder SubOrder);
    public void updateGrantDate(SubOrder SubOrder);
    public void delete(String SubOrder);
    public SubOrder getsubOrderId(String SubOrder);
    public SubOrder getByPrimaryKey(String SubOrder);
    public SubOrder getBymemberId(String SubOrder);
    public SubOrder getBysupplierId(String SubOrder);
    public SubOrder getByorderCreateTime(Timestamp SubOrder1,Timestamp SubOrder2);
    public SubOrder getByorderCloseTime(Timestamp SubOrder1,Timestamp SubOrder2);
    public List<SubOrder> getAll();
}
