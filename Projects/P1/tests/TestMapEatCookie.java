import java.io.*;
import junit.framework.*;
import java.util.*;

public class TestMapEatCookie extends TestCase {

  public void testMapEatCookie() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    Map map = frame.getMap();
    HashSet<Map.Type> emptySet = new HashSet<Map.Type>();
    emptySet.add(Map.Type.EMPTY);
    HashSet<Map.Type> wallSet = new HashSet<Map.Type>();
    wallSet.add(Map.Type.WALL);
    HashSet<Map.Type> cookieSet = new HashSet<Map.Type>();
    cookieSet.add(Map.Type.COOKIE);

    assertEquals(map.getLoc(new Location(11,12)), emptySet);
    assertEquals(map.getLoc(new Location(0,0)), wallSet);
    assertEquals(map.getLoc(new Location(1,1)), cookieSet);
    
    // Create PacMan
    PacManComponent pc = new PacManComponent(9, 12, 20);
    // Add PacMan to map
    map.add("pacman", new Location(9, 12), pc, Map.Type.PACMAN);

    assertTrue(map.getLoc(new Location(9, 12)).contains(Map.Type.PACMAN));

    // Create Cookie
    CookieComponent cookie = new CookieComponent(9, 12, 20);
    // Add PacMan to the map
    map.add("cookie", new Location(9, 12), cookie, Map.Type.COOKIE);

    assertTrue(map.getLoc(new Location(9, 12)).contains(Map.Type.COOKIE));
    assertEquals(map.eatCookie("pacman"), cookie);
  }
}
