package com.aor.DK.gui;

import com.aor.DK.model.Position;

import java.io.IOException;

public interface GUI {

    ACTION getNextAction() throws IOException;

    void drawMario(Position position);

    void drawFloor(Position position);

    void drawBarrel(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}

