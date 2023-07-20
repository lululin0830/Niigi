package products.dao;

import java.util.List;

import core.dao.CoreDAO;
import products.entity.Product;

public interface ProductDAO extends CoreDAO<Product, Integer> {

	// 萬用更新
	public Product update(Product newProduct);
	
	// 商家查詢商品(全部)
	public String selectBySupplier (String supplierId);
	
	// 前台查詢商品(關鍵字)
	public String selectByKeywords (String[] keywords);

	// 前台查詢商品(商品分類)
	public String selectByCategorie (String categorie);
	
	public List<String> getSupplierIdList (String productIds);
}
