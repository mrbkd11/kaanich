package tn.supcom.tos.fleet.Boundaries;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import tn.supcom.tos.fleet.Controllers.FleetManagerBean;

@Path("/echoes")
public class FleetManagerEndpoint {

    @Inject
    private FleetManagerBean service;

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello(@PathParam("name") String name, @HeaderParam("Accept") String acceptHeader) {
        // Determine the response format based on the Accept header
        if (acceptHeader != null && acceptHeader.contains(MediaType.APPLICATION_XML)) {
            String responseXml = service.helloXML(name);
            return Response.ok(responseXml, MediaType.APPLICATION_XML).build();
        } else {
            // Default to JSON if XML is not explicitly requested
            var responseJson = service.hello(name);
            return Response.ok(responseJson, MediaType.APPLICATION_JSON).build();
        }
    }
}
