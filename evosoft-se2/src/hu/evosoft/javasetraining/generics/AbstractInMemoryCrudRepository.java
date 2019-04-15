package hu.evosoft.javasetraining.generics;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractInMemoryCrudRepository<ID extends Serializable, T extends BusinessObject<ID>>
		implements CrudRepository<ID, T> {

	protected Map<ID, T> objects = new HashMap<>();

	@Override
	public void save(T object) {

		objects.put(object.getId(), object);

	}

	@Override
	public void update(T object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
