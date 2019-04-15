package hu.evosoft.javasetraining.di.container;

public class BeanDefinition {

	private String classFqdn;
	
	private String id;
	
	private Scope scope;

	public String getClassFqdn() {
		return classFqdn;
	}

	public void setClassFqdn(String classFqdn) {
		this.classFqdn = classFqdn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Scope getScope() {
		return scope;
	}

	public void setScope(Scope scope) {
		this.scope = scope;
	}
	
	
}
