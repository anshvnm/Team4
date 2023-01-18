import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map {

  public enum Type {
    EMPTY,
    PACMAN,
    GHOST,
    WALL,
    COOKIE
  }

  private HashMap<Location, HashSet<Type>> field;
  private boolean gameOver;
  private int dim;

  private HashMap<String, Location> locations;
  private HashMap<String, JComponent> components;
  private HashSet<Type> emptySet;
  private HashSet<Type> wallSet;

  private int cookies = 0;

  public Map(int dim) {
    gameOver = false;
    locations = new HashMap<String, Location>();
    components = new HashMap<String, JComponent>();
    field = new HashMap<Location, HashSet<Type>>();
 
    emptySet = new HashSet<Type>();
    wallSet = new HashSet<Type>();
    emptySet.add(Type.EMPTY);
    wallSet.add(Type.WALL);
    this.dim = dim;
  }

  public void add(String name, Location loc, JComponent comp, Type type) {
    locations.put(name, loc);
    components.put(name, comp);
    if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
    field.get(loc).add(type);
  }

  public int getCookies() {
    return cookies;
  }

  public boolean isGameOver() {
    return gameOver;
  }

  public boolean move(String name, Location loc, Type type) {
    // if location is not empty do not add something there
    if (!getLoc(loc).contains(Type.EMPTY)) {
      return false;
    }
    
    // get component for item to move on map
    JComponent comp = components.get(name);

    // update locations, components, and field
    add(name, loc, comp, type);
    
    // use the setLocation method for the component to move it to the new location
    comp.setLocation(loc.x, loc.y);
    
    return true;
  }

  public HashSet<Type> getLoc(Location loc) {
    if (field.containsKey(loc)) {
      return field.get(loc);
    } else {
      return emptySet;
    }
  }

  public boolean attack(String Name) {
    
    Location g_loc = locations.get(Name);
    Location p_loc = locations.get("pacman");
    if(g_loc.equals(p_loc)) {
      gameOver = true;
      return true;
    } else if((g_loc.x == (p_loc.x - 1) && g_loc.y == p_loc.y) || 
          (g_loc.x == (p_loc.x + 1) && g_loc.y == p_loc.y) || 
          (g_loc.y == (p_loc.y - 1) && g_loc.x == p_loc.x) || 
          (g_loc.y == (p_loc.y + 1) && g_loc.x == p_loc.x)) {
      gameOver = true;
      return true;
      
    }
    // update gameOver
    return false;
  }

  public JComponent eatCookie(String name) {
    // Getting the location of the PacMan
    Location pacman_loc = locations.get(name);
    String tok = "tok_x" + pacman_loc.x + "_y" + pacman_loc.y;
    if(field.get(pacman_loc).remove(Map.Type.COOKIE)) {
      // If a COOKIE component is removed/found at the location of the PacMan, increase the count for the number of cookies which tracks
      // how many you have eaten
      cookies++;
      for (HashMap.Entry<String, Location> entry: locations.entrySet()) {
        if(entry.getValue().equals(pacman_loc) && !entry.getKey().equals(name)) {
          return null;
        }
      }
      JComponent cookie = components.get(name);
      components.remove(name);
      // Return COOKIE/JComponent
      return cookie;
    } else {
      // If there was no COOKIE found
      return null;
    }

  }
}
