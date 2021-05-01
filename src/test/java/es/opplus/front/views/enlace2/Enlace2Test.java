package es.opplus.front.views.enlace2;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Span;
import io.quarkus.test.junit.QuarkusTest;

import es.opplus.front.AbstractAppTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.mvysny.kaributesting.v10.LocatorJ._assertOne;

/**
 * @author Martin Vysny <mavi@vaadin.com>
 */
@QuarkusTest
public class Enlace2Test extends AbstractAppTest {
    @BeforeEach
    public void navigate() {
        UI.getCurrent().navigate(Enlace2.class);
        _assertOne(Enlace2.class);
    }

    @Test
    public void smoke() {
        _assertOne(Span.class);
    }
}
