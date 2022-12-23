package com.aor.DK.controller.game

import com.aor.DK.Game
import com.aor.DK.model.Position
import com.aor.DK.model.arena.Arena
import com.aor.DK.model.elements.Floor
import com.aor.DK.model.elements.Stair
import spock.lang.Specification

class FireControllerTest extends Specification{

    Arena arena
    FireController fireController
    Game game
    List stair
    List floor


    def setup(){
        arena = new Arena(10,10)
        fireController = new FireController(arena)
        arena.setSpawnFirePosition(new Position(1,1), 1)
        arena.setSpawnFirePosition(new Position(2,2), 2)
        arena.spawnFire()
        game = Mock(Game.class, constructorArgs:[null])
        stair = new ArrayList()
        floor = new ArrayList()
        floor.add(new ArrayList())
    }
    def 'Testing move fire up'(){
        given:
        arena.getFireMonsters().get(0).setDirection("up")
        stair.add(new Stair(1,1))
        arena.setStairs(stair)
        floor.get(0).add(new Floor (1,2))
        arena.setFloor(floor)
        when:
        fireController.step(game,[],2000)
        then:
        arena.getFireMonsters().get(0).getPosition().y == 0
    }

    def 'Testing move fire down'(){
        given:
        arena.getFireMonsters().get(0).setDirection("down")
        stair.add(new Stair(1,2))
        arena.setStairs(stair)
        floor.get(0).add(new Floor (0,0))
        arena.setFloor(floor)
        when:
        fireController.step(game,[],2000)
        then:
        arena.getFireMonsters().get(0).getPosition().y == 2
    }

    def 'Testing move fire left'(){
        given:
        arena.getFireMonsters().get(0).setDirection("left")
        stair.add(new Stair(0,0))
        arena.setStairs(stair)
        floor.get(0).add(new Floor (1,2))
        arena.setFloor(floor)
        when:
        fireController.step(game,[],2000)
        then:
        arena.getFireMonsters().get(0).getPosition().x == 0
    }

    def 'Testing move fire right'(){
        given:
        arena.getFireMonsters().get(0).setDirection("right")
        stair.add(new Stair(0,0))
        arena.setStairs(stair)
        floor.get(0).add(new Floor (1,2))
        arena.setFloor(floor)
        when:
        fireController.step(game,[],2000)
        then:
        arena.getFireMonsters().get(0).getPosition().x == 2
    }

    def 'Testing fire switch direction right to left'(){
        given:
        arena.getFireMonsters().get(0).setDirection("right")
        stair.add(new Stair(0,0))
        arena.setStairs(stair)
        floor.get(0).add(new Floor (0,0))
        arena.setFloor(floor)
        when:
        fireController.step(game,[],2000)
        then:
        arena.getFireMonsters().get(0).getDirection() == "left"
    }

    def 'Testing fire switch direction left to right'(){
        given:
        arena.getFireMonsters().get(0).setDirection("left")
        stair.add(new Stair(0,0))
        arena.setStairs(stair)
        floor.get(0).add(new Floor (0,0))
        arena.setFloor(floor)
        when:
        fireController.step(game,[],2000)
        then:
        arena.getFireMonsters().get(0).getDirection() == "right"
    }

    def 'Testing spawn fire with time'(){
        given:
        stair.add(new Stair(0,0))
        arena.setStairs(stair)
        floor.get(0).add(new Floor (0,0))
        arena.setFloor(floor)
        when:
        fireController.step(game,[],11000)
        then:
        arena.getFireMonsters().size() == 2
    }
}
