package hu.evosoft.javasetraining.generics;

import java.util.Optional;

public class DefaultAccountRepository extends AbstractInMemoryCrudRepository<Long, Account>
		implements AccountRepository {

	@Override
	public Account findByAccountName(String accountName) {

		Optional<Account> opt = objects.values().stream().filter(a -> a.getAccountName().equalsIgnoreCase(accountName))
				.findFirst();

		if (opt.isEmpty()) {
			throw new IllegalArgumentException("Account not found!");
		}

		return opt.get();
	}
}
