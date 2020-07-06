import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class KnapsackGreedy extends Knapsack {

	public KnapsackGreedy(int capacity, Collection<Item> candidates) {
		super(capacity, candidates);
	}

	@Override
	public Selection pack() {
		Selection select = new Selection();
		Selection test = new Selection();
		Collections.sort(candidates, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				return o1.getValue()-o2.getValue();
			}
		});
		Collections.reverse(candidates);
		while(capacity!=0){
			if(capacity>=30){
				select = new Selection(test, candidates.get(1));
				capacity=capacity-30;
			}else if(capacity<30 && capacity>= 5){
				select = new Selection(select, candidates.get(2));
				capacity=capacity-5;
			}else if(capacity<5 && capacity>=1){
				select = new Selection(select, candidates.get(0));
				capacity=capacity-1;
			}
		}
		return new Selection(select);
	}
}
