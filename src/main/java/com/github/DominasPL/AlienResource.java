package com.github.DominasPL;

import com.github.DominasPL.models.Alien;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("aliens")
public class AlienResource {

    private AlienRepository alienRepository = new AlienRepository();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Alien> getAliens() {

        return alienRepository.getAliens();
    }

    @GET
    @Path("alien/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Alien getAlien(@PathParam("id") int id) {

        return alienRepository.getAlien(id);
    }

    @POST
    @Path("alien")
    @Consumes(MediaType.APPLICATION_JSON)
    public Alien createAlien(Alien alien) {

        alienRepository.create(alien);
        System.out.println(alien);

        return alien;
    }



}
