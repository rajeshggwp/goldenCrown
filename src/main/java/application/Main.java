package application;

import java.util.HashSet;
import java.util.Set;

import analyzer.RulerFinder;
import model.InputProvider;
import model.Ruler;
import result.ResultCreator;

/**
 * This is where the magic happens!
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Input Messages to kingdoms from King Shan:");
		System.out.println("Format:");
		System.out.println("kingdom name, secret message");
		System.out.println("Press Enter twice to stop providing input");
		Set<InputProvider> userInput = new InputGatherer().gather();
		Ruler kingShan = new Ruler(false, "King Shan", new HashSet<>());
		kingShan = new RulerFinder().find(userInput, kingShan);
		new ResultCreator().create(kingShan);
	}

}
