package com.aor.DK.viewer

import com.aor.DK.GUI.GUI
import com.aor.DK.GUI.LanternaGUI
import com.aor.DK.model.Position
import com.aor.DK.model.arena.Arena
import com.aor.DK.model.elements.*
import com.aor.DK.model.ranking.Scores
import com.aor.DK.viewer.GameViewer
import spock.lang.Specification

class GameViewerTest extends Specification {
    def gameViewer
    def arena
    def gui
    def floor = new ArrayList<List<Floor>>()


    def setup() {
        arena = Mock(Arena.class, constructorArgs: [10, 10])
        gameViewer = new GameViewer(arena)
        gui = Mock(GUI)
        floor.add(new ArrayList<>())
        arena.getFloor() >> floor
        arena.getStairs() >> new ArrayList<Stair>()
        arena.getBarrels() >> new ArrayList<Stair>()
        arena.getMario() >> new Mario(1, 1)
        arena.getDonkeyKong() >> new DonkeyKong(1, 1)
        arena.getPrincess() >> new Princess(1, 1)
        arena.getFireMonsters() >> new ArrayList<Fire>()
        arena.getStairs() >> new ArrayList<Stair>()
        arena.getSticks() >> new ArrayList<Stick>()
        arena.getSwitches() >> new ArrayList<Switch>()
        arena.getScores().getJumpScore() >> 2
        arena.getScores() >> new Scores(1, 1)
    }

    def "test drawElements method"() {
        when:
        gameViewer.drawElements(gui)

        then:
        1 * gui.drawLevel(new Position(36, 1), gameViewer.getModel().getLevel());
        1 * gui.drawScores(new Position(0, 1), gameViewer.getModel().getScores().getJumpScore(), gameViewer.getModel().getScores().getTimeScore())
    }

}
