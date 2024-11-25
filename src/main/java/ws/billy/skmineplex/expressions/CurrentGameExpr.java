package ws.billy.skmineplex.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.classes.Changer;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import ch.njol.util.coll.CollectionUtils;
import com.mineplex.studio.sdk.modules.game.MineplexGame;
import com.mineplex.studio.sdk.modules.game.MineplexGameModule;
import lombok.NonNull;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;
import ws.billy.skmineplex.SKMineplex;

import java.util.Optional;

public class CurrentGameExpr extends SimpleExpression<MineplexGame> {

    static {
        Skript.registerExpression(CurrentGameExpr.class, MineplexGame.class, ExpressionType.COMBINED, "[the] current game");
    }

    @Override
    protected @Nullable MineplexGame[] get(Event event) {
        final @NonNull Optional<MineplexGame> currentGame = SKMineplex.getModule(MineplexGameModule.class).getCurrentGame();
        return currentGame.map(mineplexGame -> new MineplexGame[]{mineplexGame}).orElseGet(() -> new MineplexGame[0]);
    }

    @Override
    public boolean canBeSingle() {
        return true;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends MineplexGame> getReturnType() {
        return MineplexGame.class;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return SKMineplex.getModule(MineplexGameModule.class).getCurrentGame().toString();
    }

    @Override
    public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
        return true;
    }

    @Override
    public Class<?>[] acceptChange(final Changer.ChangeMode mode) {
        if (mode == Changer.ChangeMode.DELETE || mode == Changer.ChangeMode.SET || mode == Changer.ChangeMode.RESET) {
            return CollectionUtils.array(String.class);
        }
        return null;
    }

    @Override
    public void change(Event event, Object[] delta, Changer.ChangeMode mode) {
        final MineplexGameModule gameModule = SKMineplex.getModule(MineplexGameModule.class);
        if (mode == Changer.ChangeMode.SET) {
            if (delta.length == 0 || delta[0] == null) {
                Skript.error("Target game cannot be null for this");
                return;
            }
            gameModule.setCurrentGame((MineplexGame) delta[0]);
        } else if (mode == Changer.ChangeMode.DELETE || mode == Changer.ChangeMode.RESET) {
            gameModule.setCurrentGame(null);
        }
    }

}
