package com.github.DominasPL;

import com.github.DominasPL.models.Alien;

import java.util.ArrayList;
import java.util.List;

public class AlienRepository {

    private List<Alien> aliens;

    public AlienRepository() {
        aliens = new ArrayList<>();

        Alien a1 = new Alien();
        a1.setId(1);
        a1.setName("Predator");
        a1.setPoints(100);

        Alien a2 = new Alien();
        a2.setId(2);
        a2.setName("Dominas");
        a2.setPoints(50);

        aliens.add(a1);
        aliens.add(a2);
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public Alien getAlien(int id) {

        Alien alien = null;

        for (Alien a : aliens) {

            if (a.getId() == id) {
                alien = a;
            }
        }

        return alien;

    }


    public void create(Alien alien) {

        aliens.add(alien);
    }
}
