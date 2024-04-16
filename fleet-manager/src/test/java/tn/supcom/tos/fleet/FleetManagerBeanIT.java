package tn.supcom.tos.fleet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import jakarta.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tn.supcom.tos.fleet.Controllers.FleetManagerBean;

/**
 * Run integration tests with Arquillian to be able to test CDI beans
 */
@ExtendWith(ArquillianExtension.class)
public class FleetManagerBeanIT {

    @Deployment
    public static WebArchive createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "FleetManagerServiceIT.war")
                .addClass(FleetManagerBean.class);
    }

    @Inject
    FleetManagerBean service;

    @Test
    public void testService() {
        var result = service.hello("World");
        assertEquals("Bonjour 'WORLD'.", result.get('message'));

        result = service.hello("Monde");
        assertEquals("Bonjour 'MONDE'.", result.get('message'));
    }
}