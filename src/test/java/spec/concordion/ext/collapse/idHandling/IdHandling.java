package spec.concordion.ext.collapse.idHandling;

import nu.xom.Attribute;
import nu.xom.Element;
import nu.xom.Nodes;

import org.concordion.ext.collapse.CollapseOutputExtension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import spec.concordion.ext.collapse.AbstractCollapseFixture;
import test.concordion.ProcessingResult;

@RunWith(ConcordionRunner.class)
public class IdHandling extends AbstractCollapseFixture {

	@Before
	public void installExtension() {
		System.setProperty("concordion.extensions",
				CollapseOutputExtension.class.getName());
	}

	public String renderAndRetriveJavascriptCall(String fragment) throws Exception {
		ProcessingResult result = processFragment(fragment);
		
		Nodes nodes = result.getXOMDocument().query("//a");
		Attribute attribute = ((Element)nodes.get(0)).getAttribute("href");
		
		return attribute.getValue();
	}

}
