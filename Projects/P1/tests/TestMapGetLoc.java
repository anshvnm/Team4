import java.io.*;
import junit.framework.*;
import java.util.*;

public class TestMapGetLoc extends TestCase {

  public void testMapGetLoc() throws FileNotFoundException {
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
  }
}
