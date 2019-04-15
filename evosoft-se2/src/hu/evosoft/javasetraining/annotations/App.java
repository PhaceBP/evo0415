package hu.evosoft.javasetraining.annotations;

public class App {

	public static void main(String[] args) {
		
		
		Task t = new Task();
		Todo[] todos = t.getClass().getAnnotationsByType(Todo.class);
	
		for(Todo todo : todos) {
			System.out.println("TODO> "+todo.level());
		}
		
	}

}
