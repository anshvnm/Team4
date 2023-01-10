import java.io.*;
import junit.framework.*;
import java.util.*;

public class TestMapMove extends TestCase {

  public void testMapMove() throws FileNotFoundException {
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
    
    // create pacman componenet
    PacManComponent pc = new PacManComponent(9, 12, 20);
    
    // add pacman to map
    map.add("pacman", new Location(9, 12), pc, Map.Type.PACMAN);

    assertTrue(map.getLoc(new Location(9, 12)).contains(Map.Type.PACMAN));

    // move pacman's location
    map.move("pacman", new Location(11,12), Map.Type.PACMAN);

    assertTrue(map.getLoc(new Location(11, 12)).contains(Map.Type.PACMAN));

    // can't move pacman into wall
    assertFalse(map.move("pacman", new Location(0,0), Map.Type.PACMAN));
    assertTrue(map.getLoc(new Location(0, 0)).contains(Map.Type.WALL));
  }
}
