package tn.supcom.tos.fleet.Controllers;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.Json;
import jakarta.json.JsonObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ApplicationScoped //dure de vie de linstance de class = duré de vie de l'application
public class FleetManagerBean {

    public JsonObject hello(String name) {
        String receivedTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        return Json.createObjectBuilder()
                .add("message", String.format("Bonjour '%s'.", name.toUpperCase()))
                .add("received", receivedTime)
                .build();


    }
    public String helloXML(String name) {
        // Prepare the message content
        String messageContent = String.format("Bonjour '%s'.", name.toUpperCase());
        // Prepare the received timestamp
        String receivedTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        // Format the XML with message and received time
        return """
            <?xml version="1.0" encoding="UTF-8"?>
            <response>
                <message>%s</message>
                <received>%s</received>
            </response>
            """.formatted(messageContent, receivedTime);

    }
}