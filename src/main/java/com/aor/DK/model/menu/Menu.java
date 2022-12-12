package com.aor.DK.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu{
    private List<String> entries;
    private int currentEntry = 0;
    protected String message;
    protected String mod;

    public Menu(String mod) {
        this.mod=mod;
        if (mod.equals("Start")) {
            this.entries = Arrays.asList("Start", "Instructions", "Ranking","Exit");
            this.message = "Donkey Kong";
        }
        if (mod.equals("Win")) {
            this.entries = Arrays.asList("Play again?", "Exit");
            this.message = "Congratulations! You won the game!";
        }
        if (mod.equals("Lost")) {
            this.entries = Arrays.asList("New Game?", "Instructions", "Exit");
            this.message = "Try again! Its just a Donkey Kong";
        }
        if (mod.equals("Instructions")) {
            this.entries = Arrays.asList("Start", "Exit");
            this.message = "Instructions";
        }
    }


     public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected_Number(int Entry) {
        return currentEntry == Entry;
    }

    public boolean isSelected_String(String Entry) {
        return entries.get(currentEntry).equals(Entry);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public String getMessage() {
        return message;
    }

    public String getMod() {return mod;}
}
