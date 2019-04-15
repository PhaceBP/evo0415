package hu.evosoft.javasetraining.di;

import hu.evosoft.javasetraining.di.container.Inject;

public class A extends ParentA {

	@Inject
	private B instance;

	public IB getInstance() {
		return instance;
	}

}
