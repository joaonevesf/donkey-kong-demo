package com.aor.DK

import com.aor.DK.GUI.GUI
import com.aor.DK.controller.Controller
import com.aor.DK.controller.menu.LevelController
import com.aor.DK.model.menu.Level
import com.aor.DK.states.LevelState
import com.aor.DK.viewer.LevelViewer
import spock.lang.Specification

class StateTest extends Specification{

    def 'Testing get and set State'(){
        LevelState levelState = new LevelState(new Level(1,100))
        when:
        levelState.setModel(new Level(2, 100))
        then:
        levelState.getModel().getLevel() == 2
    }

}
