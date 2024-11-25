package ws.billy.skmineplex;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import com.mineplex.studio.sdk.modules.MineplexModule;
import com.mineplex.studio.sdk.modules.MineplexModuleManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class SKMineplex extends JavaPlugin {

    private static final String PACKAGE = "ws.billy.skmineplex";

    @Getter
    private static SkriptAddon skriptAddon;
    @Getter
    private static SKMineplex instance;

    public static <T extends MineplexModule> T getModule(final Class<T> clazz) {
        return MineplexModuleManager.getRegisteredModule(clazz);
    }

    @Override
    public void onEnable() {

        final Plugin mineplexEngine = Bukkit.getPluginManager().getPlugin("MineplexEngine");
        if (mineplexEngine == null || !mineplexEngine.isEnabled()) {
            throw new RuntimeException("MineplexEngine plugin isn't enabled, this addon cannot run without it!");
        }

        // static fields
        instance = this;
        skriptAddon = Skript.registerAddon(this);

        try {
            skriptAddon.loadClasses(PACKAGE, "classinfos", "conditions", "effects", "events", "expressions", "functions", "utils");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.getLogger().info("[SKMineplex] Mineplex Studio Skript addon fully loaded!");
        this.getLogger().info("[SKMineplex] This is an unofficial addon, please direct questions to our Github repository, not the Mineplex studio discord!");

    }

}
