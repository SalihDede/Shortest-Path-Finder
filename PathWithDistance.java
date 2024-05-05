import java.util.List;


// This class represents a route along with its length in a map.
public class PathWithDistance {

    // The list of cities making up the route.
    private List<String> path;

    // The distance of the route.
    private int distance;

    // A method to set the route and its distance when creating an object.
    public PathWithDistance(List<String> path, int distance) {
        this.path = path;
        this.distance = distance;
    }

    // A method to get the list of cities representing the route.
    public List<String> getPath() {
        return path;
    }

    // A method to get the distance of the route.
    public int getDistance() {
        return distance;
    }
}
