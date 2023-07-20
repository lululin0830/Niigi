package suppliers.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.google.gson.Gson;

import core.util.HibernateUtil;
import suppliers.dao.SupplierDAO;
import suppliers.entity.Supplier;

public class SupplierDAOImpl implements SupplierDAO{
	

	@Override
	public Boolean insert(Supplier entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier selectById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplier> getAll() throws Exception {
		return null;
		
		
	}

	@Override
	public String getAllBySearch(String searchCase, String searchSelect, Timestamp startDate, Timestamp closeDate,
			String dateSelect) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllInit() {
		
		Session session = getSession();		
		Gson gson = new Gson();
		
		String result = gson.toJson(session.createQuery("FROM Supplier", Supplier.class).getResultList());
		
		return result;
	}
	
	

}
