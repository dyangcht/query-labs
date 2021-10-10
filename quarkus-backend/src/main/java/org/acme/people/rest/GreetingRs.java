package org.acme.people.rest;

// import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.people.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;

// import io.smallrye.config.events.ChangeEvent;

@RequestScoped
@Path("/request-api")
public class GreetingRs {

    private static final String PROPERTY = "my.property";

    @ConfigProperty(name = PROPERTY)
    String property;
    @ConfigProperty(name = "database.up")
    boolean status;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello " + property + "\t Status: " + status;
    }

    /*
     * public void all(@Observes ChangeEvent changeEvent) { if
     * (PROPERTY.equals(changeEvent.getKey()) && Type.UPDATE ==
     * changeEvent.getType()) { property = changeEvent.getNewValue(); } }
     */
}
