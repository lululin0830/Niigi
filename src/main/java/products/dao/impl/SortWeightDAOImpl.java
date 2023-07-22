package products.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import products.dao.SortWeightDAO;
import products.entity.SortWeight;

public class SortWeightDAOImpl implements SortWeightDAO {
	
	@Override
	public Timestamp findLatestDate() {
	    Session session = getSession();
	    String hql = "SELECT MAX(s.weightsUpdateTime) FROM SortWeight s";
	    NativeQuery<Timestamp> nativequery = session.createNativeQuery(hql, Timestamp.class);
	    return nativequery.getSingleResult();
	}
	
	@Override
	public Boolean insert(SortWeight entity)throws Exception{
		getSession().persist(entity);
		return true;
	}
	
	@Override
	public SortWeight selectById(Timestamp id)throws Exception{
		return null;
	}
	
	@Override
	public List<SortWeight> getAll() throws Exception{
		return null;
	}
	

}
