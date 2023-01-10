import java.io.*;
import junit.framework.*;
import java.awt.Color;

public class TestAttack extends TestCase {

  public void testAttack() throws FileNotFoundException {
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
     assertTrue(ghost.attack(), true);
  }
}
