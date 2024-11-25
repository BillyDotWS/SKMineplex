package ws.billy.skmineplex.events;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import com.mineplex.studio.sdk.modules.game.GameState;
import com.mineplex.studio.sdk.modules.game.MineplexGame;
import com.mineplex.studio.sdk.modules.game.event.PostMineplexGameStateChangeEvent;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StateChangeEvent extends SkriptEvent {

    static {
        Skript.registerEvent("Game state change", StateChangeEvent.class, PostMineplexGameStateChangeEvent.class, "game state chang(e|ing)");

        EventValues.registerEventValue(PostMineplexGameStateChangeEvent.class, GameState.class, new Getter<>() {
            @Override
            public @NotNull GameState get(PostMineplexGameStateChangeEvent arg) {
                return arg.getFromState();
            }
        }, -1);

        EventValues.registerEventValue(PostMineplexGameStateChangeEvent.class, GameState.class, new Getter<>() {
            @Override
            public @NotNull GameState get(PostMineplexGameStateChangeEvent arg) {
                return arg.getToState();
            }
        }, 0);

    }

    Literal<MineplexGame> gameLiteral;

    @Override
    public boolean init(Literal<?>[] args, int matchedPattern, SkriptParser.ParseResult parseResult) {
        gameLiteral = (Literal<MineplexGame>) args[0];
        return true;
    }

    @Override
    public boolean check(Event e) {
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        if (event == null) return null;
        return "Game state change event " + event;
    }
}
