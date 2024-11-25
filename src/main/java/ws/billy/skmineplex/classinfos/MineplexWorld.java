package ws.billy.skmineplex.classinfos;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import com.mineplex.studio.sdk.modules.world.MineplexWorldModule;
import com.mineplex.studio.sdk.modules.world.config.MineplexWorldConfig;
import com.mineplex.studio.sdk.modules.world.config.WorldCreationConfig;
import lombok.extern.slf4j.Slf4j;
import ws.billy.skmineplex.SKMineplex;

import java.util.UUID;

@Slf4j
public class MineplexWorld {

    static {

        Classes.registerClass(new ClassInfo<>(com.mineplex.studio.sdk.modules.world.MineplexWorld.class, "mineplexworld")
                .user("mineplex ?worlds?")
                .name("Mineplex World")
                .description("Represents a Mineplex world.")
                .examples("set {_world} to \"world-name\" parsed as a mineplex world # loads the world with the given template")
                .parser(new Parser<>() {
                    @Override
                    public String toString(com.mineplex.studio.sdk.modules.world.MineplexWorld o, int flags) {
                        return toVariableNameString(o);
                    }

                    @Override
                    public com.mineplex.studio.sdk.modules.world.MineplexWorld parse(String input, ParseContext context) {
                        final WorldCreationConfig config = WorldCreationConfig.builder()
                                .worldTemplate(input)
                                .build();

                        final MineplexWorldConfig worldConfig = MineplexWorldConfig.builder()
                                .worldRegionType(MineplexWorldConfig.WorldRegionFormatType.ANVIL)
                                .worldCreationConfig(config)
                                .build();

                        // load world with UUID as name.
                        log.info("Loading world {} with config: {}", UUID.randomUUID(), worldConfig);
                        return SKMineplex.getModule(MineplexWorldModule.class)
                                .createMineplexWorld(worldConfig, UUID.randomUUID().toString());

                    }

                    @Override
                    public String toVariableNameString(com.mineplex.studio.sdk.modules.world.MineplexWorld world) {
                        return world.getId();
                    }

                }));

    }

}
