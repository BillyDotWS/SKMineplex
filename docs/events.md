# Events

## Game

### Game state change

```
on game state change
```

This also then exposes the previous and new state.

```
on game state change:
    broadcast "%past event-gamestate%" # the previous state
    broadcast "%event-gamestate%" # the new state
```