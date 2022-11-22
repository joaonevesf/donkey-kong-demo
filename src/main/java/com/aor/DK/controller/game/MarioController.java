package com.aor.DK.controller.game;

import com.aor.DK.Game;
import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Floor;
import com.aor.DK.model.elements.Mario;
import com.aor.DK.model.elements.Stair;

import java.util.List;

public class MarioController extends GameController {

    private final float GRAVITY = 0.5f;

    public MarioController(Arena arena) {
        super(arena);
    }

    public void moveMarioLeft() {
        moveMario(getModel().getMario().getPosition().getLeft());
    }

    public void moveMarioRight() {
        moveMario(getModel().getMario().getPosition().getRight());
    }

    public void moveMarioUp() {
        moveMario(getModel().getMario().getPosition().getUp());
    }

    public void moveMarioDown() {
        moveMario(getModel().getMario().getPosition().getDown());
    }

    private void moveMario(Position position) {
        if (getModel().outOfBounds(position)) {
            getModel().getMario().setPosition(position);
            if (getModel().isBarrel(position)) getModel().end();
        }
    }

    private boolean isOnFloor() {
        for(List<Floor> storey : getModel().getFloor()) {
            for(Floor floor : storey)
                if(getModel().getMario().getPosition().getY()-1 == (floor.getPosition().getY())) {
                    return true;
            }
        }
        return false;
    }


    private void jumpMario() {
        if(!isOnFloor()) {
            getModel().getMario().setVy(2);
        }
    }

    private boolean checkStairs() {
        for(Stair stair : getModel().getStairs()) {
            if((getModel().getMario().getPosition().getX() == stair.getPosition().getX()) && ((getModel().getMario().getPosition().getY()-1) == stair.getPosition().getY())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) {
            if(checkStairs()) {
                moveMarioUp();
            }
        }
        if (action == GUI.ACTION.RIGHT) moveMarioRight();
        if (action == GUI.ACTION.DOWN) {
            if (checkStairs()) {
                moveMarioDown();
            }
        }
        if (action == GUI.ACTION.LEFT) moveMarioLeft();
        if (action == GUI.ACTION.SPACE) jumpMario();
        if(!isOnFloor()) {
            Mario mario = getModel().getMario();
            moveMario(mario.getPosition().getSum(0,(int)mario.getVy()));
            mario.decrementVy(GRAVITY);
        }
    }
}
