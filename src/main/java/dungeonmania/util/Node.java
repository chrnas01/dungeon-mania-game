package dungeonmania.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Node {

    private Position position;
    private double dist;

    public Node(Position position, double dist) {
        this.position = position;
        this.dist = dist;
    }

    public Position getPos() {
        return position;
    }
}