package orders.dao;

import java.util.List;

import core.dao.CoreDAO;
import orders.entity.MainOrder;

public interface MainOrderDAO extends CoreDAO<MainOrder, String> {

	public MainOrder update(MainOrder newMainOrder);

	public List<MainOrder> selectByMemberID(String memberId);

}
