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
    if (!getLoc(loc).equals(Type.EMPTY)) {
      return false;
    }
    
    // if empty is to be added then comp stays null
    JComponent comp = null;
    
    if (type.equals(Type.PACMAN)) {
      comp = new PacManComponent(loc.x, loc.y, dim);
    } else if (type.equals(Type.GHOST)) {
      comp = new GhostComponent(loc.x, loc.y, dim);
    } else if (type.equals(Type.WALL)) {
      comp = new WallComponent(loc.x, loc.y, dim);
    } else if (type.equals(Type.COOKIE)) {
      comp = new CookieComponent(loc.x, loc.y, dim);
    }

    // update locations, components, and field
    add(name, loc, comp, type);
    
    // use the setLocation method for the component to move it to the new location
    comp.setLocation(loc.x, loc.y);
    
    return true;
  }

  public HashSet<Type> getLoc(Location loc) {
    // wallSet and emptySet will help you write this method
    return null;
  }

  public boolean attack(String Name) {
    // update gameOver
    return false;
  }

  public JComponent eatCookie(String name) {
    // update locations, components, field, and cookies
    // the id for a cookie at (10, 1) is tok_x10_y1
    return null;
  }
}
