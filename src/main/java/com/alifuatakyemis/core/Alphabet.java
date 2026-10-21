package com.alifuatakyemis.core;

import java.util.HashSet;
import java.util.Set;

public class Alphabet {
    private Set<Character> alphabet;

    public Alphabet() {
        this(new String());
    }

    public Alphabet(String alphabet) {
        this.alphabet = new HashSet<>();

        for (char ch : alphabet.toCharArray()) {
            this.alphabet.add(ch);
        }
    }

    public boolean isEmpty() {
        return this.alphabet.isEmpty();
    }

    public int size() {
        return this.alphabet.size();
    }

    public boolean contains(Character ch) {
        if (ch == null)
            throw new IllegalArgumentException("Character cannot be null");

        return this.alphabet.contains(ch);
    }

    public void addCharacter(Character ch) throws IllegalArgumentException {
        if (ch == null)
            throw new IllegalArgumentException("Character cannot be null");

        this.alphabet.add(ch);
    }

    public void removeCharacter(Character ch) throws IllegalArgumentException {
        if (!this.alphabet.contains(ch))
            throw new IllegalArgumentException("Character cannot be null");

        this.alphabet.remove(ch);
    }
}
