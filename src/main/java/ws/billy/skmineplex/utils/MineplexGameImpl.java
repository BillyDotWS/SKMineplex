package ws.billy.skmineplex.utils;

import com.mineplex.studio.sdk.modules.game.BuiltInGameState;
import com.mineplex.studio.sdk.modules.game.BuiltInPlayerState;
import com.mineplex.studio.sdk.modules.game.MineplexGameMechanicFactory;
import com.mineplex.studio.sdk.modules.game.SingleWorldMineplexGame;
import com.mineplex.studio.sdk.modules.game.helper.GameStateTracker;
import com.mineplex.studio.sdk.modules.game.helper.PlayerStateTracker;
import com.mineplex.studio.sdk.modules.world.MineplexWorld;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Delegate;
import ws.billy.skmineplex.SKMineplex;

@RequiredArgsConstructor
public class MineplexGameImpl implements SingleWorldMineplexGame {

    private final String name;

    @Delegate
    private PlayerStateTracker playerStateTracker;
    @Delegate
    private GameStateTracker gameStateTracker;
    private MineplexGameMechanicFactory gameMechanicFactory;

    @Setter
    private MineplexWorld gameWorld;

    @Setter
    @Getter
    private int minimumPlayers, maximumPlayers;

    @Override
    public @NonNull MineplexWorld getGameWorld() {
        return gameWorld;
    }

    @Override
    public @NonNull String getName() {
        return name;
    }

    @Override
    public @NonNull MineplexGameMechanicFactory getGameMechanicFactory() {
        return gameMechanicFactory;
    }

    @Override
    public void setup() {
        this.gameStateTracker = new GameStateTracker(this, BuiltInGameState.PREPARING);
        this.playerStateTracker = new PlayerStateTracker(this, BuiltInPlayerState.SPECTATOR);
        this.gameMechanicFactory = SKMineplex.getModule(MineplexGameMechanicFactory.class);
    }

    @Override
    public void teardown() {
        this.gameStateTracker = null;
        this.playerStateTracker = null;
        this.gameMechanicFactory.teardown();
        this.gameMechanicFactory = null;
    }

    @Override
    public String toString() {
        return name;
    }
}
