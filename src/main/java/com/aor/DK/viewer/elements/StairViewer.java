package com.aor.DK.viewer.elements;

import com.aor.DK.GUI.GUI;
import com.aor.DK.viewer.GenericViewer;
import com.aor.DK.model.elements.Stair;

public class StairViewer implements GenericViewer<Stair> {
    @Override
    public void draw(Stair stair, GUI gui) {
        gui.drawStair(stair.getPosition());
    }
}