package dungeonmania;

import dungeonmania.movingEntities.Player;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import dungeonmania.collectableEntities.*;

public class Inventory {
    
    private Player player;
    private List<CollectableEntity> inv = new ArrayList<>();

    /**
     * Constructor for Inventory
     * @param player
     */
    public Inventory(Player player) {
        this.player = player;
    }

    public void pickup(CollectableEntity collectable, Player player){
        this.inv.add(collectable);
        collectable.setPlayer(player);
    }

    // Getters and Setters
    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<CollectableEntity> getInventory() {
        return inv;
    }


    /**
     * Uses the item with the given id.
     * @param id
     */
    public void useItem(String type) {
        for (CollectableEntity inv_item : inv) {
            if (inv_item.getType().equals(type)) {
                inv_item.use();
                return;
            }
        }
        return null;
    }

}
