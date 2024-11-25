package ws.billy.skmineplex.classinfos;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import lombok.extern.slf4j.Slf4j;
import ws.billy.skmineplex.utils.MineplexGameImpl;

@Slf4j
public class MineplexGame {

    static {

        Classes.registerClass(new ClassInfo<>(MineplexGameImpl.class, "mineplexgame")
                .user("mineplex ?games?")
                .name("Mineplex Game")
                .description("Represents a Mineplex Game.")
                .examples("set {_game} to \"Micro Battles\" parsed as a mineplex game")
                .parser(new Parser<>() {
                    @Override
                    public String toString(MineplexGameImpl o, int flags) {
                        return toVariableNameString(o);
                    }

                    @Override
                    public MineplexGameImpl parse(String input, ParseContext context) {
                        return new MineplexGameImpl(input);
                    }

                    @Override
                    public String toVariableNameString(MineplexGameImpl game) {
                        return game.getName();
                    }

                }));

    }

}
