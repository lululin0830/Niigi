package suppliers.service;

import com.google.gson.JsonObject;

import core.service.CoreService;

public interface SupplierService extends CoreService{
	
	public String getAllInit();
	
	public String getBySearch(JsonObject searchCondition);

}
