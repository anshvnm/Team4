import junit.framework.*;
 import java.awt.Color;
 import java.io.*;
 import java.util.*;

public class TestConsume extends TestCase {

  public void testConsume() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
     Map map = frame.getMap();
     int scale = 20;
     Location loc = new Location(1, 1);
     PacMan pacman = new PacMan("pacman", loc, map);
     PacManComponent pc = new PacManComponent(loc.x, loc.y, scale);
     map.add("pacman", loc, pc, Map.Type.PACMAN);
     assertTrue(pacman.consume() instanceof CookieComponent);
     assertFalse(pacman.consume() instanceof CookieComponent);
  }
}
