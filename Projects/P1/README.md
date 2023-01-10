# Autonomous Pac-Man!

# Table of contents
1. [Contributors](#members)
2. [Game Visual](#image)
3. [Running the Code](#codeinst)
4. [Function List](#functions)


## Contributors <a name="members"></a>
Evan Guenterberg, Fatima Chariwala, Dante Idiagbonya, Peter Hwang

## Game Visual <a name="image"></a>
TODO: image playing pacman

## Running the Code <a name="codeinst"></a>
To compile and run:
```
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```


## Function List <a name="functions"></a>
### Map
  - getLoc: Returns all the objects at a Location in the map.
Test checks the functionality against the default game map.
  - move: If location inputed is empty then it places the desired componenet at that location and returns true. Otherwise, returns false and does not place component.
  - attack: Checks if the ghost was successfully able to attack the pacman based on their locations and returns true or false based on it.
  - eatCookie: Checks if the pacman is sharing location with a cookie and returns the cookie's component after removing if found, else it returns null.

### Test functions
  - TestMapAttack: Checks if the Map.attack feature works correctly.
  - TestMapGetLoc: Test checks the functionality against the default game map.
  - TesetMapMove: Tests functionality of Map.move() and that components are placed in only in correct empty locations.
  - TestMapEatCookie: Tests whether a cookie can be detected and deleted.
