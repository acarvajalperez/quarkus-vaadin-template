package es.opplus.front.views.example.clientcallable;

import com.vaadin.flow.component.UI;
import es.opplus.front.AbstractAppTest;
import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.mvysny.kaributesting.v10.LocatorJ._assertOne;

/**
 * @author Martin Vysny <mavi@vaadin.com>
 */
@QuarkusTest
public class ClientCallableRouteTest extends AbstractAppTest {
    @BeforeEach
    public void navigate() {
        UI.getCurrent().navigate(ClientCallableRoute.class);
        _assertOne(ClientCallableRoute.class);
    }

    @Test
    public void smoke() {
        _assertOne(HelloWorldCC.class);
    }
}
