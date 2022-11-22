package com.aor.DK.controller.game;

import com.aor.DK.Game;
import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Barrel;
import com.aor.DK.model.elements.Floor;

import java.io.IOException;
import java.util.List;

public class BarrelController extends GameController{

    private long lastMovement;
    public BarrelController(Arena arena) {
        super(arena);
        this.lastMovement = 0;
    }

    private int getFloorNumber(Position position) {
        List<List<Floor>> storeys = getModel().getFloor();
        for(int i = 0; i < storeys.size(); i++) {
            for(Floor floor : storeys.get(i)) {
                if(position.equals(floor.getPosition())) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean isOutOfBounds(Position position) {
        return position.getX() < 0 || position.getX() > getModel().getWidth() || position.getY() < 0 || position.getY() > getModel().getHeight();
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if(this.lastMovement - time > 500) {
            getModel().spawnBarrel();
        }
        for(Barrel barrel: getModel().getBarrels()) {
            if(getFloorNumber(barrel.getPosition()) == -1) barrel.setPosition(barrel.getPosition().getDown());
            if(getFloorNumber(barrel.getPosition())%2 == 0) {
                barrel.setPosition(barrel.getPosition().getLeft());
            }
            if(getFloorNumber(barrel.getPosition())%2 == 1) {
                barrel.setPosition(barrel.getPosition().getRight());
            }
            if(isOutOfBounds(barrel.getPosition())) {
                getModel().deleteFirstBarrel();
            }
        }

    }
}
