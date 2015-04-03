package org.concordion.ext.collapse;


import org.concordion.api.Resource;
import org.concordion.api.extension.ConcordionExtender;
import org.concordion.api.extension.ConcordionExtension;

public class CollapseOutputExtension implements ConcordionExtension {
	
	private CollapseOutputDocumentParsingListener listener = new CollapseOutputDocumentParsingListener();
	private String javascriptOutputDirectory = "/js";
	private String cssOutputDirectory = "/css";

	public void addTo(ConcordionExtender concordionExtender) {
		concordionExtender.withDocumentParsingListener(listener);
		concordionExtender.withLinkedJavaScript("/org/concordion/ext/collapse/collapse-expand.js", new Resource(javascriptOutputDirectory + "/collapse-expand.js"));
		concordionExtender.withLinkedCSS("/org/concordion/ext/collapse/collapse-expand.css", new Resource(cssOutputDirectory + "/collapse-expand.css"));
	}
	
	public CollapseOutputExtension withLinkText(String text) {
		listener.setLinkText(text);
		return this;
	}
	
	public CollapseOutputExtension withClassName(String className) {
		listener.setClassName(className);
		return this;
	}

	public CollapseOutputExtension withCollapsedHeight(String collapsedHeight) {
		listener.setCollapsedHeight(collapsedHeight);
		return this;
	}

	public CollapseOutputExtension withJavascriptOutputDirectory(String javascriptDir) {
		this.javascriptOutputDirectory = javascriptDir;
		return this;
	}
	
	public CollapseOutputExtension withCSSOutputDirectory(String cssDir) {
		this.cssOutputDirectory = cssDir;
		return this;
	}
	
}
