package main.world;

import java.util.ArrayList;
import main.ent.Entity;

public class WorldEventHandler {

	public static ArrayList<Entity> worldEnt = new ArrayList<Entity>();
	
	public void updateAll() {
		int i;
		
		for(i = 0; i <= worldEnt.size() - 1; i += 1) {
			worldEnt.get(i).update();
		}
		
	}
	
}
