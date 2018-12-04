package goldenCrown;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import analyzer.RulerFinder;
import model.InputProvider;
import model.Kingdom;
import model.Ruler;

public class RulerFinderTest {

	private static RulerFinder finder;
	private static Set<InputProvider> input;

	@BeforeClass
	public static void setup() {
		finder = new RulerFinder();
	}

	private Ruler ruler;

	@Before
	public void inputSetup() {
		input = new HashSet<>();
		input.add(new InputProvider(Kingdom.AIR, "OWLAAAA"));
		input.add(new InputProvider(Kingdom.FIRE, "DQRAWGUOJN"));
		input.add(new InputProvider(Kingdom.LAND, "ANDPA"));
		ruler = new Ruler(false, "King Shan", new HashSet<>());
	}

	@Test
	public void testFindWhenBothInputIsNull() {
		Ruler testRuler = finder.find(null, null);
		Assert.assertNull(testRuler);
	}

	@Test
	public void testFindWhenInputContainsNull() {
		input.add(null);
		Ruler testRuler = finder.find(input, ruler);
		Assert.assertEquals(testRuler.isRule(), true);
	}

	@Test
	public void testFindWhenInputHasInsufficientSupporters() {
		input.clear();
		input.add(new InputProvider(Kingdom.AIR, "OWLAAAA"));
		input.add(new InputProvider(Kingdom.FIRE, "DQRAWGUOJN"));
		input.add(new InputProvider(Kingdom.LAND, "DQRAWGUOJN"));
		Ruler testRuler = finder.find(input, ruler);
		Assert.assertEquals(testRuler.isRule(), false);
	}

	@Test
	public void testFindWhenInputHasWrongMessage() {
		input.clear();
		input.add(new InputProvider(Kingdom.AIR, "OWLAAAA"));
		input.add(new InputProvider(Kingdom.FIRE, "DQRAWGUOJN"));
		Ruler testRuler = finder.find(input, ruler);
		Assert.assertEquals(testRuler.isRule(), false);
	}

	@Test
	public void testFindWhenInputIsNull() {
		Ruler testRuler = finder.find(null, ruler);
		Assert.assertEquals(testRuler, ruler);
	}

	@Test
	public void testFindWhenInputIsValid() {
		Ruler testRuler = finder.find(input, ruler);
		Assert.assertEquals(testRuler.isRule(), true);
	}
}
