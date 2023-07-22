package products.dao;

import java.sql.Timestamp;

import core.dao.CoreDAO;
import products.entity.SortWeight;

public interface SortWeightDAO extends CoreDAO<SortWeight,Timestamp> {
	
	//找出最新的異動
	Timestamp findLatestDate();

}