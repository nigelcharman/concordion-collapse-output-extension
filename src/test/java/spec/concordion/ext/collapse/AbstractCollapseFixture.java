package spec.concordion.ext.collapse;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.concordion.api.Resource;

import test.concordion.ProcessingResult;
import test.concordion.TestRig;

public abstract class AbstractCollapseFixture {
	
	public ProcessingResult processFragment(String fragment) {
		ProcessingResult result = new TestRig()
				.withFixture(this)
				.withResource(new Resource("/org/concordion/ext/collapse/collapse-expand.js"), "")
				.withResource(new Resource("/org/concordion/ext/collapse/collapse-expand.css"), "")
				.processFragment(fragment);
		return result;
	}
	
	public String render(String fragment) throws Exception {
		ProcessingResult result = processFragment(fragment);
		
		return prettyPrintXml(result.getOutputFragmentXML());
	}

	protected String prettyPrintXml(String unformattedXML)
			throws TransformerConfigurationException,
			TransformerFactoryConfigurationError, TransformerException {
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		//initialize StreamResult with File object to save to file
		StreamResult streamResult = new StreamResult(new StringWriter());
		transformer.transform(new StreamSource(new StringReader(unformattedXML)), streamResult);
		
		return streamResult.getWriter().toString();
	}


}
