package com.github.DominasPL;

import com.github.DominasPL.models.Alien;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("aliens")
public class AlienResource {

    private AlienRepository alienRepository = new AlienRepository();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Alien> getAliens() {


        return alienRepository.getAliens();
    }

    @POST
    @Path("alien")
    public Alien createAlien(Alien alien) {

        alienRepository.create(alien);

        return alien;
    }



}
