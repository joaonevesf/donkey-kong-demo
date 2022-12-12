package com.aor.DK.controller.game;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Mario;
import com.aor.DK.model.elements.Switch;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.states.GameState;
import com.aor.DK.states.MenuState;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ArenaController extends GameController {
    private final MarioController marioController;
    private final BarrelController barrelController;

    private final FireController fireController;

    public ArenaController(Arena arena) {
        super(arena);
        this.marioController = new MarioController(arena);
        this.barrelController = new BarrelController(arena);
        this.fireController = new FireController(arena);
    }

    private void manageSwitches() {
        Position marioPos = getModel().getMario().getPosition();
        for(Switch s : getModel().getSwitches()) {
            if(!s.isOn()) continue;
            if(s.getPosition().getX() == marioPos.getX() &&
                    (marioPos.getY() == s.getPosition().getY() - 1
                    || marioPos.getY() == s.getPosition().getY() - 2 )) {
                s.turnOff();
            }
        }
    }

    @Override
    public void step(Game game, List<GUI.ACTION> actions, long time) throws IOException {
        boolean allSwitchesOff = false;
        if (actions.contains(GUI.ACTION.QUIT))
            game.setState(new MenuState(new Menu(Arrays.asList("Start", "Exit"),"\t\t  Menu")));
        else {
            marioController.step(game, actions, time);
            barrelController.step(game, actions, time);
            fireController.step(game, actions, time);
            for(Switch s : getModel().getSwitches()){
                allSwitchesOff = allSwitchesOff || s.isOn();
            }
            if(!allSwitchesOff){
                game.setState();
            }
            else {
                manageSwitches();
            }

        }
    }
}
