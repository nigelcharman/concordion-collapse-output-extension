package spec.concordion.ext.collapse.config.styleClass;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import spec.concordion.ext.collapse.AbstractCollapseFixture;
import test.concordion.ext.collapse.DummyCollapseExtensionFactory;

@RunWith(ConcordionRunner.class)
public class StyleClassFixture extends AbstractCollapseFixture {

	@Before
	public void installExtension() {
		System.setProperty("concordion.extensions",
				DummyCollapseExtensionFactory.class.getName());
		
		DummyCollapseExtensionFactory.setStyleClass("myCustomClass");
	}

}
