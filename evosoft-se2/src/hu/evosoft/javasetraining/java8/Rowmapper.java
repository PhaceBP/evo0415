package hu.evosoft.javasetraining.java8;

@FunctionalInterface
public interface Rowmapper<S, T> {

	T map(S object);

}
