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
    return null;
  }

  public boolean move() {
    return false;
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
      return c_Comp;
    }
    return null;
  }
}
