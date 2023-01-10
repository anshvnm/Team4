import java.io.*;
import junit.framework.*;
import java.util.*;

public class TestGhostInRange extends TestCase {

  public void testGhostInRange() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    Map map = frame.getMap();
    HashSet<Map.Type> emptySet = new HashSet<Map.Type>();
    emptySet.add(Map.Type.EMPTY);
    HashSet<Map.Type> wallSet = new HashSet<Map.Type>();
    wallSet.add(Map.Type.WALL);
    HashSet<Map.Type> cookieSet = new HashSet<Map.Type>();
    cookieSet.add(Map.Type.COOKIE);

    // create pacman and ghosts
    PacMan pacman = new PacMan("pacman", new Location(9, 12), map);
    Ghost ghost1 = new Ghost("ghost1", new Location(8, 11), map);
    Ghost ghost2 = new Ghost("ghost2", new Location(8, 12), map);

    PacManComponent pc = new PacManComponent(9, 12, 20);
    GhostComponent gc1 = new GhostComponent(8, 11, null, 20);
    GhostComponent gc2 = new GhostComponent(8, 12, null, 20);

    // add pacman to map
    map.add("pacman", new Location(9, 12), pc, Map.Type.PACMAN);

    assertTrue(map.getLoc(new Location(9, 12)).contains(Map.Type.PACMAN));
    
    // add ghost that is out of range
    map.add("ghost1", new Location(8, 11), gc1, Map.Type.GHOST);

    assertFalse(pacman.is_ghost_in_range());

    // add ghost that is in range
    map.add("ghost2", new Location(8, 12), gc2, Map.Type.GHOST);

    assertTrue(pacman.is_ghost_in_range());
  }
}
