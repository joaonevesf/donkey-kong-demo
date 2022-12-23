package com.aor.DK.viewer

import com.aor.DK.GUI.GUI
import com.aor.DK.model.ranking.Ranking
import spock.lang.Specification

class RankingViewerTest extends Specification{

    def 'Testing ranking viewer draw'(){
        given:
        def ranking = new Ranking()
        def viewer = new RankingViewer(ranking)
        def gui = Mock(GUI)
        when:
        viewer.draw(gui)
        then:
        _ * gui.drawText(_)
    }
}
