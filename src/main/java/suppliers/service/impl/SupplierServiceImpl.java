package suppliers.service.impl;

import suppliers.dao.impl.SupplierDAOImpl;
import suppliers.service.SupplierService;

public class SupplierServiceImpl implements SupplierService {

	SupplierDAOImpl dao;
	
	public SupplierServiceImpl(){
		dao = new SupplierDAOImpl();
	}
	
	@Override
	public String getAllInit() {
		
		String getAllInit = null;
		
		try {
			beginTransaction();
			getAllInit = dao.getAllInit();
			commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return getAllInit;
	}

}
