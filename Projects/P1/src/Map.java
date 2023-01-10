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
    // update locations, components, and field
    // use the setLocation method for the component to move it to the new location
    return false;
  }

  public HashSet<Type> getLoc(Location loc) {
    // wallSet and emptySet will help you write this method
    return field.getOrDefault(loc, emptySet);
  }

  public boolean attack(String Name) {
    // update gameOver
    return false;
  }

  public JComponent eatCookie(String name) {
    // Getting the location of the PacMan
    Location pacman_loc = locations.get(name);
    if(field.get(pacman_loc).remove(Map.Type.COOKIE)) {
      // If a COOKIE component is removed/found at the location of the PacMan
      // Updating the token. Took the scale variable from the "MainFrame"
      Location loc = new Location(pacman_loc.x, pacman_loc.y);
      CookieComponent tok = new CookieComponent(loc.x, loc.y, 20);
      myMap.add("tok_x" + pacman_loc.x + "_y" + pacman_loc.y, loc, tok, Map.Type.COOKIE);
      add(tok);
      tok.setLocation(pacman_loc.x, pacman_loc.y);

      // Return COOKIE/JComponent
      return components.get(tok);
    } else {
      // If there was no COOKIE found
      return null;
    }

  }
}
