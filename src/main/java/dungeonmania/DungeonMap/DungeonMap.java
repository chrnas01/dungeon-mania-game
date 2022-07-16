package dungeonmania.DungeonMap;

import java.lang.*;
import org.json.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import dungeonmania.Entity;
import dungeonmania.util.*;

public class DungeonMap {
    private String dungeonId;
    private String dungeonName;
    private Map<Position, List<String>> entities = new HashMap<Position, List<String>>();
    private String goals;

    public DungeonMap(String dungeonId, String dungeonName) {
        this.dungeonId = dungeonId;
        this.dungeonName = dungeonName;

        try {
            String payload = FileLoader.loadResourceFile("/dungeons/" + dungeonName + ".json");

            JSONArray entitiesPayload = new JSONObject(payload).getJSONArray("entities");
            JSONObject goalsPayload = new JSONObject(payload).getJSONObject("goal-condition");

            for (int i = 0; i < entitiesPayload.length(); i++) {
                int x = entitiesPayload.getJSONObject(i).getInt("x");
                int y = entitiesPayload.getJSONObject(i).getInt("y");
                Position pos = new Position(x, y);
                String type = entitiesPayload.getJSONObject(i).getString("type");
                
                if (!entities.containsKey(pos)) {
                    entities.put(pos, new ArrayList<String>());
                }

                entities.get(pos).add(type);
            } 

            System.out.println(goalsPayload);

            // entities.put(new Position(1, 1), "Something else");
            // System.out.println(entities.get(new Position(1, 1)));
        }
        catch(IOException e) {
            System.exit(0);
        }
    }
}