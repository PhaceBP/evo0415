package hu.evosoft.javasetraining.generics;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AccountRepository accRepo = new DefaultAccountRepository();
		
		accRepo.save(new Account());
	}

}
