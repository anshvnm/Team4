import java.io.*;
import junit.framework.*;

public class TestPacManValidMoves extends TestCase {

  public void testPacManValidMoves() throws FileNotFoundException {
     NoFrame frame = new NoFrame();
     Map map = frame.getMap();

     Location center = new Location(9, 12);
     Location left = new Location(8, 12);
     Location right = new Location(10, 12);
     Location up = new Location(9, 13);
     Location down = new Location(9, 11);

     PacMan pacman = new PacMan("pacman", center, map);
     PacManComponent pc = new PacManComponent(center.x, center.y, 20);
     map.add("pacman", center, pc, Map.Type.PACMAN);
     WallComponent wall = new WallComponent(left.x, left.y, 20);
     map.add("wall", left, wall, Map.Type.WALL);
     
     /*
     System.out.println("Center is:" + center);
     System.out.println("Left is:" + left);
     System.out.println("Right is:" + right);
     System.out.println("Up is:" + up);
     System.out.println("Down is:" + down);
     System.out.println(pacman.get_valid_moves());
    */

     assertTrue(!pacman.get_valid_moves().contains(left));
     assertTrue(pacman.get_valid_moves().contains(right));
     assertTrue(pacman.get_valid_moves().contains(up));
     assertTrue(pacman.get_valid_moves().contains(down));
  }
}