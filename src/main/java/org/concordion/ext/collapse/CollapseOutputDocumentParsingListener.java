package org.concordion.ext.collapse;

import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Nodes;

import org.concordion.api.listener.DocumentParsingListener;

public class CollapseOutputDocumentParsingListener implements DocumentParsingListener {

	private String className = "collapsible";

	private String linkText = "Expand / Collapse";
	
	private String collapsedHeight = "1.5";
	
	private String collapsedHeightUnit = "em";
	
	private String collapsedHeightAttributeName = "collapsed-height";

	public void beforeParsing(Document document) {
		Element rootElement = document.getRootElement();

		Nodes nodes = rootElement.query(buildXpath());
		for (int i = 0; i < nodes.size(); i++) {
			createToogleContainer((Element) nodes.get(i));
		}

	}

	private String buildXpath() {
		return String.format("//*[@class='%s']", className);
	}

	private void createToogleContainer(Element element) {
		Element container = new Element("div");
		container.addAttribute(new Attribute("class", "toggleContainer"));
		
		String id = evaluateElementId(element);
		element.addAttribute(new Attribute(collapsedHeightAttributeName, collapsedHeight));
		element.addAttribute(new Attribute(collapsedHeightAttributeName + "-unit", collapsedHeightUnit));
		
		element.addAttribute(new Attribute("style", "height: " + collapsedHeight + collapsedHeightUnit + ";"));
		
		
		Element link = new Element("a");
		link.addAttribute(new Attribute("href", String.format("javascript:Collapsible.collapseExpand('%s');", id)));

		link.appendChild(linkText);
		
		element.getParent().replaceChild(element, container);

		container.appendChild(link);
		container.appendChild(element);
	}

	/**
	 * Check if the id attribute on the element is present.
	 * If yes  return it for usage in the javascript function
	 * If not create and set an id attribute using the hashCode of the elements value.
	 *
	 * @param element
	 * @return id of the element
	 */
	private String evaluateElementId(Element element) {
		String id;
		Attribute idAttribute = element.getAttribute("id");
		if (idAttribute != null && idAttribute.getValue() != null) {
			id = idAttribute.getValue();
		} else {
			id = element.getValue().hashCode() + "";
			element.addAttribute(new Attribute("id", id));
		}

		return id;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}

	public void setCollapsedHeight(String collapsedHeight) {
		this.collapsedHeight = collapsedHeight;
	}

}
