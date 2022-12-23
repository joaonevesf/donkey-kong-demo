package com.aor.DK.viewer.ranking

import com.aor.DK.GUI.LanternaGUI
import com.aor.DK.Game
import com.aor.DK.model.ranking.Ranking
import spock.lang.Specification

import java.awt.event.ActionEvent

class PlayerNameGUITest extends Specification{

   def 'Testing action button ok'(){
        given:
        Game game = Mock(Game.class, constructorArgs:[null])
        PlayerNameGUI gui = new PlayerNameGUI(game, 1000)
        when:
        gui.actionButtonOk(new ActionEvent(new Object(), 1, ""))
        Ranking ranking = new Ranking()
        then:
        ranking.getList().get(ranking.getList().size() - 1).score == 1000
        cleanup:
        ranking.getList().remove(ranking.getList().size() - 1)
        ranking.save()
    }

}
