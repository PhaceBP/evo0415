package hu.evosoft.javasetraining.generics;

import java.io.Serializable;
import java.util.List;

public interface CrudRepository<ID extends Serializable, T extends BusinessObject<ID> & Serializable> {

	void save(T object);

	void update(T object);

	void delete(ID id);

	T get(ID id);

	List<T> getAll();
}
