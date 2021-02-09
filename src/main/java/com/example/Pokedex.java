package com.example;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Pokedex {
    private Pokemon[] pokemon;

    public Pokemon[] getPokemon() {
        return pokemon;
    }

    public Pokedex() { }

    // Filter methods

    public Pokemon[] searchForPokemon(String request) {
        throw new NotImplementedException();
    }

    public Pokemon[] searchForType(String request) {
        throw new NotImplementedException();
    }

    public Pokemon[] searchForWeakness(String request) {
        throw new NotImplementedException();
    }

    public Pokemon[] searchHeightRange(String request) {
        throw new NotImplementedException();
    }
}
