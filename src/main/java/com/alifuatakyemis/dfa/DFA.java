package com.alifuatakyemis.dfa;

import java.util.HashMap;
import java.util.Map;

public class DFA {
    private DFAState entry, accept;
    private Map<String, DFAState> states;

    public DFA() {
        this.entry = null;
        this.accept = null;
        this.states = new HashMap<>();
    }

    public boolean isEmpty() {
        return this.states.isEmpty();
    }

    public int size() {
        return this.states.size();
    }

    public boolean evaluate(String word) {
        char[] chars = word.toCharArray();

        DFAState currentState = this.entry;

        for (char ch : chars) {
            currentState = currentState.nextState(ch);
        }

        return (currentState != null && currentState == this.accept) ? true : false;
    }

    public void add(String label) throws IllegalArgumentException {
        if (label == null)
            throw new IllegalArgumentException("Label cannot be null");

        if (label.isEmpty())
            throw new IllegalArgumentException("Label cannot be empty");

        if (!this.states.containsKey(label))
            this.states.put(label, new DFAState(label));
    }

    public void setEntryState(String label) throws IllegalArgumentException {
        if (label == null)
            throw new IllegalArgumentException("Label cannot be null");

        if (label.isEmpty())
            throw new IllegalArgumentException("Label cannot be empty");

        if (!this.states.containsKey(label)) {
            this.entry = new DFAState(label);
            this.states.put(label, this.entry);
        } else
            this.entry = this.states.get(label);
    }

    public void setAcceptState(String label) throws IllegalArgumentException {
        if (label == null)
            throw new IllegalArgumentException("Label cannot be null");

        if (!this.states.containsKey(label)) {
            this.accept = new DFAState(label);
            this.states.put(label, this.accept);
        } else
            this.accept = this.states.get(label);

    }

    public void addPath(String source, String destination, Character ch) throws IllegalArgumentException {
        if (source == null || destination == null)
            throw new IllegalArgumentException(((source == null) ? "Source" : "Destination") + " cannot be null");

        if (!this.states.containsKey(source) || !this.states.containsKey(destination))
            throw new IllegalArgumentException(
                    ((!this.states.containsKey(source) ? "Source" : "Destination") + " does not exist"));

        this.states.get(source).addPath(ch, this.states.get(destination));
    }

    public void removePath(String source, String destination, Character ch) throws IllegalArgumentException {
        if (source == null || destination == null)
            throw new IllegalArgumentException(((source == null) ? "Source" : "Destination") + " cannot be null");

        if (!this.states.containsKey(source) || !this.states.containsKey(destination))
            throw new IllegalArgumentException(
                    ((!this.states.containsKey(source) ? "Source" : "Destination") + " does not exist"));

        this.states.get(source).removePath(ch);
    }
}
