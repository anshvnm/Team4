# Autonomous Pac-Man!

Contributors: Evan Guenterberg, Fatima Chariwala

TODO: image playing pacman

To compile and run:
```
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```

## Function List
- Map
  - getLoc: Returns all the objects at a Location in the map.
  - attack: Checks if the ghost was successfully able to attack the pacman based on their locations and returns true or false based on it.

- Test functions
  - TestMapAttack: Checks if the Map.attack feature works correctly.
  - TestMapGetLoc: Test checks the functionality against the default game map.