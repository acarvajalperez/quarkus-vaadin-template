package es.opplus.front.views.example.thirdparty;

import com.vaadin.flow.component.UI;
import es.opplus.front.AbstractAppTest;
import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.vaadin.gatanaso.MultiselectComboBox;

import static com.github.mvysny.kaributesting.v10.LocatorJ._assertOne;

/**
 * @author Martin Vysny <mavi@vaadin.com>
 */
@QuarkusTest
public class ThirdPartyRouteTest extends AbstractAppTest {
    @BeforeEach
    public void navigate() {
        UI.getCurrent().navigate(ThirdPartyRoute.class);
        _assertOne(ThirdPartyRoute.class);
    }

    @Test
    public void smoke() {
        _assertOne(MultiselectComboBox.class);
    }
}
