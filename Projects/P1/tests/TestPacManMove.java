import java.io.*;
import junit.framework.*;

public class TestPacManMove extends TestCase {

  public void testPacManMove() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    Map map = frame.getMap();

    // create ghost
    PacMan pacman = new PacMan("pacman", new Location(8, 11), map);

    PacManComponent pc = new PacManComponent(8, 11, 20);

    map.add("pacman", new Location(8, 11), pc, Map.Type.PACMAN);

    assertTrue(pacman.move());

    assertTrue(map.getLoc(new Location(9, 11)).contains(Map.Type.PACMAN));
  }
}
