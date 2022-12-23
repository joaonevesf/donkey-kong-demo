package com.aor.DK.model.menu

import spock.lang.Specification

class MenuTest extends Specification{

    def 'Testing menu start'(){
        when:
        def menu = new Menu("Start")
        then:
        menu.getNumberEntries() == 4
        menu.getMessage() == "Donkey Kong"
    }


    def 'Testing menu instructions'(){
        when:
        def menu = new Menu("Instructions")
        then:
        menu.getNumberEntries() == 1
        menu.getMessage() == "Instructions"
    }

    def 'Testing next entry'() {
        given:
        def menu = new Menu("Start")
        when:
        menu.nextEntry()
        then:
        menu.isSelectedNumber(1)
    }

        def 'Testing next entry to 0'(){
            given:
            def menu = new Menu("Start")
            when:
            menu.nextEntry()
            menu.nextEntry()
            menu.nextEntry()
            menu.nextEntry()
            then:
            menu.isSelectedNumber(0)
    }

    def 'Testing previous entry'(){
        given:
        def menu = new Menu("Start")
        when:
        menu.previousEntry()
        then:
        menu.isSelectedNumber(3)
    }

    def 'Testing previous entry to 0'(){
        given:
        def menu = new Menu("Start")
        when:
        menu.previousEntry()
        menu.previousEntry()
        menu.previousEntry()
        menu.previousEntry()
        then:
        menu.isSelectedNumber(0)
    }

    def 'Testing get entry'(){
        given:
        def menu = new Menu("Start")
        when:
        def entry = menu.getEntry(0)
        then:
        entry == "Start"
    }

    def 'Testing is selected String'(){
        given:
        def menu = new Menu("Start")
        expect:
        menu.isSelectedString("Start")
    }

    def 'Testing get message / get Mod'(){
        given:
        def menu = new Menu("Instructions")
        expect:
        menu.getMessage() == "Instructions"
        menu.getMod() == "Instructions"
    }
}
