package com.aor.DK.GUI;



import com.aor.DK.model.Position;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }
    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        return terminalFactory.createTerminal();
    }


    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if(keyStroke == null) return ACTION.NONE;
        switch(keyStroke.getKeyType()) {
            case EOF:
                return ACTION.QUIT;
            case Character:
                if (keyStroke.getCharacter() == 'q') return ACTION.QUIT;
                if (keyStroke.getCharacter() == ' ') return ACTION.SPACE;
                else break;
            case ArrowUp:
                return ACTION.UP;
            case ArrowRight:
                return ACTION.RIGHT;
            case ArrowDown:
                return ACTION.DOWN;
            case ArrowLeft:
                return ACTION.LEFT;
            case Enter:
                return ACTION.SELECT;
            default:
                return ACTION.NONE;
        }
        return ACTION.NONE;
    }

    @Override
    public void drawMario(Position position) {
        drawCharacter(position.getX(), position.getY(), 'X', "#e2cbd2");
    }

    @Override
    public void drawFloor(Position position) {
        drawCharacter(position.getX(), position.getY(), '#', "#b4076d");
    }

    @Override
    public void drawBarrel(Position position) {
        drawCharacter(position.getX(), position.getY(), 'O', "#ef970f");
    }

    @Override
    public void drawStair(Position position) {
        drawCharacter(position.getX(), position.getY(), 'H', "#4ad5f6");
    }
    @Override
    public void drawDonkeyKong(Position position) {
        drawCharacter(position.getX(), position.getY(), 'D', "#560000");
    }
    @Override
    public void drawPrincess(Position position) {
        drawCharacter(position.getX(), position.getY(), 'P', "#ff57ff");
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    public void close(Screen screen) throws IOException {
        screen.close();
    }
}
