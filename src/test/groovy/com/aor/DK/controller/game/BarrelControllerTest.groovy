package com.aor.DK.controller.game

import com.aor.DK.GUI.GUI
import com.aor.DK.Game
import com.aor.DK.model.Position
import com.aor.DK.model.arena.Arena
import com.aor.DK.model.elements.Barrel
import com.aor.DK.model.elements.Floor
import com.aor.DK.model.elements.Stair
import spock.lang.Specification

class BarrelControllerTest extends Specification {

    BarrelController barrelController
    Arena arena
    List stair
    List floor
    Game game

    def setup() {
        arena = new Arena(10,10)
        barrelController = new BarrelController(arena)
        stair = new ArrayList()
        floor = new ArrayList()
        floor.add(new ArrayList())
        floor.add(new ArrayList())
        game = Mock(Game.class, constructorArgs:[null])
    }


    def "test move barrel down method"() {
        given:
        stair.add(new Stair(1,1))
        arena.stairs = stair
        floor.get(0).add(new Floor (1,1))
        arena.setFloor(floor)
        def barrels = new ArrayList()
        barrels.add(new Barrel(1,1))
        arena.setBarrels(barrels)
        when:
        barrelController.step(game, [], 1000)
        then:
        arena.getBarrels().get(0).getPosition().y == 2
    }

    def "test move barrel left method"() {
        given:
        stair.add(new Stair(0,0))
        arena.stairs = stair
        floor.get(0).add(new Floor (1,2))
        arena.setFloor(floor)
        def barrels = new ArrayList()
        barrels.add(new Barrel(1,1))
        arena.setBarrels(barrels)
        when:
        barrelController.step(game, [], 1000)
        then:
        arena.getBarrels().get(0).getPosition().x == 0
    }

    def "test move barrel right method"() {
        given:
        stair.add(new Stair(0,0))
        arena.stairs = stair
        floor.get(1).add(new Floor (1,2))
        arena.setFloor(floor)
        def barrels = new ArrayList()
        barrels.add(new Barrel(1,1))
        arena.setBarrels(barrels)
        when:
        barrelController.step(game, [], 1000)
        then:
        arena.getBarrels().get(0).getPosition().x == 2
    }

    def "test spawn barrel method"() {
        given:
        stair.add(new Stair(0,0))
        arena.stairs = stair
        floor.get(1).add(new Floor (1,2))
        arena.setFloor(floor)
        def barrels = new ArrayList()
        arena.setBarrels(barrels)
        arena.setSpawnBarrelPosition(new Position(3,3))
        when:
        barrelController.step(game, new ArrayList<GUI.ACTION>(), 4000)
        then:
        arena.getBarrels().size() == 1
    }


}

