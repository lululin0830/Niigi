package products.dao;

import core.dao.CoreDAO;
import products.entity.ProductSpec;

public interface ProductSpecDAO extends CoreDAO<ProductSpec, String> {

	// 萬用更新
	public ProductSpec update(ProductSpec newProductSpec);

}
