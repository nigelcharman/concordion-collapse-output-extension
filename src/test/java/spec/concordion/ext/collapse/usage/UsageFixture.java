package spec.concordion.ext.collapse.usage;

import org.concordion.ext.collapse.CollapseOutputExtension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import spec.concordion.ext.collapse.AbstractCollapseFixture;

@RunWith(ConcordionRunner.class)
public class UsageFixture extends AbstractCollapseFixture {
	
	@Before
	public void installExtension() {
		//Used for this test instead of @Extensions(CollapseOutputExtension.class)
		System.setProperty("concordion.extensions",
				CollapseOutputExtension.class.getName());
	}

	public boolean returnTrue() {
		return true;
	}
}
