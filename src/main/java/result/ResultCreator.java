package result;

import model.Ruler;

public class ResultCreator {

	public void create(Ruler kingShan) {
		System.out.println("Who is the ruler of Southeros?");
		if (kingShan.isRule()) {
			System.out.println(kingShan.getName());
		} else {
			System.out.println("None");
		}
		System.out.println("Allies of Ruler?");
		if (kingShan.isRule()) {
			kingShan.getSupporters().forEach(System.out::println);
		} else {
			System.out.println("None");
		}
	}

}
