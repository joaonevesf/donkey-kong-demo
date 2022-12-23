package com.aor.DK.viewer

import com.aor.DK.GUI.GUI
import com.aor.DK.GUI.LanternaGUI
import com.aor.DK.model.Position
import com.aor.DK.model.menu.Menu
import com.aor.DK.viewer.menu.InstructionsViewer
import com.aor.DK.viewer.menu.LostViewer
import com.aor.DK.viewer.menu.StartViewer
import com.aor.DK.viewer.menu.WinViewer
import spock.lang.Specification

class MenuViewerTest extends Specification{

    GUI gui

    def setup(){
        gui = Mock(GUI)
    }

    def 'Testing draw elements' (){
        given:
        def viewer = new MenuViewer(new Menu("Instructions"))
        when:
        viewer.drawElements(gui)
        then:
        _ * gui.drawText(_,_,_)

    }

    def 'Testing instructions menu viewer'(){
        given:
        int x = 2
        int y = 12
        def viewer = new InstructionsViewer(new Menu("Instructions"))

        when:
        viewer.drawElements(gui)
        then:
        1 * gui.drawText(new Position(x + 2, y), "Princess", "#E6003C")
        1 * gui.drawText(new Position(x + 2, y + 1), "Your goal is to save her ", "#FFFFFF")
        1 * gui.drawPrincess(new Position(x, y))

        1 * gui.drawText(new Position(x + 2, y + 3), "Donkey Kong ", "#E6003C")
        1 * gui.drawText(new Position(x + 2, y + 4), "Appears in every level ", "#FFFFFF")
        1 * gui.drawText(new Position(x + 2, y + 5), "Throwing obstacles or guarding Lady ", "#FFFFFF")
        1 * gui.drawDonkeyKong(new Position(x, y + 3))

        1 * gui.drawText(new Position(x + 2, y + 7), "Stairs", "#E6003C")
        1 * gui.drawText(new Position(x + 2, y + 8), "To go to the up level", "#FFFFFF")
        1 * gui.drawText(new Position(x + 2, y + 9), "you need to climb them", "#FFFFFF")
        1 * gui.drawStair(new Position(x, y + 7))
        1 * gui.drawStair(new Position(x, y + 8))

        1 * gui.drawText(new Position(x + 2, y + 11), "Barrels", "#E6003C")
        1 * gui.drawText(new Position(x + 2, y + 12), "Are thrown by Donkey Kong", "#FFFFFF")
        1 * gui.drawText(new Position(x + 2, y + 13), "Move randomly across the game", "#FFFFFF")
        1 * gui.drawText(new Position(x + 2, y + 14), "Jump them to get some points", "#FFFFFF")
        1 * gui.drawBarrel(new Position(x, y + 11))
    }

    def 'Testing start menu viewer'() {
        given:
        def viewer = new StartViewer(new Menu("Start"))
        when:
        viewer.drawElements(gui)
        then:
        gui.drawDonkeyKong(new Position(15, 20))
        gui.drawPrincess(new Position(20, 20))
        gui.drawText(new Position(21, 20), "HELP!!!!", "#EB93D0")
    }

    def 'Testing win menu viewer'() {
        given:
        def viewer = new WinViewer(new Menu("Start"))
        when:
        viewer.drawElements(gui)
        then:
        gui.drawPrincess(new Position(20, 20))
    }

    def 'Testing lost menu viewer'() {
        given:
        def viewer = new LostViewer(new Menu("Start"))
        when:
        viewer.drawElements(gui)
        then:
        gui.drawDonkeyKong(new Position(20,20))
    }

}
