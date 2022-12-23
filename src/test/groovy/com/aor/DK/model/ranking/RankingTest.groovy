package com.aor.DK.model.ranking

import spock.lang.Specification

class RankingTest extends Specification{
    def 'Testing add person'(){
        given:
        def ranking = new Ranking()
        when:
        ranking.addPerson(new RankingElement("X",10))
        then:
        ranking.getList().get(ranking.getList().size() - 1 ).getName() == "X"
        cleanup:
        ranking.getList().remove(ranking.getList().size() - 1)
    }
}
