package com.alifuatakyemis.dfa;

import java.util.HashMap;
import java.util.Map;

public class DFAState {
    String label;
    Map<Character, DFAState> paths;

    public DFAState() {
        this.label = null;
        this.paths = new HashMap<>();
    }

    public DFAState(String label) {
        this.label = label;
        this.paths = new HashMap<>();
    }

    public int size() {
        return this.paths.size();
    }

    public String toString() {
        return label;
    }

    public void addPath(Character ch, DFAState next) throws IllegalArgumentException {
        if (ch == null || next == null)
            throw new IllegalArgumentException(((ch == null) ? "Character" : "Next state") + " cannot be null");

        this.paths.put(ch, next);
    }

    public void removePath(Character ch) throws IllegalArgumentException {
        if (ch == null)
            throw new IllegalArgumentException("Character cannot be null");

        if (!this.paths.containsKey(ch))
            throw new IllegalArgumentException("This edge does not exist");

        this.paths.remove(ch, this.paths.get(ch));
    }

    public DFAState nextState(Character ch) throws IllegalArgumentException {
        if (ch == null)
            throw new IllegalArgumentException("Character cannot be null");

        if (!this.paths.containsKey(ch))
            throw new IllegalArgumentException("This edge does not exist");

        return this.paths.get(ch);
    }
}
