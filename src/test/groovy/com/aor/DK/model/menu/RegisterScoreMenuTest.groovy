package com.aor.DK.model.menu

import spock.lang.Specification

class RegisterScoreMenuTest extends Specification{

    def 'Testing get score'(){
        given:
        def registerScore = new RegisterScoreMenu("Start", 100)
        expect:
        registerScore.getScore() == 100
    }
}
