package dungeonmania.Goals;

import java.util.List;
import java.util.Map;

import dungeonmania.DungeonMap.DungeonMap;
import dungeonmania.Entity;
import dungeonmania.util.Position;

public class ORGoal extends ComplexGoal {
    
    public ORGoal (String goalType) {
        super(goalType);
    }
    
    @Override
    public boolean goalIsComplete(DungeonMap dungeon) {
        return true;
    };
}
