package com.aor.DK.controller.game;

import com.aor.DK.GUI.GUI;
import com.aor.DK.Game;
import com.aor.DK.model.Position;
import com.aor.DK.model.arena.Arena;
import com.aor.DK.model.elements.Mario;
import com.aor.DK.model.menu.Menu;
import com.aor.DK.states.MenuState;

import java.util.Arrays;

public class MarioController extends GameController {

    private final float GRAVITY = 0.25f;

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
        if (!getModel().outOfBounds(position) || getModel().checkStairs(getModel().getMario().getPosition())) {
            getModel().getMario().setPosition(position);
        }
    }


    private void jumpMario() {
        if (getModel().isOnFloor(getModel().getMario().getPosition()) && !getModel().checkStairs(getModel().getMario().getPosition())) {
            Position position = getModel().getMario().getPosition();
            position.setY(position.getY() - 2);
            getModel().getMario().setPosition(position);

        }
    }
    private void gravityPush() {
        if(!getModel().isOnFloor(getModel().getMario().getPosition()) && !getModel().checkStairs(getModel().getMario().getPosition())) {
            Mario mario = getModel().getMario();
            moveMario(new Position(mario.getPosition().getX(),mario.getPosition().getY()+(int)mario.getVy()));
            mario.incrementVy(GRAVITY);
        }
        else{
            getModel().getMario().setVy(0);
        }
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) {

        /*
        if (action == GUI.ACTION.NONE && getModel().isOnFloor(getModel().getMario().getPosition())) {
            getModel().getMario().stationary();
        }*/

        if (action == GUI.ACTION.UP) {
            if(getModel().checkStairs(getModel().getMario().getPosition())) {
                moveMarioUp();
                getModel().getMario().climbingStairs();
            }
        }

        if (action == GUI.ACTION.DOWN) {
            if (getModel().checkUnderStairs(getModel().getMario().getPosition())) {
                moveMarioDown();
                getModel().getMario().climbingStairs();
            }
        }
        if (action == GUI.ACTION.LEFT) {
            moveMarioLeft();
            getModel().getMario().movingLeft();
        }

        if ((action == GUI.ACTION.RIGHT) && !getModel().outOfBounds(getModel().getMario().getPosition())){
            moveMarioRight();
            getModel().getMario().movingRight();
        }

        if (action == GUI.ACTION.SPACE) jumpMario();

        gravityPush();

        if((getModel().barrelCrash(getModel().getMario().getPosition()))
                || getModel().outOfBounds(getModel().getMario().getPosition())
                || getModel().crashDonkeyKong(getModel().getMario().getPosition()))  {
            game.setState(new MenuState(new Menu(Arrays.asList("Try again", "Exit"), "\t\t  You lost!")));
        }

        int winFloor = getModel().getFloorNumber(getModel().getPrincess().getPosition());
        if(getModel().getFloorNumber(getModel().getMario().getPosition())==winFloor){
            game.setState(new MenuState(new Menu(Arrays.asList("Play again", "Exit"), "\t\t  You won!")));
        }
    }




}
