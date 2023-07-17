package order.dao.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.mysql.cj.xdevapi.SessionFactory;

import order.dao.SubOrderDAO;
import order.entity.SubOrder;

public class SubOrderDAOImpl implements SubOrderDAO {

	@Override
	public Boolean insert(SubOrder entity) throws Exception {
		getSession().persist(entity);
		return true;
	}

	@Override
	public SubOrder selectById(String id) throws Exception {

//		Session session = getSession();
//		SubOrder subOrder = session.get(SubOrder.class, id);
		return getSession().get(SubOrder.class, id);
	}

	@Override
	public List<SubOrder> getAll() throws Exception {

		Session session = getSession();
		Query<SubOrder> query = session.createQuery("FROM SubOrder", SubOrder.class);
		return query.getResultList();
	}

	@Override
	public SubOrder update(SubOrder newSubOrder) throws Exception {
		Session session = getSession();
		SubOrder subOrder = session.get(SubOrder.class, newSubOrder.getSubOrderId());

		final Timestamp orderCloseTime = newSubOrder.getOrderCloseTime();
		final String subOrderStatus = newSubOrder.getSubOrderStatus();
		final String grantStatus = newSubOrder.getGrantStatus();
		final Date grantDate = newSubOrder.getGrantDate();

		if (orderCloseTime != null && !(orderCloseTime.toString().isBlank())) {
			subOrder.setOrderCloseTime(orderCloseTime);
		}
		if (subOrderStatus != null && !(subOrderStatus.isBlank())) {
			subOrder.setSubOrderStatus(subOrderStatus);
		}
		if (grantStatus != null && !(grantStatus.isBlank())) {
			subOrder.setGrantStatus(grantStatus);
		}
		if (grantDate != null && !(grantDate.toString().isBlank())) {
			subOrder.setGrantDate(grantDate);
		}

		return subOrder;
	}

	@Override
	public List<SubOrder> getAllByOrderId(String searchcase, String SearchSelect, Timestamp startDate, Timestamp closeDate,
			String dateSelect) throws Exception {
		String hql = "FROM SubOrder where " + SearchSelect + " like '%" + searchcase + "%'" ;
		Session session = getSession();
		
		Query<SubOrder> query = session.createQuery(hql,SubOrder.class);
		List<SubOrder> list= query.getResultList();	
		System.out.println("我走到查詢結果了");
		return list;
		
		
		
	}

}
