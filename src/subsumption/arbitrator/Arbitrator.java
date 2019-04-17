package subsumption.arbitrator;

import java.util.HashMap;
import java.util.Map;

import subsumption.Constants;
import subsumption.common.Wish;
import subsumption.wish.Effector;

public class Arbitrator {
	private Wish[] wishes = new Wish[Constants.MAX_WISH];
	private final Effector[] effectors;
	private Map<Wish, Integer> increasedWishPower = new HashMap<>();
	
	
	public Arbitrator(Effector... effectors) {
		this.effectors = effectors;
		for(Wish wish: Wish.values()){
			increasedWishPower.put(wish, 0);
		}
	}

	public synchronized void accept(Wish wish, int priority) {
		priority = increasedWishPower.get(wish) + priority;
		if(priority> Constants.MAX_WISH) {
			priority = Constants.MAX_WISH;
		}
		if (wish == Wish.NOTHING)
			wishes[priority] = null;
		else {
			// Wunsch in Tabelle eintragen.
			wishes[priority] = wish;
			// im Array alle Wünsche durchlaufen ab der Priorität dieses
			// aktuellen wunsches + 1
			// gibt es irgendeine höhere?
			boolean wishHasTopPriority = true;
			for (int p = priority + 1; p < Constants.MAX_WISH; p++)
				if (wishes[p] != null) {
					wishHasTopPriority = false;
					break;
				}
			// falls dieser Wunsch die höchste Prio hatte
			// diesen Wunsch an alle Effektoren weitergeben
			if (wishHasTopPriority) {
				if( wish == Wish.Reset ) {
					 wishes = new Wish[Constants.MAX_WISH];
				}
				//wishes[priority] = null;
				for (Effector effector : effectors) {
					effector.accept(wish);
				}
			}
		}
	}
	
	

}
