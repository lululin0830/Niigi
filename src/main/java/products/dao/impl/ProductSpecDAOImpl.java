package products.dao.impl;

import java.util.List;

import products.dao.ProductSpecDAO;
import products.entity.ProductSpec;

public class ProductSpecDAOImpl implements ProductSpecDAO {

	@Override
	public Boolean insert(ProductSpec entity) throws Exception {
		return null;
	}

	@Override
	public ProductSpec selectById(String id) throws Exception {
		return getSession().get(ProductSpec.class, id);
	}

	@Override
	public List<ProductSpec> getAll() throws Exception {
		return null;
	}

	@Override
	public ProductSpec update(ProductSpec newProductSpec) {
		return null;
	}

}
