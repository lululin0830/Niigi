package core.dao;

import java.util.List;

public interface CoreDAO<E, I> {

	Boolean insert(E entity);

	E getByPrimarryKey(I id);

	List<E> getAll();
}
