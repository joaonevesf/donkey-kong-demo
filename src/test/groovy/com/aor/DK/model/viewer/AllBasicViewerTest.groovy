package com.aor.DK.model.viewer

import com.aor.DK.GUI.LanternaGUI
import com.aor.DK.model.elements.Barrel
import com.aor.DK.model.elements.DonkeyKong
import com.aor.DK.model.elements.Fire
import com.aor.DK.model.elements.Floor
import com.aor.DK.model.elements.Mario
import com.aor.DK.model.elements.Princess
import com.aor.DK.model.elements.Stair
import com.aor.DK.model.elements.Switch
import spock.lang.Specification

class AllBasicViewerTest extends Specification{

    def 'Testing barrel viewer'(){
        given:
        def viewer = new BarrelViewer()
        def gui = Mock(LanternaGUI.class, constructorArgs:[30, 30])
        def barrel = Mock(Barrel.class, constructorArgs: [1,1])
        when:
        viewer.draw(barrel,gui)
        then:
        1 * gui.drawBarrel(barrel.getPosition())
    }

    def 'Testing donkey kong viewer'(){
        given:
        def viewer = new DonkeyKongViewer()
        def gui = Mock(LanternaGUI.class, constructorArgs:[30, 30])
        def donkeyKong = Mock(DonkeyKong.class, constructorArgs: [1, 1])
        when:
        viewer.draw(donkeyKong,gui)
        then:
        1 * gui.drawDonkeyKong(donkeyKong.getPosition())
    }

    def 'Testing fire viewer'(){
        given:
        def viewer = new FireViewer()
        def gui = Mock(LanternaGUI.class, constructorArgs:[30, 30])
        def fire = Mock(Fire.class, constructorArgs: [1,1])
        when:
        viewer.draw(fire,gui)
        then:
        1 * gui.drawFire(fire.getPosition(), fire.getLetter())
    }

    def 'Testing floor viewer'(){
        given:
        def viewer = new FloorViewer()
        def gui = Mock(LanternaGUI.class, constructorArgs:[30, 30])
        def floor = Mock(Floor.class, constructorArgs: [1, 1])
        when:
        viewer.draw(floor,gui)
        then:
        1 * gui.drawFloor(floor.getPosition())
    }

    def 'Testing mario viewer'(){
        given:
        def viewer = new MarioViewer()
        def gui = Mock(LanternaGUI.class, constructorArgs:[30, 30])
        def mario = Mock(Mario.class, constructorArgs: [1, 1])
        when:
        viewer.draw(mario,gui)
        then:
        1 * gui.drawMario(mario.getPosition(), mario.getLetter());
    }

    def 'Testing princess viewer'(){
        given:
        def viewer = new PrincessViewer()
        def gui = Mock(LanternaGUI.class, constructorArgs:[30, 30])
        def princess = Mock(Princess.class, constructorArgs: [1, 1])
        when:
        viewer.draw(princess,gui)
        then:
        1 * gui.drawPrincess(princess.getPosition());
    }

    def 'Testing stair viewer'(){
        given:
        def viewer = new StairViewer()
        def gui = Mock(LanternaGUI.class, constructorArgs:[30, 30])
        def stair = Mock(Stair.class, constructorArgs: [1, 1])
        when:
        viewer.draw(stair,gui)
        then:
        1 * gui.drawStair(stair.getPosition());
    }

    def 'Testing switch viewer'(){
        given:
        def viewer = new SwitchViewer()
        def gui = Mock(LanternaGUI.class, constructorArgs:[30, 30])
        def s = Mock(Switch.class, constructorArgs: [1, 1])
        s.isOn() >> true
        when:
        viewer.draw(s,gui)
        then:
        1 * gui.drawSwitch(s.getPosition());
    }
}
