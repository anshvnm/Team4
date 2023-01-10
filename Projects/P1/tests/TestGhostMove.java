import java.io.*;
import junit.framework.*;

public class TestGhostMove extends TestCase {

  public void testGhostMove() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    Map map = frame.getMap();

    // create ghost
    Ghost ghost1 = new Ghost("ghost1", new Location(8, 11), map);

    GhostComponent gc1 = new GhostComponent(8, 11, null, 20);

    map.add("ghost1", new Location(8, 11), gc1, Map.Type.GHOST);

    assertTrue(ghost1.move());

    assertTrue(map.getLoc(new Location(9, 11)).contains(Map.Type.GHOST));
  }
}
