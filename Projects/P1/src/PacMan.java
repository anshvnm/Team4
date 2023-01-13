import java.util.ArrayList;
import java.util.HashSet;

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
    // Check if PacMan is out of bounds  
    // Right
    if (!(myMap.getLoc(myLoc.shift(1, 0)).contains(Map.Type.WALL)) && (myLoc.x > 0 && myLoc.x <24) && (myLoc.y > 0 && myLoc.y <24)) {
      result.add(myLoc.shift(1, 0));
    }
    // Left
    if (!(myMap.getLoc(myLoc.shift(-1, 0)).contains(Map.Type.WALL)) && (myLoc.x > 0 && myLoc.x <24) && (myLoc.y > 0 && myLoc.y <24)) {
      result.add(myLoc.shift(-1, 0));
    }
    // Up
    if (!(myMap.getLoc(myLoc.shift(0, -1)).contains(Map.Type.WALL)) && (myLoc.x > 0 && myLoc.x <24) && (myLoc.y > 0 && myLoc.y <24)) {
      result.add(myLoc.shift(0, -1));
    }
    // Down
    if (!(myMap.getLoc(myLoc.shift(0, 1)).contains(Map.Type.WALL)) && (myLoc.x > 0 && myLoc.x <24) && (myLoc.y > 0 && myLoc.y <24)) {
      result.add(myLoc.shift(0, 1));
    }
    return result;
  }

  public boolean move() {
    ArrayList<Location> moves = get_valid_moves();
    if (moves.size() == 0) {
      return false;
    }
    myMap.move(myName, moves.get(3), Map.Type.PACMAN);
    myLoc = moves.get(0);
    return true;
  }

  public boolean is_ghost_in_range() {
    boolean in_range = false;
    // checks right
    if (myMap.getLoc(myLoc.shift(1, 0)).contains(Map.Type.GHOST)) in_range = true;
    // checks left
    if (myMap.getLoc(myLoc.shift(-1, 0)).contains(Map.Type.GHOST)) in_range = true;
    // checks up
    if (myMap.getLoc(myLoc.shift(0, -1)).contains(Map.Type.GHOST)) in_range = true;
    // checks down
    if (myMap.getLoc(myLoc.shift(0, 1)).contains(Map.Type.GHOST)) in_range = true;
    return in_range;
  }

  public JComponent consume() {
    HashSet<Map.Type> ret = myMap.getLoc(myLoc);
    if(ret.contains(Map.Type.COOKIE)) {
      JComponent c_Comp = myMap.eatCookie(myName);
      return null;
    }
    return null;
  }
}
