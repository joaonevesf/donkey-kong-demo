package com.aor.DK.GUI;

import com.aor.DK.model.Position;

import java.io.IOException;
import java.util.List;

public interface GUI {

    List<ACTION> getNextActions() throws IOException;

    void drawMario(Position position);

    void drawDonkeyKong(Position position);

    void drawPrincess(Position position);

    void drawFloor(Position position);

    void drawBarrel(Position position);

    void drawStair(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SPACE, SELECT}
}
