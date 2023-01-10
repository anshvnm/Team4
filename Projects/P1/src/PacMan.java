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
    return false;
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
