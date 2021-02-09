package com.example;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Pokedex {
    private Pokemon[] pokemon;

    public Pokemon[] getPokemon() {
        return pokemon;
    }

    public Pokedex() { }

    // Filter methods

    public Pokemon[] searchForName(String name) {
        throw new NotImplementedException();
    }

    public Pokemon[] searchForType(String type) {
        throw new NotImplementedException();
    }

    public Pokemon[] searchForWeakness(String weakness) {
        throw new NotImplementedException();
    }

    public Pokemon[] searchHeightRange(double minHeight, double maxHeight) {
        throw new NotImplementedException();
    }
}
