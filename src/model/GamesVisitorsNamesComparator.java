package model;

import java.util.Comparator;

public class GamesVisitorsNamesComparator implements Comparator<Game>{

	@Override
	public int compare(Game g1, Game g2) {
		
		if(g1.getOccupancy()>g2.getOccupancy()) {
			return 1;
		}else if(g1.getOccupancy()<g2.getOccupancy())  {
			return -1;
		}else {
			
			return g1.getName().compareTo(g2.getName());
			
		}
			
		
	}

	
	
}
