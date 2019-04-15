package hu.evosoft.javasetraining.di;

import hu.evosoft.javasetraining.di.container.Inject;

public class B implements IB {

	@Inject
	private C cInstance;

	public C getcInstance() {
		
		return cInstance;
	}

	public void setcInstance(C cInstance) {
		this.cInstance = cInstance;
	}

}
