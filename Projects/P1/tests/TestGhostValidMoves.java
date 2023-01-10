import java.io.*;
import junit.framework.*;
import java.util.*;

public class TestGhostValidMoves extends TestCase {

  public void testGhostValidMoves() throws FileNotFoundException {
    NoFrame frame = new NoFrame();
    Map map = frame.getMap();

    Location center = new Location(9, 12);
    Location left = new Location(8, 12);
    Location right = new Location(10, 12);
    Location up = new Location(9, 13);
    Location down = new Location(9, 11);
    
    Ghost ghost = new Ghost("ghost", center, map);
    GhostComponent gc = new GhostComponent(center.x, center.y, 20);
    map.add("ghost", center, gc, Map.Type.GHOST);
    WallComponent wall = new WallComponent(left.x, left.y, 20);
    map.add("wall", left, wall, Map.Type.WALL);

    System.out.println("Center is:" + center);
    System.out.println("Left is:" + left);
    System.out.println("Right is:" + right);
    System.out.println("Up is:" + up);
    System.out.println("Down is:" + down);
    System.out.println(ghost.get_valid_moves());
    /*
    assertTrue(pacman.get_valid_moves().contains(left));
    assertTrue(pacman.get_valid_moves().contains(right));
    assertTrue(pacman.get_valid_moves().contains(up));
    assertTrue(pacman.get_valid_moves().contains(down));
    */
 }
}