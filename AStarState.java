

import java.util.HashMap;
public class AStarState
{
    private Map2D map;

    public HashMap<Location, Waypoint> openNode = new HashMap<Location, Waypoint>();
    public HashMap<Location, Waypoint> closeNode = new HashMap<Location, Waypoint>();

    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    public Map2D getMap()
    {
        return map;
    }

    public Waypoint getMinOpenWaypoint()
    {
        if(openNode.size() == 0)
            return null;
        Waypoint first = (Waypoint) openNode.values().toArray()[0];
        float min = first.getTotalCost();
        for(Waypoint wp : openNode.values())
        {
            if(min >= wp.getTotalCost())
            {
                min = wp.getTotalCost();
                first = wp;
            }
        }
        return first;
    }

    public boolean addOpenWaypoint(Waypoint newWP)
    {
        // TODO:  Implement.
        if (openNode.get(newWP.getLocation()) == null) {
            openNode.put(newWP.getLocation(), newWP);
            return true;
        }
        else {
            if (openNode.get(newWP.getLocation()).getPreviousCost()>newWP.getPreviousCost()) {
                openNode.put(newWP.getLocation(),newWP);
                return true;
            }
        }
        return false;
    }

    public int numOpenWaypoints()
    {
        return openNode.size();
    }

    public void closeWaypoint(Location loc)
    {
        // TODO:  Implement.
        closeNode.put(loc,openNode.remove(loc));
    }

    public boolean isLocationClosed(Location loc)
    {
        if (closeNode.containsKey(loc)) {
            return true;
        } else
            return false;
    }
}