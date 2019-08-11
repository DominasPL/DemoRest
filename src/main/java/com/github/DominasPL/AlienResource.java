package com.github.DominasPL;

import com.github.DominasPL.models.Alien;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Alien getAlien() {

        System.out.println("getAlien() called!!");
        Alien a1 = new Alien();
        a1.setName("Predator");
        a1.setPoints(100);

        return a1;
    }


}
