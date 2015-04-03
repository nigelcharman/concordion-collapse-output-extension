package spec.concordion.ext.collapse.config.resources;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import spec.concordion.ext.collapse.AbstractCollapseFixture;
import test.concordion.ProcessingResult;
import test.concordion.ext.collapse.DummyCollapseExtensionFactory;

@RunWith(ConcordionRunner.class)
public class ResourcesFixture extends AbstractCollapseFixture {

	@Before
	public void installExtension() {
		System.setProperty("concordion.extensions",
				DummyCollapseExtensionFactory.class.getName());
		
		DummyCollapseExtensionFactory.setJavascriptOutputDirectory("/myCustomJsDirectory");
		DummyCollapseExtensionFactory.setCSSOutputDirectory("/myCustomCSSDirectory");
	}

	public boolean hasJavaScriptResourceLink(ProcessingResult result, String name) {
		return result.hasJavaScriptDeclaration(name);
	}
	
	public boolean hasCSSResourceLink(ProcessingResult result, String name) {
		return result.hasCSSDeclaration(name);
	}

}
