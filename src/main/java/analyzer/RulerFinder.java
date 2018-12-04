package analyzer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import model.InputProvider;
import model.Kingdom;
import model.Ruler;

public class RulerFinder {

	private void buildAnimalMap(Map<Character, Integer> animalMap, char[] animal) {
		for (char c : animal) {
			Character character = Character.valueOf(c);
			Integer value = animalMap.putIfAbsent(character, 1);
			if (value != null) {
				animalMap.put(character, value + 1);
			}
		}
	}

	public Ruler find(Set<InputProvider> userInput, Ruler kingShan) {
		if (userInput == null || userInput.isEmpty() || kingShan == null) {
			return kingShan;
		}
		Iterator<InputProvider> iterator = userInput.iterator();
		while (iterator.hasNext()) {
			InputProvider input = iterator.next();
			if (input == null) {
				continue;
			}
			Kingdom kingdom = input.getKingdom();
			if (kingShan.getSupporters().contains(kingdom)) {
				continue;
			}
			String message = input.getMessage();
			char[] animal = kingdom.getAnimal().toCharArray();
			Map<Character, Integer> animalMap = new HashMap<>();
			buildAnimalMap(animalMap, animal);
			for (char c : message.toCharArray()) {
				if (animalMap.isEmpty()) {
					break;
				}
				Character character = Character.valueOf(c);
				if (animalMap.containsKey(character)) {
					Integer value = animalMap.get(character);
					if (value == 1) {
						animalMap.remove(character);
					} else {
						animalMap.replace(character, value - 1);
					}
				}
			}
			if (animalMap.isEmpty()) {
				kingShan.addSupporter(kingdom);
			}
		}
		if (kingShan.getSupporters().size() >= 3) {
			kingShan.setRule(true);
		}
		return kingShan;
	}

}
