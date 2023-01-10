import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.*;

public class TestMapAttack extends TestCase {

  public void testMapAttack() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    Map map = frame.getMap();
    int scale = 20;
    Location loc = new Location(9, 12);
    PacMan pacman = new PacMan("pacman", loc, map);
    PacManComponent pc = new PacManComponent(loc.x, loc.y, scale);
    map.add("pacman", loc, pc, Map.Type.PACMAN);
    loc = new Location(9,11);
    Ghost ghost = new Ghost("clyde", loc, map);
    GhostComponent comp = new GhostComponent(loc.x, loc.y, Color.BLACK, scale);
    map.add("clyde", loc, comp, Map.Type.GHOST);
    assertEquals(map.attack("clyde"), true);
    assertEquals(map.isGameOver(), true);
  }
}
