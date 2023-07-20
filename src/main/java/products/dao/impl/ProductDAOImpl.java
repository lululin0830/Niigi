package products.dao.impl;

import java.util.List;

import products.dao.ProductDAO;
import products.entity.Product;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public Boolean insert(Product entity) throws Exception {
		getSession().persist(entity);
		return true ;
	}

	@Override
	public Product selectById(Integer id) throws Exception {
		return getSession().get(Product.class, id);
	}

	@Override
	public List<Product> getAll() throws Exception {
		return null;
	}

}
