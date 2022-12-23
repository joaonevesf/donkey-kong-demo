package com.aor.DK.controller.menu

import com.aor.DK.GUI.GUI
import com.aor.DK.Game
import com.aor.DK.model.menu.Menu
import com.aor.DK.model.ranking.Ranking
import spock.lang.Specification

class MenuControllerTest extends Specification{

    Game game

    def setup(){
        game = new Game(null)
    }

    def 'Testing menu controller step GUI.ACTION.SPACE'(){
        given:
        def menuController = new MenuController(new Menu("Instructions"))
        when:
        menuController.step(game,[GUI.ACTION.SPACE],100)
        then:
        game.getState().getModel().getMod() == "Start"
    }

    def 'Testing menu controller step GUI.ACTION.UP'(){
        given:
        def menuController = new MenuController(new Menu("Start"))
        when:
        menuController.step(game,[GUI.ACTION.UP],100)
        game.getState().setModel(menuController.getModel())
        then:
        game.getState().getModel().isSelectedNumber(3)
    }

    def 'Testing menu controller step GUI.ACTION.DOWN'(){
        given:
        def menuController = new MenuController(new Menu("Start"))
        when:
        menuController.step(game,[GUI.ACTION.DOWN],100)
        game.getState().setModel(menuController.getModel())
        then:
        game.getState().getModel().isSelectedNumber(1)
    }


    def 'Testing menu controller step select exit'(){
        given:
        def menuController = new MenuController(new Menu("Start"))
        when:
        menuController.getModel().previousEntry()
        menuController.step(game,[GUI.ACTION.SELECT],100)
        then:
        game.getState() == null
    }

    def 'Testing menu controller step select Start'(){
        given:
        def menuController = new MenuController(new Menu("Start"))
        when:
        menuController.step(game,[GUI.ACTION.SELECT],100)
        then:
        game.getState().getModel().getLevel() == 1
    }

    def 'Testing menu controller step select Instructions'(){
        given:
        def menuController = new MenuController(new Menu("Start"))
        when:
        menuController.getModel().nextEntry()
        menuController.step(game,[GUI.ACTION.SELECT],100)
        then:
        game.getState().getModel().getMod() == "Instructions"
    }

    def 'Testing menu controller step select ranking'(){
        given:
        def menuController = new MenuController(new Menu("Start"))
        when:
        menuController.getModel().nextEntry()
        menuController.getModel().nextEntry()
        menuController.step(game,[GUI.ACTION.SELECT],100)
        then:
        game.getState().getModel().getClass() == Ranking
    }

}
