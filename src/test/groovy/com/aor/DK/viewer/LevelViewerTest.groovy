package com.aor.DK.viewer

import com.aor.DK.GUI.GUI
import com.aor.DK.GUI.LanternaGUI
import com.aor.DK.model.menu.Level
import spock.lang.Specification

class LevelViewerTest extends Specification{
    def 'Testing draw elements'(){
        given:
        def viewer = new LevelViewer(new Level(1,1000))
        def gui = Mock(GUI)
        when:
        viewer.drawElements(gui)
        then:
        3 * gui.drawText(_,_,_)
        1 * gui.drawDonkeyKong(_)
    }

}
