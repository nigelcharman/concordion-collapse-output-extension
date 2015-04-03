package spec.concordion.ext.collapse.config;

import org.concordion.ext.collapse.CollapseOutputExtension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import spec.concordion.ext.collapse.AbstractCollapseFixture;

@RunWith(ConcordionRunner.class)
public class ConfigFixture extends AbstractCollapseFixture {

	@Before
	public void installExtension() {
		System.setProperty("concordion.extensions",
				CollapseOutputExtension.class.getName());
	}
}
