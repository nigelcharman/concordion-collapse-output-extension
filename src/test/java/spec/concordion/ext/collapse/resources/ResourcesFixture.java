package spec.concordion.ext.collapse.resources;

import org.concordion.ext.collapse.CollapseOutputExtension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import spec.concordion.ext.collapse.AbstractCollapseFixture;
import test.concordion.ProcessingResult;

@RunWith(ConcordionRunner.class)
public class ResourcesFixture extends AbstractCollapseFixture {

	@Before
	public void installExtension() {
		System.setProperty("concordion.extensions",
				CollapseOutputExtension.class.getName());
	}

	public boolean hasJavaScriptResourceLink(ProcessingResult result, String name) {
		return result.hasJavaScriptDeclaration(name);
	}
	
	public boolean hasCSSResourceLink(ProcessingResult result, String name) {
		return result.hasCSSDeclaration(name);
	}

}
