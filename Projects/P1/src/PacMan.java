import java.util.ArrayList;
import javax.swing.JComponent;

public class PacMan {
  String myName;
  Location myLoc;
  Map myMap;
  Location shift;

  public PacMan(String name, Location loc, Map map) {
    this.myLoc = loc;
    this.myName = name;
    this.myMap = map;
  }

  public ArrayList<Location> get_valid_moves() {
    // Returns all the valid moves that PacMan can make given his current position
    // Create the resulting ArrayList
    ArrayList<Location> result = new ArrayList<>();
    // Checks the PacMan surroundings for a wall and adds to the "valid" list of moves accordingly
    // Right
    if (!(myMap.getLoc(myLoc.shift(1, 0)).contains(Map.Type.WALL))) {
      result.add(myLoc.shift(1, 0));
    }
    // Left
    if (!(myMap.getLoc(myLoc.shift(-1, 0)).contains(Map.Type.WALL))) {
      result.add(myLoc.shift(-1, 0));
    }
    // Up
    if (!(myMap.getLoc(myLoc.shift(0, -1)).contains(Map.Type.WALL))) {
      result.add(myLoc.shift(0, -1));
    }
    // Down
    if (!(myMap.getLoc(myLoc.shift(0, 1)).contains(Map.Type.WALL))) {
      result.add(myLoc.shift(0, 1));
    }
    return result;
  }

  public boolean move() {
    return false;
  }

  public boolean is_ghost_in_range() {
    return false;
  }

  public JComponent consume() {
    return null;
  }
}
