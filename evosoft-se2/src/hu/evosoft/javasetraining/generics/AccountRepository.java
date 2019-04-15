package hu.evosoft.javasetraining.generics;


public interface AccountRepository extends CrudRepository<Long,Account> {
	
	Account findByAccountName(String accountName);
}
