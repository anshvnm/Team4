# Autonomous Pac-Man!

# Table of contents
1. [Contributors](#members)
2. [Game Visual](#image)
3. [Running the Code](#codeinst)
4. [Function List](#functions)


## Contributors <a name="members"></a>
Evan Guenterberg, Fatima Chariwala, Dante Idiagbonya, Peter Hwang

## Game Visual <a name="image"></a>

<p align="center" width="100%">
    <img width="50%" src="Pacman%20Game%201.png">
    <img width="50%" src="Pacman%20Game.png">
</p>


## Running the Code <a name="codeinst"></a>

To compile and run:
```
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```

## Function List <a name="functions"></a>
### Pacman Class
  The Pacman class represents a pacman in the game. It has fields like name, location, map, and shift that reprsents the pacman's name, 
  its current location, the game's map, and movement respectively. Below are the methods of the Pacman class.
  
  - get_valid_moves(): Returns an ArrayList of valid moves that PacMan can make, given its current position on the map, without moving out of bounds 
    or running into a wall.
  - is_ghost_in_range: Returns true if there is a ghost 1 space away from pacman in the directions UP, DOWN, LEFT & RIGHT. False, otherwise. 
    (Diagonal    directions are not considered)
  - consume: The method checks if there is a cookie at the location of the pacman and if there is, then the eatCookie method of
    the Map class is used to allow the pacman to eat it. If successful, it returns the cookie component otherwise null.
  - move: If pacman has a valid move, take it and return true. Relies on PacMan.get_valid_moves() and Map.move().

### Ghost Class
  - get_valid_moves(): Returns an ArrayList of valid moves that Ghost can make, given its current position on the map, without moving out of bounds or running into a wall.
  - is_pacman_in_range: Returns true if pacman is 1 space away from a ghost in the directions UP, DOWN, LEFT & RIGHT. False, otherwise. (Diagonal directions are not considered)
  - move: If the ghost has a valid move, make it and return true. Relies on Map.move.
  - attack: After checking if the pacman is in range, the method allows the ghost to attack the pacman. It returns true if the attack
  was successful otherwise, returns false.

### Map Class
  - getLoc: Returns all the objects at a Location in the map.
  - move: If location inputed is empty then it places the desired componenet at that location and returns true. Otherwise, returns false and does not place component.
  - attack: Checks if the ghost was successfully able to attack the pacman based on their locations and returns true or false based on it.
  - eatCookie: Checks if the pacman is sharing location with a cookie and returns the cookie's component after removing if found, else it returns null.

### Test functions
  - TestMapAttack: Checks if the Map.attack feature works correctly.
  - TestMapGetLoc: Test checks the functionality against the default game map.
  - TesetMapMove: Tests functionality of Map.move() and that components are placed in only in correct empty locations.
  - TestMapEatCookie: Tests whether a cookie can be detected and deleted.
  - TestGhostMove: Checks that ghosts can and do move.
  - TestGhostInRange: Tests that pacman can properly identify when a ghost is in range and is not.
  - TestPacManInRange: Tests that ghost can properly identify when pacman is in range and is not.
  - TestAttack: Tests the attack method of the ghost class and checks if the method returns the correct value after a successful/unsuccessful attack.
  - TestConsume: Tests the consume method of the pacman class. It checks if the cookie is successfully consumed if the pacman
  is in the same location and the cookie component is returned.
  - TestPacManValidMoves: Tests that PacMan.get_valid_moves() returns the correct list of valid moves, given an adjacent wall and boundaries.
  - TestGhostValidMoves: Tests that Ghost.get_valid_moves() returns the correct list of valid moves, given an adjacent wall and boundaries.
  - TestPacManMove: Tests that PacMan can and does move.
