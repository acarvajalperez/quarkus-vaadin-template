package es.opplus.front.views.example.pushdemo;

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
public class PushDemoRouteTest extends AbstractAppTest {
    @BeforeEach
    public void navigate() {
        UI.getCurrent().navigate(PushDemoRoute.class);
        _assertOne(PushDemoRoute.class);
    }

    @Test
    public void smokeTest() {
        _assertOne(PushDemoRoute.class);
    }
}
