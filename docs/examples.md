# Examples

## World

### Loading a world

Load the world from a template name and save it to a variable for further usage

```
set {_world} to "world-name" parsed as a mineplex world
```

## Game

### Creating a game

Create a game and register it as the current game running on this server

```
set {_game} to "Micro Battles" parsed as a mineplex game
set {_game}'s game world to {_world}
set {_game}'s maximum players to 20
set {_game}'s minimum players to 4
set the current game to {_game}
```

### Starting a game

```
on join:
    add player to {_players::*}
    
on player quit:
    remove player from {_players::*}

every 1 second:
    if size of {_players::*} is greater than or equal to {_game}'s minimum players:
        wait 10 seconds
        set game state of {_game} to "STARTED"
        clear {_players::*}
```

### Game state changed

```
on game state change:
    if event-gamestate = "STARTED":
        broadcast "The game has started!"
```