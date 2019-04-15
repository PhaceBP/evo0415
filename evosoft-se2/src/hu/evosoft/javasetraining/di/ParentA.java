package hu.evosoft.javasetraining.di;

import hu.evosoft.javasetraining.di.container.Inject;

public class ParentA {

	@Inject
	private D instanceD;

	public D getInstanceD() {
		return instanceD;
	}

	public void setInstanceD(D instanceD) {
		this.instanceD = instanceD;
	}
	
	
}
