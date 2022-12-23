package com.aor.DK

import com.aor.DK.GUI.GUI
import spock.lang.Specification

import com.aor.DK.GUI.LanternaGUI


class GameTest extends Specification {
    Game game
    GUI gui

    def setup() {
        gui = Mock(GUI)
        game = new Game(null)
    }

    def 'Testing setState method'() {
        when:
        game.setState(null)

        then:
        game.state == null
    }

}
