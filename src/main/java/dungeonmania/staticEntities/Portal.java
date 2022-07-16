package dungeonmania.staticEntities;

import java.util.List;

import dungeonmania.Entity;
import dungeonmania.DungeonMap.DungeonMap;
import dungeonmania.movingEntities.MovingEntity;
import dungeonmania.util.Direction;
import dungeonmania.util.Position;

public class Portal extends StaticEntity {

    private String colour_id;
    private Position teleportal;

    /**
     * Constructor for Portal
     * @param id
     * @param position
     * @param type
     * @param colour_id
     */
    public Portal (String id, Position position, String type, String colour_id) {
        super(id, position, type);
        this.colour_id = colour_id;
    }

    /**
     * Teleports the moving entity to 
     * @param dungeon
     * @param direction
     * @param entity
     */
    public void teleport(DungeonMap dungeon, Direction direction, MovingEntity entity) {
        dungeon.getMap().forEach((key, value) -> {
            for (Entity ent : value) {
                if ((ent instanceof Portal) && ((Portal) ent).getColour().equals(colour_id)) {
                    this.underBoulder = true; return;
                }
            }
        })
        entity.move(teleportal.translateBy(direction));
    }


    public String getColour() {
        return this.colour_id;
    }

}
