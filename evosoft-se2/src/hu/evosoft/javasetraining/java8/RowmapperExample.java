package hu.evosoft.javasetraining.java8;

public class RowmapperExample {

	public static void main(String[] args) {

		Rowmapper<String, Integer> mapper = (s) -> {
			return Integer.parseInt(s);
		};

		System.out.println(mapper.map("1"));

	}
}
