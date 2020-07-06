import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class KnapsackRecursive extends Knapsack {

	public KnapsackRecursive(int capacity, Collection<Item> candidates) {
		super(capacity, candidates);
	}

	@Override
	public Selection pack() {
		return new Selection();
	}

}

