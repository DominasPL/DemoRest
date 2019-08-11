package com.github.DominasPL;

import com.github.DominasPL.models.Alien;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("aliens")
public class AlienResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Alien> getAliens() {

        System.out.println("getAlien() called!!");
        Alien a1 = new Alien();
        a1.setName("Predator");
        a1.setPoints(100);

        Alien a2 = new Alien();
        a2.setName("Dominas");
        a2.setPoints(50);


        return Arrays.asList(a1,a2);
    }




}
