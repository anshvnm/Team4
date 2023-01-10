import java.io.*;
import junit.framework.*;
import java.util.*;

public class TestPacManValidMoves extends TestCase {

  public void testPacManValidMoves() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    Map map = frame.getMap();
    HashSet<Map.Type> emptySet = new HashSet<Map.Type>();
    emptySet.add(Map.Type.EMPTY);
    HashSet<Map.Type> wallSet = new HashSet<Map.Type>();
    wallSet.add(Map.Type.WALL);
    HashSet<Map.Type> cookieSet = new HashSet<Map.Type>();
    cookieSet.add(Map.Type.COOKIE);

    // Create PacMan
    PacMan pacman = new PacMan("pacman", new Location(9, 12), map);
    PacManComponent pc = new PacManComponent(9, 12, 20);
    // Create Wall
    WallComponent wall = new WallComponent(9, 11, 20);

    // Adding the PacMan to Map
    map.add("pacman", new Location(9, 12), pc, Map.Type.PACMAN);
    // Adding a Wall
    map.add("wall", new Location(9, 11), wall, Map.Type.WALL);
    System.out.println(pacman.get_valid_moves());
    //assertEquals(pacman.get_valid_moves(),{new Location(9, 13), new Location(8, 12), new Location(10, 12)});
  }
}
